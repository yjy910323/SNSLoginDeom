<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	<a href="https://api.weibo.com/oauth2/authorize?${weiboparams}"><!-- ${params}通过LoginServlet传递 -->
  		<img alt="" src="img/weibo_login_button.png">
	</a>
	<a href="https://graph.renren.com/oauth/authorize?${renrenparams}"><!-- ${params}通过LoginServlet传递 -->
		<img src="img/renren_login_button.png"/>
	</a>
	<a href="https://www.douban.com/service/auth2/auth?${doubanparams}"><!-- ${params}通过LoginServlet传递 -->
		<img src="img/douban_login_button.png"/>
	</a>
    <a href="https://open.t.qq.com/cgi-bin/oauth2/authorize?${qwbparams}"><!-- ${params}通过LoginServlet传递 -->
		<img src="img/qwb_login_button.png"/>
	</a>
    <a href="http://api.kaixin001.com/oauth2/authorize?${kaixinparams}"><!-- ${params}通过LoginServlet传递 -->
		<img src="img/kaixin_login_button.png"/>
	</a>
    <a href="https://openapi.baidu.com/oauth/2.0/authorize?${baiduparams}"><!-- ${params}通过LoginServlet传递 -->
		<img src="img/baidu_login_button.gif"/>
	</a>
	<a href="https://api.t.163.com/oauth2/authorize?${nwbparams}"><!-- ${params}通过LoginServlet传递 -->
		<img src="img/nwb_login_button.png"/>
	</a>
	<a href="https://oauth.taobao.com/authorize?${taobaoparams}"><!-- ${params}通过LoginServlet传递 -->
		<img src="img/taobao_login_button.png"/>
	</a>
  </body>
</html>
