//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import util.Connector;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import model.Category;
import model.Product;

public class ProductDAO {
	private static final String SELECT_PRODUCT = "SELECT p.id,p.description, p.neighborhood_overview, p.name, p.district, p.city, p.country, r.avg_rating, p.lng, p.lat, user_id, total_guest, bedroom, bed, bath, default_price FROM property p left join (SELECT propertyId, AVG(cleanliness_rating + communication_rating + checkin_rating + accuracy_rating + location_rating + value_rating) as avg_rating FROM review GROUP BY propertyId) r ON p.id = r.propertyId WHERE id = ?; ";
	private static final String SELECT_ASSET_BY_ID = "SELECT name, url FROM asset WHERE property_id = ?;";

	private static final String SELECT_ALL_PRODUCT = "SELECT p.id, p.district, p.city, p.country, r.avg_rating, a.url, p.default_price as price, p.category_id\r\n"
			+ "			    		FROM UrbanEasyV2.property p join (SELECT propertyId, AVG((cleanliness_rating+communication_rating+checkin_rating+accuracy_rating+location_rating+value_rating)/6) as avg_rating \r\n"
			+ "			    								FROM UrbanEasyV2.review\r\n"
			+ "											GROUP BY propertyId) r    		ON p.id = r.propertyId\r\n"
			+ "			   		join asset a on p.id = a.property_id            where a.name='1';";
	private static final String SELECT_ALL_PRODUCT_BY_CATEGORY = "SELECT p.id, p.district, p.city, p.country, r.avg_rating, a.url, p.default_price as price, p.category_id\r\n"
			+ "    		 		FROM urbaneasyv2.property p left join (SELECT propertyId, AVG((cleanliness_rating+communication_rating+checkin_rating+accuracy_rating+location_rating+value_rating)/6) as avg_rating \r\n"
			+ "    		   								FROM urbaneasyv2.review\r\n"
			+ "    		   		                        GROUP BY propertyId) r\r\n"
			+ "    		   		ON p.id = r.propertyId\r\n"
			+ "    		  		join asset a on p.id = a.property_id\r\n"
			+ "					where a.name='1' and p.category_id=? ORDER BY view DESC LIMIT 100;"; // + 1
	private static final String UPDATE_PROPERTY_VIEW = "UPDATE PROPERTY SET view = view + 1 WHERE id = ?;";
	private static final String INSERT_INTO_PRODUCT ="INSERT INTO property (name, description,neighborhood_overview, total_guest, bedroom, bed, bath, district, city, country, street_address,lng,lat, default_price,category_id)\r\n"
			+ "			VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
	private static final String LAST_INSERT_ID = "SELECT last_insert_id() as id;";
	
	public ProductDAO() {
	}

