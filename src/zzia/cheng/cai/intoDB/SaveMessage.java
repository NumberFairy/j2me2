package zzia.cheng.cai.intoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;

import zzia.cheng.cai.Utils.ConnectDataBase;

/**
 * 将用户的进一步详细信息保存到数据库
 * 
 * @author SummerRain
 * 
 */
public class SaveMessage {
	public static boolean saveMessage(String username, String company,
			String job, String blog, String address) throws Exception {		
		String sql = "update t_user set company=?,job=?,blog=?,address=? where username=?";
		Connection con = ConnectDataBase.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, company);
		ps.setString(2, job);
		ps.setString(3, blog);
		ps.setString(4, address);
		ps.setString(5, username);
		int n = ps.executeUpdate();
		if (n <= 0) {
			return false;
		}
		return true;
	}
}
