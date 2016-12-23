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
		    	result = true;
		    }
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
