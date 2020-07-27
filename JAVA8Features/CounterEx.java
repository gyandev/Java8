package com.gyan.JAVA8Features;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CounterEx 
{
	
	public static void main(String[] args) {
		String[] arr = {"program", "creek", "program", "creek", "java", "web", "program"};
		Stream<String> stream = Stream.of(arr).parallel();
		Map<String, Long> counter = stream.collect(Collectors.groupingBy(String::toString, Collectors.counting()));
		System.out.println(counter);
		
		System.out.println("-------Grouping By Examples");
		
		
	}

}
