package cn.exfly.handler.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.exfly.model.UserDBProc;
import cn.exfly.util.DBConfiger;

/**
 * Servlet implementation class Signin
 */
@WebServlet("/Signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String DatabaseDriver=getServletContext().getInitParameter("DatabaseDriver");
		String DatabaseUrl=getServletContext().getInitParameter("DatabaseUrl");
		String dbusername=getServletContext().getInitParameter("username");
		String dbpassword=getServletContext().getInitParameter("password");
		DBConfiger DBCONFIG = DBConfiger.getInstance(DatabaseDriver, DatabaseUrl, dbusername, dbpassword);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		UserDBProc user = new UserDBProc(session, DBCONFIG);
		if(user.signin(username, password)){
			session.setAttribute("isLogin", "true");
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		} else {
			session.setAttribute("isLogin", "false");
			response.sendRedirect(request.getContextPath()+ "/user/loginform.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
