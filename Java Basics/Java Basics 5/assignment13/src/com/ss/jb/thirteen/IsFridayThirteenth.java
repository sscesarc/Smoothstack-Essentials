package com.ss.jb.thirteen;

import java.time.LocalDate;

public class IsFridayThirteenth {
    public static void main(String [] args){
    	LocalDate ld = LocalDate.now();
        
        int i = ld.getDayOfWeek().getValue();
        
        if (i == 5) {
        	System.out.println(ld + " is a Friday.");
        }
        else {
        	System.out.println(ld + " is not a Friday.");
        }
    }
}