package cn.exfly.util;

public class NewsObject {
	public int id;
	public int userid;
	public String newstittle;
	public String newscontent;
	public String publictime;
	public int power;
	public NewsObject(int id, int userid, String newstittle, String newscontent, String publictime, int power) {
		this.id = id;
		this.userid = userid;
		this.newstittle = newstittle;
		this.newscontent = newscontent;
		this.publictime = publictime;
		this.power = power;
	}
}
