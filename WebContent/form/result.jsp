<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>结果 | result</title>
</head>
<body>
   <%@ include file="form.jsp" %>
   <%
     String username = request.getParameter("username");
     String password = request.getParameter("password");
   %>
   
   <h1>Hello <%= username %></h1>
   <%
     if(!password.equals("password")) {
    	 response.sendRedirect("/javaeeGenerator/form/form.jsp");
     }
   %>
   <%
     if(password.equals("password")){
    	 out.println("Signed in");
     } else{
   %>
   		<p>unsigned in (input password:<%=password %>)</p>
   <%
     }
   %>
</body>
</html>