<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>News List</title>
</head>
<body>
	<%
	List<cn.exfly.util.NewsObject> list = (List<cn.exfly.util.NewsObject>) request.getAttribute("newsdataList");
	Iterator iter=list.iterator();
	int i=0;
	%>
	<ul>
	<% 
	while(iter.hasNext()){
		 i += 1;
		 cn.exfly.util.NewsObject newsobject = (cn.exfly.util.NewsObject) iter.next();
		%>
			<li><span style="background-color: yellow;color:red;"> <%=i %> </span><%=newsobject.id %> + <%=newsobject.userid %> + <%=newsobject.newstittle %> + <%=newsobject.publictime %> + <%=newsobject.power %><br></li>
		<%
	 }
		%>
	</ul>
</body>
</html>