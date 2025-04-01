package com.vatsalya.add_student;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req , HttpServletResponse res ) 
			throws IOException,ServletException{
	
		HttpSession hs = req.getSession(false);
		
		if(hs==null) {
			
			req.setAttribute("msg","Session Expired. <br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
			
		}
		else {
			
			StudentBean sb = new StudentBean();
			
			String rollNo = req.getParameter("rollno");
			String name = req.getParameter("name");
			String course = req.getParameter("course");
			int coreJava = Integer.parseInt(req.getParameter("cjava"));
			int advJava = Integer.parseInt(req.getParameter("ajava"));
			int ui =Integer.parseInt(req.getParameter("ui"));
			int db =Integer.parseInt(req.getParameter("db"));
			int tools =Integer.parseInt(req.getParameter("tools"));
			int totalMarks = coreJava + advJava + ui + tools + db;
			float percentage = (float)totalMarks/5;
			String result = null;
			
			if(percentage >70) result = "A";
			else if(percentage >60) result = "B";
			else if(percentage >50) result = "C";
			else if(percentage <50) result = "D";
			
			sb.setRollno(rollNo);
			sb.setName(name);
			sb.setCourse(course);
			sb.setTotalMarks(totalMarks);
			sb.setPercentage(percentage);
			sb.setResult(result);
			
			sb.getMk().setCoreJava(coreJava);
			sb.getMk().setAdvJava(advJava);
			sb.getMk().setUi(ui);
			sb.getMk().setDb(db);
			sb.getMk().setTools(tools);
			
			int k = new AddStudentDAO().insert(sb);
			
			if(k>0) {
				
				req.setAttribute("msg", "Student Added Successfully.<br>");
				req.getRequestDispatcher("AddStudent.jsp").forward(req, res);
			}
			
		}
		
	}
}
