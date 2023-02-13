package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.User;
import util.Connector;

public class UserDAO {
	private static final String SELECT_USER_BY_ID = "SELECT user_name, about, is_host, year(date) as year_join, avatar_url FROM USER WHERE id = ?;";
	private static final String SELECT_PROPERTY_OWNED_BY_USER_ID = "SELECT property.id,url, avg_rating, property.name  FROM UrbanEasyV2.user join property on user.id = property.user_id join asset on asset.property_id = property.id LEFT join (SELECT propertyId, AVG(cleanliness_rating + communication_rating + checkin_rating + accuracy_rating + location_rating + value_rating) / 6 as avg_rating FROM review GROUP BY propertyId) r ON property.id = r.propertyId where user.id = ? AND asset.name = \"1\";";
	private static final String SELECT_USER_BY_ID_TO_SHOW = "select user_name, phone_number, email, avatar_url, YEAR(date) as year, about from user where id=?;";
	private static final String UPDATE_USER_BY_ID = "UPDATE user SET user_name=?, phone_number=?, email=? WHERE id=?;";
	private static final String UPDATE_AVATAR_BY_ID = "UPDATE user SET avatar_url=? WHERE id=?;";

	public User selectUserById(long id) {
		User result = null;
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(SELECT_USER_BY_ID);

			ps.setLong(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				String about = rs.getString("about");
				String year = rs.getString("year_join");
				String name = rs.getString("user_name");
				String avatarURL = rs.getString("avatar_url");
				boolean isHost = rs.getInt("is_host") == 1 ? true : false;
				result = new User(name, about, isHost, year, avatarURL);
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

	public User selectUserById2(long id) {
		User result = null;
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(SELECT_USER_BY_ID_TO_SHOW);

			ps.setLong(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString("user_name");
				String phone = rs.getString("phone_number");
				String email = rs.getString("email");
				String avatarURL = rs.getString("avatar_url");
				String year = rs.getString("year");
				String about = rs.getString("about");
				if (avatarURL == null) {
					avatarURL = "https://ui-avatars.com/api/?name=" + name + "&background=random&size=200";
				}
				result = new User(name, phone, email, avatarURL, year, about);
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

	public List<Product> selectPropertyOwnedByUser(long userId) {
		List<Product> result = new ArrayList<>();
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(SELECT_PROPERTY_OWNED_BY_USER_ID);
			ps.setLong(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				String url = rs.getString("url");
				double ratings = (double) Math.round(rs.getDouble("avg_rating") * 10.0) / 10.0;
				String name = rs.getString("name");
				result.add(new Product(id, name, url, ratings));
			}
		} catch (Exception e) {
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

	public void updateInfoUser(long id, String name, String phone, String email) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(UPDATE_USER_BY_ID);

			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setLong(4, id);
			ps.executeUpdate();
		} catch (Exception e) {
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
				e.printStackTrace();
			}

		}
	}

	public void updateAvatarUser(long id, String url) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(UPDATE_AVATAR_BY_ID);

			ps.setString(1, url);
			ps.setLong(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
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
				e.printStackTrace();
			}

		}
	}
}