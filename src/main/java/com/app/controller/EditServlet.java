package com.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.app.dto.AccountantResponseDTO;
import com.app.dto.StudentResponseDTO;
import com.app.model.Student;
import com.app.service.AccountantService;
import com.app.service.StudentService;

/**
 * Servlet implementation class AccountantEditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type=request.getParameter("type");
		int id=Integer.valueOf(request.getParameter("id"));
		switch(type)
		{
		case "accountant":
		{
			AccountantService ser = new AccountantService();
			AccountantResponseDTO res = ser.getOne(id);
			if(res != null)
			{
				request.setAttribute("accountant", res);
				request.getRequestDispatcher("accountant-create.jsp").forward(request, response);
			}
		}
		case "student":
		{
			StudentService ser = new StudentService();
			StudentResponseDTO res = ser.getOne(id);
			if(res!=null)
			{
				Student s = new Student();
				s.setCourse(res.getCourse());
				s.setDob(res.getDob());
				s.setFather(res.getFather());
				s.setMobile(res.getMobile());
				s.setMother(res.getMother());
				s.setName(res.getName());
				s.setQualification(res.getQualification());
				s.setId(res.getId());
				
				request.setAttribute("student", s);
				request.getRequestDispatcher("update-student.jsp").forward(request, response);
			}
			else
			{
				response.sendRedirect("accountant-home.jsp");
			}
		}
		}
		
	}


}
