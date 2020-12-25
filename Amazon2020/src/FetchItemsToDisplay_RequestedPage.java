import java.util.*;

/*
 * Amazon's website contains one to many items in each page. To mimic the logic of the website, an Amazon programmer has a list of items and each item has its name, relevance and price. After sorting the items by (name: 0, relevance: 1, price: 2), the programmer is trying to find out a list of items displayed in a chosen page.

Given a list of items, the sort column, the sort order (0: ascending, 1: descending), the number of items to be displayed in each page and a page number, write an algorithm to determine the list of item names in the specified page while respecting the item's order (Page number starts at 0).

Input

The input to the function/method consists of six arguments:

numOfltems, an integer representing the number of items;

items, a map of string as key representing the name and pair of integers as values representing the relevance, price.

sortParameter, an integer representing the value used for sorting (0 for name, 1 for relevance, 2 for price)

sortOrder, an integer representing the order of sorting (0 for ascending order and 1 descending order);

itemsPerPage, an integer representing the number of items per page;

pageNumber, an integer representing the page number.

Output

Return a list of strings representing the item names on the requested page in the order they are displayed.

Constraints

1 <= numOfitems < 10^5

0 <= relevance, price < 10^8

0 <= pageNumber < 10

Note

itemsPerPage is always greater than 0, and is always less than the minimum of numOfltems and 20.

Example

Input:

numOfltems = 3

items = [["item1", 10,15], ["item2",3,4]. ["item3", 17, 8]]

sortParameter=1

sortOrder = 0

itemsPerPage=2

pageNumber=1

Output:

["item3"]

Explanation:

There are 3 items.

Sort them by relevance(sortParameter = 1) in ascending order ( items = [["item2", 3, 4], ["item1", 10,15], ["item3", 17, 8]]).

Display up to 2 items on each page.

The page 0 contains 2 item names ["item2", "item1"] and page 1 contains only 1 item name ["item3"].

So, the output is "item3".
 */
public class FetchItemsToDisplay_RequestedPage {
	 public static List<String> fetchItemsToDisplay(int numOfItems, HashMap<String, Pair<Integer, Integer>> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber) {
	        
	        if(items.size() == 0)
	           return Collections.EMPTY_LIST;

	        SortedSet<Map.Entry<String, Pair<Integer, Integer>>> set = new TreeSet<>(new Comparator<Map.Entry<String, Pair<Integer, Integer>>>() {
	            @Override
	            public int compare(Map.Entry<String, Pair<Integer, Integer>> entry1, Map.Entry<String, Pair<Integer, Integer>> entry2) {
	                if(sortParameter == 0) {
	                    if(sortOrder == 0)
	                        return entry1.getKey().compareTo(entry2.getKey());
	                    return entry2.getKey().compareTo(entry1.getKey());
	                }
	                
	                if(sortParameter == 1) {
	                    if(sortOrder == 0)
	                        return (int) entry1.getValue().getKey() - (int) entry2.getValue().getKey();
	                    return (int) entry2.getValue().getKey() - (int) entry1.getValue().getKey();
	                }
	                
	                if(sortParameter == 2) {
	                    if(sortOrder == 0)
	                        return (int) entry1.getValue().getValue() - (int) entry2.getValue().getValue();
	                    return (int) entry2.getValue().getValue() - (int) entry1.getValue().getValue();
	                }
	                return 0;
	            }
	        });

	        set.addAll(items.entrySet());

	        List<String> result = new ArrayList<>();
	        for(Map.Entry<String,Pair<Integer, Integer>> entry : set)
	            result.add(entry.getKey());

	       int start = pageNumber * itemsPerPage;
	       int end = (start + itemsPerPage) > result.size() ? result.size() : start + itemsPerPage;

	       return result.subList(start, end);
	    }
	    
	    public static void main(String[] args) {
	        int numOfItems = 3;
	        HashMap<String, Pair<Integer, Integer>> items = new HashMap<>();
	        items.put("item1", new Pair<Integer, Integer>(10, 15));
	        items.put("item2", new Pair<Integer, Integer>(3, 4));
	        items.put("item3", new Pair<Integer, Integer>(17, 8));
	        
	        int sortParameter = 1;
	        int sortOrder = 0;
	        int itemsPerPage = 2;
	        int pageNumber = 1;
	        
	        System.out.println(fetchItemsToDisplay(numOfItems, items, sortParameter, sortOrder, itemsPerPage, pageNumber));
	    }
	}

	