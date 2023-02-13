package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.time.LocalDate;

import model.Booking;
import util.Connector;
import util.Ultilities;

public class BookingDAO {
	private static BookingDAO instance;

	public static BookingDAO getInstance() {
		if (instance == null) {
			instance = new BookingDAO();
		}
		return instance;
	}

	private BookingDAO() {
	}

	private static final String INSERT_BOOKING = "INSERT INTO booking (property_id, user_id, date_start, date_end) VALUES(?,?, str_to_date(?, '%d/%m/%Y'), str_to_date(?, '%d/%m/%Y'));";
	private static final String SELECT_BOOKING_BY_PROPERTY_ID = "SELECT date_start, date_end FROM booking WHERE property_id = ?;";
	private static final String SELECT_BOOKINGS_INFO = "SELECT booking.id, property.name, asset.url, street_address, date_start, date_end, status FROM booking JOIN property ON booking.property_id = property.id JOIN asset ON asset.property_id = property.id WHERE booking.user_id = ? AND asset.name='1' ORDER BY date DESC;";
	private static final String GET_BOOKING_DETAILS = "SELECT booking.id, booking.property_id, user.id as user_id, avatar_url, asset.url, property.name, date_start, date_end, status, street_address, total_guest, user_name, phone_number, booking.date, email, cleanliness_rating FROM booking JOIN property ON booking.property_id = property.id JOIN asset ON property.id = asset.property_id JOIN user ON property.user_id = user.id LEFT JOIN review ON review.bookingId = booking.id WHERE booking.id = ? AND  asset.name = '1';";
	private static final String CANCEL_BOOKING = "UPDATE booking SET status = 'CANCELLED' WHERE id = ?;";
	private static final String BOOK_DATE_AVAILABLE = "\r\n"
			+ "select s.dateAvailable, adddate(dateAvailable, INTERVAL (SELECT FLOOR(RAND()*(10-5+1)+5)) DAY) as dateEnd\r\n"
			+ "					 from (SELECT adddate(IF(current_date() > date_end, current_date(), date_end), INTERVAL 1 DAY) as dateAvailable  FROM booking WHERE property_id= 50523 ORDER BY date_end desc LIMIT 1) s;";

	private static Map<Integer, String> month = new HashMap<Integer, String>() {
		{
			put(1, "Jan");
			put(2, "Feb");
			put(3, "Mar");
			put(4, "Apr");
			put(5, "May");
			put(6, "Jun");
			put(7, "Jul");
			put(8, "Aug");
			put(9, "Sep");
			put(10, "Oct");
			put(11, "Nov");
			put(12, "Dec");
		}
	};

	public void insertCustomerBooking(long propertyId, long userId, String dateStart, String dateEnd) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(INSERT_BOOKING);
			ps.setLong(1, propertyId);
			ps.setLong(2, userId);
			ps.setString(3, dateStart);
			ps.setString(4, dateEnd);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public List<Date> selectBookingDates(long propertyId) {
		List<Date> result = new ArrayList<>();
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(SELECT_BOOKING_BY_PROPERTY_ID);
			ps.setLong(1, propertyId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Date dateStart = rs.getDate("date_start");
				Date dateEnd = rs.getDate("date_end");
				result.addAll(Ultilities.getDatesBetween(dateStart, dateEnd));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<Booking> getBookingInfo(long userId) {
		List<Booking> result = new ArrayList<>();
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(SELECT_BOOKINGS_INFO);
			ps.setLong(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				long bookingId = rs.getLong("id");
				String propertyUrl = rs.getString("url");
				String address = rs.getString("street_address");
				String dateStart = Ultilities.reformatDate(rs.getDate("date_start"));
				String dateEnd = Ultilities.reformatDate(rs.getDate("date_end"));
				String status = rs.getString("status");
				String name = rs.getString("name");
				result.add(new Booking(bookingId, propertyUrl, dateStart, dateEnd, address, status, name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public Booking getBookingDetails(long bookingId) {
		Booking result = null;
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(GET_BOOKING_DETAILS);
			ps.setLong(1, bookingId);
			rs = ps.executeQuery();
			if (rs.next()) {
				long id = rs.getLong("id");
				long propertyId = rs.getLong("property_id");
				long userId = rs.getLong("user_id");
				String propertyUrl = rs.getString("url");
				String address = rs.getString("street_address");
				Date dateStart = rs.getDate("date_start");
				Date dateEnd = rs.getDate("date_end");
				int length = Ultilities.getDatesBetween(dateStart, dateEnd).size();
				String status = rs.getString("status");
				String name = rs.getString("name");
				int guests = rs.getInt("total_guest");
				String hostName = rs.getString("user_name");
				String phoneNumber = rs.getString("phone_number");
				String date = Ultilities.reformatDate(rs.getDate("date"));
				String email = rs.getString("email");
				String avatarUrl = rs.getString("avatar_url");
				boolean isReviewed = rs.getString("cleanliness_rating") == null ? false : true;
				result = new Booking(id, propertyId, userId, avatarUrl, propertyUrl, name,
						Ultilities.reformatDate(dateStart), Ultilities.reformatDate(dateEnd), address, status, guests,
						hostName, phoneNumber, date, email, "200", isReviewed, length);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public void cancelBooking(long bookingId) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(CANCEL_BOOKING);
			ps.setLong(1, bookingId);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public List<String> getAvailableDate(long propertyId) {

		List<String> result = new ArrayList<>();
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(BOOK_DATE_AVAILABLE);
			ps.setLong(1, propertyId);
			rs = ps.executeQuery();

			if (rs.next()) {
				String start = Ultilities.reformatDate(rs.getDate("dateAvailable"));
				String end = Ultilities.reformatDate(rs.getDate("dateEnd"));

				String dateAvailableStart = month.get(Integer.parseInt(start.substring(3, 5))) + " "
						+ start.substring(0, 2);
				String dateAvailableEnd = month.get(Integer.parseInt(end.substring(3, 5))) + " " + end.substring(0, 2);
				System.out.println("Hello: " + dateAvailableStart + " " + dateAvailableEnd);
				result.add(dateAvailableStart);
				result.add(dateAvailableEnd);

			} else {
				Random rand = new Random();

				LocalDate currentDate = LocalDate.now();
				result.add(month.get(currentDate.getMonthValue()) + " " + currentDate.getDayOfMonth());
				currentDate = currentDate.plusDays(rand.nextInt((10 - 4) + 1) + 4);
				result.add(month.get(currentDate.getMonthValue()) + " " + currentDate.getDayOfMonth());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}