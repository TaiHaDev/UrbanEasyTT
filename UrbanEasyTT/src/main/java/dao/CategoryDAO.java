package dao;

import java.sql.Connection;
import util.Connector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Category;

public class CategoryDAO {
	private static CategoryDAO instance;

	public static CategoryDAO getInstance() {
		if (instance == null) {
			instance = new CategoryDAO();
		}
		return instance;
	}

	private CategoryDAO() {
	}

	private static final String SELECT_ALL_CATEGORIES = "SELECT * FROM category;";

	public List<Category> selectAllCategory() {
		List<Category> categoryList = new ArrayList<Category>();
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(SELECT_ALL_CATEGORIES);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String url = rs.getString("url");
				categoryList.add(new Category(id, name, url));
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

		return categoryList;
	}
}