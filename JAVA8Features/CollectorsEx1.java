package com.gyan.JAVA8Features;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsEx1 
{
	
	public static void main(String[] args) {
		
		List<Student> studentList = new ArrayList<Student>();
        
		studentList.add(new Student("Paul", 11, "Economics", 78.9));
		studentList.add(new Student("Zevin", 12, "Computer Science", 91.2));
		studentList.add(new Student("Harish", 13, "History", 83.7));
		studentList.add(new Student("Xiano", 14, "Literature", 71.5));
		studentList.add(new Student("Soumya", 15, "Economics", 77.5));
		studentList.add(new Student("Asif", 16, "Mathematics", 89.4));
		studentList.add(new Student("Nihira", 17, "Computer Science", 84.6));
		studentList.add(new Student("Mitshu", 18, "History", 73.5));
		studentList.add(new Student("Vijay", 19, "Mathematics", 92.8));
		studentList.add(new Student("Harry", 20, "History", 71.9));
		
		/* Collecting top 3 performing students into List */
		List<Student> top3Students = 
		studentList.stream()
		.sorted(Comparator.comparingDouble(Student::getPercentage).reversed()).limit(3)
		.collect(Collectors.toList());
		System.out.println("top3Students" + top3Students);
		
		

		
	}

}

class Student
{
    String name;
     
    int id;
     
    String subject;
     
    double percentage;
     
    public Student(String name, int id, String subject, double percentage) 
    {
        this.name = name;
        this.id = id;
        this.subject = subject;
        this.percentage = percentage;
    }
     
    public String getName() 
    {
        return name;
    }
     
    public int getId() 
    {
        return id;
    }
     
    public String getSubject() 
    {
        return subject;
    }
     
    public double getPercentage() 
    {
        return percentage;
    }
     
    @Override
    public String toString() 
    {
        return name+"-"+id+"-"+subject+"-"+percentage;
    }
}
