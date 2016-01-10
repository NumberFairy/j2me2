<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="zzia.cheng.cai.getDB.GetDBFromReply"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="zzia.cheng.cai.getDB.GetDBFromNote"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String noteID = new String(request.getParameter("ID").getBytes(
			"ISO8859-1"), "utf-8");
	request.getSession().setAttribute("noteID", noteID);
%>

<%
	//首先得到你当前点击的标题的noteID
	String note_ID = new String(request.getParameter("ID").getBytes(
			"ISO8859-1"), "utf-8");
	//根据noteID从数据库中查找相应的信息
	List<String> user = new ArrayList<String>();
	List<String> cont = new ArrayList<String>();
	List<String> time = new ArrayList<String>();
	List<List<String>> list = GetDBFromReply.getDB(note_ID);
	user = null;
	cont = null;
	time = null;

	if (!list.isEmpty()) {//非空才执行
		user = list.get(0);
		cont = list.get(1);
		time = list.get(2);
	}
	//获取系统当前时间
	Long l = System.currentTimeMillis();
	Date d = new Date(l);
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String nowTime = df.format(d);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/j2me2/css/detail.css">
<title>详情：显示当前的问题标题</title>
<style type="text/css">
.text span {
	font-family: "微软雅黑", "宋体", "隶书";
	font-size: 16px;
	line-height: 20px;
	letter-spacing: 1.5px;
}

.reply_time {
	float: right;
	font-size: 14px;
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
					href="/j2me2/pages/cancel.jsp">&nbsp;&nbsp;&nbsp;&nbsp;注销</a> </span>
			</h2>
			<%
				}
			%>
		</form>
	</div>
	<div class="allcontent">
		<div class="content_left">
			<h3 style="margin-top:10px;">
				<a href="/j2me2/index.jsp">懒虫寻你千百度</a>--->问与答
			</h3>
			<hr />
			<div class="owner_content">
				<div class="topic">
					<span><%=new String(request.getParameter("t")
					.getBytes("ISO8859-1"), "utf-8")%></span>
				</div>
				<hr />
				<div class="text">
					<span><%=new String(request.getParameter("c")
					.getBytes("ISO8859-1"), "utf-8")%><br /> <br /> <br /> <br /> </span>
				</div>
			</div>
			<%
				if (!list.isEmpty()) {
			%>
			<div class="existReply">
				<div class="totaltop">
					<span><%=cont.size()%>条回复&nbsp&nbsp|&nbsp&nbsp直到<%=nowTime%></span>
				</div>
				<hr />
				<div class="showreply">
					<%
						for (int i = 0; i < cont.size(); i++) {
					%>
					<table>
						<tr>
							<td><%=cont.get(i)%></td>
						</tr>
						<tr class="reply_time">
							<td><%=user.get(i)%></td>
							<td>&nbsp|&nbsp<%=time.get(i)%></td>
						</tr>
					</table>
					<%
						}
					%>
				</div>
			</div>
			<%
				}
			%>








			<%
				String exist = (String) request.getSession().getAttribute(
						"username");
				if (!(exist == null)) {
			%>
			<div class="comment">
				<form action="/j2me2/reply" method="post">
					<div class="add">
						<span>添加一条新回复</span>
					</div>
					<hr />
					<div class="reply">
						<textarea rows="10" name="reply_content"></textarea>
					</div>
					<input type="submit" value="回复" />
				</form>
			</div>
			<%
				}
			%>

		</div>


		<div class="content_right">
			<h4 class="h4">发帖提示</h4>
			<hr />
			<ul id="ul1">
				<li class="li1">·主题标题
					<ul id="ul2">
						<li>请在标题中描述内容要点。如果一件事情在标题的长度内就已经可以说清楚，那就没有必要写正文了。</li>
					</ul></li>
				<li class="li1">·正文
					<ul id="ul2">
						<li>可以在正文中为你要发布的主题添加更多细节。</li>
					</ul></li>
				<li class="li1">·尊重原创
					<ul id="ul2">
						<li>请不要在 发布任何盗版下载链接，包括软件、音乐、电影等等。LazyBone 是创意工作者的社区，我们尊重原创。</li>
					</ul></li>
				<li class="li1">·友好互助
					<ul id="ul2">
						<li>保持对陌生人的友善。用知识去帮助别人。</li>
					</ul></li>
			</ul>
		</div>
	</div>
</body>
</html>