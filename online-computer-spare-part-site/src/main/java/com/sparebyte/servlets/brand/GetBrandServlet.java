package com.sparebyte.servlets.brand;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sparebyte.service.brand.BrandServiceImpl;
import com.sparebyte.service.brand.IBrandService;

/**
 * Servlet implementation class GetBrandServlet
 */
@WebServlet("/GetBrandServlet")
public class GetBrandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBrandServlet() {
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
		
		String brandID = request.getParameter("brandID");
		
		IBrandService iBrandService = new BrandServiceImpl();
		iBrandService.getBrandById(brandID);
		
		request.setAttribute("brandID", brandID);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/brandListUpdate.jsp");
		dispatcher.forward(request, response);
		
	}

}
