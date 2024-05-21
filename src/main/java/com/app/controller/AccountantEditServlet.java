package com.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.app.dto.AccountantResponseDTO;
import com.app.service.AccountantService;

/**
 * Servlet implementation class AccountantEditServlet
 */
@WebServlet("/accountantEdit")
public class AccountantEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountantEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.valueOf(request.getParameter("id"));
		
		AccountantService ser = new AccountantService();
		AccountantResponseDTO res = ser.getOne(id);
		if(res != null)
		{
			request.setAttribute("accountant", res);
			request.getRequestDispatcher("accountant-create.jsp").forward(request, response);
		}
		
	}


}
