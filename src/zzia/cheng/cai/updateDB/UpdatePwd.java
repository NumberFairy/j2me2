package zzia.cheng.cai.updateDB;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import sun.misc.BASE64Encoder;
import zzia.cheng.cai.Utils.ConnectDataBase;

/**
 * 更新密码
 * 
 * @author SummerRain
 * 
 */
public class UpdatePwd {
	public static int update(String username, String oldPwd, String newPwd)
			throws Exception {
		int n = 0;
		MessageDigest digest = MessageDigest.getInstance("MD5");
		BASE64Encoder base64Encoder = new BASE64Encoder();
		oldPwd = base64Encoder.encode(digest.digest(oldPwd.getBytes("utf-8")));
		newPwd = base64Encoder.encode(digest.digest(newPwd.getBytes("utf-8")));
		Connection con = ConnectDataBase.getConnection();
		String sql1 = "select pwd from t_user where username = ?";
		PreparedStatement ps = con.prepareStatement(sql1);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		String str = null;
		while (rs.next()) {
			str = rs.getString("pwd");
		}
		if (str.equals(oldPwd)) {
			// 执行更改
			String sql2 = "update t_user set pwd = ? where username = ?";
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setString(1, newPwd);
			ps2.setString(2, username);
			n = ps2.executeUpdate();
			return n;
		}
		return n;
	}

	@Test
	public void test1() throws Exception {
		int n = UpdatePwd.update("cao", "cao", "caoxu");
		System.out.println(n + "条记录受影响！");
	}
}
