package zzia.cheng.cai.Utils;

import java.util.List;

/**
 * �����㴫���ֵ---�� ��Сʱ�����ӡ������ж�����ʲôʱ�䷢���ģ�����һ���ַ���
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
			return elapseDays + "��ǰ����";
		} else if (elapseHourse > 0) {
			return elapseHourse + "Сʱǰ����";
		} else if (elapseMinutes > 10) {
			return elapseMinutes + "����ǰ����";
		} else {
			return "�ոշ���";
		}
	}
}
