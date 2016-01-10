package zzia.cheng.cai.getDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import zzia.cheng.cai.Utils.ConnectDataBase;

/**
 * 根据帖子的ID来查询有多少条回复
 * 
 * @author SummerRain
 * 
 */
public class GetCountFromReply {
	public static int getCount(String noteID) throws Exception {
		int count = 0;
		Connection con = ConnectDataBase.getConnection();
		String sql = "select　* from t_reply where noteID=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, noteID);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			count++;
		}

		return count;
	}

	@Test
	public void test1() throws Exception {
		String noteID = "1957e3bf5b2643ddb022d6f341bfe488";
		int n = GetCountFromReply.getCount(noteID);
		System.out.println(n + "条回复！");
	}
}
