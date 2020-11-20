package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CartBean;

/**
 * Servlet implementation class ProductDetailsServlet
 */
@WebServlet("/product")
public class ProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub



		request.setCharacterEncoding("UTF-8");

		CartBean cartb = new CartBean();

		int s = Integer.parseInt(request.getParameter("number"));
		String h = request.getParameter("name");
		int i = Integer.parseInt(request.getParameter("price"));
		int j = Integer.parseInt(request.getParameter("code"));



		HttpSession session = request.getSession(false);



		ArrayList<CartBean> cartlist = (ArrayList<CartBean>) session.getAttribute("cartlist");

		if(cartlist == null) {

			cartlist = new ArrayList<CartBean>();

		}

		cartb.setQuantity(s);
		cartb.setName(h);
		cartb.setPrice(i);
		cartb.setProcd(j);

		cartlist.add(cartb);



		session.setAttribute("cartlist", cartlist);


		response.sendRedirect("/ECsite/view/Cart.jsp");


		return;







	}

}
