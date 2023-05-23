package com.sparebyte.servlets.product;

import java.io.IOException;

import javax.servlet.annotation.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sparebyte.models.Product;
import com.sparebyte.service.product.IProductService;
import com.sparebyte.service.product.ProductServiceImpl;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
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
		
		Product product = new Product();
		
		String productID = request.getParameter("productID");
		product.setProductID(productID);
		product.setProductName(request.getParameter("productname"));
		product.setProductDec(request.getParameter("description"));
		product.setProductCategory(request.getParameter("category"));
		product.setProductBrand(request.getParameter("brand"));
		product.setProductModel(request.getParameter("model"));
		product.setProductPrice(request.getParameter("price"));
		product.setProductStock(request.getParameter("stock"));
		
		System.out.println(productID);

	    
	    IProductService iProductService = new ProductServiceImpl();
		iProductService.updateProduct(productID, product);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/productList.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
