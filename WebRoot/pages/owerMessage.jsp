<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/j2me2/css/owerMessage.css">
<title>编辑个人资料</title>
<style type="text/css">

</style>
</head>
<body>
	<div class="content">
		<div class="left">
			<div class="leftContent">
				<p class="top">
					<a href="/j2me2/index.jsp">懒虫寻你千百度</a>&nbsp;&nbsp;&nbsp;>>&nbsp;&nbsp;&nbsp;<span
						class="edit">编辑资料</span>
				</p>
				<hr />	
				<div class="cont1">
					<form action="/j2me2/saveMessage" method="post">
						<table>
							<tr>
								<td class="td1">用户名</td>
								<td class="td2"><input type="text" /></td>
							</tr>
							<tr>
								<td class="td1">邮箱</td>
								<td class="td2"><input type="text" /></td>
							</tr>
							<tr>
								<td class="td1">所在公司</td>
								<td class="td2"><input type="text" name="company" /></td>
							</tr>
							<tr>
								<td class="td1">工作岗位</td>
								<td class="td2"><input type="text" name="job" /></td>
							</tr>
							<tr>
								<td class="td1">博客地址</td>
								<td class="td2"><input type="text" name="blog" /></td>
							</tr>
							<tr>
								<td class="td1">所在地</td>
								<td class="td2"><input type="text" name="address" /></td>
							</tr>
						</table>
						<input class="update" type="submit" value="保存" />
					</form>
				</div>
			</div>

			<div class="uploadPic">
				<p>上传头像</p>
				<form action="/j2me2/uploadImage" method="post">
					选择一个图片文件&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="file"
						value="浏览。。" name="path"/> <br /> <input
						class="begin" type="submit" value="开始上传" />
				</form>
			</div>
			<div class="updatepwd">
				<p>更改密码</p>
				<hr />
				<form action="/j2me2/updatePwd" method="post">
					<table>
						<tr>
							<td class="td1">当前密码</td>
							<td class="td2"><input type="password" name="oldpwd" /></td>
						</tr>
						<tr>
							<td class="td1">新密码</td>
							<td class="td2"><input type="password" name="newpwd" /></td>
						</tr>
						<tr>
							<td class=td1>再次输入新密码</td>
							<td class="td2"><input type="password" name="newpwd" /></td>
						</tr>
					</table>
					<input class="update" type="submit" value="确认修改" />
				</form>
			</div>
		</div>
		<div class="rightContent">
			<P>信息编辑注意事项</P><hr/>
			<ul class="warn">
				<li>1、确保您的信息是真实的，方便HR找到你</li>
				<li>2、尽可能的完善您的信息，以便HR了解你，便于人才的发现</li>
				<li>3、禁止使用低俗或敏感的图片作为头像</li>
				<li>4、如果你是男的，请不要用女人的照片作为头像，这样可能会产生误导</li>
			</ul>
		</div>
	</div>
</body>
</html>