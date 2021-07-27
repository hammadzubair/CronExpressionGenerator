package com.cron.expression.generator.Utils;

public class GenerateExp {
	public static String generateCronExpression(final String seconds, final String minutes, final String hours,
            final String dayOfMonth,
            final String month, final String dayOfWeek, final String year)
{
return String.format("%1$s %2$s %3$s %4$s %5$s %6$s %7$s", seconds, minutes, hours, dayOfMonth, month, dayOfWeek, year);
}

}
