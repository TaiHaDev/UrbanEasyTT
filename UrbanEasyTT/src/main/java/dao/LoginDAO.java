package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import util.Connector;

public class LoginDAO {
	private final String AUTHENTICATE_USER_AND_RETURN_ID = "SELECT id FROM user WHERE email = ? AND password = ?;";
	public int authenticateUser(String email, String password) {
		int result = -1;
    	Connection connection = Connector.makeConnection();
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	try {
    		ps = connection.prepareStatement(AUTHENTICATE_USER_AND_RETURN_ID);
    		ps.setString(1, email);
    		ps.setString(2, password);
    		rs = ps.executeQuery();
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	return result;
	}
}
