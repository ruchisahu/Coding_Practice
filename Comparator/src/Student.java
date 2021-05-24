import java.util.Comparator;

//Java program to demonstrate working of Comparator
//interface more than one field

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Student {

	// instance member variables
	String FName;
	String LName;
	int Age;

	// parameterized constructor
	public Student(String FName, String LName,Integer Age)
	{
		this.FName = FName;
		this.LName=LName;
		this.Age = Age;
	}

	public String getName() { return FName; }
	public String getLName() { return LName; }

	public void setName(String FName,String LName) { 
		this.FName = FName; 
		this.LName=LName;
		
	}

	public Integer getAge() { return Age; }

	public void setAge(Integer Age) { this.Age = Age; }

	// overriding toString() method
	@Override public String toString()
	{
		return "Customer{"
			+ "Name=" + FName + LName +"  Age=" + Age + '}';
	}

	static class CustomerSortingComparator implements Comparator<Student> {

		@Override
		public int compare(Student customer1,Student customer2)
		{
		int NameCompare = customer1.getName().compareTo(customer2.getName());
			int AgeCompare = customer1.getAge().compareTo(customer2.getAge());

			// 2-level comparison
			return (NameCompare == 0) ? AgeCompare
									: NameCompare;
		}
	}

	public static void main(String[] args)
	{

		// create ArrayList to store Student
		List<Student> al = new ArrayList<>();

		// create customer objects using constructor
		// initialization
		Student obj1 = new Student("Ajay","A", 27);
		Student obj2 = new Student("Sneha","B", 23);
		Student obj3 = new Student("Simran","C", 37);
		Student obj4 = new Student("Ajay","D", 22);
		Student obj5 = new Student("Ajay","F", 29);
		Student obj6 = new Student("Sneha","E", 22);

		// add customer objects to ArrayList
		al.add(obj1);
		al.add(obj2);
		al.add(obj3);
		al.add(obj4);
		al.add(obj5);
		al.add(obj6);

		// before Sorting arraylist: iterate using Iterator
		Iterator<Student> custIterator = al.iterator();

		System.out.println("Before Sorting:\n");
		while (custIterator.hasNext()) {
			System.out.println(custIterator.next());
		}

		// sorting using Collections.sort(al, comparator);
		Collections.sort(al,
						new CustomerSortingComparator());

		// after Sorting arraylist: iterate using enhanced
		// for-loop
		System.out.println("\n\nAfter Sorting:\n");
		for (Student customer : al) {
			System.out.println(customer);
		}
	}
}
