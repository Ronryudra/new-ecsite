package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.ProductDao;
import model.CategoryBean;
import model.ProductBean;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

    @Override





    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO 自動生成されたメソッド・スタブ


//      !! you will search product information by product code !!

    	String productcd = request.getParameter("procd");

    	ProductDao pd = new ProductDao();

    	ProductBean productbean = pd.commercecode(Integer.parseInt(productcd));;



    	CategoryDao cd = new CategoryDao();
    	CategoryBean cb = new CategoryBean();

          cb = cd.getname(productbean.getCatId());


    	request.setAttribute("product",productbean);
    	request.setAttribute("Category", cb );

    	RequestDispatcher dispatcher = request.getRequestDispatcher("/view/ProductDetails.jsp");

        dispatcher.forward(request,response);
    }
















    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		request.setCharacterEncoding("UTF-8");

		 String name = request.getParameter("search");
		 int id = Integer.parseInt(request.getParameter("category"));
		 System.out.println(name);













		ArrayList<ProductBean> plist = new ArrayList<ProductBean>();
		ProductDao pd = new ProductDao();

		if(name.equals("") && id ==0) {

			   plist = pd.product();


           }else if(!name.equals("") && id ==0) {

	    	   plist = pd.product(name);


	       }else if(name.equals("") && id !=0) {

	    	   plist = pd.product(id);

	       }else if(!name.equals("") && id !=0){

	    	   plist = pd.product(name,id);

	       }else if( plist.size() == 0){

	    	   request.setAttribute("error", "There is no product");

				RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Search.jsp");

				dispatcher.forward(request, response);
				return;
	       }









       request.setAttribute("abc",plist);

       RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Search.jsp");

       dispatcher.forward(request,response);






	}




}
