package zzia.cheng.cai.Utils;

import java.util.List;

/**
 * 根据你传入的值---天 、小时、分钟、秒来判断你是什么时间发布的，返回一个字符串
 * 
 * @author SummerRain
 * 
 */
public class JudgeTime {
	public static String getReplyTime(List<Long> l) {
		Long elapseDays = l.get(0);
		Long elapseHourse = l.get(1);
		Long elapseMinutes = l.get(2);
		// Long elapseSeconds = l.get(3);
		if (elapseDays > 0) {
			return elapseDays + "天前发布";
		} else if (elapseHourse > 0) {
			return elapseHourse + "小时前发布";
		} else if (elapseMinutes > 10) {
			return elapseMinutes + "分钟前发布";
		} else {
			return "刚刚发布";
		}
	}
}
