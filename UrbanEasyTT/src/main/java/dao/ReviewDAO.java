package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Review;
import model.User;
import util.Connector;

public class ReviewDAO {
    private static final String COUNT_REVIEWS_BY_USER_ID = "SELECT count(propertyId) as review_count, user.id, user.avatar_url, user.user_name FROM user JOIN property on user.id = property.user_id LEFT JOIN review on review.propertyId = property.id WHERE user.id = ?;";
    private static final String SELECT_REVIEW_OF_OWNER_BY_ID = "SELECT userId , property.id as property_id, review.date, property.name, comment, url, u.user_name, city, country, u.avatar_url FROM user JOIN property on user.id = property.user_id JOIN review on review.propertyId = property.id JOIN asset ON asset.property_id = property.id JOIN user u ON review.userId = u.id  WHERE user.id = ? AND asset.name = \"1\";";
    private static final String SELECT_REVIEW_BY_PROPERTY_ID = "SELECT user.id, user_name, avatar_url, comment, review.date, cleanliness_rating, communication_rating, checkin_rating, accuracy_rating, location_rating, value_rating FROM property\n"
    		+ "	JOIN review ON property.id = review.propertyId\n"
    		+ "    JOIN user ON user.id = review.userId WHERE property.id = ?;";
    public User countOwnerReviewById (long userId) {
    	User result = null;
    	Connection connection = Connector.makeConnection();
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	try {
    		ps = connection.prepareStatement(COUNT_REVIEWS_BY_USER_ID);
    		ps.setLong(1, userId);
    		rs = ps.executeQuery();
    		if (rs.next()) {
    			int totalReview = rs.getInt("review_count");
    			long id = rs.getLong("id");
    			String url = rs.getString("avatar_url");
    			String userName = rs.getString("user_name");
    			result = new User(id, userName, url, totalReview);
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
    
    
    public List<Review> selectReviewsOfPropertyById(long propertyId) {
    	List<Review> result = new ArrayList<>();
    	Connection connection = Connector.makeConnection();
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	try {
    		ps = connection.prepareStatement(SELECT_REVIEW_BY_PROPERTY_ID);
    		ps.setLong(1, propertyId);
    		rs = ps.executeQuery();
    		while (rs.next()) {
    			int reviewerId = rs.getInt("id");
    			String userName = rs.getString("user_name");
    			String userUrl = rs.getString("avatar_url");
    			String comment = rs.getString("comment");
    			String date = rs.getString("date");
    			int cleanliness = rs.getInt("cleanliness_rating");
    			int communication = rs.getInt("communication_rating");
    			int checkin = rs.getInt("checkin_rating");
    			int accuracy = rs.getInt("accuracy_rating");
    			int location = rs.getInt("location_rating");
    			int value = rs.getInt("value_rating");
    			result.add(new Review(reviewerId, userName, userUrl, comment, date, cleanliness, communication, checkin, accuracy, location, value));
    			
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