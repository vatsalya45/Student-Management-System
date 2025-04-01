package com.vatsalya.update_marks;

import java.io.*;
import java.util.*;

import com.vatsalya.add_student.StudentBean;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;


@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditMarksServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res ) 
			throws IOException, ServletException
	{
		HttpSession hs = req.getSession(false);
		
		if(hs == null ) {
			
			req.setAttribute("msg","Session Expired.<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			
			@SuppressWarnings("unchecked")
			ArrayList<StudentBean> al = (ArrayList<StudentBean>) hs.getAttribute("alist");
			String rNo = req.getParameter("rollno");
			
			Iterator<StudentBean> it = al.iterator();
			
			while(it.hasNext()) {
				
				StudentBean sb = (StudentBean)it.next();
				if(rNo.equals(sb.getRollno())) {
					
					req.setAttribute("sbean", sb);
					req.getRequestDispatcher("EditMarks.jsp").forward(req, res);
				}
			}
		}
		
		
	}

}
