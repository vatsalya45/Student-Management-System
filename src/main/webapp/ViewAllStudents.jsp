<%@page import="com.vatsalya.add_student.StudentBean"%>
<%@page import="com.vatsalya.admin_login_files.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="com.vatsalya.*,java.util.*"
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
		ArrayList<StudentBean> al = (ArrayList<StudentBean>)session.getAttribute("alist");
		
		out.println("Page belongs to Admin : "+ab.getfName()+"<br>");
		if(al.size() == 0){
			out.println("No Students availble..<br>");
			
		}else{
				Iterator<StudentBean> it = al.iterator();
				while(it.hasNext()){
				
				StudentBean sb = (StudentBean)it.next();
				out.println(sb.getRollno()+"&nbsp&nbsp"+sb.getName()
				+"&nbsp&nbsp"+sb.getCourse()+"&nbsp&nbsp"+sb.getTotalMarks()
				+"&nbsp&nbsp"+sb.getPercentage()+"&nbsp&nbsp"+sb.getResult()
				+" <a href = 'viewm?rollno="+sb.getRollno()+"'> ViewMarks</a><br>");
			}
		}
	%>
</body>
</html>