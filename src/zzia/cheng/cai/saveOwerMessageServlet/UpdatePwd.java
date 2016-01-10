package zzia.cheng.cai.saveOwerMessageServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �޸�����
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
		// �жϲ���������
		try {
			int n = zzia.cheng.cai.updateDB.UpdatePwd.update(username, oldPwd,
					newPwd);
			if (n <= 0) {
				// �޸�ʧ��
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print("������������쳣��");
			} else {
				// �����޸ĳɹ�---��ת����½ҳ��
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
