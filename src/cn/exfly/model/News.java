package cn.exfly.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.exfly.util.DBConfiger;
import cn.exfly.util.DBConnector;



public class News {
	private Connection con;
	private int power;
	private String username;
	List<cn.exfly.util.NewsObject> list;
	private News(String username, int power, DBConfiger indbconfig) {
		this.power = power;
		this.username = username;
		list = (List<cn.exfly.util.NewsObject>)new ArrayList();
	}
	
	
	public static List<cn.exfly.util.NewsObject> getNews(String username, int power, DBConfiger indbconfig){
		News news = new News(username, power, indbconfig);
		news.con = DBConnector.initDBConnector(indbconfig.DatabaseDriver, indbconfig.DatabaseUrl, 
				indbconfig.username, indbconfig.password);
		news.__getNews();
		return news.list;
	}
	
	private List<cn.exfly.util.NewsObject> __getNews(){
		try{
			Statement stmt1 = con.createStatement();
		    // 4、执行SQL，获取结果
		    ResultSet rs = stmt1.executeQuery("select * from news");
		    
		    // 5、遍历并解析结果
		    while (rs.next()) {
		    	int priv = rs.getInt("private");
		    	if(hasPower(priv)){
		    		list.add(new cn.exfly.util.NewsObject(
		    					rs.getInt(1),
		    					rs.getInt(2),
		    					rs.getString(3),
		    					rs.getString(4),
		    					rs.getString(5),
		    					rs.getInt(6)
		    				));
		    	}
		    }
		}catch(Exception e) {
		}
		
		return list;
	}
	
	private boolean hasPower(int priv) {
		return power <= priv;
	}
}
