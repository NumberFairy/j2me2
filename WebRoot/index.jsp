<%@page import="zzia.cheng.cai.getDB.GetImage"%>
<%@page import="zzia.cheng.cai.getDB.GetCountFromReply"%>
<%@page import="zzia.cheng.cai.Utils.JudgeTime"%>
<%@page import="zzia.cheng.cai.Utils.TimeDifference"%>
<%@page import="zzia.cheng.cai.getDB.GetDBFromNote"%>
<%@page import="zzia.cheng.cai.cookie.GetCookie"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<%
	List<Long> time = new ArrayList<Long>();

	List<List<String>> list = GetDBFromNote.getFromNote_topicAndtime();
	List<String> topic = new ArrayList<String>();
	List<String> publishTime = new ArrayList<String>();
	List<String> content = new ArrayList<String>();
	List<String> noteID = new ArrayList<String>();
	List<String> name = new ArrayList<String>();
	topic = list.get(0);
	publishTime = list.get(1);
	content = list.get(2);
	noteID = list.get(3);
	name = list.get(4);
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
<style type="text/css"></style>
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
					GetImage.getImage(username);
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
		<div class="content">
			<table>
				<%
					for (int i = topic.size() - 1; i >= 0; i--) {
						String t = topic.get(i);
						String c = content.get(i);
						String ID = noteID.get(i);
						String author = name.get(i);
						request.setAttribute("t", t);
						request.setAttribute("c", c);
						request.setAttribute("ID", ID);
						String reply_time = publishTime.get(i);
						//通过一个方法，来算得发布时间距离现在的时间差
						//返回的是一个集合---days  hours  minutes  seconds
						time = TimeDifference.timeDifference(publishTime.get(i));
						String getReplyTime = JudgeTime.getReplyTime(time);
						//获得回复条数
						int count = GetCountFromReply.getCount(ID);
				%>
				<tr>
					<td class="tdImg"><img src="/j2me2/images/<%=author + ".jpg"%>" />
					</td>
					<td><span class="qustion_topic"><a
							href="/j2me2/pages/detail.jsp?t=<%=t%>&c=<%=c%>&ID=<%=ID%>"><%=t%></a>
					</span><br />
						<div class="question_detail">
							<span>作者：<%=author%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发布时间：<%=getReplyTime%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=count%>回复</span>
						</div>
					</td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
		<div class="content_right">
			<div class="showtop">
				<h3>LazyBone = clever fairy</h3>
				<span>lazyBone是你分享知识探索未知的地方</span>
				<hr />
			</div>
			<%
				if (username == null) {
			%>
			<div class="btn">
				<input type="button" value="现在去注册"
					onclick="window.location.href='/j2me2/pages/register.jsp'"
					style="cursor: pointer;" />
			</div>
			<%
				} else {
			%>
			<div class="detailMsg">
				<table>
					<tr>
						<td><img
							src="/j2me2/images/<%=(String) request.getSession()
						.getAttribute("username") + ".jpg"%>" />
						</td>
						<td>&nbsp;&nbsp;<span><a
								href="/j2me2/pages/owerMessage.jsp"><%=request.getSession().getAttribute("username")%></a>
						</span>
						</td>
					</tr>
				</table>


				<h5>
					<img src="/j2me2/images/sendMessage.jpg" /><a
						href="/j2me2/checksendmessage">提出你的疑问，分享你的成果</a>
				</h5>
			</div>
			<%
				}
			%>

		</div>
	</div>
</body>
</html>
