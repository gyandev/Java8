package com.gyan.JAVA8Features;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApi 
{
	
	public static void main(String[] args) {
		// find the max/min in an array using Stream
		int [] array = {10,3,5,4,1,1,6};
		int min =IntStream.of(array)
		.min()
		.getAsInt();
		System.out.println("Minimum of Array :" + min);
		
		// find the max/min in an array using Stream
				int max =IntStream.of(array)
				.max()
				.getAsInt();
				System.out.println("Maximum of Array:" + max);
				
				// find the max/min in an array using Stream Optional
				
				 IntStream.of(array)
				.max()
				.ifPresent(System.out::println);
				 
				// find the average of arrays 
				 IntStream.of(array)
				 .average()
				 .ifPresent(System.out::println);
				 
				 // find the sum of numbers
				 int sum =IntStream.of(array)
				 .sum();
				 System.out.println("Sum of array :" + sum);
				 
				 // find the count of numbers
				 int count =(int) IntStream.of(array)
				 .count();
				 System.out.println("Count of array :" + sum);
				 
				 // find the count of numbers
			IntSummaryStatistics intSummaryStatistics =IntStream.of(array)
				 .summaryStatistics();
			
			// List of Int
			
			List<Integer> list = Arrays.asList(10,3,5,4,1,1,6);
			Integer sum1 = list.stream()
					.mapToInt(Integer::intValue)
					.sum();
			System.out.println("sum of Array:" + sum1);
			
			// List do find out square of even numbers
			System.out.println("List do find out square of even numbers");
			List<Integer> list2 = Arrays.asList(1,2,3,4,5,6);
			list2.stream()
			.filter(x->x%2==0)
			.map(x->x*x)
			.forEach(System.out::println);
			
				 
				 
				 
		
		
	
	}

}
