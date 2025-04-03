<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "com.vatsalya.admin_login_files.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Admin</title>
<link rel = "stylesheet" type = "text/css" href = "WelcomeAdmin.css">
</head>
<body>
	<header>
		<%
			AdminBean ab = (AdminBean)session.getAttribute("abean");
			out.println("Welcone Admin :"+ab.getfName()+"<br>");
		%>
	</header>
	<main>
		<div>
			<img alt="Add Student image" src="Images/AddStudent.png">
			<a href ="Student.html"><button>Add Student</button></a>
		</div>
		<div>
			<img class = "ViewStudent" alt="View Student image" src="Images/ViewStudent.jpg">
			<a href ="view"><button>ViewAllStudents</button></a>
		</div>
		<div>
			<img alt="Add Student image" src="Images/Logout.png">
			<a href ="logout"><button>Logout</button></a>
		</div>
	</main>
	<footer>
		<p>&copy; 2025 JSP Example Inc.</p>
	</footer>
</body>
</html>