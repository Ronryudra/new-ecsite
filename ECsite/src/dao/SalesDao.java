package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.CartBean;

public class SalesDao {

	public void insert(int user_id , ArrayList<CartBean> a ) {


		String url = "jdbc:mysql://localhost/art";
		String id = "root";
		String pass = "password";


		Connection conn = null;




	    PreparedStatement pstmt= null;




			try {
				Class.forName("com.mysql.jdbc.Driver");

				} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
				}




			try {


				conn = DriverManager.getConnection(url,id,pass);


				String query = "insert into sales values(null,?,?,now(),?)";
				pstmt = conn.prepareStatement(query);



				CartBean cartbean = new CartBean();



				for(int i = 0; i < a.size(); i++) {

					cartbean = a.get(i);
					pstmt.setInt(1,user_id);
					pstmt.setInt(2,cartbean.getProcd());
					pstmt.setInt(3,cartbean.getPrice()*cartbean.getQuantity());

					pstmt.executeUpdate();
				}














			} catch (SQLException ex) {
				ex.printStackTrace();
			}finally {
				try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null) conn.close();

				}catch(Exception ex) {}

			}

	}

}




//if you wanna have results you gotta use RS