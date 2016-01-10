package zzia.cheng.cai.cookie;

import javax.servlet.http.Cookie;

/**
 * �����û����������Ƿ����cookie
 * 
 * @author SummerRain
 * 
 */
public class GetCookie {
	public static Cookie findCookie(Cookie[] cookies, String name) {
		if (cookies == null) {// û��cookie
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
