package com.ss.jb.thirteen;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LetterAStrings {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("animal", "anime", "bobby", "xbox", "playstation", "art", "halo");
		
		List<String> alist = list.stream().filter(i -> i.startsWith("a")).collect(Collectors.toList());
		
		System.out.println(alist);

	}

}
