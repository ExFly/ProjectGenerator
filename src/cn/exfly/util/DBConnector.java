package cn.exfly.util;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.http.HttpSession;

public class DBConnector {
	private Connection con;
	String dbDriver;
	String dbUrl;
	String username;
	String password;
	public DBConnector(String dbdriver, String url, String username, String password) {
		dbDriver = dbdriver;
		dbUrl = url;
		this.username = username;
		this.password = password;
	}
	private Connection initDBConnector() {
		if(con == null) {
			try {
			    	// 1、加载MYSQL驱动，这是`Driver`的实现，MySQL的JDBC驱动类是com.mysql.jdbc.Driver
				    Class.forName(dbDriver).newInstance();
				    // 2、连接到MYSQL，通过`DriverManger`来操作`Driver`，获取数据库连接
				    con = DriverManager.getConnection(dbUrl, username, password);
			    } catch (Exception e) {
			    	// 如果有异常，进行异常处理
			    	e.printStackTrace();
			    	System.out.print("MYSQL ERROR:" + e.getMessage());
			}
		}
		return con;
	}
	
	public static Connection initDBConnector(String dbdriver, String url, String username, String password) {
		return new DBConnector(dbdriver, url, username, password).initDBConnector();
	}
}
