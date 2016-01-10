package zzia.cheng.cai.replyServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzia.cheng.cai.Utils.GetPrimaryKey;
import zzia.cheng.cai.intoDB.WriteToReply;

public class ReplyServlet extends HttpServlet {

	private static final long serialVersionUID = -2648869222763582147L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String reply = new String(request.getParameter("reply_content")
				.getBytes("ISO8859-1"), "utf-8");
		String name = (String) request.getSession().getAttribute("username");
		String noteID = (String) request.getSession().getAttribute("noteID");
		try {
			boolean b = WriteToReply.writeToReply(name, noteID, reply);
			if (b) {// 回复成功
					// 重定向到主页
				response.sendRedirect("/j2me2/sign/reply.html");
			} else {
				response.getWriter().print("回复失败，请检查。。。。");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
