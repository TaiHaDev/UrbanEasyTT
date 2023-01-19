package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import model.Product;
import model.Review;
import model.User;
import util.Connector;

public class UserDAO {
	private static final String SELECT_USER_BY_ID = "SELECT user_name, about, year(date) as year_join , is_host, avatar_url FROM USER WHERE id = ?;";
    private static final String SELECT_PROPERTY_OWNED_BY_USER_ID = "SELECT property.id,url, avg_rating, property.name  FROM UrbanEasyV2.user join property on user.id = property.user_id join asset on asset.property_id = property.id LEFT join (SELECT propertyId, AVG(cleanliness_rating + communication_rating + checkin_rating + accuracy_rating + location_rating + value_rating) / 6 as avg_rating FROM review GROUP BY propertyId) r ON property.id = r.propertyId where user.id = ? AND asset.name = \"1\";";
    private static final String SELECT_REVIEW_OF_OWNER_BY_ID = "SELECT userId , property.id as property_id, review.date, property.name, comment, url, u.user_name, city, country, u.avatar_url FROM user JOIN property on user.id = property.user_id JOIN review on review.propertyId = property.id JOIN asset ON asset.property_id = property.id JOIN user u ON review.userId = u.id  WHERE user.id = ? AND asset.name = \"1\";";
    
    public User selectUserById(long id) {
    	User result = null;
    	Connection connection = Connector.makeConnection();
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	try {
    		ps = connection.prepareStatement(SELECT_USER_BY_ID);
    	
    		ps.setLong(1, id);
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			String about = rs.getString("about");
    			String year = rs.getString("year_join");
    			boolean isHost = rs.getInt("is_host") == 1 ? true : false;
    			String name = rs.getString("user_name");
    			String avatarURL = rs.getString("avatar_url");
    			result = new User(name, about, year, isHost, avatarURL);
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
    public List<Product> selectPropertyOwnedByUser(long userId) {
    	List<Product> result = new ArrayList<>();
    	Connection connection = Connector.makeConnection();
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	try {
    		ps = connection.prepareStatement(SELECT_PROPERTY_OWNED_BY_USER_ID);
    		ps.setLong(1, userId);
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			long id = rs.getLong("id");
    			String url = rs.getString("url");
    			double ratings = (double)Math.round(rs.getDouble("avg_rating") * 10.0) / 10.0;
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	return result;
    }
    public List<Review> selectReviewsFromUserToOwner(long userId) {
    	List<Review> result = new ArrayList<>();
    	Connection connection = Connector.makeConnection();
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	try {
    		ps = connection.prepareStatement(SELECT_REVIEW_OF_OWNER_BY_ID);
    		ps.setLong(1, userId);
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			long reviewerId = rs.getLong("userId");
    			long propertyId = rs.getLong("property_id");
    			String date = rs.getString("date");
    			String name = rs.getString("name");
    			String comment = rs.getString("comment");
    			String url = rs.getString("url");
    			String userName = rs.getString("user_name");
    			String city = rs.getString("city");
    			String country = rs.getString("country");
    			String userUrl = rs.getString("avatar_url");
    			result.add(new Review(name, date, comment, url, userUrl, propertyId, reviewerId, userName, city, country));
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
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
    	return result;
    }
}
