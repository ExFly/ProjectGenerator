package cn.exfly.handler.resource;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.exfly.util.DBConfiger;
import cn.exfly.util.UserInfor;


@WebServlet("/News")
public class News extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public News() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 检查
		String DatabaseDriver=getServletContext().getInitParameter("DatabaseDriver");
		String DatabaseUrl=getServletContext().getInitParameter("DatabaseUrl");
		String dbusername=getServletContext().getInitParameter("username");
		String dbpassword=getServletContext().getInitParameter("password");
		DBConfiger DBCONFIG = DBConfiger.getInstance(DatabaseDriver, DatabaseUrl, dbusername, dbpassword);
		
		HttpSession session = request.getSession();
		UserInfor ui = (UserInfor) session.getAttribute("userinfo");
		int power = 8;
		String username="";
		if(ui != null){
			power = ui.power;
			username = ui.username;
		}
		List<cn.exfly.util.NewsObject> list = cn.exfly.model.News.getNews(username, power, DBCONFIG);
		 
		request.setAttribute("newsdataList", list);  //添加数据
		ServletContext application = this.getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/resource/news.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

