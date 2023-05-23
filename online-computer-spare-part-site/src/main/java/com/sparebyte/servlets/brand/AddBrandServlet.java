package com.sparebyte.servlets.brand;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sparebyte.models.Brand;
import com.sparebyte.service.brand.BrandServiceImpl;
import com.sparebyte.service.brand.IBrandService;

/**
 * Servlet implementation class AddBrandServlet
 */
@WebServlet("/AddBrandServlet")
public class AddBrandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBrandServlet() {
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
		
		Brand brand = new Brand();
		
		brand.setBrandName(request.getParameter("brandName"));
		brand.setBrandOrigin(request.getParameter("brandOrigin"));
		brand.setBrandProductFocus(request.getParameter("brandProductFocus"));
		brand.setBrandProductPortfolio(request.getParameter("brandProductPortfolio"));
		
		IBrandService iBrandService = new BrandServiceImpl();
		iBrandService.addBrand(brand);
		
		request.setAttribute("brand", brand);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addBrands.jsp");
		dispatcher.forward(request, response);
	}

}
