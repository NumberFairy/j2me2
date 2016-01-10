package zzia.cheng.cai.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 存储数据库中的所有用用户名
 * 
 * 也用List集合
 * 
 * @author SummerRain
 * 
 */
public class Usernames {
	public static List<String> getUsername() throws Exception {
		// 用集合存储所有的用户名
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
	 * 测试案例----查找所有的用户名
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
