package com.gyan.JAVA8Features;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


public class CollectorsEx 
{
	
	public static void main(String[] args) {
		List<Employee2> employeeList = new ArrayList<Employee2>();
        
		employeeList.add(new Employee2(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee2(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee2(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee2(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee2(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee2(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee2(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee2(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee2(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee2(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee2(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee2(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee2(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee2(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee2(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee2(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee2(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
		
		/* How many male and female employees are there in the organization? */
		
		Map<String,Long> noOfMaleAndFemaleEmployees=employeeList.stream()
				.collect(Collectors.groupingBy(Employee2::getGender,Collectors.counting()));
		System.out.println(noOfMaleAndFemaleEmployees);
		
		/* Print the name of all departments in the organization? */
		
		employeeList.stream()
		.map(Employee2::getDepartment)
		.distinct()
		.forEach(System.out::println);
		
		/* What is the average age of male and female employees */
		
		Map<String, Integer> averageAge=employeeList
		.stream()
		.collect(Collectors
				.groupingBy(Employee2::getGender,Collectors.summingInt(Employee2::getAge)));
		System.out.println(averageAge);
		
		/* Get the details of highest paid employee in the organization */
		
		Optional<Employee2> highestPaidEmployeeWrapper =employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee2::getSalary)));
		Employee2 highestPaidEmployee = highestPaidEmployeeWrapper.get();
		System.out.println("ID : "+highestPaidEmployee.getId() + ", Name : "+highestPaidEmployee.getName() + " , Age : "+highestPaidEmployee.getAge());
		
		/* Get the names of all employees who have joined after 2015? */
		
		System.out.println("---------------");
		employeeList.stream()
		.filter(e->e.getYearOfJoining() >2015)
		.map(Employee2::getName)
		.forEach(System.out::println);

		/* Count the number of employees in each department */
		Map<String, Long> countNo=
				employeeList.stream().collect(Collectors.groupingBy(Employee2::getDepartment,Collectors.counting()));
		
		System.out.println("No of Employee from Each Dept :" +countNo);		
		
		/* What is the average salary of each department */
		
		Map<String,Double> avarageSal =
				employeeList.stream()
				.collect(Collectors.groupingBy(Employee2::getDepartment,Collectors.averagingDouble(Employee2::getSalary)));
		
		System.out.println("Average Salary from Each Dept:" + avarageSal);
		
		/* Get the details of youngest male employee in the product development department? */
		
		Optional<Employee2> getDetails =
				employeeList.stream()
				.filter(e->e.getGender()=="Male" && e.getDepartment() =="Product Development")
				.min(Comparator.comparingInt(Employee2::getAge));
		Employee2 youngestMale =getDetails.get();
		System.out.println("=============");
		System.out.println("Get details of Yongest male " + youngestMale.getName() + ",Age is " + youngestMale.getAge());
		
		/* Who has the most working experience in the organization? */
		
		Optional<Employee2> seniorMostEmployee =
		employeeList.stream()
		.sorted(Comparator.comparingInt(Employee2::getYearOfJoining)).findFirst();
		Employee2 MostWorkingExp =seniorMostEmployee.get();
		System.out.println("Most Working Employee :" +MostWorkingExp.getName());
		
		/* How many male and female employees are there in the sales and marketing team? */
		
		Map<String,Long> countMaleFemaleEmployeesInSalesMarketing =
				employeeList.stream()
				.filter(e->e.getDepartment() =="Sales And Marketing")
				.collect(Collectors.groupingBy(Employee2::getGender, Collectors.counting()));
		System.out.println("-------------------");
		System.out.println("countMaleFemaleEmployeesInSalesMarketing" + countMaleFemaleEmployeesInSalesMarketing);

	System.out.println("/* List down the names of all employees in each department? */");
		
		Map<String,List<Employee2>> listofEmployee =
				employeeList.stream()
				.collect(Collectors.groupingBy(Employee2::getDepartment));
				System.out.println(listofEmployee);
				Set<Entry<String, List<Employee2>>> entrySet = listofEmployee.entrySet();
			    for (Entry<String, List<Employee2>> entry : entrySet) 
			    {
			        System.out.println("--------------------------------------");
			                 
			        System.out.println("Employees In "+entry.getKey() + " : ");
			                 
			        System.out.println("--------------------------------------");
				    List<Employee2> list = entry.getValue();
			    for (Employee2 e : list) 
			    {
			        System.out.println(e.getName());
			    }
			    }
			    System.out.println();
    System.out.println("/* What is the average salary and total salary of the whole organization */ ");
			    DoubleSummaryStatistics summaryStats =
			    		employeeList.stream()
			    		.collect(Collectors.summarizingDouble(Employee2::getSalary));
			    
			    System.out.println("Average Salary :" + summaryStats.getAverage());
			    System.out.println("Total Salary :" + summaryStats.getSum());
			    
			    System.out.println("Separate the employees who are younger or "
			    		+ "equal to 25 years from those employees who are older than 25 years");
			    
			    Map<Boolean,List<Employee2>> partitionEmployeesByAge 
			    = employeeList.stream()
			    .collect(Collectors.partitioningBy(e->e.getAge() >25));
			    
			    Set<Entry<Boolean, List<Employee2>>> entrySet1 = partitionEmployeesByAge.entrySet();
			    for (Entry<Boolean, List<Employee2>> entry : entrySet1) 
			    {
			        System.out.println("----------------------------");
			                 
			        if (entry.getKey()) 
			        {
			            System.out.println("Employees older than 25 years :");
			        }
			        else
			        {
			            System.out.println("Employees younger than or equal to 25 years :");
			        }
			                 
			        System.out.println("----------------------------");
			                 
			        List<Employee2> list = entry.getValue();
			                 
			        for (Employee2 e : list) 
			        {
			            System.out.println(e.getName());
			        }
			    }

			    
			    

		

		
		
		
		
	}
	
	

}

class Employee2
{
    int id;
     
    String name;
     
    int age;
     
    String gender;
     
    String department;
     
    int yearOfJoining;
     
    double salary;
     
    public Employee2(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) 
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }
     
    public int getId() 
    {
        return id;
    }
     
    public String getName() 
    {
        return name;
    }
     
    public int getAge() 
    {
        return age;
    }
     
    public String getGender() 
    {
        return gender;
    }
     
    public String getDepartment() 
    {
        return department;
    }
     
    public int getYearOfJoining() 
    {
        return yearOfJoining;
    }
     
    public double getSalary() 
    {
        return salary;
    }
     
    @Override
    public String toString() 
    {
        return "Id : "+id
                +", Name : "+name
                +", age : "+age
                +", Gender : "+gender
                +", Department : "+department
                +", Year Of Joining : "+yearOfJoining
                +", Salary : "+salary;
    }
}