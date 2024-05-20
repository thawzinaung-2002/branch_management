package com.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.app.dto.AccountantRequestDTO;
import com.app.dto.AccountantResponseDTO;
import com.app.model.Accountant;
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
		request.getSession().setAttribute("accountants", acc);
		request.getRequestDispatcher("accountant-list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String branch=request.getParameter("branch");
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		String dob=request.getParameter("dob");
		String join_date=request.getParameter("joindate");
		String salary = request.getParameter("salary");
		double salaryDob;
		
		boolean branchTest = branch !=null && !branch.equals("Select a Branch");
		boolean nameTest = name!=null && name.length() > 0;
		boolean passTest = password!=null && password.length() > 0;
		boolean dobTest = dob!=null && dob.length() > 0;
		boolean joinTest = join_date!=null && join_date.length()>0;
		
		if(salary != null && salary.matches("\\d+") && branchTest && nameTest && passTest && dobTest && joinTest)
		{
			salaryDob = Double.valueOf(salary);
			
			Accountant acc= new Accountant();
			acc.setUsername(name);
			acc.setDob(dob);
			acc.setJoin_date(join_date);
			acc.setPassword(password);
			acc.setSalary(salaryDob);
			
			AccountantRequestDTO req=new AccountantRequestDTO();
			req.setBranch(branch);
			req.setDob(acc.getDob());
			req.setJoin_date(acc.getJoin_date());
			req.setPassword(acc.getPassword());
			req.setSalary(acc.getSalary());
			req.setUsername(acc.getUsername());
			
			AccountantService service = new AccountantService();
			int result = service.addOne(req);
			if(result > 0)
			{
				doGet(request, response);
			}
		}
		else
		{
			request.getSession().setAttribute("msg", "Please fill the fields right data!");
			response.sendRedirect("accountant-create.jsp");
		}
		
	
	}

}
