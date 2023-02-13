package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
	public static Connection makeConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/UrbanEasyV2?allowPublicKeyRetrieval=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "370291");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
