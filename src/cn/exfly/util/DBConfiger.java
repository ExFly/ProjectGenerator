package cn.exfly.util;

public class DBConfiger {
	public String DatabaseDriver;
	public String DatabaseUrl;
	public String username;
	public String password;
	private static DBConfiger theOnlyOneInstance;
	private DBConfiger(String dbDriver, String dbUrl, String username, String password){
		this.DatabaseDriver = dbDriver;
		this.DatabaseUrl = dbUrl;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * 创建实例
	 * @param dbDriver
	 * @param dbUrl
	 * @param username
	 * @param password
	 * @return null
	 */
	private static void init(String dbDriver, String dbUrl, String username, String password) {
		theOnlyOneInstance = new DBConfiger(dbDriver,dbUrl, username, password);
	}
	
	/**
	 * 创建或者返回创建已经存在的实例
	 * @param dbDriver
	 * @param dbUrl
	 * @param username
	 * @param password
	 * @return theOnlyOneInstance 返回实例
	 */
	public static DBConfiger getInstance(String dbDriver, String dbUrl, String username, String password) {
		if(DBConfiger.theOnlyOneInstance == null) {
			init(dbDriver, dbUrl, username, password);
		}
		return theOnlyOneInstance;
	}

}
