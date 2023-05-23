package com.sparebyte.servlets.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sparebyte.models.User;
import com.sparebyte.service.user.IUserService;
import com.sparebyte.service.user.UserServiceImpl;

/**
 * Servlet implementation class UpdateUserRoleServlet
 */
@WebServlet("/UpdateUserRoleServlet")
public class UpdateUserRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserRoleServlet() {
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
		
		String userID = request.getParameter("userID");
		String userRole = request.getParameter("userRole");
		
		System.out.println(userID);
		System.err.println(userRole);
		
		User user = new User();
		
		user.setUserId(userID);
		user.setUserRole(userRole);
		
		IUserService iUserService = new UserServiceImpl();
		iUserService.updateUserRole(userID, user);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/manageUsers.jsp");
		dispatcher.forward(request, response);
		
	}

}
