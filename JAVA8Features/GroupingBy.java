package com.gyan.JAVA8Features;

import java.util.ArrayList;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GroupingBy 
{
	public static void main(String[] args) {
		
	
	List<Employee> allEmployees = new ArrayList<>();
	Map<String, Employee> topEmployees =
		    allEmployees.stream()
		                .collect(groupingBy(
		                    e -> e.department,
		                    collectingAndThen(maxBy(comparingInt(e -> e.salary)), Optional::get) 
		                ));
	System.out.println(topEmployees);
	}

}

class Employee {
    public String department;
    public int salary;
}
