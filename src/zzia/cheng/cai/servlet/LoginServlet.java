package zzia.cheng.cai.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzia.cheng.cai.Utils.ConnectDataBase;

/**
 * ����û���--��½--У��
 * 
 * @author SummerRain
 * 
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 5041415656861111714L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ȷ����֤��ı����ʽ
		request.setCharacterEncoding("utf-8");
		// �����������ı��ĸ�ʽ
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		String checkcode = request.getParameter("checkcode");
		// ���session�е���֤������
		String checkcode_session = (String) request.getSession().getAttribute(
				"checkcode_session");
		// �ж���֤��
		if (checkcode_session == null
				|| !request.getSession().getAttribute("checkcode_session")
						.equals(checkcode)) {
			// ��֤��Ϊ�գ������Ǵ���
			request.setAttribute("msg", "��֤�벻��ȷ");
			// ����ֻ����ת������ΪҪ��msg��ֵ����login.jspҳ����
			request.getRequestDispatcher("/pages/login.jsp").forward(request,
					response);
			return;
		}
		try {
			// ����number��ֵ���жϵ�½���
			int number = ConnectDataBase.selectData(username, pwd);

			// number=0----�û���������
			if (number == 0) {
				request.setAttribute("msg", "�û��������ڣ�");
				request.getRequestDispatcher("/pages/login.jsp").forward(
						request, response);
				return;
			}

			// number=1------�������
			if (number == 1) {
				request.setAttribute("msg", "�������");
				request.getRequestDispatcher("/pages/login.jsp").forward(
						request, response);
				return;
			}

			// number=2-----��½�ɹ�
			if (number == 2) {
				// ��session�����½���û���----������ҳ��ʾ
				request.getSession().setAttribute("username", username);

				// n �����ת��XX��ҳ
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
