package com.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.app.dto.AccountantResponseDTO;
import com.app.dto.StudentRequestDTO;
import com.app.dto.StudentResponseDTO;
import com.app.model.Student;
import com.app.service.StudentService;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentService service = new StudentService();
		AccountantResponseDTO acc = (AccountantResponseDTO) request.getServletContext().getAttribute("accountant");
		if(acc != null)
		{
			List<StudentResponseDTO> res = service.getAll(acc.getBranch());
			request.getSession().setAttribute("students", res);
			response.sendRedirect("accountant-home.jsp");
		}
		else
		{
			response.sendRedirect("index.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("username");
		String course=request.getParameter("course");
		String mobile=request.getParameter("mobile");
		String father = request.getParameter("father");
		String mother = request.getParameter("mother");
		String dob=request.getParameter("dob");
		String qualification=request.getParameter("qualification");
		AccountantResponseDTO res =(AccountantResponseDTO)request.getServletContext().getAttribute("accountant");
		String branch=res.getBranch();
		
		boolean branchTest = branch !=null && !branch.equals("Select a Branch");
		boolean nameTest = name!=null && name.length() > 0;
		boolean courseTest = course!=null && course.length() > 0;
		boolean mobileTest = mobile!=null && mobile.matches("\\d+");
		boolean fatherTest = father!=null && father.length()>0;
		boolean motherTest = mother!=null && mother.length()>0;
		boolean dobTest = dob!=null && dob.length()>0;
		boolean qualificationTest = qualification!=null && qualification.length()>0;
		
		if(branchTest && nameTest && courseTest && mobileTest && fatherTest && motherTest && dobTest && qualificationTest && branch!=null)
		{
			Student s = new Student();
			s.setCourse(course);
			s.setDob(dob);
			s.setFather(father);
			s.setMobile(mobile);
			s.setMother(mother);
			s.setName(name);
			s.setQualification(qualification);
			
			StudentRequestDTO req = new StudentRequestDTO();
			req.setBranch(branch);
			req.setCourse(s.getCourse());
			req.setDob(s.getDob());
			req.setFather(s.getFather());
			req.setMobile(s.getMobile());
			req.setMother(s.getMother());
			req.setName(s.getName());
			req.setQualification(s.getQualification());
			
			StudentService service = new StudentService();
			String id = request.getParameter("id");
			
			if(id!= null) // for update
			{
				int stu_id = Integer.valueOf(id);
				int result = service.addStudent(req, stu_id);
				if(result > 0)
				{
					doGet(request, response);
				}
				
			}
			else //for insert
			{
				int result = service.addStudent(req);
				if(result > 0)
				{
					doGet(request, response);
				}	
			}
		}
		else
		{
			request.setAttribute("msg", "Please Fill the correct data!");
			request.getRequestDispatcher("create-student.jsp").forward(request, response);
		}
	}

}
