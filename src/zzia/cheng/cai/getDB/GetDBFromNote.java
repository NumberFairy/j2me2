package zzia.cheng.cai.getDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import zzia.cheng.cai.Utils.ConnectDataBase;

/**
 * 从数据库中获取数据
 * 
 * @author SummerRain
 * 
 */
public class GetDBFromNote {

	/**
	 * 从数据库中获取帖子的标题、和发帖时间、和帖子内容---存储到集合中
	 * 
	 * @throws Exception
	 */
	public static List<List<String>> getFromNote_topicAndtime()
			throws Exception {

		List<String> topic = new ArrayList<String>();
		List<String> publishTime = new ArrayList<String>();
		List<String> content = new ArrayList<String>();
		List<String> noteID = new ArrayList<String>();
		List<String> username = new ArrayList<String>();
		List<List<String>> list = new ArrayList<List<String>>();

		Connection con = ConnectDataBase.getConnection();
		String sql = "select * from t_note order by publishTime";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String ID = rs.getString("noteID");
			String t = rs.getString("topic");
			String c = rs.getString("content");
			String d = rs.getString("publishTime");
			String u = rs.getString("username");
			topic.add(t);
			content.add(c);
			publishTime.add(d);
			noteID.add(ID);
			username.add(u);
		}
		list.add(topic);
		list.add(publishTime);
		list.add(content);
		list.add(noteID);
		list.add(username);

		rs.close();
		ps.close();
		con.close();

		return list;
	}

	@Test
	public void test1() throws Exception {
		List<List<String>> list = GetDBFromNote.getFromNote_topicAndtime();
		List<String> topic = new ArrayList<String>();
		List<String> publishTime = new ArrayList<String>();
		topic = list.get(0);
		publishTime = list.get(1);
		System.out.println(topic);
		System.out.println(publishTime);
	}
}
