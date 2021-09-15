package com.ss.jb.thirteen;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Cesar Camarena
 *
 */
public class BasicLambdas {

	public static void main(String[] args) {
		// 1) Basic lambdas.Make an array containing a few Strings. Sort it by
		//		length
		//		reverse length
		//		alphabetically by the first character only
		//		strings that contain "e" first, everything else second
		//		redo previous problem, but use a static helper method so that
		//			your lambda looks like this:
		//				Arrays.sort(words, (s1, s2) -> Utils.yourMethod(s1, s2))
		
		//Prints out list of strings
		System.out.println("LIST OF STRINGS:");
		List<String> strings = Arrays.asList("Array", "of", "strings", "test", "elephant", "anime");
		for(String s : strings) {System.out.println(s);}
		
		
		//Sorted by length
		System.out.println("\nSORTED BY LENGTH:");
		Collections.sort(strings, (a, b)->(a.length() - b.length()));
		for(String s : strings) {System.out.println(s);}
		
		//Sorted by reverse length
		System.out.println("\nSORTED BY REVERSE LENGTH:");
		Collections.sort(strings, (a, b)-> (b.length() - a.length()));
		for(String s : strings) {System.out.println(s);}
		
		//Alphabetically sorted by the first character only
		System.out.println("\nALPHABETICALLY SORTED BY FIRST CHARACTER:");
		Collections.sort(strings, (a, b)->(a.charAt(0) - b.charAt(0)));
		for(String s : strings) {System.out.println(s);}
		
		
		//Strings that contain the letter "e" first, everything else second
		System.out.println("\nSTRINGS THAT CONTAIN 'e' FIRST:");
		Collections.sort(strings, (a, b)->{
			if (a.contains("e") && b.contains("e")) return 0;
			if (a.contains("e")) return -1;
			if (b.contains("e")) return 1;
			else return 0;
		});
		for(String s : strings) {System.out.println(s);}
		
		//Strings that contain the letter "e" with a static helper method
		System.out.println("\nSTRINGS THAT CONTAIN 'e' FIRST WITH STATIC HELPER METHOD:");
		Collections.sort(strings, (a, b)->sortContainsE(a, b));
		for(String s : strings) {System.out.println(s);}
		
	}
	
	public static int sortContainsE(String a, String b) {
		if (a.contains("e") && b.contains("e")) return 0;
		if (a.contains("e")) return -1;
		if (b.contains("e")) return 1;
		else return 0;
	}
	
	
}