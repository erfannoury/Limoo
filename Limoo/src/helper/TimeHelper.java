package helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeHelper {
	/*
	 * Gets and formats current time
	 */
	public static String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
	}
	
	/*
	 * Gets and formats the provided time.
	 * To get a Date object, best way is to use this:
	 * 	Calender.getInstanceOf().getDate()
	 */
	public static String getDateTime(Date date)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return dateFormat.format(date);
	}
}
