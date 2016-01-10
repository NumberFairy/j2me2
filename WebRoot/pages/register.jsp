<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Cntrol" content="no-cache">
<meta http-equiv="Expires" content="0">
<link rel="stylesheet" style="text/css" href="/j2me2/css/register_css.css">
<title>Insert title here</title>
<script type="text/javascript">
	function change() {
		document.getElementById("myImage").src = "/j2me2/checkcode?"
				+ new Date().getTime();
	}
</script>
</head>
<body>
	<div class="top">
		<form class="top_form" action="">
			<input id="search" type="text" name="search" placeholder="searcher" />
			<input class="form_btn" type="button" value="login"
				onclick="location.href='/j2me2/pages/login.jsp'" /> <input
				class="form_btn" type="button" value="regiser"
				onclick="location.href='/j2me2/pages/register.jsp'" />
		</form>
	</div>
	<div class="reg">
		<div class="reg_top">
			<span><a href="/j2me2/index.jsp">懒虫寻你千百度</a><%=" ---> 注册"%></span>
			<hr style="color:#E2E2E2" />
		</div>
		<form action="/j2me2/register" method="post">
		<h1 style="color:red;text-align: center;">${requestScope.msg }</h1>
			<table>
				<tr>
					<td class="table_left">用户名</td>
					<td class="table_right" colspan="2"><input type="text"
						name="username" /></td>
				</tr>
				<tr>
					<td class="table_left">密码</td>
					<td class="table_right" colspan="2"><input type="password"
						name="password" /></td>
				</tr>
				<tr>
					<td class="table_left">再输入密码</td>
					<td class="table_right" colspan="2"><input type="password"
						name="passwordAgain" /></td>
				</tr>
				<tr>
					<td class="table_left">电子邮箱</td>
					<td class="table_right" colspan="2"><input type="text"
						name="email" /></td>
				</tr>
				<tr>
					<td class="table_left">验证码</td>
					<td class="table_right"><input type="text" name="checkcode" />
					</td>
					<td><img id="myImage" style="cursor: pointer;"
						src="/j2me2/checkcode" onclick="change();" /></td>
				</tr>
				<tr>
					<td colspan="3"><input class="reg_btn" type="submit"
						name="register" value="register	" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>