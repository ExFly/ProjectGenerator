<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div>CopyRight@ 2016</div>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	out.println(path);
	out.println("<br>");
	out.println(basePath);
	out.println("<br>");
%>
<%
	out.println(request.getMethod());
	out.println(request.getProtocol());
	out.println(request.getRequestURI());
	out.println(request.getServletPath());
	out.println(request.getQueryString());
	out.println(request.getServerName());
	out.println(request.getServerPort());
	out.println(request.getRemoteAddr());
	out.println("<br>");
%>