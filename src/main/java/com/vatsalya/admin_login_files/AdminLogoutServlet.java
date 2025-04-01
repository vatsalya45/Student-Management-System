package com.vatsalya.admin_login_files;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/logout")
public class AdminLogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws IOException, ServletException
	{
		
		HttpSession hs = req.getSession(false);
		
		if(hs == null) {
			
			req.setAttribute("msg","Session Expired.<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else
		{
			req.getRequestDispatcher("Adminlogout.jsp").forward(req, res);
		}
	}
	
}
