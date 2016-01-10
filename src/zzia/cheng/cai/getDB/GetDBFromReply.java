package zzia.cheng.cai.getDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import zzia.cheng.cai.Utils.ConnectDataBase;

/**
 * 这个类完成对t_reply这个表的查询
 * 
 * 按照noteID来 查询username、content、replyTime
 * 
 * @author SummerRain
 * 
 */
public class GetDBFromReply {
	public static List<List<String>> getDB(String noteID) throws Exception {
		List<String> user = new ArrayList<String>();
		List<String> cont = new ArrayList<String>();
		List<String> time = new ArrayList<String>();
		List<List<String>> list = new ArrayList<List<String>>();
		Connection con = ConnectDataBase.getConnection();
		PreparedStatement ps = con
				.prepareStatement("select * from t_reply where noteID=?");
		ps.setString(1, noteID);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String username = rs.getString("username");
			String content = rs.getString("content");
			String replyTime = rs.getString("replyTime");
			user.add(username);
			cont.add(content);
			time.add(replyTime);
			
			list.add(user);
			list.add(cont);
			list.add(time);
		}
		return list;
	}

	/**
	 * 测试上面的方法
	 * 
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		List<String> user = new ArrayList<String>();
		List<String> cont = new ArrayList<String>();
		List<String> time = new ArrayList<String>();
		List<List<String>> list = new ArrayList<List<String>>();
		list = GetDBFromReply.getDB("7ba42137562a4c0ead3562a5c4599ce2");
		user = list.get(0);
		cont = list.get(1);
		time = list.get(2);
		System.out.println(user);
		System.out.println(cont);
		System.out.println(time);
	}
}
