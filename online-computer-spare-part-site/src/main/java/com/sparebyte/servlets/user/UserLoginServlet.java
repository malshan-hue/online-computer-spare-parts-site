package com.sparebyte.servlets.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sparebyte.models.User;
import com.sparebyte.service.user.IUserService;
import com.sparebyte.service.user.UserServiceImpl;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
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
		
		String userName = request.getParameter("username");
        String password = request.getParameter("password");
		
		IUserService userService = new UserServiceImpl();
		User authenticateUser = userService.getUserByName(userName);
		
		if(authenticateUser.getUserName().equals(userName) && authenticateUser.getPassword().equals(password)) {
			
			request.getSession().setAttribute("status", "success");
			
			request.getSession().setAttribute("userID", authenticateUser.getUserId());
			request.getSession().setAttribute("user", authenticateUser.getUserName());
			request.getSession().setAttribute("role", authenticateUser.getUserRole());
			
			if(authenticateUser.getUserRole().equals("admin")) {

				response.sendRedirect("indexAdmin.jsp");	
			}
			
			if (authenticateUser.getUserRole().equals("inventory-Manager")) {

				response.sendRedirect("indexInventoryManager.jsp");
			}
			
			if (authenticateUser.getUserRole().equals("manager")) {

				response.sendRedirect("indexManager.jsp");
			}
			
			if (authenticateUser.getUserRole().equals("user")) {

				response.sendRedirect("index.jsp");
			}
			
		}
		else {
			
			request.getSession().setAttribute("status", "failed");
			request.getRequestDispatcher("/userLogin.jsp").forward(request, response);
		}
		
		
	}

}
