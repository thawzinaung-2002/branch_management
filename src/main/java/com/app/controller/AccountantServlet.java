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
 * Servlet implementation class AccountantServlet
 */
@WebServlet("/accountant")
public class AccountantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountantService service = new AccountantService();
		List<AccountantResponseDTO> acc = service.getAll();
		request.setAttribute("accountants", acc);
		request.getRequestDispatcher("accountant-list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		String dob=request.getParameter("dob");
		String join_date=request.getParameter("joindate");
		double salary = Double.valueOf(request.getParameter("salary"));
		
		boolean nameTest = name!=null && name.length() > 0;
		boolean passTest = password!=null && password.length() > 0;
		boolean dobTest = dob!=null && dob.length() > 0;
		boolean joinTest = join_date!=null && join_date.length()>0;
		boolean salaryTest = salary>0;
		
		if(nameTest && passTest && dobTest && joinTest && salaryTest)
		{
			AccountantService service = new AccountantService();
			int result = service.addOne();
			if(result > 0)
			{
				doGet(request, response);
			}
		}
		else
		{
			request.setAttribute("msg", "Please fill the fields right data!");
			request.getRequestDispatcher("accountant-create.jsp").forward(request, response);
		}
		
	
	}

}
