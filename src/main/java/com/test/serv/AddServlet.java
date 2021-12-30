package com.test.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bean.Student;
import com.test.service.StudentService;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=(String)request.getParameter("name");
		int roll=(int)Integer.parseInt(request.getParameter("roll"));
		Student student=new Student();
		student.setName(name);
		student.setRoll(roll);
		StudentService ss=new StudentService();
		boolean b=ss.addStuent(student);
		if(b!=false)
		System.out.println("success");
		List<Student> listOfAllStudents=ss.getAllStudents();
		PrintWriter pw=response.getWriter();
		pw.print("<html>");
		pw.print("<body>");
		pw.print("<table align='center' bgcolor='pink'>");
		pw.print("<tr>");
		pw.print("<th>"+"name");
		pw.print("</th>");
		pw.print("<th>"+"roll");
		pw.print("</th>");
		
		pw.print("</tr>");
		for(Student s : listOfAllStudents)
		{
			pw.print("<tr>");
			pw.print("<td>"+s.getName()+"</td>");
			pw.print("<td>"+s.getRoll()+"</td>");
			
			pw.print("</tr>");
		}
		
		pw.print("</table>");
		
		pw.print("</body>");
		
		pw.print("</html>");
		RequestDispatcher rd=request.getRequestDispatcher("./login.html");
		rd.include(request, response);
		
		}

}
