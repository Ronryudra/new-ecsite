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

import dao.CategoryDao;
import dao.UserDao;
import model.CategoryBean;
import model.UserBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");




//	    !!!!  It's goint to get parameter from jsp'a form !!!!!

		String name = request.getParameter("name");

		String password = request.getParameter("password");










		if (name.equals("") || password.equals("")) {

			request.setAttribute("error", "Type your name and password ");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Login.jsp");

			dispatcher.forward(request, response);
			return;

		}





//		!!!! Use Dao !!!!

		UserDao userdao = new UserDao();

		UserBean u = userdao.login(name, password);







		if (u.getLoginid() == null || u.getLoginpassword() == null) {

			request.setAttribute("error", "Name or Password doesn't match");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Login.jsp");

			dispatcher.forward(request, response);
			return;



		} else {

//          !!!!!  you gotta prepare the search page after idenifying cd and pw.
//            At the same time, category and product should be equiped.!!!!!!!!



//			in order to summon DAO's method and use it, we will create someting to get


			CategoryDao cd = new CategoryDao();

			ArrayList<CategoryBean> clist = cd.getAllCategory();


			HttpSession session = request.getSession(true);


//			!!!!!  this is for login  !!!!
			session.setAttribute("userinformation", u);


//			!!!!  this is for category !!!!
			session.setAttribute("getcategory", clist);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Search.jsp");
			dispatcher.forward(request, response);


			return;

		}
	}

	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	// TODO 自動生成されたメソッド・スタブ

		 RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Login.jsp");

			dispatcher.forward(request, response);
			return;

	 }
}
