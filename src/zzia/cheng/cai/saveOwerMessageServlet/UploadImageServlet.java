package zzia.cheng.cai.saveOwerMessageServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzia.cheng.cai.intoDB.UploadImage;

public class UploadImageServlet extends HttpServlet {

	private static final long serialVersionUID = -8370465827199664866L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String filePath = request.getParameter("path");
		String username = (String) request.getSession()
				.getAttribute("username");
		// ����·������ȡ�ļ�---���ֽڶ�ȡ
		try {
			int n = UploadImage.saveImage(filePath, username);
			if (n > 0) {
				// ͼƬ�ϴ��ɹ�---�ض�����ҳ
				response.sendRedirect("/j2me2/index.jsp");
			} else {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print("ͷ���ϴ�ʧ�ܣ�");
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
