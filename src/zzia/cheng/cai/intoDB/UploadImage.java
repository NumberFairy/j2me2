package zzia.cheng.cai.intoDB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import zzia.cheng.cai.Utils.ConnectDataBase;

/**
 * 将图片以二进制形式存储到数据库中
 * 
 * @author SummerRain
 * 
 */
public class UploadImage {
	public static int saveImage(String filename, String username)
			throws Exception {
		int n = 0;
		Connection con = ConnectDataBase.getConnection();
		File file = new File(filename);
		byte[] img = new byte[1024 * 1014 * 2];
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(img);
			String sql = "update t_user set headSculpture=? where username=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setBytes(1, img);
			ps.setString(2, username);
			n = ps.executeUpdate();
			return n;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Test
	public void test1() throws Exception {
		int n = UploadImage.saveImage("C:\\Users\\SummerRain\\Desktop\\pic\\3.jpg",
				"cao");
		System.out.println(n+"条数据受影响");
	}
}
