package cn.exfly.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import cn.exfly.util.DBConfiger;
import cn.exfly.util.DBConnector;
import cn.exfly.util.UserInfor;


public class UserDBProc {
	private DBConfiger dbconfig;
	private HttpSession session;
	private Connection con;
	public UserDBProc(HttpSession session, DBConfiger indbconfig) {
		dbconfig = indbconfig;
		this.session = session;
	}
//	private Connection initDBConnector() {
//		if(con == null) {
//			try {
//			    	// 1、加载MYSQL驱动，这是`Driver`的实现，MySQL的JDBC驱动类是com.mysql.jdbc.Driver
//				    Class.forName(dbconfig.DatabaseDriver).newInstance();
//				    // 2、连接到MYSQL，通过`DriverManger`来操作`Driver`，获取数据库连接
//				    con = DriverManager.getConnection(dbconfig.DatabaseUrl, dbconfig.username, dbconfig.password);
//			    } catch (Exception e) {
//			    	// 如果有异常，进行异常处理
//			    	e.printStackTrace();
//			    	System.out.print("MYSQL ERROR:" + e.getMessage());
//			}
//		}
//		return con;
//	}
	private void initDBConnector() {
		con = DBConnector.initDBConnector(dbconfig.DatabaseDriver,dbconfig.DatabaseUrl,dbconfig.username,dbconfig.password);
	}
	
	public boolean signin(String _username, String _password) {
		boolean result = false;
		initDBConnector();
		PreparedStatement pstmt = null;
		try {
		    String SQL = "select * from user WHERE username=? and password=?";
		    pstmt = con.prepareStatement(SQL);
		    pstmt.setString(1,_username);
		    pstmt.setString(2,_password);
		    ResultSet rs = pstmt.executeQuery();
		    if(!rs.next()) {
		    	System.out.println(_username+" "+_password+"尝试了错的密码");
		    }else {
		    	int userid = rs.getInt("userid");
		    	String username = _username;
		    	int power = rs.getInt("private");
		    	String usergroup = rs.getString("usergroup");
		    	UserInfor userinfo = new UserInfor(userid, username, power, usergroup);
		    	session.setAttribute("userinfo", userinfo);
//		    	session.setAttribute("username", username);
//		    	session.setAttribute("power", power);
//		    	session.setAttribute("usergroup", usergroup);
		    	result = true;
		    }
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
