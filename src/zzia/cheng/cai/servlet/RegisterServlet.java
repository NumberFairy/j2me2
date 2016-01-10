package zzia.cheng.cai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzia.cheng.cai.Utils.ConnectDataBase;

/**
 * 实现用户注册的功能
 * 
 * @author SummerRain
 * 
 */
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = -6410197585998565432L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 如果没有下面这句设置编码格式，你的验证码永远都是错的
		request.setCharacterEncoding("utf-8");
		// 获得请求数据
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		String email = request.getParameter("email");
		String checkcode = request.getParameter("checkcode");
		// 获得session中的验证码数据
		String checkcode_session = (String) request.getSession().getAttribute(
				"checkcode_session");
		// 验证码检测
		if (checkcode_session == null
				|| !request.getSession().getAttribute("checkcode_session")
						.equals(checkcode)) {
			// 验证码为空，或者是错误
			request.setAttribute("msg", "验证码不正确");
			// 这里只能用转发，因为要让msg的值传到login.jsp页面中
			request.getRequestDispatcher("/pages/register.jsp").forward(
					request, response);
			return;
		}

		// 将用户名、密码、email存入数据库
		try {
			ConnectDataBase.insertData(username, pwd, email);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 注册成功，跳转到登陆页面
		response.sendRedirect("/j2me2/pages/login.jsp");
		

		// 测试，输出一句话
		//response.setContentType("text/html;charset=utf-8");
		//response.getWriter().print("注册成功！");
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
