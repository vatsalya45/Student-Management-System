package com.vatsalya.view_all_students;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import com.vatsalya.add_student.StudentBean;

@SuppressWarnings("serial")
@WebServlet("/viewm")
public class ViewMarksServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException
	{
		HttpSession hs = req.getSession(false);
		
		if(hs == null) {
			
			req.setAttribute("msg","Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			
			@SuppressWarnings("unchecked")
			ArrayList<StudentBean> al = (ArrayList<StudentBean>) hs.getAttribute("alist");
			String rNo = req.getParameter("rollno");
			
			Iterator<StudentBean> it = al.iterator();
			
			while(it.hasNext()) {
				
				StudentBean sb = (StudentBean)it.next();
				if(rNo.equals(sb.getRollno())) {
					
					req.setAttribute("sbean", sb);
					req.getRequestDispatcher("ViewMarks.jsp").forward(req, res);
					break;
				}
			}
			
		}
		
	}
}
