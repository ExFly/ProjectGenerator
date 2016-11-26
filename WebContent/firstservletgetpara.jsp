<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>从servlet跳转过来，并显示命名空间中的属性值</title>
</head>
<body>
  <%=request.getAttribute("name")%>
  <%
    //response.sendRedirect("/javaeeGenerator/test.jsp");
	//application.getRequestDispatcher("/test.jsp").forward(request, response);//servelet跳转
  %>
</body>
</html>
