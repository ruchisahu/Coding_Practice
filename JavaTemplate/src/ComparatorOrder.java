

	import java.util.*;
	import java.util.Comparator;
	public class ComparatorOrder
	{
		/* static final Comparator<Employee> NameORDER = 
                 new Comparator<Employee>() {
			 			public int compare(Employee e1, Employee e2) {
			 			return e1.getName().compareTo(e2.getName());
			 			}
		 			};
		 			*/

	   // static final Collection<Employee> employees = ... ;

	    public static void main(String[] args) {
	    	
	    	Employee[] employees = new Employee[4];
			 
			employees[0] = new Employee("Tom", 45, 80000);
			employees[1] = new Employee("Sam", 56, 75000);
			employees[2] = new Employee("Alex", 30, 120000);
			employees[3] = new Employee("Peter", 25, 60000);
			
	        List<Employee> e = new ArrayList<Employee>();
	        e.add(new Employee("Tom", 45, 80000));
	        e.add(new Employee("Sam", 56, 700000));
	        e.add(new Employee("amar", 20, 700000));
	        Collections.sort(e);  //sorted basted on compareto in emp
	     //  Collections.sort(e, NameORDER );
	        System.out.println(e);
	    }
	}

