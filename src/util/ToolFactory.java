package util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToolFactory {
	public static void outFooter(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		PrintWriter out = response.getWriter();
		out.println(path);
		out.println("<br>");
		out.println(basePath);
		out.println("<br>");
	}
}
