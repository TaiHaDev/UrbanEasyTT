//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package dao;

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

public class ProductDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/urbaneasyv2?allowPublicKeyRetrieval=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String jdbcUsername = "tindev";
    private String jdbcPassword = "370291";
    private static final String SELECT_PRODUCT = "SELECT p.id, p.district, p.city, p.country, r.avg_rating, p.lng, p.lat FROM property p join\t(SELECT propertyId, AVG(cleanliness_rating + communication_rating + checkin_rating + accuracy_rating + location_rating + value_rating) as avg_rating FROM review GROUP BY propertyId) r ON p.id = r.propertyId; ";
    private static final String SELECT_ASSET_BY_ID = "SELECT name, url FROM asset WHERE property_id = ?;";
    private static final String SELECT_ALL_PRODUCT = "SELECT p.id, p.district, p.city, p.country, r.avg_rating, a.url, p.default_price as price\n"
    		+ "    		FROM UrbanEasyV2.property p join (SELECT propertyId, AVG((cleanliness_rating+communication_rating+checkin_rating+accuracy_rating+location_rating+value_rating)/6) as avg_rating \n"
    		+ "    								FROM UrbanEasyV2.review\n"
    		+ "    		                        GROUP BY propertyId) r\n"
    		+ "    		ON p.id = r.propertyId\n"
    		+ "    		join asset a on p.id = a.property_id\n"
    		+ "            where a.name='1';";
    public ProductDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(this.jdbcURL, this.jdbcUsername, this.jdbcPassword);
        } catch (SQLException var3) {
            var3.printStackTrace();
        } catch (ClassNotFoundException var4) {
            var4.printStackTrace();
        }

        return connection;
    }
    public Product selectProduct(int id) {
    	Product result = null;
    	try(Connection connection = getConnection();
    			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT);) {
    		var rs = preparedStatement.executeQuery();
    		while(rs.next()) {
    			int propertyId = rs.getInt("id");
    			String district = rs.getString("district");
    			String city = rs.getString("city");
    			String country = rs.getString("country");
    			double lng = rs.getDouble("lng");
    			double lat = rs.getDouble("lat");
    			double avg_rating = (double)Math.round(rs.getDouble("avg_rating") * 10.0) / 10.0; 
    			result = new Product(propertyId, district, city, country, avg_rating, lng, lat);
    		}
    		
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return result;
    	
    }
    public String[] selectAssets(int id) {
    	String[] result = new String[5];
    	try(Connection connection = getConnection();
    			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ASSET_BY_ID);) {
    		preparedStatement.setInt(1, id);
    		ResultSet rs = preparedStatement.executeQuery();
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
    	}
    	return result;
    }
    public List<Product> selectAllProducts2() {
	    List <Product> products = new ArrayList <> ();
	    try (Connection connection = getConnection();
	
	        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
	        // System.out.println(preparedStatement);
	        ResultSet rs = preparedStatement.executeQuery();
	
	        while (rs.next()) {
	        	int id = rs.getInt("id");
                String district = rs.getString("district");
                String city = rs.getString("city");
                String country = rs.getString("country");
                double avg_rating = (double)Math.round(rs.getDouble("avg_rating") * 10.0) / 10.0;
                String url = rs.getString("url");
                double price = rs.getDouble("price");
                products.add(new Product(id, district, city, country, avg_rating, price, url));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return products;
}}

