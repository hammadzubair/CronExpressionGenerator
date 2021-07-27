package com.cron.expression.generator.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cron.expression.generator.Model.CronExpressionReq;
import com.cron.expression.generator.Service.ICronService;
import com.cron.expression.generator.Utils.CronRegExp;

@RestController
@SuppressWarnings({ "rawtypes","unchecked" })
public class CronExpressionController {
	
	@Autowired
	@Qualifier("cronServiceImpl")
	ICronService cronService;
	
	@PostMapping("/minutes")
       public String cronMinutes(@RequestBody CronExpressionReq cronExpReq) {
		Long minute=cronExpReq.getMinutes();
		if (minute!=null && minute >= 1 && minute <= 30) {
		String cronFormat=cronService.cronMinutesExp(minute);
		return cronFormat;
			}
		return"Incorrect Value";
			}
	
	@PostMapping("/hourly")
    public String cronHourly(@RequestBody CronExpressionReq cronExpReq) {
		Long hour=cronExpReq.getHourly();
		String time=cronExpReq.getTime();
		String type=cronExpReq.getType();
		if(type.equals("every")) {
		if(hour!=null && hour >= 1 && hour <= 12) {
		String cronFormat=cronService.cronHourlyExp(hour);
		return cronFormat;
		   } 
		}
		if(type.equals("startAt")) {
		if(time!=null) {
		boolean  validTime=CronRegExp.isValidTime(time);
		if(validTime) {
		String cronFormat=cronService.cronOtherTimeExp(time);
		return cronFormat;
		}
		 }
		}
		return "Incorrect Value";
	}
	
	@PostMapping("/daily")
    public String cronDaily(@RequestBody CronExpressionReq cronExpReq) {
		String time=cronExpReq.getTime();
		String type=cronExpReq.getType();
		if(time!=null) {
		boolean  validTime=CronRegExp.isValidTime(time);
		if(validTime) {
		if(type.equals("everyDay")) {
		String cronFormat=cronService.cronDailyExp(time);
		return cronFormat;
		   }
		if(type.equals("everyWeekDay")) {
		String cronFormat=cronService.cronEveryWeekDAyExp(time);
		return cronFormat;
		}
			}
		}
		return "Incorrect Value";
	}
	
	@PostMapping("/weekly")
    public String cronWeekly(@RequestBody CronExpressionReq cronExpReq) {
		String timeVal=cronExpReq.getTime();
		String days=cronExpReq.getDays();
		if(timeVal!=null && days!=null) {
		boolean  validTime=CronRegExp.isValidTime(timeVal);
		boolean  validDays=CronRegExp.isValidDaysName(days);
		if(validTime && validDays) {
		String cronFormat=cronService.cronWeeklyExp(timeVal,days);
		return cronFormat;	
			}
		}
		return "Incorrect Value";
	}
	
	@PostMapping("/monthly")
    public String cronMonthly(@RequestBody CronExpressionReq cronExpReq) {
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
		String cronFormat=cronService.cronMonthlyExp(day,month,time);
		return cronFormat;
		}
			}
		if(type.equals("everyMonth")) {
		if((month >= 1 && month <= 6) && (weekNo!=null && weekNo >= 1 && weekNo<= 4)) {
		boolean  validDay=CronRegExp.isValidDaysName(dayName);
		if(validDay) {
		String cronFormat=cronService.cronMonthlyByWeekExp(month,weekNo,time,dayName);
		return cronFormat;
			}
		  }
		}
	}
		return "Incorrect Value";
	}
	
	@PostMapping("/yearly")
    public String cronYearly(@RequestBody CronExpressionReq cronExpReq) {
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
		String cronFormat=cronService.cronYearlyExp(monthName,dayNo,time);
		return cronFormat;
		}
			}
		if(type.equals("yearlyDayMonth")) {
		boolean  validDay=CronRegExp.isValidDaysName(dayName);
		if(validDay) {
		if(weekNo!=null && weekNo>=1 && weekNo <=4) {
	    String cronFormat=cronService.cronYearlyByMonthExp(monthName,weekNo,dayName,time);
        return cronFormat;
		      }
		    }
		  }
		}
		return "Incorrect Value";
	}

}
