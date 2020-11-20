package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;
import dao.SalesDao;
import model.CartBean;
import model.ProductBean;
import model.UserBean;

/**
 * Servlet implementation class ConfirmationServlet
 */
@WebServlet("/confirmation")
public class ConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub





		ProductBean productbean = new ProductBean();

		ProductDao productdao = new ProductDao();




//		we don't need value since we did not use return



		HttpSession session = request.getSession(false);

		SalesDao salesdao = new SalesDao();
		CartBean cartbean = new CartBean();
		UserBean userbean = (UserBean)session.getAttribute("userinformation");

		ArrayList<CartBean> cart = new ArrayList<CartBean>();


		cart =(ArrayList<CartBean>) session.getAttribute("cartlist");


		for(int i = 0; i<cart.size(); i++) {
           cartbean = cart.get(i);

			salesdao.insert(Integer.parseInt(userbean.getLoginid()), cart);
			int x = productdao.stock(cartbean.getProcd());
			productdao.change(x-cartbean.getQuantity(), cartbean.getProcd());



		}
		session.removeAttribute("cartlist");








		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Complete.jsp");
		dispatcher.forward(request, response);


		return;




	}
//	カートにはいってるプロコード、はいってなかったらゲット

}
