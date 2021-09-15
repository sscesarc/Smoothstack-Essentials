package com.ss.jb.thirteen;

import java.util.Arrays;
import java.util.List;

public class CommaInt {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 16, 20, 25, 232, 500);
		
		StringBuilder s = new StringBuilder();
		
		list.forEach((i) -> {
			if (i % 2 == 0) {
				s.append("e" + i.toString() + ", ");
			}
			else {
				s.append("o" + i.toString() + ", ");
			}
		});
		
		System.out.println(s.toString());
	}

}
