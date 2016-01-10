package zzia.cheng.cai.cookie;

import javax.servlet.http.Cookie;

/**
 * 根据用户名来查找是否存在cookie
 * 
 * @author SummerRain
 * 
 */
public class GetCookie {
	public static Cookie findCookie(Cookie[] cookies, String name) {
		if (cookies == null) {// 没有cookie
			return null;
		} else {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie;
				}
			}
			return null;
		}
	}
}
