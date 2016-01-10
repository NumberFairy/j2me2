package zzia.cheng.cai.getDB;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import zzia.cheng.cai.Utils.ConnectDataBase;

/**
 * �ӱ��н����������ݶ�ȡ�����ش�����
 * 
 * @author SummerRain
 * 
 */
public class GetImage {
	public static void getImage(String username) throws Exception {
		Connection con = ConnectDataBase.getConnection();
		String sql = "select * from t_user where username=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			InputStream in = rs.getBinaryStream("headSculpture");
			OutputStream out = new FileOutputStream(
					"E:\\Java\\workplace_myeclipse\\j2me2\\WebRoot\\images\\" + username+".jpg");
			int len = 0;
			byte[] buff = new byte[1024 * 1024];
			while ((len = in.read(buff)) != -1) {
				out.write(buff, 0, len);
			}
			out.close();
		}else{
			int flag = 0;
		}
		//System.out.println("ͼƬ��ȡ�ɹ���");
	}

	@Test
	public void test1() throws Exception {
		GetImage.getImage("����");
	}
}
