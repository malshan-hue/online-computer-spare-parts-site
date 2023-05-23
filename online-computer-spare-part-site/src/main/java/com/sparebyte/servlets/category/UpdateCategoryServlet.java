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
 * Servlet implementation class UpdateCategoryServlet
 */
@WebServlet("/UpdateCategoryServlet")
public class UpdateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCategoryServlet() {
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
		
		String catID = request.getParameter("catID");
		category.setCatID(catID);
		category.setCatName(request.getParameter("catName"));
		category.setCatDesc(request.getParameter("catDescription"));
		category.setCatUpdatedDate(request.getParameter("updatedDate"));
		
		System.out.println(catID + request.getParameter("catName") + request.getParameter("catDescription") + request.getParameter("updatedDate"));
		
		ICategoryService iCategoryService = new CategoryServiceImpl();
		iCategoryService.updateCategory(catID, category);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/categoryList.jsp");
		dispatcher.forward(request, response);
		
		
		
		
	}

}
