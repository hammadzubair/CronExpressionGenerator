package com.cron.expression.generator.Service;

public interface ICronService {
	
      String cronMinutesExp(Long minute);
      String cronHourlyExp(Long hour);
      String cronOtherTimeExp(String time);
      String  cronDailyExp(String timeVal);
      String cronEveryWeekDAyExp(String val);
      String cronWeeklyExp(String weeklyTime,String days);
      String cronMonthlyExp(Long day,Long month,String time);
      String cronMonthlyByWeekExp(Long month,Long weekNo,String time,String dayName);
      String cronYearlyExp(String monthName,Long dayNo,String time);
      String cronYearlyByMonthExp(String monthName,Long weekNo,String dayName,String time);
      
}
