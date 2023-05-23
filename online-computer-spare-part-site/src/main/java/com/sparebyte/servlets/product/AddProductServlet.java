package com.sparebyte.servlets.product;

import java.io.IOException;

import javax.servlet.annotation.*;
import javax.servlet.http.Part;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sparebyte.models.Product;
import com.sparebyte.service.product.IProductService;
import com.sparebyte.service.product.ProductServiceImpl;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
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
		
		product.setProductName(request.getParameter("productname"));
		product.setProductDec(request.getParameter("description"));
		product.setProductCategory(request.getParameter("category"));
		product.setProductBrand(request.getParameter("brand"));
		product.setProductModel(request.getParameter("model"));
		product.setProductPrice(request.getParameter("price"));
		product.setProductStock(request.getParameter("stock"));
		
		Part filePart = request.getPart("file");
	    String fileName = filePart.getSubmittedFileName();
	    product.setProductImagePath(fileName);
	    for (Part part : request.getParts()) {
	      part.write("D:\\Documents\\Hello World\\eclipse-workspace\\online-computer-spare-part-site\\src\\main\\webapp\\resources\\productImages\\" + fileName);
	    }
		
		IProductService iProductService = new ProductServiceImpl();
		iProductService.addProduct(product);
		
		request.setAttribute("product", product);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/indexInventoryManager.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
