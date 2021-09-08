/**
 * 
 */
package com.ss.jb.three;
import java.util.Scanner;


/**
 * @author Cesar Camarena
 *
 */
public class Assignment3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Take multiple values from the command line and show the result of adding all of them
		System.out.println("Enter integers to have them summed up.");
		System.out.println("Type 'exit' when you are done.");
		int sum = 0;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
	    while (in.hasNext()) {
	    	if ("exit".equals(in.hasNext())){
	    		break;
	    	}
	    	try {
	    		sum += in.nextInt();
	    	} catch (Exception e) {
	    		System.out.println("Please enter integers only.");
	    		break;
	    	}
	    }
	    
	    System.out.println(sum);
	}

}
