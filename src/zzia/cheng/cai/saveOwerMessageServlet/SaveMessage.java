package zzia.cheng.cai.saveOwerMessageServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveMessage extends HttpServlet {

	private static final long serialVersionUID = -6716835135200697705L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置request的得到数据编码格式
		request.setCharacterEncoding("utf-8");
		String username = (String) request.getSession()
				.getAttribute("username");
		String company = request.getParameter("company");
		String job = request.getParameter("job");
		String blog = request.getParameter("blog");
		String address = request.getParameter("address");
		// 执行添加到数据库的语句
		try {
			boolean b = zzia.cheng.cai.intoDB.SaveMessage.saveMessage(username,
					company, job, blog, address);
			if (b) {
				// 信息修改成功，重定向到主页
				response.sendRedirect("/j2me2/index.jsp");
			} else {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print("信息修改失败！");
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
