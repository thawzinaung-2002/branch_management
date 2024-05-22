package com.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.app.dto.AccountantRequestDTO;
import com.app.dto.AccountantResponseDTO;
import com.app.model.Accountant;
import com.app.service.AccountantService;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/accLogin")
public class AccountantLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountantLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String branch = request.getParameter("branch");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		boolean branchTest = branch !=null && !branch.equals("Select a Branch");
		boolean usernameTest = username != null && username.length() > 0;
		boolean passwordTest = password != null && password.length() > 0;
		
		if(branchTest && usernameTest && passwordTest)
		{
			Accountant acc = new Accountant();
			acc.setUsername(username);
			acc.setPassword(password);
			
			AccountantRequestDTO req = new AccountantRequestDTO();
			req.setUsername(acc.getUsername());
			req.setPassword(acc.getPassword());
			req.setBranch(branch);
			
			AccountantService service = new AccountantService();
			AccountantResponseDTO res = service.checkAccountant(req);
			if(res != null)
			{
				request.getServletContext().setAttribute("accountant", res);
				response.sendRedirect("student");
			}
			else
			{
				request.setAttribute("msg", "Please fill the correct data!");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
		}
		else
		{
			request.setAttribute("msg", "Please fill the correct data!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}



}
