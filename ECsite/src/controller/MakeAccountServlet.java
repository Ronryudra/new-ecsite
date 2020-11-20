package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class MakeAccountServlet
 */
@WebServlet("/makeaccount")
public class MakeAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		String name = request.getParameter("createname");

		String password = request.getParameter("createpassword");

		UserDao ud = new UserDao();


		if(name.equals("")|| password.equals("")) {
			request.setAttribute("error", "Type your name and password ");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Makeaccount.jsp");

			dispatcher.forward(request, response);
			return;


		}

		int count = ud.count(password);


		if(count !=0) {

			request.setAttribute("error", "Please change your password ");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Makeaccount.jsp");

			dispatcher.forward(request, response);
			return;



	    }else {


            ud.makeaccount(name, password);


			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Login.jsp");

			dispatcher.forward(request, response);
			return;





	    }



	}


	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	// TODO 自動生成されたメソッド・スタブ

		 RequestDispatcher dispatcher = request.getRequestDispatcher("/view/MakeAccount.jsp");

			dispatcher.forward(request, response);
			return;

	 }

}
