package dao;

import java.sql.Connection;
import util.Connector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Facility;

public class FacilityDAO {
	private static final String SELECT_ALL_FACILITIES= "SELECT * FROM facility;";
	
	public List<Facility> selectAllFacility() {
		List<Facility> facilityList = new ArrayList<Facility>();
		Connection connection = Connector.makeConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
            ps = connection.prepareStatement(SELECT_ALL_FACILITIES); 
			rs = ps.executeQuery();
			while (rs.next()) {
	        	int id = rs.getInt("id");
                String name = rs.getString("facility_name");
                String svg = rs.getString("facility_icon");
                facilityList.add(new Facility(id, name, svg));
	        }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(connection!=null) {
					connection.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		 		
		return facilityList;
	}
}
