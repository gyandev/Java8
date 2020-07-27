package com.gyan.JAVA8Features;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap3 
{
	
	public static void main(String[] args) {
		
		/* Given two lists of numbers, how would you return all pairs of numbers? For example, given a
				list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For
				simplicity, you can represent a pair as an array with two elements. */
		
		List<Integer> list1 = Arrays.asList(1,2,3);
		List<Integer> list2 = Arrays.asList(3,4);
		List<int[]> 	pairs = 
				list1.stream()
				.flatMap(i -> list2.stream()
						.map(j->new int[]{i,j}))
				.collect(Collectors.toList());
		for(int[] l : pairs)
		{
			System.out.println(l);
		}
		
		
		
		
		
		
		
				
		
	}

}
