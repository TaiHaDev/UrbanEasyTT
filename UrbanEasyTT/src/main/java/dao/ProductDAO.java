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
    private String jdbcURL = "jdbc:mysql://localhost:3306/urbaneasyv2?allowPublicKeyRetrieval=true&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "370291";
    private static final String SELECT_PRODUCT = "SELECT p.propertyId, p.district, p.city, p.country, r.avg_rating FROM property p join\t(SELECT propertyId, AVG(stars) as avg_rating FROM reviews GROUP BY propertyId) r ON p.propertyId = r.propertyId; ";
    private static final String SELECT_ALL_PRODUCT = "SELECT p.id, p.district, p.city, p.country, r.avg_rating, a.url, p.default_price as price\r\n"
    		+ "    		FROM property p join (SELECT propertyId, AVG((cleanliness_rating+communication_rating+checkin_rating+accuracy_rating+location_rating+value_rating)/6) as avg_rating \r\n"
    		+ "    								FROM review\r\n"
    		+ "    		                        GROUP BY propertyId) r\r\n"
    		+ "    		ON p.id = r.propertyId\r\n"
    		+ "    		join asset a on p.id = a.property_id\r\n"
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

    public List<Product> selectAllProducts() {
        List<Product> products = new ArrayList();

        try {
            Throwable var2 = null;
            Object var3 = null;

            try {
                Connection connection = this.getConnection();

                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);

                    try {
                        ResultSet rs = preparedStatement.executeQuery();

                        while(rs.next()) {
                            int id = rs.getInt("propertyId");
                            String district = rs.getString("district");
                            String city = rs.getString("city");
                            String country = rs.getString("country");
                            double avg_rating = (double)Math.round(rs.getDouble("avg_rating") * 10.0) / 10.0;
                            String url = rs.getString("url");
                            double price = rs.getDouble("price");
                            products.add(new Product(id, district, city, country, avg_rating, url, price));
                        }
                    } finally {
                        if (preparedStatement != null) {
                            preparedStatement.close();
                        }

                    }
                } catch (Throwable var26) {
                    if (var2 == null) {
                        var2 = var26;
                    } else if (var2 != var26) {
                        var2.addSuppressed(var26);
                    }

                    if (connection != null) {
                        connection.close();
                    }
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (Throwable var27) {
                if (var2 == null) {
                    var2 = var27;
                } else if (var2 != var27) {
                    var2.addSuppressed(var27);
                }
            }
        } catch (Exception var28) {
            var28.printStackTrace();
        }

        return products;
    }
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
	        	int id = rs.getInt("propertyId");
                String district = rs.getString("district");
                String city = rs.getString("city");
                String country = rs.getString("country");
                double avg_rating = (double)Math.round(rs.getDouble("avg_rating") * 10.0) / 10.0;
                String url = rs.getString("url");
                double price = rs.getDouble("price");
                products.add(new Product(id, district, city, country, avg_rating, url, price));
	        }
	    } catch (SQLException e) {
	        printSQLException(e);
	    }
	    System.out.println("test"+products[0]);
	    return products;
}
