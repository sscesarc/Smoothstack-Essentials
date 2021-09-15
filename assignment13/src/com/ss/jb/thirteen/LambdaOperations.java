package com.ss.jb.thirteen;

import java.util.Scanner;

interface PerformOperation{
	boolean operation(int i);
}

public class LambdaOperations {

	public static void main(String[] args) {
		LambdaOperations lo = new LambdaOperations();
		try (Scanner in = new Scanner(System.in)) {
			int cases = in.nextInt();
			for(int i = 0; i < cases; i++) {
				int choice = in.nextInt();
				int value = in.nextInt();
				
				switch(choice) {
				case 1:
					if(lo.perform(lo.isOdd(), value)) System.out.println("ODD");
					else System.out.println("EVEN"); break;
				case 2:
					if(lo.perform(lo.isPrime(), value)) System.out.println("PRIME");
					else System.out.println("COMPOSITE"); break;
				case 3:
					if(lo.perform(lo.isPalindrome(), value)) System.out.println("PALINDROME");
					else System.out.println("NOT A PALINDROME"); break;
				}
			}
		} return;
	}
	
	private PerformOperation isOdd() {
		PerformOperation po = (i -> {
			if(i % 2 == 0) return false;
			else return true;
		}); return po;
	}
	
	private PerformOperation isPrime() {
		PerformOperation po = (i -> {
			if (i <= 1) return false;
			for(int a = 2; a < i; a++) if (i % a == 0) return false;
			return true;
		}); return po;
	}
	
	private PerformOperation isPalindrome() {
		PerformOperation po = (i -> {
			String s = Integer.toString(i);
			int a = 0, b = s.length() - 1;
			while (a < b) {
				if (s.charAt(a) != s.charAt(b)) return false;
				a++;
				b--;
			} return true;
		}); return po;
	}
	
	private boolean perform(PerformOperation po, int i) {
		return po.operation(i);
	}

}
