package com.yuntong.dateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormatDate {
	public static String dateFormat(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(Calendar.getInstance().getTime());
	}
}
