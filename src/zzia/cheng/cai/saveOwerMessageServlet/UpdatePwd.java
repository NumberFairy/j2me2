package zzia.cheng.cai.saveOwerMessageServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 修改密码
 * 
 * @author SummerRain
 * 
 */
public class UpdatePwd extends HttpServlet {

	private static final long serialVersionUID = 8697784225551193381L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String) request.getSession()
				.getAttribute("username");
		String oldPwd = request.getParameter("oldpwd");
		String newPwd = request.getParameter("newpwd");
		// 判断并更改密码
		try {
			int n = zzia.cheng.cai.updateDB.UpdatePwd.update(username, oldPwd,
					newPwd);
			if (n <= 0) {
				// 修改失败
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print("更新密码出现异常！");
			} else {
				// 密码修改成功---跳转到登陆页面
				response.sendRedirect("/j2me2/pages/login.jsp");
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
