import java.util.*;



import java.util.Scanner;

public class Comparator 
{

	public static void main(String[] args)
	{
		Employee[] employees = new Employee[4];
		 
		employees[0] = new Employee("Tom", 45, 80000);
		employees[1] = new Employee("Sam", 56, 75000);
		employees[2] = new Employee("Alex", 30, 120000);
		employees[3] = new Employee("Peter", 25, 60000);
		 
		System.out.println("Before sorting: " + Arrays.toString(employees));
		 
		Arrays.sort(employees);
		 
		System.out.println("After sorting: " + Arrays.toString(employees));
		
		//other 
		

	}

}
