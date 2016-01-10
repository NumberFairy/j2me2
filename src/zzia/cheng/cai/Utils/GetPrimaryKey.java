package zzia.cheng.cai.Utils;

import java.util.UUID;

import org.junit.Test;

public class GetPrimaryKey {
	public static String getPrimaryKey() {
		String key = UUID.randomUUID().toString();
		return key.replaceAll("-", "");
	}

	//2b3a0d0399df4e8c848d672c33f57373
	//addb022491834594945710c68c0409cd
	//74B751BF-5CA5-4526-AFB8-2AA467852976 
	/**
	 * 测试--产生唯一的ID
	 */
	@Test
	public void test1() {
		String primarykey = GetPrimaryKey.getPrimaryKey();
		System.out.println(primarykey);
	}
}
