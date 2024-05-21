package com.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.app.dto.AccountantResponseDTO;
import com.app.service.AccountantService;

/**
 * Servlet implementation class AccountantDeleteServlet
 */
@WebServlet("/accountantDelete")
public class AccountantDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountantDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.valueOf(request.getParameter("id"));
		AccountantService service = new AccountantService();
		int result = service.deleteOne(id);
		if(result > 0)
		{
			request.getSession().invalidate();
			List<AccountantResponseDTO> acc = service.getAll();
			request.getSession().setAttribute("accountants", acc);
			response.sendRedirect("accountant-list.jsp");	
		}
		
	}

	

}
