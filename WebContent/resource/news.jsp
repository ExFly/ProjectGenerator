<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<cn.exfly.util.NewsObject> list = (List<cn.exfly.util.NewsObject>)request.getAttribute("newsdataList");
	Iterator iter=list.iterator();
	 while(iter.hasNext()){
		 cn.exfly.util.NewsObject newsobject = (cn.exfly.util.NewsObject) iter.next();
		%>
			<%=newsobject.id %> + <%=newsobject.userid %> + <%=newsobject.newstittle %> + <%=newsobject.newscontent %> + <%=newsobject.publictime %> + <%=newsobject.power %><br>
		<%
	 }
	%>
</body>
</html>