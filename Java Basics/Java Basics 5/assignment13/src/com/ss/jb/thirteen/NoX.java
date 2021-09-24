package com.ss.jb.thirteen;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NoX {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("ax", "bb", "cx");
//		List<String> list = Arrays.asList("xxax", "xbxbx", "xxcx");
//		List<String> list = Arrays.asList("x");
		System.out.println(noX(list));
	}
	
	private static List<String> noX(List<String> list){
		return list.stream().map(i -> i.replace("x", "")).collect(Collectors.toList());
	}
}
