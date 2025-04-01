package com.vatsalya.update_marks;

import java.io.*;
import java.util.*;
import com.vatsalya.add_student.StudentBean;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateMarksServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
		throws IOException, ServletException
	{
		HttpSession hs = req.getSession(false);
		
		if(hs == null ) {
			req.setAttribute("msg","Session Expired.<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		
		}else {
			
			ArrayList<StudentBean> al = (ArrayList<StudentBean>) hs.getAttribute("alist");
			String rNo = req.getParameter("rollno");
			Iterator<StudentBean> it = al.iterator();
			
			while(it.hasNext()) {
				
				StudentBean sb = (StudentBean)it.next();
				if(rNo.equals(sb.getRollno())) {
					
					sb.getMk().setCoreJava(Integer.parseInt(req.getParameter("corejava")));
					sb.getMk().setAdvJava(Integer.parseInt(req.getParameter("advjava")));
					sb.getMk().setUi(Integer.parseInt(req.getParameter("ui")));
					sb.getMk().setDb(Integer.parseInt(req.getParameter("db")));
					sb.getMk().setTools(Integer.parseInt(req.getParameter("tools")));
					
					int k = new UpdateMarksDAO().update(sb);
					if(k>0) {
						
						req.setAttribute("msg", "Marks Updated. <br>");
						req.getRequestDispatcher("UpdateMarks.jsp").forward(req, res);
					}
				}
			}
		}
		
	}
}





