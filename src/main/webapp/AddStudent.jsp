<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "com.vatsalya.admin_login_files.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		AdminBean ab = (AdminBean)session.getAttribute("abean");
		String msg = (String)request.getAttribute("msg");
		out.println("Page belongs to Admin : "+ab.getfName()+"<br>");
		out.println(msg);
	%>
<a href="Student.html">AddStudent</a>
<a href="view">ViewAllStudents</a>
<a href="logout">Logout</a>
</body>
</html>