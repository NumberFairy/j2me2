package zzia.cheng.cai.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzia.cheng.cai.Utils.ConnectDataBase;

/**
 * 完成用户的--登陆--校验
 * 
 * @author SummerRain
 * 
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 5041415656861111714L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 确保验证码的编码格式
		request.setCharacterEncoding("utf-8");
		// 向浏览器输出文本的格式
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		String checkcode = request.getParameter("checkcode");
		// 获得session中的验证码数据
		String checkcode_session = (String) request.getSession().getAttribute(
				"checkcode_session");
		// 判断验证码
		if (checkcode_session == null
				|| !request.getSession().getAttribute("checkcode_session")
						.equals(checkcode)) {
			// 验证码为空，或者是错误
			request.setAttribute("msg", "验证码不正确");
			// 这里只能用转发，因为要让msg的值传到login.jsp页面中
			request.getRequestDispatcher("/pages/login.jsp").forward(request,
					response);
			return;
		}
		try {
			// 根据number的值来判断登陆情况
			int number = ConnectDataBase.selectData(username, pwd);

			// number=0----用户名不存在
			if (number == 0) {
				request.setAttribute("msg", "用户名不存在！");
				request.getRequestDispatcher("/pages/login.jsp").forward(
						request, response);
				return;
			}

			// number=1------密码错误
			if (number == 1) {
				request.setAttribute("msg", "密码错误！");
				request.getRequestDispatcher("/pages/login.jsp").forward(
						request, response);
				return;
			}

			// number=2-----登陆成功
			if (number == 2) {
				// 用session保存登陆的用户名----方便主页显示
				request.getSession().setAttribute("username", username);

				// n 秒后跳转到XX主页
				response.sendRedirect("/j2me2/sign/left_n_seconds.html");
				//response.sendRedirect("/j2me2/index.jsp");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
