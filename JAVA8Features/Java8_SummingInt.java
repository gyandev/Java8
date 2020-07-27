package com.gyan.JAVA8Features;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Java8_SummingInt 
{
	
	public static void main(String[] args) {
		  List <Employee1> employees = Arrays.asList(new Employee1(1, 1000, "Chandra Shekhar", 6000),
		   new Employee1(1, 1000, "Rajesh", 8000),
		   new Employee1(1, 1004, "Rahul", 9000),
		   new Employee1(1, 1001, "Suresh", 12000),
		   new Employee1(1, 1004, "Satosh", 8500)
		  );
		  
		  int totalSalary = employees.stream().collect(Collectors.summingInt(Employee1::getSalary));
		  System.out.println("The sum of Salary : "+ totalSalary);
		  /* We can also calculate the sum of salaries by filtering the department ids */
		  int SalaryByDept = employees.stream().filter(name->1000 ==name.getDeptId()).collect(Collectors.summingInt(Employee1::getSalary));
		  System.out.println("Total Employees Salary of 1000 Dept :" + SalaryByDept);
	}
		  
		  

}
	
class Employee1 {
		 private int id;
		 private int deptId;
		 private String name;
		 private int salary;	
		 
		 public Employee1(int id, int deptId, String name, int salary) {
			  super();
			  this.id = id;
			  this.deptId = deptId;
			  this.name = name;
			  this.salary = salary;
			 }
			 public int getId() {
			  return id;
			 }
			 public String getName() {
			  return name;
			 }
			 public int getSalary() {
			  return salary;
			 }
			 public int getDeptId() {
			  return deptId;
			 }
}

