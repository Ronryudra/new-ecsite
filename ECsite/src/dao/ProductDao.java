package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ProductBean;


public class ProductDao {


	public ArrayList<ProductBean> product(String name) {

		ArrayList<ProductBean> pb = new ArrayList<ProductBean>();




		String url = "jdbc:mysql://localhost/art";
		String id = "root";
		String pass = "password";
	    Connection conn = null;





	    ResultSet rs = null;



	    PreparedStatement pstmt= null;




			try {
				Class.forName("com.mysql.jdbc.Driver");

				} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
				}




			try {


				conn = DriverManager.getConnection(url,id,pass);


				String query = "select * from product where pro_name like ?";
				pstmt = conn.prepareStatement(query);
                pstmt.setString(1,"%"+name+"%");





				rs = pstmt.executeQuery();

				while(rs.next()) {

					ProductBean p = new ProductBean();
					 p.setProName(rs.getString("pro_name"));
					 p.setProPrice(rs.getInt("pro_price"));
					 p.setProStock(rs.getInt("stock_no"));
					 p.setProCd(rs.getInt("pro_cd"));

					 pb.add(p);

					 }






			} catch (SQLException ex) {
				ex.printStackTrace();
			}finally {
				try {
				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null) conn.close();

				}catch(Exception ex) {}

			}



			return pb;



	}




	public ArrayList<ProductBean> product(int catid) {

		ArrayList<ProductBean> pb = new ArrayList<ProductBean>();




		String url = "jdbc:mysql://localhost/art";
		String id = "root";
		String pass = "password";
	    Connection conn = null;





	    ResultSet rs = null;



	    PreparedStatement pstmt= null;




			try {
				Class.forName("com.mysql.jdbc.Driver");

				} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
				}




			try {


				conn = DriverManager.getConnection(url,id,pass);



				String query = "select * from product where cat_id=? ";
				pstmt = conn.prepareStatement(query);
				 pstmt.setInt(1,catid);






				rs = pstmt.executeQuery();

				while(rs.next()) {

					ProductBean p = new ProductBean();
					 p.setProName(rs.getString("pro_name"));
					 p.setProPrice(rs.getInt("pro_price"));
					 p.setProStock(rs.getInt("stock_no"));
					 p.setProCd(rs.getInt("pro_cd"));

					 pb.add(p);

					 }



			} catch (SQLException ex) {
				ex.printStackTrace();
			}finally {
				try {
				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null) conn.close();

				}catch(Exception ex) {}

			}



			return pb;



	}



	public ArrayList<ProductBean> product() {

		ArrayList<ProductBean> pb = new ArrayList<ProductBean>();







		String url = "jdbc:mysql://localhost/art";
		String id = "root";
		String pass = "password";
	    Connection conn = null;





	    ResultSet rs = null;



	    PreparedStatement pstmt= null;




			try {
				Class.forName("com.mysql.jdbc.Driver");

				} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
				}




			try {


				conn = DriverManager.getConnection(url,id,pass);


				String query = "select * from product";
				pstmt = conn.prepareStatement(query);





				rs = pstmt.executeQuery();

				while(rs.next()) {

					ProductBean p = new ProductBean();
					 p.setProName(rs.getString("pro_name"));
					 p.setProPrice(rs.getInt("pro_price"));
					 p.setProStock(rs.getInt("stock_no"));
					 p.setProCd(rs.getInt("pro_cd"));

					 pb.add(p);

					 }






			} catch (SQLException ex) {
				ex.printStackTrace();
			}finally {
				try {
				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null) conn.close();

				}catch(Exception ex) {}

			}



			return pb;



	}



	public ArrayList<ProductBean> product(String name, int catid) {

		ArrayList<ProductBean> pb = new ArrayList<ProductBean>();







		String url = "jdbc:mysql://localhost/art";
		String id = "root";
		String pass = "password";
	    Connection conn = null;





	    ResultSet rs = null;



	    PreparedStatement pstmt= null;




			try {
				Class.forName("com.mysql.jdbc.Driver");

				} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
				}




			try {


				conn = DriverManager.getConnection(url,id,pass);



				String query = "select * from product where cat_id=? and pro_name like? ";
				pstmt = conn.prepareStatement(query);

				pstmt.setInt(1,catid);
				pstmt.setString(2,"%"+name+"%");







				rs = pstmt.executeQuery();

				while(rs.next()) {

					ProductBean p = new ProductBean();
					 p.setProName(rs.getString("pro_name"));
					 p.setProPrice(rs.getInt("pro_price"));
					 p.setProStock(rs.getInt("stock_no"));
					 p.setProCd(rs.getInt("pro_cd"));

					 pb.add(p);

					 }







			} catch (SQLException ex) {
				ex.printStackTrace();
			}finally {
				try {
				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null) conn.close();

				}catch(Exception ex) {}

			}



			return pb;



	}







	public ProductBean commercecode(int productcd) {

		ProductBean pb = new ProductBean();


		String url = "jdbc:mysql://localhost/art";
		String id = "root";
		String pass = "password";
	    Connection conn = null;





	    ResultSet rs = null;



	    PreparedStatement pstmt= null;




			try {
				Class.forName("com.mysql.jdbc.Driver");

				} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
				}





			try {


				conn = DriverManager.getConnection(url,id,pass);



				String query = "select * from product where pro_cd = ? ";
				pstmt = conn.prepareStatement(query);


				pstmt.setInt(1,productcd);










				rs = pstmt.executeQuery();


//		!!!!!!	the value that bring from datebase have to be contained in Bean!!!!

				while(rs.next()) {

					 pb.setProCd(rs.getInt("pro_cd"));
					 pb.setProName(rs.getString("pro_name"));
					 pb.setProPrice(rs.getInt("pro_price"));
					 pb.setProStock(rs.getInt("stock_no"));
					 pb.setProImg(rs.getString("pro_img"));
					 pb.setProMsg(rs.getString("pro_msg"));
					 pb.setCatId(rs.getInt("cat_id"));

				}










			} catch (SQLException ex) {
				ex.printStackTrace();
			}finally {
				try {
				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null) conn.close();

				}catch(Exception ex) {}

			}



		return pb;
	}





	public int stock(int procode) {




		String url = "jdbc:mysql://localhost/art";
		String id = "root";
		String pass = "password";
	    Connection conn = null;





	    ResultSet rs = null;



	    PreparedStatement pstmt= null;

	    int stock= 0;




			try {
				Class.forName("com.mysql.jdbc.Driver");

				} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
				}




			try {


				conn = DriverManager.getConnection(url,id,pass);



				String query = "select stock_no from product where pro_cd=?";
				pstmt = conn.prepareStatement(query);



				pstmt.setInt(1,procode);


				rs = pstmt.executeQuery();

				rs.next();


				stock = rs.getInt("stock_no");


//               you got stock_no under the condition of pro_cd, which pro_cd isn't definde before choosing product


			} catch (SQLException ex) {
				ex.printStackTrace();
			}finally {
				try {
				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null) conn.close();

				}catch(Exception ex) {}

			}



		return stock;
	}




	public void change (int change, int consequence) {




		String url = "jdbc:mysql://localhost/art";
		String id = "root";
		String pass = "password";
	    Connection conn = null;





	    ResultSet rs = null;



	    PreparedStatement pstmt= null;





			try {
				Class.forName("com.mysql.jdbc.Driver");

				} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
				}




			try {


				conn = DriverManager.getConnection(url,id,pass);



				String query = "update product set stock_no = ? where pro_cd = ?";
				pstmt = conn.prepareStatement(query);


				pstmt.setInt(1, change);
				pstmt.setInt(2, consequence);

//                how many could you update  i mean recode

				pstmt.executeUpdate();






			} catch (SQLException ex) {
				ex.printStackTrace();
			}finally {
				try {
				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null) conn.close();

				}catch(Exception ex) {}

			}



//		we don't need anythig from this dao
	}







}
