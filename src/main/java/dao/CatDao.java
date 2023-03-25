package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Category;
import util.JDBCConnectionUtil;

public class CatDao {
	private static Connection conn;
	private static Statement st;
	private static ResultSet rs;

	public static ArrayList<Category> getItems() {
		ArrayList<Category> listItems = new ArrayList<>();
		conn = JDBCConnectionUtil.getConnection();
		try {
			String sql = "SELECT * FROM danhmuctin";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("ID_DanhMucTin");
				String name = rs.getString("TenDanhMucTin");
				Category objItem = new Category(id, name);
				listItems.add(objItem);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnectionUtil.close(rs, st, conn);
		}
		return listItems;
	}

}
