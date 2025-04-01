package com.vatsalya.view_all_students;


import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import com.vatsalya.add_student.StudentBean;


@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewAllStudentsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		
		HttpSession hs = req.getSession(false);//Accessing existing session
		
		if(hs == null) {
			
			req.setAttribute("msg", "Session Expired...");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
			
		}else {
			
			ArrayList<StudentBean> al = new ViewAllStudentsDAO().retrieve();
			hs.setAttribute("alist", al);//List object added to the session
			req.getRequestDispatcher("ViewAllStudents.jsp").forward(req, res);
			
		}
		
	}
	
}
