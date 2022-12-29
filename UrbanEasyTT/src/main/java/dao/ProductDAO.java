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
import java.util.List;
import model.Product;

public class ProductDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/UrbanEasy?allowPublicKeyRetrieval=true&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "15012003";
    private static final String SELECT_PRODUCT = "SELECT p.propertyId, p.district, p.city, p.country, r.avg_rating FROM property p join\t(SELECT propertyId, AVG(stars) as avg_rating FROM reviews GROUP BY propertyId) r ON p.propertyId = r.propertyId; ";

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
                    PreparedStatement preparedStatement = connection.prepareStatement("SELECT p.propertyId, p.district, p.city, p.country, r.avg_rating FROM property p join\t(SELECT propertyId, AVG(stars) as avg_rating FROM reviews GROUP BY propertyId) r ON p.propertyId = r.propertyId; ");

                    try {
                        ResultSet rs = preparedStatement.executeQuery();

                        while(rs.next()) {
                            int id = rs.getInt("propertyId");
                            String district = rs.getString("district");
                            String city = rs.getString("city");
                            String country = rs.getString("country");
                            double avg_rating = (double)Math.round(rs.getDouble("avg_rating") * 10.0) / 10.0;
                            products.add(new Product(id, district, city, country, avg_rating));
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
