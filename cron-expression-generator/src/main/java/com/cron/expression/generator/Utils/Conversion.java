package com.cron.expression.generator.Utils;

import java.time.Month;

public class Conversion {

	public static Long getMonthNumber(String monthName) {
		Long monthNo=(long) Month.valueOf(monthName.toUpperCase()).getValue();
	    return monthNo;
	}
}
