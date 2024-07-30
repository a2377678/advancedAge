package com.example.springboot.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	
	private Date date;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	private int applyYear;
	private String month; 
	
	
	
	public DateFormatUtil() {
	}

	public DateFormatUtil(Date date) {
		this.date = date;
		this.applyYear = Integer.valueOf(sdf.format(date).substring(0,4))-1911; 
		this.month = sdf.format(date).substring(4,6); 
	}

	public Date getDate() {
		return date;
	}

	public int getApplyYear() {
		return applyYear;
	}

	public String getMonth() {
		return month;
	}
	
	
}
