package zzia.cheng.cai.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

/**
 * 根据传入的参数算得当前时间与参数的时间差
 * 
 * @author SummerRain
 * 
 */
public class TimeDifference {
	public static List<Long> timeDifference(String time) {
		List<Long> timeList = new ArrayList<Long>();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date d = df.parse(time);
			Long ago = d.getTime();
			Long now = System.currentTimeMillis();
			Long difference = now - ago;
			timeList = getTime(difference);
			return timeList;

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据毫秒值来计算时间
	 * 
	 * 返回值是一个集合--天数差、小时差、分钟差、秒数差
	 * 
	 * @param l
	 */
	public static List<Long> getTime(Long different) {
		List<Long> timeList = new ArrayList<Long>();

		long secondsInMilli = 1000;
		long minutesInMilli = secondsInMilli * 60;
		long hoursInMilli = minutesInMilli * 60;
		long daysInMilli = hoursInMilli * 24;

		long elapsedDays = different / daysInMilli;
		different = different % daysInMilli;

		long elapsedHours = different / hoursInMilli;
		different = different % hoursInMilli;

		long elapsedMinutes = different / minutesInMilli;
		different = different % minutesInMilli;

		long elapsedSeconds = different / secondsInMilli;

		timeList.add(elapsedDays);
		timeList.add(elapsedHours);
		timeList.add(elapsedMinutes);
		timeList.add(elapsedSeconds);

		return timeList;
	}

	/**
	 * 测试
	 */
	@Test
	public void test1() {
		// 2015-12-15 21:54:05.493
		List<Long> list = TimeDifference
				.timeDifference("2015-12-15 21:54:05.493");
		long elapseDays = list.get(0);
		long elapseHours = list.get(1);
		long elapseMinutes = list.get(2);
		long elapseSeconds = list.get(3);
		System.out.println(elapseDays + "天" + elapseHours + "小时"
				+ elapseMinutes + "分钟" + elapseSeconds + "秒前");
	}
}
