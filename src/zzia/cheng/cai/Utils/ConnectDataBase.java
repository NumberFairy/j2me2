package zzia.cheng.cai.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import sun.misc.BASE64Encoder;

/**
 * 连接数据库
 * 
 * @author SummerRain
 * 
 */
public class ConnectDataBase {
	// NO_USERNAME-----用户名不存在
	static final int NO_USERNAME = 0;
	// WRONG_PWD------密码错误
	static final int WRONG_PWD = 1;
	// SUCCESS------登陆成功
	static final int SUCCESS = 2;

	static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=lazyBone";
	static final String USER = "sa";
	static final String PWD = "123456";

	/**
	 * 返回一个连接对象
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PWD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 将数据插入数据库，插入过程中将--密码--以密文的形式插入
	 * 
	 * @param username
	 * @param pwd
	 * @param email
	 * @return
	 * @throws SQLException
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public static int insertData(String username, String pwd, String email)
			throws SQLException, NoSuchAlgorithmException, IOException {
		// 将pwd进行加密---将密码加密
		MessageDigest digest = MessageDigest.getInstance("MD5");
		BASE64Encoder base64Encoder = new BASE64Encoder();
		pwd = base64Encoder.encode(digest.digest(pwd.getBytes("utf-8")));
		// 获得数据库的连接对象
		Connection con = ConnectDataBase.getConnection();
		File file = new File(
				"E:\\Java\\workplace_myeclipse\\j2me2\\WebRoot\\images\\pic2.jpg");
		byte[] img = new byte[1024 * 1014 * 2];
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileInputStream.read(img);
		PreparedStatement ps = con
				.prepareStatement("insert into t_user (username,pwd,email,headSculpture) values(?,?,?,?)");
		ps.setString(1, username);
		ps.setString(2, pwd);
		ps.setString(3, email);
		ps.setBytes(4, img);
		int n = ps.executeUpdate();
		return n;
	}

	public static int selectData(String username, String pwd) throws Exception {
		// 将pwd进行加密---将密码加密
		MessageDigest digest = MessageDigest.getInstance("MD5");
		BASE64Encoder base64Encoder = new BASE64Encoder();
		pwd = base64Encoder.encode(digest.digest(pwd.getBytes("utf-8")));

		// 1、判断，用户名，密码
		// 2、先得到用户的用户名，判断是否存在
		// 3、判断对应的密码
		List<String> list = Usernames.getUsername();
		if (!list.contains(username)) {
			// 用户名不存在
			return NO_USERNAME;
		}
		// 如果用户名存在了，再判断密码
		if (!Boolean_GetPwdByUsername.judgeUsername(username, pwd)) {
			// 密码错误
			return WRONG_PWD;
		}
		// 用户名和密码都正确
		return SUCCESS;
	}

	/**
	 * 测试案例-----测试插入数据是否正常
	 * 
	 * @throws SQLException
	 * @throws Exception
	 * @throws NoSuchAlgorithmException
	 */
	@Test
	public void test1() throws SQLException, NoSuchAlgorithmException,
			Exception {
		int n = ConnectDataBase.insertData("aaa", "111", "111@1");
		System.out.println(n + "行受影响！");
	}
}
