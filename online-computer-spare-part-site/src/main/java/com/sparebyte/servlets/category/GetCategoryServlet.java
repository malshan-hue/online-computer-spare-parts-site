package com.sparebyte.servlets.category;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sparebyte.service.category.CategoryServiceImpl;
import com.sparebyte.service.category.ICategoryService;

/**
 * Servlet implementation class GetCategoryServlet
 */
@WebServlet("/GetCategoryServlet")
public class GetCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String catID = request.getParameter("catID");
		
		ICategoryService iCategoryService = new CategoryServiceImpl();
		iCategoryService.getCategoryById(catID);
		
		request.setAttribute("catID", catID);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/categoryListUpdate.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
