package zzia.cheng.cai.sendMessageServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzia.cheng.cai.intoDB.WriteMessageIntoDB;

/**
 * ��÷���ҳ�����Ϣ-----���⡢����
 * 
 * @author SummerRain
 * 
 */
public class GetMessageServlet extends HttpServlet {

	private static final long serialVersionUID = 7852965468433609997L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���request�����е�������������
		request.setCharacterEncoding("utf-8");
	
		// �õ����⡢����
		String topic = request.getParameter("topic");
		String content = request.getParameter("main_body");
		// �ĵ��û���
		String username = (String) request.getSession()
				.getAttribute("username");
		
		//System.out.println(topic+" "+content+"  "+username);
		// ������д�����ݿ�
		try {
			boolean b = WriteMessageIntoDB.writeToDB(username, topic, content);
			if(b){//���ӳɹ���ӵ����ݿ�
				//�ض�����ҳ
				response.sendRedirect("/j2me2/sign/sendMessageSuccessful.html");
			}else{
				response.getWriter().print("���ӷ���ʧ�ܣ����顣������");
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
