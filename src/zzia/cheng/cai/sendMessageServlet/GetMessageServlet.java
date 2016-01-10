package zzia.cheng.cai.sendMessageServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzia.cheng.cai.intoDB.WriteMessageIntoDB;

/**
 * 获得发帖页面的信息-----标题、内容
 * 
 * @author SummerRain
 * 
 */
public class GetMessageServlet extends HttpServlet {

	private static final long serialVersionUID = 7852965468433609997L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//解决request请求中的中文乱码问题
		request.setCharacterEncoding("utf-8");
	
		// 得到标题、正文
		String topic = request.getParameter("topic");
		String content = request.getParameter("main_body");
		// 的到用户名
		String username = (String) request.getSession()
				.getAttribute("username");
		
		//System.out.println(topic+" "+content+"  "+username);
		// 将数据写入数据库
		try {
			boolean b = WriteMessageIntoDB.writeToDB(username, topic, content);
			if(b){//帖子成功添加到数据库
				//重定向到主页
				response.sendRedirect("/j2me2/sign/sendMessageSuccessful.html");
			}else{
				response.getWriter().print("帖子发布失败，请检查。。。。");
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
