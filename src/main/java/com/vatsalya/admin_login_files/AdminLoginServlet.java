package com.vatsalya.admin_login_files;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
		
		String uN = req.getParameter("uname");//uN user name 
		String pW = req.getParameter("pword");//pW user password
		
		AdminBean ab = new AdminLoginDAO().login(uN, pW);
		if(ab==null) {
			
			req.setAttribute("msg","Invalid Login Process. Try Again");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			HttpSession hs = req.getSession();//Creating new session 
			hs.setAttribute("abean", ab);//Adding the AdminBean obj to the session
			req.getRequestDispatcher("AdminLoginSuccess.jsp").forward(req, res);
		}
		
	}

}
