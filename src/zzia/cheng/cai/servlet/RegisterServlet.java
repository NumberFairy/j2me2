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
 * ʵ���û�ע��Ĺ���
 * 
 * @author SummerRain
 * 
 */
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = -6410197585998565432L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���û������������ñ����ʽ�������֤����Զ���Ǵ��
		request.setCharacterEncoding("utf-8");
		// �����������
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		String email = request.getParameter("email");
		String checkcode = request.getParameter("checkcode");
		// ���session�е���֤������
		String checkcode_session = (String) request.getSession().getAttribute(
				"checkcode_session");
		// ��֤����
		if (checkcode_session == null
				|| !request.getSession().getAttribute("checkcode_session")
						.equals(checkcode)) {
			// ��֤��Ϊ�գ������Ǵ���
			request.setAttribute("msg", "��֤�벻��ȷ");
			// ����ֻ����ת������ΪҪ��msg��ֵ����login.jspҳ����
			request.getRequestDispatcher("/pages/register.jsp").forward(
					request, response);
			return;
		}

		// ���û��������롢email�������ݿ�
		try {
			ConnectDataBase.insertData(username, pwd, email);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ע��ɹ�����ת����½ҳ��
		response.sendRedirect("/j2me2/pages/login.jsp");
		

		// ���ԣ����һ�仰
		//response.setContentType("text/html;charset=utf-8");
		//response.getWriter().print("ע��ɹ���");
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
