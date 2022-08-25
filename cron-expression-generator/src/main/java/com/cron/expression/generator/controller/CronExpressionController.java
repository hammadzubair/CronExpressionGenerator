package com.cron.expression.generator.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cron.expression.generator.Model.CronExpressionReq;
import com.cron.expression.generator.Service.ICronService;
import com.cron.expression.generator.Utils.CronRegExp;

@RestController
public class CronExpressionController {

	@Autowired	
	ICronService cronService;

	@PostMapping("/minutes")
	public ResponseEntity<String> cronMinutes(@RequestBody CronExpressionReq cronExpReq) {
		Long minute=cronExpReq.getMinutes();
		if (minute!=null && minute >= 1 && minute <= 30) {			
			return new ResponseEntity<>(cronService.cronMinutesExp(minute),HttpStatus.OK);
		}
		return new ResponseEntity<>("Incorrect Value",HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/hourly")
	public ResponseEntity<String> cronHourly(@RequestBody CronExpressionReq cronExpReq) {
		Long hour=cronExpReq.getHourly();
		String time=cronExpReq.getTime();
		String type=cronExpReq.getType();
		if(type.equals("every")) {
			if(hour!=null && hour >= 1 && hour <= 12) {				
				return new ResponseEntity<>(cronService.cronHourlyExp(hour),HttpStatus.OK);
			} 
		}
		if(type.equals("startAt")) {
			if(time!=null) {
				boolean  validTime=CronRegExp.isValidTime(time);
				if(validTime) {					
					return new ResponseEntity<>(cronService.cronOtherTimeExp(time),HttpStatus.OK);
				}
			}
		}
		return new ResponseEntity<>("Incorrect Value",HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/daily")
	public ResponseEntity<String> cronDaily(@RequestBody CronExpressionReq cronExpReq) {
		String time=cronExpReq.getTime();
		String type=cronExpReq.getType();
		if(time!=null) {
			boolean  validTime=CronRegExp.isValidTime(time);
			if(validTime) {
				if(type.equals("everyDay")) {					
					return new ResponseEntity<>(cronService.cronDailyExp(time),HttpStatus.OK);
				}
				if(type.equals("everyWeekDay")) {					
					return new ResponseEntity<>(cronService.cronEveryWeekDAyExp(time),HttpStatus.OK);
				}
			}
		}
		return new ResponseEntity<>("Incorrect Value",HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/weekly")
	public ResponseEntity<String> cronWeekly(@RequestBody CronExpressionReq cronExpReq) {
		String timeVal=cronExpReq.getTime();
		String days=cronExpReq.getDays();
		if(timeVal!=null && days!=null) {
			boolean  validTime=CronRegExp.isValidTime(timeVal);
			boolean  validDays=CronRegExp.isValidDaysName(days);
			if(validTime && validDays) {				
				return new ResponseEntity<>(cronService.cronWeeklyExp(timeVal,days),HttpStatus.OK);	
			}
		}
		return new ResponseEntity<>("Incorrect Value",HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/monthly")
	public ResponseEntity<String> cronMonthly(@RequestBody CronExpressionReq cronExpReq) {
		Long day= cronExpReq.getDayNo();
		Long month= cronExpReq.getMonth();
		String time=cronExpReq.getTime();
		Long weekNo=cronExpReq.getWeekNo();
		String dayName=cronExpReq.getDayName();
		String type=cronExpReq.getType();
		boolean  validTime=CronRegExp.isValidTime(time);
		if(validTime) {
			if(type.equals("dayMonth")) {
				if((day!=null && day >= 1 && day <= 31 ) && (month >= 1 && month <= 6)) {
					return new ResponseEntity<>(cronService.cronMonthlyExp(day,month,time),HttpStatus.OK);
				}
			}
			if(type.equals("everyMonth")) {
				if((month >= 1 && month <= 6) && (weekNo!=null && weekNo >= 1 && weekNo<= 4)) {
					boolean  validDay=CronRegExp.isValidDaysName(dayName);
					if(validDay) {						
						return new ResponseEntity<>(cronService.cronMonthlyByWeekExp(month,weekNo,time,dayName),HttpStatus.OK);
					}
				}
			}
		}
		return new ResponseEntity<>("Incorrect Value",HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/yearly")
	public ResponseEntity<String> cronYearly(@RequestBody CronExpressionReq cronExpReq) {
		String monthName= cronExpReq.getMonthName();
		Long dayNo= cronExpReq.getDayNo();
		Long weekNo=cronExpReq.getWeekNo();
		String dayName=cronExpReq.getDayName();
		String time=cronExpReq.getTime();
		String type=cronExpReq.getType();
		boolean  validMonthName=CronRegExp.isValidMonth(monthName);
		boolean  validTime=CronRegExp.isValidTime(time);
		if(validMonthName && validTime) {
			if(type.equals("yearlyMonth")) {
				if(dayNo!=null && dayNo>=1 && dayNo <=31) {					
					return new ResponseEntity<>(cronService.cronYearlyExp(monthName,dayNo,time),HttpStatus.OK);
				}
			}
			if(type.equals("yearlyDayMonth")) {
				boolean  validDay=CronRegExp.isValidDaysName(dayName);
				if(validDay) {
					if(weekNo!=null && weekNo>=1 && weekNo <=4) {						
						return new ResponseEntity<>(cronService.cronYearlyByMonthExp(monthName,weekNo,dayName,time),HttpStatus.OK);
					}
				}
			}
		}
		return new ResponseEntity<>("Incorrect Value",HttpStatus.BAD_REQUEST);
	}

}
