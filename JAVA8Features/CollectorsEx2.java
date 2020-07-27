package com.gyan.JAVA8Features;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectorsEx2 
{
	
	static List<Employee3> employeeList
    = Arrays.asList(new Employee3("Tom Jones", 45, 15000.00),
      new Employee3("Tom Jones", 45, 7000.00),
      new Employee3("Ethan Hardy", 65, 8000.00),
      new Employee3("Nancy Smith", 22, 10000.00),
      new Employee3("Deborah Sprightly", 29, 9000.00));

	public static void main(String[] args) {
		
		/*Employee with MAX SALARY */
		
		Optional<Employee3> maxSalary=
				employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Employee3::getSalary)));
		System.out.println("Employee with Max Salary"+ (maxSalary.isPresent() ? maxSalary.get():"Not Application"));
	}

}

 class Employee3 {
	  private String name;
	  private Integer age;
	  private Double salary;
	 
	  public Employee3(String name, Integer age, Double salary) {
	    this.name = name;
	    this.age = age;
	    this.salary = salary;
	  }
	 
	  
	  
	 
	  public String toString(){
	    DecimalFormat dformat = new DecimalFormat(".##");
	    return "Employee Name:"+this.name
	        + "  Age:"+this.age
	        + "  Salary:"+dformat.format(this.salary);
	  }
	
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee3 other = (Employee3) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		return true;
	}




	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	}