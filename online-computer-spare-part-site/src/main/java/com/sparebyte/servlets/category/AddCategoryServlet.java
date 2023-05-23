package com.sparebyte.servlets.category;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sparebyte.models.Category;
import com.sparebyte.service.category.CategoryServiceImpl;
import com.sparebyte.service.category.ICategoryService;

/**
 * Servlet implementation class AddCategoryServlet
 */
@WebServlet("/AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCategoryServlet() {
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
		
		Category category = new Category();
		
		category.setCatName(request.getParameter("catName"));
		category.setCatDesc(request.getParameter("catDescription"));
		category.setCatCreatedDate(request.getParameter("createdDate"));
		category.setCatUpdatedDate(request.getParameter("createdDate"));
		
		ICategoryService iCategoryService = new CategoryServiceImpl();
		iCategoryService.addCategory(category);
		
		request.setAttribute("category", category);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addCategory.jsp");
		dispatcher.forward(request, response);
	}

}
