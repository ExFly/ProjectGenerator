package DBobject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class User {
	public String uuid;
	public String username;
	public String password;
	public User(String uuid, String username, String password) {
		this.uuid = uuid;
		this.username= username;
		this.password=password;
	}
	
	
	public static List<User> getAllUser(){
		Connection con = null;
		Statement stmt = null;
	    List<User> ulist = new ArrayList();
	    
		try {
		    // 1、加载MYSQL驱动，这是`Driver`的实现，MySQL的JDBC驱动类是com.mysql.jdbc.Driver
		    Class.forName("com.mysql.jdbc.Driver").newInstance(); 
		    // 2、连接到MYSQL，通过`DriverManger`来操作`Driver`，获取数据库连接
		    con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bms", "root", "toor"); 
		    // 3、创建用以执行SQL语言的声明
		    Statement stmt1 = con.createStatement();
		    // 4、执行SQL，获取结果
		    ResultSet rs = stmt1.executeQuery("select * from auth");
		    // 5、遍历并解析结果
		    while (rs.next()) {
		    	String id = rs.getString("uuid");
		    	String username = rs.getString("username");
		    	String password = rs.getString("username");
		    	
		    	ulist.add(new User(id, username, password));
		    	
		    	System.out.println(id + "\t" + username + "\t" + password);
		    }
		} catch (Exception e) {
		    // 如果有异常，进行异常处理
			e.printStackTrace();
		    System.out.print("MYSQL ERROR:" + e.getMessage());
		} finally {
		    // 6、关闭连接与声明
		    try {
		        if (stmt != null) {
		            stmt.close();
		        }
		        if (con != null) {
		            con.close();
		        }
		    } catch (SQLException e) {
		    	e.printStackTrace();
		    }
		}
		return ulist;
	}
}
