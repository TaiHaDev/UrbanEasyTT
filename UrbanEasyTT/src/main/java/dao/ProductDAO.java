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

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import model.Product;

public class ProductDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/UrbanEasyV2?allowPublicKeyRetrieval=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String jdbcUsername = "root";
    private String jdbcPassword = "15012003";
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

   

	public List<Product> selectAllProducts2() {
	    // using try-with-resources to avoid closing resources (boiler plate code)
	    List <Product> products = new ArrayList <> ();
	    // Step 1: Establishing a Connection
	    try (Connection connection = getConnection();
	
	        // Step 2:Create a statement using connection object
	        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
	        System.out.println(preparedStatement);
	        // Step 3: Execute the query or update query
	        ResultSet rs = preparedStatement.executeQuery();
	
	        // Step 4: Process the ResultSet object.
	        while (rs.next()) {
	        	int id = rs.getInt("id");
                String district = rs.getString("district");
                String city = rs.getString("city");
                String country = rs.getString("country");
                double avg_rating = (double)Math.round(rs.getDouble("avg_rating") * 10.0) / 10.0;
                String url = rs.getString("url");
                double price = rs.getDouble("price");
                products.add(new Product(id, district, city, country, avg_rating, url, price));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return products;
}}
