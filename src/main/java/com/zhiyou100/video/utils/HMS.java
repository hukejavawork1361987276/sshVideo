package com.zhiyou100.video.utils;

public class HMS {

	public static String trans(int vlength){
		int hour=vlength/3600;
		int min=vlength%3600/60;
		int s=vlength%3600%60;
		String hour1="";
		String min1="";
		String s1="";
		if (hour==0) {
				hour1="00";
		}else if (hour<10) {
			hour1="0"+hour;
		}else{
			hour1=""+hour;
		} 
		
		if (min==0) {
			min1="00";
	}else if (min<10) {
		min1="0"+min;
	}else{
		min1=""+min;
	} 
		
		if (s==0) {
			s1="00";
	}else if (s<10) {
		s1="0"+s;
	}else{
		s1=""+s;
	} 
		
	String vlengthStr=hour1+":"+min1+":"+s1;
	return vlengthStr;
	}
}
