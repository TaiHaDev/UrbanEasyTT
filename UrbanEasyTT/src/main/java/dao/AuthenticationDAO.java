package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import util.Connector;

public class AuthenticationDAO {
	private static AuthenticationDAO instance;

	public static AuthenticationDAO getInstance() {
		if (instance == null) {
			instance = new AuthenticationDAO();
		}
		return instance;
	}

	private AuthenticationDAO() {
	}

	private final String AUTHENTICATE_USER_AND_RETURN_ID = "SELECT id, avatar_url FROM user WHERE email = ? AND password = ?;";
	private final String CHECK_IF_EMAIL_IS_REGISTERED = "SELECT * FROM user WHERE email = ?;";
	private final String INSERT_TEMPORARY_USER_INFO = "INSERT INTO verification_detail ( name, password, email, code) values (?, ?, ?, ?);";
	private final String DELETE_ROW_VERIFICATION = "DELETE FROM verification_detail WHERE id = ?;";
	private final String LAST_INSERT_ID = "SELECT last_insert_id() as id;";
	private final String CHECK_VERIFICATION_CODE = "SELECT * FROM verification_detail WHERE id = ? AND code = ?";
	private final String INSERT_SIGNUP_USER = "INSERT INTO user(user_name, password, email)\n"
			+ "SELECT name, password, email FROM verification_detail WHERE id = ?;";

	public User authenticateUser(String email, String password) {
		User result = null;
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(AUTHENTICATE_USER_AND_RETURN_ID);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				long id = rs.getLong("id");
				String avatarUrl = rs.getString("avatar_url");
				result = new User(id, avatarUrl);
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

	public boolean checkExistingEmail(String email) {
		boolean result = false;
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(CHECK_IF_EMAIL_IS_REGISTERED);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = true;
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

	public int insertTemporaryUserDetail(String email, String password, String name, int code) {
		int result = -1;
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(INSERT_TEMPORARY_USER_INFO);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setInt(4, code);
			ps.execute();
			ps2 = connection.prepareStatement(LAST_INSERT_ID);
			rs = ps2.executeQuery();
			if (rs.next()) {
				result = rs.getInt("id");
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

	public void deleteVerificationRow(int id) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(DELETE_ROW_VERIFICATION);
			ps.setInt(1, id);
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
				e.printStackTrace();
			}
		}
	}

	public boolean verifyCodes(int id, String code) {
		boolean result = false;
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(CHECK_VERIFICATION_CODE);
			ps.setInt(1, id);
			ps.setInt(2, Integer.parseInt(code));
			rs = ps.executeQuery();
			if (rs.next()) {
				result = true;
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

	public void finalisingUser(int id) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(INSERT_SIGNUP_USER);
			ps.setInt(1, id);
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
				e.printStackTrace();
			}
		}
	}
}