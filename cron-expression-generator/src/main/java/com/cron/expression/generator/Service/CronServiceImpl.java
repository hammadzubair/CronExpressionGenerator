package com.cron.expression.generator.Service;

import org.springframework.stereotype.Component;

import com.cron.expression.generator.Utils.Conversion;
import com.cron.expression.generator.Utils.GenerateExp;

@Component
public class CronServiceImpl   implements ICronService{
	
	@Override
	public String cronMinutesExp(Long minute){
	  String mintVal=minute.toString();
	return GenerateExp.generateCronExpression("0","0/"+mintVal,"*","1/1","*","?","*");
	}

	@Override
	public String cronHourlyExp(Long hour) {
		String hourVal=hour.toString();
	return GenerateExp.generateCronExpression("0","0","0/"+hourVal,"1/1","*","?","*");
	}

	@Override
	public String cronOtherTimeExp(String time) {
		String[] parts = time.split(":");
		String hour = parts[0]; 
		String mint = parts[1];
	return GenerateExp.generateCronExpression("0",mint,hour,"1/1","*","?","*");
	}

	@Override
	public String cronDailyExp(String timeVal) {
		String[] parts = timeVal.split(":");
		String hour = parts[0]; 
		String mint = parts[1];
	return GenerateExp.generateCronExpression("0",mint,hour,"1/1","*","?","*");
	}

	@Override
	public String cronEveryWeekDAyExp(String val) {
		String[] parts = val.split(":");
		String hour = parts[0]; 
		String mint = parts[1];
	return GenerateExp.generateCronExpression("0",mint,hour,"?","*","MON-FRI","*");
	}

	@Override
	public String cronWeeklyExp(String weeklyTime, String days) {
		String[] parts = weeklyTime.split(":");
		String hour = parts[0]; 
		String mint = parts[1];
	return GenerateExp.generateCronExpression("0",mint,hour,"?","*",days,"*");
	}

	@Override
	public String cronMonthlyExp(Long day, Long month, String time) {
		String dayVal=day.toString();
		String monthVal=month.toString();
		String[] parts = time.split(":");
		String hour = parts[0]; 
		String mint = parts[1];
	return GenerateExp.generateCronExpression("0",mint,hour,dayVal,"1/"+monthVal,"?","*");
		
	}

	@Override
	public String cronMonthlyByWeekExp(Long month, Long weekNo, String time, String dayName) {
		 String monthNo=month.toString();
		 String weekNoVal=weekNo.toString();
		 String[] parts = time.split(":");
		 String hour = parts[0]; 
		 String mint = parts[1];
	return GenerateExp.generateCronExpression("0",mint,hour,"?","1/"+monthNo,dayName+"#"+weekNoVal,"*");
	}

	@Override
	public String cronYearlyExp(String monthName, Long dayNo, String time) {
		Long monthNo=Conversion.getMonthNumber(monthName);
		 String monthNoStr=monthNo.toString();
		 String dayNoVal=dayNo.toString();
		 String[] parts = time.split(":");
		 String hour = parts[0]; 
		 String mint = parts[1];
	return GenerateExp.generateCronExpression("0",mint,hour,dayNoVal,monthNoStr,"?","*");
	}

	@Override
	public String cronYearlyByMonthExp(String monthName, Long weekNo, String dayName, String time) {
		Long monthNo=Conversion.getMonthNumber(monthName);
		 String monthNoStr=monthNo.toString();
		String weekNoVal=weekNo.toString();
		 String[] parts = time.split(":");
		 String hour = parts[0]; 
		 String mint = parts[1];
    return GenerateExp.generateCronExpression("0",mint,hour,"?",monthNoStr,dayName+"#"+weekNoVal,"*");
	}
	
}
