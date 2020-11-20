package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.CategoryBean;

public class CategoryDao {

	public ArrayList<CategoryBean> getAllCategory () {

	String url = "jdbc:mysql://localhost/art";
	String id = "root";
	String pass = "password";
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;


//   !!! this is same as UserDAO !!!
	ArrayList<CategoryBean> clist = new ArrayList<CategoryBean>();



	try {
		Class.forName("com.mysql.jdbc.Driver");

	} catch (ClassNotFoundException ex) {
		ex.printStackTrace();
	}

	try {

		conn = DriverManager.getConnection(url, id, pass);

		String query = "select * from category";
		pstmt = conn.prepareStatement(query);

		rs = pstmt.executeQuery();



//	 !!!!!every time you come here, it means you gotta put database information into each bean!!!

		while (rs.next()) {


			CategoryBean cb = new CategoryBean();
			cb.setCatName(rs.getString("cat_name"));
			cb.setCatId(rs.getInt("cat_id"));

            clist.add(cb);

		}

	} catch (SQLException ex) {
		ex.printStackTrace();
	} finally {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();

		} catch (Exception ex) {
		}

	}

	return clist;
}
















	public CategoryBean getname (int getname) {

		String url = "jdbc:mysql://localhost/art";
		String id = "root";
		String pass = "password";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;


	//   !!! this is same as UserDAO !!!
		CategoryBean cb = new CategoryBean();



		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		try {

			conn = DriverManager.getConnection(url, id, pass);

			String query = "select * from category where cat_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,getname);

			rs = pstmt.executeQuery();



//			!!!!!!!!!every time you come here, it means you gotta put database information into each bean!!!

			while (rs.next()) {



				cb.setCatName(rs.getString("cat_name"));
				cb.setCatId(rs.getInt("cat_id"));

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception ex) {
			}

		}

		return cb;
	}








}
