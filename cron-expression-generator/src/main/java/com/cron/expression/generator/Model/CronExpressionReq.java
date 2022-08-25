package com.cron.expression.generator.Model;

public class CronExpressionReq {

	private Long minutes;
	private Long hourly;
	private String days;
	private Long dayNo;
	private Long month;
	private Long weekNo;
	private String dayName;
	private String monthName;
	private String time;
	private String type;

	public CronExpressionReq() {
		super();
	}

	public CronExpressionReq(Long minutes, Long hourly, String days, Long dayNo,
			Long month, Long weekNo, String dayName, String monthName, String time, String type) {
		super();
		this.minutes = minutes;
		this.hourly = hourly;
		this.days = days;
		this.dayNo = dayNo;
		this.month = month;
		this.weekNo = weekNo;
		this.dayName = dayName;
		this.monthName = monthName;
		this.time = time;
		this.type = type;
	}

	public Long getMinutes() {
		return minutes;
	}

	public void setMinutes(Long minutes) {
		this.minutes = minutes;
	}

	public Long getHourly() {
		return hourly;
	}

	public void setHourly(Long hourly) {
		this.hourly = hourly;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public Long getDayNo() {
		return dayNo;
	}

	public void setDayNo(Long dayNo) {
		this.dayNo = dayNo;
	}

	public Long getMonth() {
		return month;
	}

	public void setMonth(Long month) {
		this.month = month;
	}

	public Long getWeekNo() {
		return weekNo;
	}

	public void setWeekNo(Long weekNo) {
		this.weekNo = weekNo;
	}

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}




}