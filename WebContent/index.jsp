<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.exfly.util.UserInfor" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
<% 
	UserInfor userinfo = (UserInfor)session.getAttribute("userinfo"); 
	String username = "Anonymous";
	if(userinfo != null) {
		username = userinfo.username;
	}
%>
<h1>Hello, <%=username %>!</h1>
	<%
	if(userinfo != null) {
		%>
			<a href="<%=request.getContextPath()%>/Logout">Logout</a><br>
		<%
	}else{
		%>
			<a href="<%=request.getContextPath()%>/user/loginform.jsp">signin</a>
	<%
	}
	%>


<br>
<h2>功能列表</h2>
<a href="<%=request.getContextPath()%>/News">news</a>
</body>
</html>
