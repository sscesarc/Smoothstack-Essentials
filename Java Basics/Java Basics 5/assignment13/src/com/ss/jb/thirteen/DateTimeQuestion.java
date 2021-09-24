package com.ss.jb.thirteen;

import java.time.LocalDate;
import java.time.YearMonth;

public class DateTimeQuestion {
    
    public static void main(String [] args) {
    	LocalDate ld = LocalDate.now();
    	int year = ld.getYear();
    	
    	for (int i = 1; i <= 12; i++) {
    		YearMonth ym = YearMonth.of(year, i);
    		
    		String month = ym.getMonth().name();
    		int days  = ym.lengthOfMonth();
    		
    		System.out.println(month + " has " + days + " days.");
    	}
    }
}