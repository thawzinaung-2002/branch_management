package com.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.app.dto.AccountantResponseDTO;
import com.app.dto.StudentResponseDTO;
import com.app.service.AccountantService;
import com.app.service.StudentService;

/**
 * Servlet implementation class AccountantDeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type=request.getParameter("type");
		int id = Integer.valueOf(request.getParameter("id"));
		
		switch(type)
		{
		case "accountant":
		{
			AccountantService service = new AccountantService();
			int result = service.deleteOne(id);
			if(result > 0)
			{
				List<AccountantResponseDTO> acc = service.getAll();
				request.getSession().setAttribute("accountants", acc);
				response.sendRedirect("accountant-list.jsp");	
			}	
		}
		case "student":
		{
			StudentService service = new StudentService();
			int result = service.deleteOne(id);
			if(result > 0)
			{
				AccountantResponseDTO res = (AccountantResponseDTO) request.getServletContext().getAttribute("accountant");
				List<StudentResponseDTO> studentList = service.getAll(res.getBranch());
				request.getSession().setAttribute("students", studentList);
				response.sendRedirect("accountant-home.jsp");
			}
		}
		}
		
	}

	

}