	public Product selectProduct(long id) {
    	Product result = null;
    	Connection connection = Connector.makeConnection();
    	PreparedStatement ps = null;
    	PreparedStatement ps2 = null;
    	ResultSet rs = null;
    	try {
    		ps2 = connection.prepareStatement(UPDATE_PROPERTY_VIEW);
    		ps2.setLong(1, id);
    		ps2.execute();
    		ps = connection.prepareStatement(SELECT_PRODUCT);
    		ps.setLong(1, id);
    		rs = ps.executeQuery();
    	
    		while(rs.next()) {
    			long propertyId = rs.getLong("id");
    			String district = rs.getString("district");
    			String city = rs.getString("city");
    			String country = rs.getString("country");
    			double lng = rs.getDouble("lng");
    			double lat = rs.getDouble("lat");
    			double avg_rating = (double) Math.round(rs.getDouble("avg_rating") * 10.0) / 10.0; 
    			long userId = rs.getLong("user_id");
    			int totalGuest = rs.getInt("total_guest");
    			int bedroom = rs.getInt("bedroom");
    			int bed = rs.getInt("bed");
    			int bath = rs.getInt("bath");
    			String name = rs.getString("name");
    			String description = rs.getString("description");
    			String overview = rs.getString("neighborhood_overview");
    			BigDecimal price = rs.getBigDecimal("default_price");
    			result = new Product(propertyId, name, district, city, country, avg_rating, lng, lat, userId, totalGuest, bedroom, bed, bath, price, description, overview);
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
				if (ps2 != null) {
					ps2.close();
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

	 public String[] selectAssets(long id) {
	    	String[] result = new String[5];
	    	Connection connection = Connector.makeConnection();
	    	PreparedStatement ps = null;
	    	ResultSet rs = null;
	    	try {
	    		ps = connection.prepareStatement(SELECT_ASSET_BY_ID);
	    		ps.setLong(1, id);
	    		rs = ps.executeQuery();
	    		while (rs.next()) {
	    			String name = rs.getString("name");
	    			String url = rs.getString("url");
	    			for (int i = 1; i <= 5; i++) {

	    				if (name.contains("" + i)) {
	    					result[i-1] = url;
	    					break;
	    				}
	    			}
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

	public List<Product> selectAllProducts2() {
		List<Product> products = new ArrayList<>();
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(SELECT_ALL_PRODUCT);
			rs = ps.executeQuery();

			while (rs.next()) {
				long propertyId = rs.getLong("id");
				String district = rs.getString("district");
				String city = rs.getString("city");
				String country = rs.getString("country");
				double avg_rating = (double) Math.round(rs.getDouble("avg_rating") * 10.0) / 10.0;
				String url = rs.getString("url");
				BigDecimal price = rs.getBigDecimal("price");
				int category_id = rs.getInt("category_id");
				products.add(new Product(propertyId, district, city, country, avg_rating, price, url, category_id));
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
		return products;
	}

	public List<List<Product>> selectProductByCategory() {

		List<List<Product>> products = new ArrayList<List<Product>>();
		int categoriesAmount = 0;
		Connection connection0 = Connector.makeConnection();
		PreparedStatement ps0 = null;
		ResultSet rs0 = null;
		try {
			ps0 = connection0.prepareStatement("select count(id) as category_amount from category;");
			rs0 = ps0.executeQuery();
			while (rs0.next()) {
				categoriesAmount = rs0.getInt("category_amount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs0 != null) {
					rs0.close();
				}
				if (ps0 != null) {
					ps0.close();
				}
				if (connection0 != null) {
					connection0.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("category_amount: "+categoriesAmount);
		Connection connection = Connector.makeConnection();
		for (int i = 0; i < categoriesAmount; i++) {

			PreparedStatement ps = null;
			ResultSet rs = null;
			products.add(new ArrayList<Product>());
			try {

				ps = connection.prepareStatement(SELECT_ALL_PRODUCT_BY_CATEGORY );
				ps.setString(1, Integer.toString(i + 1));
				rs = ps.executeQuery();

				while (rs.next()) {
					long propertyId = rs.getLong("id");
					String district = rs.getString("district");
					String city = rs.getString("city");
					String country = rs.getString("country");
					double avg_rating = (double) Math.round(rs.getDouble("avg_rating") * 10.0) / 10.0;
					String url = rs.getString("url");
					BigDecimal price = rs.getBigDecimal("price");
					int category_id = rs.getInt("category_id");
					products.get(i).add(new Product(propertyId, district, city, country, avg_rating, price, url, category_id));

				}
				try {
					if (rs != null) {
						rs.close();
					}
					if (ps != null) {
						ps.close();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs = null;
				ps = null;

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

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return products;
	}
	public boolean insertIntoProduct(String houseTitle, String description, String neighborhood, String guest, String bedroom, 
			String bed, String bathroom, String district, String city, String country, String streetAddress, String longtitude, 
			String latitude, String price, String category) {
		
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(INSERT_INTO_PRODUCT);
			ps.setString(1, houseTitle);
			ps.setString(2, description);
			ps.setString(3, neighborhood);
			ps.setString(4, guest);
			ps.setString(5, bedroom);
			ps.setString(6, bed);
			ps.setString(7, bathroom);
			ps.setString(8, district);
			ps.setString(9, city);
			ps.setString(10, country);
			ps.setString(11, streetAddress);
			ps.setString(12, longtitude);
			ps.setString(13, latitude);
			ps.setString(14, price);
			ps.setString(15, category);
			System.out.println(ps);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return true;
	}


}
