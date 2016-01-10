package zzia.cheng.cai.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Boolean_GetPwdByUsername {
	/**
	 * 遍历数据库中user表的内容，然后和传过来的参数进行比较，都一致，就返回true
	 * 
	 * 
	 * @param username
	 * @param 这里的密码已经是密文了
	 *            ，不要再加密了pwd
	 * @return
	 * @throws Exception
	 */
	public static boolean judgeUsername(String username, String pwd)
			throws Exception {
		Connection con = ConnectDataBase.getConnection();
		String sql = "select * from t_user";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String username2 = rs.getString("username");
			String pwd2 = rs.getString("pwd");
			if (username.equals(username2) && pwd.equals(pwd2)) {
				return true;
			}
		}
		return false;
	}
}
