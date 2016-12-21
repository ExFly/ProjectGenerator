<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/Signin" method="post">
	username:<input type="text" name="username"><br>
	password:<input type="password" name="password"><br>
	<%
	String isLogin = (String)session.getAttribute("isLogin");
	if(isLogin!=null){
		if(isLogin.equals("false")){
	%>
		<p>message:账号或密码错误；</p>
	<% 
		}
	}	
	if(isLogin!=null){
		if(isLogin.equals("true")){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
	}
	%>
	<input type="submit" value="login">
</form>
</body>
</html>
