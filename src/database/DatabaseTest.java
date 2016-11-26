package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTest {
	
	public void stmtTest() {
		Connection con = null;
		Statement stmt = null;

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
		    	String password = rs.getString("password");
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
	}
	
	public void creatDatabase() {
		Connection conn = null;
		Statement stmt = null;
		String DB_NAME = "Students";
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance(); 
		    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/", "root", "toor"); 
		    stmt = conn.createStatement();
		    
		    String sql = "CREATE DATABASE " + DB_NAME + " default character set utf8 default collate utf8_general_ci;";
		    try{
		    	stmt.executeUpdate(sql);
		    } catch(Exception e) {
		    	String dsql = "Drop Database " + DB_NAME;
		    	System.out.println("Drop and Create database!");
		    	stmt.executeUpdate(dsql);
		    	stmt.executeUpdate(sql);
		    	System.out.println("Drop and Create database successful");
		    }
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			} catch(SQLException se2) {
				se2.printStackTrace();
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			} catch(SQLException se) {
				se.printStackTrace();
			}//end finally try
		}
	}
	public static void main(String[] args) {
//		new DatabaseTest().stmtTest();
		DatabaseTest database = new DatabaseTest();
//		database.creatDatabase();
		database.stmtTest();
		System.out.println("over");
	}
}
