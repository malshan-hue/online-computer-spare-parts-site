package com.sparebyte.servlets.cart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sparebyte.models.Cart;
import com.sparebyte.service.cart.CartServiceImpl;
import com.sparebyte.service.cart.ICartService;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
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
		
		Cart cart = new Cart();
		
		cart.setUserID(request.getParameter("userID"));
		cart.setProductName(request.getParameter("productName"));
		cart.setAmount(request.getParameter("amount"));
		
		ICartService iCartService = new CartServiceImpl();
		iCartService.addToCart(cart);
		
		request.setAttribute("cart", cart);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/products.jsp");
		dispatcher.forward(request, response);
	}

}
