package com.ss.jb.thirteen;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class SampleSingleton {

	private static Connection conn = null;
	
	private static volatile SampleSingleton instance = null;
	
	private SampleSingleton() {}
	
	public static SampleSingleton getInstance() {
		if (instance == null) {
			synchronized(SampleSingleton.class) {
				if (instance == null) {
					instance = new SampleSingleton();
				}
			}
		}
		return instance;
	}
	
}