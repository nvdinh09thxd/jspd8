package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.News;
import util.JDBCConnectionUtil;

public class NewsDao {
	private static Connection conn;
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;

	public static ArrayList<News> getItems() {
		ArrayList<News> listItems = new ArrayList<>();
		conn = JDBCConnectionUtil.getConnection();
		try {
			String sql = "SELECT * FROM tintuc";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("ID_TinTuc");
				String name = rs.getString("TenTinTuc");
				String description = rs.getString("MoTa");
				String detail = rs.getString("ChiTiet");
				News objItem = new News(id, name, description, detail);
				listItems.add(objItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnectionUtil.close(rs, st, conn);
		}
		return listItems;
	}

	public static ArrayList<News> getItemsByIdCat(int idCat) {
		ArrayList<News> listItems = new ArrayList<>();
		conn = JDBCConnectionUtil.getConnection();
		try {
			String sql = "SELECT * FROM tintuc WHERE ID_DanhMucTin = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idCat);
			rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID_TinTuc");
				String name = rs.getString("TenTinTuc");
				String description = rs.getString("MoTa");
				String detail = rs.getString("ChiTiet");
				News objItem = new News(id, name, description, detail);
				listItems.add(objItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnectionUtil.close(rs, pst, conn);
		}
		return listItems;
	}

	public static News getItem(int idNews) {
		News item = null;
		conn = JDBCConnectionUtil.getConnection();
		try {
			String sql = "SELECT * FROM news WHERE id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idNews);
			rs = pst.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("ID_TinTuc");
				String name = rs.getString("TenTinTuc");
				String description = rs.getString("MoTa");
				String detail = rs.getString("ChiTiet");
				item = new News(id, name, description, detail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnectionUtil.close(rs, pst, conn);
		}
		return item;
	}
}
