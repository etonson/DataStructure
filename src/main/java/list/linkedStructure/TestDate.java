package list.linkedStructure;

import java.text.ParseException;
import java.util.Date;

public class TestDate {
public static void main(String[] args) {
	String dateStr = "2022-05-24 00:00:00";
	try {
		Date d = DateUtil.parse(dateStr);
		System.out.println(d);
		System.out.println(DateUtil.formatDate(new Date()));
	} catch (ParseException e) {
		e.printStackTrace();
	}
}
}
