import java.util.*;
/*
 Collections.copy(list, list)
Copy a collection to another
Collections.reverse(list)
Reverse the order of the list
Collections.shuffle(list)
Shuffle the list
Collections.sort(list)
Sort the list
 */
public class Collection1 {
	public static void main(String[] args) {

        // create a list using the
        List<String> list = Arrays.asList("Lars", "Simon");

        // alternatively
        List<String> anotherList = new ArrayList<>();
        anotherList.add("Lars");
        anotherList.add("Simon");


        // print each element to the console using method references
        list.forEach(System.out::println);
        anotherList.forEach(System.out::println);
        
        /////
        List<Integer> list1 = Arrays.asList(3,2,1,4,5,6,6);

        // alternative you can declare the list via:
        // List<Integer> list = new ArrayList<>();
        // and use list.add(element); to add elements
        for (Integer integer : list1) {
            System.out.println(integer);
        }

    }

}
