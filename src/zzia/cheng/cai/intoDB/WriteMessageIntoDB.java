package zzia.cheng.cai.intoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import zzia.cheng.cai.Utils.ConnectDataBase;
import zzia.cheng.cai.Utils.GetPrimaryKey;

/**
 * ������������д�����ݿ�
 * 
 * @author SummerRain
 * 
 */
public class WriteMessageIntoDB {
	public static boolean writeToDB(String username, String topic,
			String content) throws Exception {
		// ��ȡnoteID
		String noteID = GetPrimaryKey.getPrimaryKey();

		Connection con = ConnectDataBase.getConnection();
		PreparedStatement ps = con
				.prepareStatement("insert into t_note values(?,?,?,?,getdate())");
		ps.setString(1, noteID);
		ps.setString(2, topic);
		ps.setString(3, content);
		ps.setString(4, username);
		int n = ps.executeUpdate();
		if (n <= 0) {
			return false;
		}
		return true;
	}

	@Test
	public void test1() throws Exception {
		boolean b = WriteMessageIntoDB.writeToDB("�ֳ�", "asd", "sdfgsdfg");
		System.out.println(b);
	}
}
