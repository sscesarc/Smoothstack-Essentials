package com.ss.jb.thirteen;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Doubling {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3);
//		List<Integer> list = Arrays.asList(6, 8, 6, 8, -1);
//		List<Integer> list = Arrays.asList();
		System.out.println(doubling(list));
	}
	
	private static List<Integer> doubling(List<Integer> list) {
		return list.stream().map(i -> i * 2).collect(Collectors.toList());
	}

}
