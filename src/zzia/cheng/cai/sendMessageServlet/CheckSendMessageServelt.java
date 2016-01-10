package zzia.cheng.cai.sendMessageServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * --当用户即将发帖子的时候，检测该用户是否登陆
 * 
 * 如果没有登陆，给出提示和链接地址
 * 
 * @author SummerRain
 * 
 */
public class CheckSendMessageServelt extends HttpServlet {

	private static final long serialVersionUID = 5726648915461946817L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String) request.getSession()
				.getAttribute("username");
		if(username==null){
			//跳转到--去登陆----去注册提示页面
			//重定向
			response.sendRedirect("/j2me2/sign/go_signIn_signUp.html");
		}else{
			//直接跳转到发帖页面
			response.sendRedirect("/j2me2/pages/sendMessage.jsp");
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
