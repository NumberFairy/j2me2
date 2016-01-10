package zzia.cheng.cai.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * �洢���ݿ��е��������û���
 * 
 * Ҳ��List����
 * 
 * @author SummerRain
 * 
 */
public class Usernames {
	public static List<String> getUsername() throws Exception {
		// �ü��ϴ洢���е��û���
		List<String> list = new ArrayList<String>();
		Connection con = ConnectDataBase.getConnection();
		String sql = "select * from t_user";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String username = rs.getString("username");
			list.add(username);
		}
		return list;
	}

	/**
	 * ���԰���----�������е��û���
	 * 
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		List<String> list = Usernames.getUsername();
		for (String string : list) {
			System.out.println(string);
		}
	}
}
