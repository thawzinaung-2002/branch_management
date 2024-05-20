package com.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String sys_username = request.getServletContext().getInitParameter("username");
		String sys_password = request.getServletContext().getInitParameter("password");
		
		if(username != null && password != null)
		{
			if(username.equals(sys_username) && password.equals(sys_password))
			{
				request.getServletContext().setAttribute("username", username);
				request.getServletContext().setAttribute("password", password);
				response.sendRedirect("accountant");
			}
			else
			{
				request.setAttribute("msg", "Please fill the correct data!");
				request.getRequestDispatcher("admin-login-form.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("msg", "Please fill the fields!");
			request.getRequestDispatcher("admin-login-form.jsp").forward(request, response);
		}
	}

}
