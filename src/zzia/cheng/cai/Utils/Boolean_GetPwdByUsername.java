package zzia.cheng.cai.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Boolean_GetPwdByUsername {
	/**
	 * �������ݿ���user������ݣ�Ȼ��ʹ������Ĳ������бȽϣ���һ�£��ͷ���true
	 * 
	 * 
	 * @param username
	 * @param ����������Ѿ���������
	 *            ����Ҫ�ټ�����pwd
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
