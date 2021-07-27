package com.cron.expression.generator.Utils;
import java.util.regex.*;
public class CronRegExp {

	public static boolean isValidTime(String time)
    {
        String regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        Pattern p = Pattern.compile(regex);
        if (time == null) {
            return false;
        }
        Matcher m = p.matcher(time);
        return m.matches();
    }
	
	public static boolean isValidDaysName(String days)
    {
		String regex = "(MON)?((^|,)TUE)?((^|,)WED)?((^|,)THU)?((^|,)FRI)?((^|,)SAT)?((^|,)SUN)?";
		Pattern p = Pattern.compile(regex);
        if (days == null) {
            return false;
        }
        Matcher m = p.matcher(days);
        return m.matches();
    }
	
	public static boolean isValidMonth(String monthName)
    {
		String regex= "(?:Jan(?:uary)?|Feb(?:ruary)?|Mar(?:ch)?|Apr(?:il)?|May(?:May)?|June(?:June)?|July(?:July)?|Aug(?:ust)?|Sept(?:ember)?|Oct(?:ober)?|Nov(?:ember)?|Dec(?:ember)?)";
		Pattern p = Pattern.compile(regex);
        if (monthName == null) {
            return false;
        }
        Matcher m = p.matcher(monthName);
        return m.matches();
    }
}
