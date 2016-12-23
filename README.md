# 笔记
一共两个项目，需要根据愿功能进行扩展。
1 投票系统
	流程较简单，需要扩展功能，将流程正式一些
2 带登陆的复杂流程控制，但是没有数据库

功能 -> 流程图 设计思路
源代码和部分步骤的截图

操作约定：
主页显示普通可以看的页面，根据不同的用户权限，显示不同的页面
登陆页面，连接数据库，验证用户信息，并将用户的用户id 用户名 以及用户权限写入session
特殊页面需要过滤器验证是否登陆

文件目录
project
	src
		cn
			exfly
				util
				handler
					user
						signin
						signup
					resource
						infor
				filter
					hasPrivate
	WebContent
		user
			signin.jsp
			signup.jsp
			changeuserinfo.jsp
		resource
			news.jsp
		notice
			????

数据库设计 mis_exfly
	设计原因：
		权限管理：每个用户有自己的权限，同时用户属于一个组，这个组具有相应的权限，当用户的权限>=资源的权限时可以使用资源，否则不可以使用资源。故使用资源时需要查询用户的权限，后验证是否可以使用
		每次资源的访问都需要验证用户的权限，包括枚举资源和访问具体的资源-统一为对相应资源数据库访问
	登陆：
		用户登录时，session中添加userid username private，方便对资源的验证，也减少对于数据库访问

user
	userid		//唯一标识用户
	username
	password
	private 	// 权限
	usergroup	//用户组

private 0 1 2 4 8
8 public
0 admin
111 4 2 1

userinfo
	userid
	nickname
	phonenumber
	...

<!-- 
usergroup
	groupname
	groupprivate	//组权限 
-->

<!-- private 			//权限
	id
	resourceid
	privatetype		//777 111b own group public 读写执行 
-->

news
	id
	userid		//发布用户的人
	newstittle	//标题
	newscontent	//内容
	publictime	//发布时间
	private 	//权限

# 依赖
jstl.jar
mysql-connector-java.jar
standard.jar


# 流程图
1. 登陆