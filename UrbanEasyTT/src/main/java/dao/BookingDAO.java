package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.Connector;
import util.Ultilities;

public class BookingDAO {
	private static final String INSERT_BOOKING = "INSERT INTO booking (property_id, user_id, date_start, date_end) VALUES(?,?, str_to_date(?, '%d/%m/%Y'), str_to_date(?, '%d/%m/%Y'));";
	private static final String SELECT_BOOKING_BY_PROPERTY_ID = "SELECT date_start, date_end FROM booking WHERE property_id = ?;";
	public BookingDAO() {
		super();
	}
	
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
			if (rs.next()) {
				Date dateStart = rs.getDate("date_start");
				Date dateEnd = rs.getDate("date_end");
				result = Ultilities.getDatesBetween(dateStart, dateEnd);
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
	
}
