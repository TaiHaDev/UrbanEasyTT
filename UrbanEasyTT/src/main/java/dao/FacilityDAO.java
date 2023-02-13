package dao;

import java.sql.Connection;
import util.Connector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Facility;

public class FacilityDAO {
	private static final String SELECT_ALL_FACILITIES = "SELECT * FROM facility;";
	private static final String INSERT_INTO_FACILITY_DETAIL = "INSERT INTO falcility_detail "
			+ "(falcility_id, apartment_id) VALUES (?, ?);";

	public List<Facility> selectAllFacility() {
		List<Facility> facilityList = new ArrayList<Facility>();
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(SELECT_ALL_FACILITIES);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("facility_name");
				String icon = rs.getString("facility_icon");
				facilityList.add(new Facility(id, name, icon));
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

		return facilityList;
	}

	public boolean insertIntoFacilityDetail(ArrayList<String> amenities, String productId) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		System.out.println(amenities.toString() + "\n" + productId);
		try {
			for (String faci : amenities) {
				ps = connection.prepareStatement(INSERT_INTO_FACILITY_DETAIL);
				ps.setString(1, faci);
				ps.setString(2, productId);
				ps.executeUpdate();
			}

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
				e.printStackTrace();
			}
		}
		return true;
	}
}
