package com.ss.jb.thirteen;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RightDigit {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 22, 93);
//		List<Integer> list = Arrays.asList(16, 8, 886, 8, 1);
//		List<Integer> list = Arrays.asList(10, 0);
		System.out.println(rightDigit(list));
	}
	
	private static List<Integer> rightDigit(List<Integer> list) {
		return list.stream().map(i -> i % 10).collect(Collectors.toList());
	}
}
