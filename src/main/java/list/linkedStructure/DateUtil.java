package list.linkedStructure;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public static synchronized String formatDate(Date date)throws ParseException{
        return sdf.format(date);
    }
    
    public static synchronized Date parse(String strDate) throws ParseException{
        return sdf.parse(strDate);
    }
}