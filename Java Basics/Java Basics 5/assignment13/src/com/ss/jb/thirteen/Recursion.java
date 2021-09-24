package com.ss.jb.thirteen;

public class Recursion {

	public static void main(String[] args) {
		int[] array = {2, 4, 8};
//		int[] array = {1, 2, 4, 8, 1};
//		int[] array = {2, 4, 4, 8};
		
		
		System.out.println(groupSumClump(0, array, 14));
	}
	
	private static boolean groupSumClump(int start, int[] nums, int target) {
	    if(start >= nums.length)
	        return target == 0;
	          
	    int i = start;
	    int sum = 0;
	    
	    while(i < nums.length && nums[start] == nums[i]) {
	        sum += nums[i];
	        i++;
	    }
	                              
	    if(groupSumClump(i, nums, target - sum))
	        return true;
	                                        
	    if(groupSumClump(i, nums, target))
	        return true;
	                                                  
	    return false;
	}
}
