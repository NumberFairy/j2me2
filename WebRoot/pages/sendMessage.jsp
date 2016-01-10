<%@page import="zzia.cheng.cai.cookie.GetCookie"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>懒虫寻你千百度</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="/j2me2/css/index.css">
<link rel="stylesheet" type="text/css" href="/j2me2/css/sendMessage.css">
<style type="text/css">
#cancel {
	font-size: 14px;
}

#cancel a:LINK {
	text-decoration: none;
}

#cancel a:HOVER {
	color: blue;
	text-shadow: maroon;
}
</style>
</head>
<body>
	<div class="top">
		<form class="top_form">
			<input id="search" type="text" name="search" placeholder="searcher" />
			<%
				String username = (String) request.getSession().getAttribute(
						"username");
				if (username == null) {
			%>
			<input class="form_btn" type="button" value="login"
				onclick="location.href='/j2me2/pages/login.jsp'" /> <input
				class="form_btn" type="button" value="regiser"
				onclick="location.href='/j2me2/pages/register.jsp'" />
			<%
				} else {
			%>
			<h2
				style="color:red;float: right;line-height: 50px;text-align: center;padding-right: 100px;">
				欢迎你，${username }<span id="cancel"><a
					href="/j2me2/pages/cancel.jsp">&nbsp;&nbsp;&nbsp;&nbsp;注销</a>
				</span>
			</h2>
			<%
				}
			%>
		</form>
	</div>
	<div class="allcontent">
		<div class="content">
			<h3>
				<a href="/j2me2/index.jsp">懒虫寻你千百度</a>--->提出你的疑问，分享你的成果
			</h3>
			<hr />
			<form action="/j2me2/getmessage" method="post">
				<h4 class="h4">主题</h4>
				<textarea name="topic" rows="1"
					placeholder="请输入你的主题标题，如果标题能够表达完整内容，则正文可以为空"></textarea>
				<hr />
				<h4 class="h4">正文</h4>
				<textarea name="main_body" style="height:250px;padding-left: 20px;"
					cols="20"></textarea>
				<input class="publish" type="submit" value="  发布" />
			</form>
		</div>
		<!-- 详情页右边的内容有待改掉 -->
		<div class="content_right">
			<h4 class="h4">发帖提示</h4>
			<hr />
			<ul id="ul1">
				<li class="li1">·主题标题
					<ul id="ul2">
						<li>请在标题中描述内容要点。如果一件事情在标题的长度内就已经可以说清楚，那就没有必要写正文了。</li>
					</ul>
				</li>
				<li class="li1">·正文
					<ul id="ul2">
						<li>可以在正文中为你要发布的主题添加更多细节。</li>
					</ul>
				</li>
				<li class="li1">·尊重原创
					<ul id="ul2">
						<li>请不要在 发布任何盗版下载链接，包括软件、音乐、电影等等。LazyBone 是创意工作者的社区，我们尊重原创。</li>
					</ul>
				</li>
				<li class="li1">·友好互助
					<ul id="ul2">
						<li>保持对陌生人的友善。用知识去帮助别人。</li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>
