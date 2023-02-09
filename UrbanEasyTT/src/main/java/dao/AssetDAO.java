package dao;

import java.sql.Connection;
import util.Connector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AssetDAO {
	private static final String INSERT_TO_ASSET = "INSERT INTO asset (property_id, name, url) VALUES (?,?,?);";

	public AssetDAO() {
		super();
	}

	public boolean insertToAsset(String insertedId, ArrayList<String> imgs) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		try {

			for (int i = 0; i < imgs.size(); i++) {
				ps = connection.prepareStatement(INSERT_TO_ASSET);
				ps.setString(1, insertedId);
				ps.setInt(2, i+1);
				ps.setString(3, imgs.get(i));
				
				ps.executeUpdate();
				System.out.println("asset: " + insertedId+" "+i+1 +" "+ imgs.get(i));
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
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

		return true;
	}
}
