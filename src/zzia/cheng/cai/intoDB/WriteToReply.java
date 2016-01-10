package zzia.cheng.cai.intoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;

import zzia.cheng.cai.Utils.ConnectDataBase;

/**
 * 这个类的功能：将用户的回复信息存储到t_reply这个表中
 * 
 * @author SummerRain
 * 
 */
public class WriteToReply {
	public static boolean writeToReply(String username, String noteID,
			String content) throws Exception {
		Connection con = ConnectDataBase.getConnection();
		PreparedStatement ps = con
				.prepareStatement("insert into t_reply values(?,?,?,getdate())");
		ps.setString(1, username);
		ps.setString(2, noteID);
		ps.setString(3, content);
		int n = ps.executeUpdate();
		if (n <= 0) {
			return false;
		}
		return true;
	}
}
