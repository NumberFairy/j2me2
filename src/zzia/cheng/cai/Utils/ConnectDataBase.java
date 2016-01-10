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
 * �������ݿ�
 * 
 * @author SummerRain
 * 
 */
public class ConnectDataBase {
	// NO_USERNAME-----�û���������
	static final int NO_USERNAME = 0;
	// WRONG_PWD------�������
	static final int WRONG_PWD = 1;
	// SUCCESS------��½�ɹ�
	static final int SUCCESS = 2;

	static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=lazyBone";
	static final String USER = "sa";
	static final String PWD = "123456";

	/**
	 * ����һ�����Ӷ���
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
	 * �����ݲ������ݿ⣬��������н�--����--�����ĵ���ʽ����
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
		// ��pwd���м���---���������
		MessageDigest digest = MessageDigest.getInstance("MD5");
		BASE64Encoder base64Encoder = new BASE64Encoder();
		pwd = base64Encoder.encode(digest.digest(pwd.getBytes("utf-8")));
		// ������ݿ�����Ӷ���
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
		// ��pwd���м���---���������
		MessageDigest digest = MessageDigest.getInstance("MD5");
		BASE64Encoder base64Encoder = new BASE64Encoder();
		pwd = base64Encoder.encode(digest.digest(pwd.getBytes("utf-8")));

		// 1���жϣ��û���������
		// 2���ȵõ��û����û������ж��Ƿ����
		// 3���ж϶�Ӧ������
		List<String> list = Usernames.getUsername();
		if (!list.contains(username)) {
			// �û���������
			return NO_USERNAME;
		}
		// ����û��������ˣ����ж�����
		if (!Boolean_GetPwdByUsername.judgeUsername(username, pwd)) {
			// �������
			return WRONG_PWD;
		}
		// �û��������붼��ȷ
		return SUCCESS;
	}

	/**
	 * ���԰���-----���Բ��������Ƿ�����
	 * 
	 * @throws SQLException
	 * @throws Exception
	 * @throws NoSuchAlgorithmException
	 */
	@Test
	public void test1() throws SQLException, NoSuchAlgorithmException,
			Exception {
		int n = ConnectDataBase.insertData("aaa", "111", "111@1");
		System.out.println(n + "����Ӱ�죡");
	}
}
