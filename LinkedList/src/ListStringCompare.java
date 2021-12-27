/*
 * compare 2 linked list of strings to see if the total string across the whole list is equal. 
 * node values can be any length as well as empty.
example"

"w" -> "" -> "orl" -> "d"

"worl" -> "" -> "" -> "" -> "d"

Result: true.

sol1:stringbuilders then compare approach. Intervewer wanted O(1) space.

Suggested a compare chars approach with 2 pointers after some thought about handling different val lengths and empty strings. Interviewer seemed happy and i coded it out.
 */

//sol in LinkedLiist
public class ListStringCompare {
	public static boolean compare(ListNodeString list1, ListNodeString list2) {
		StringBuilder sb1=new StringBuilder();
		StringBuilder sb2=new StringBuilder();
		while(list1!=null) {
			String str=list1.val;
			if(!str.matches("\\S+")) {
			sb1.append(str);
			list1=list1.next;
			}
		}
		while(list2!=null) {
			String str=list2.val;
			if(!str.matches("\\S+")) {
			sb2.append(str);
			list2=list2.next;
			}
		}
		//System.out.println(sb1+"    "+sb2);
		return sb1.toString().equals(sb2.toString());
	}
	
	//sol2
	public static boolean compare2(ListNodeString list1, ListNodeString list2) {
		ListNodeString curr1=new ListNodeString();
		ListNodeString curr2=new ListNodeString();
		curr1=list1;
		curr2=list2;
		while(list1!=null || list2!=null) {
			if((list1.val).matches("\\S+")) {list1=list1.next; }
			if((list2.val).matches("\\S+")) {list2=list2.next; }
			String str1=list1.val;
			String str2=list2.val;
			
			char c1=findNext(str1,list1);
			char c2=findNext(str2,list2);
			if(c1!=c2)return false;
			
		}
		return true;
		
	}
	public static Character findNext(String s, ListNodeString list1){
		char c = 0;
		
		return c;
	}

	public static void main(String[] args) {
		ListNodeString list1=new ListNodeString("w");
		ListNodeString list1_2=new ListNodeString("");
		ListNodeString list1_3=new ListNodeString("orl");
		ListNodeString list1_4=new ListNodeString("d");
		list1.next=list1_2;
		list1_2.next=list1_3;
		list1_3=list1_4;
		
		ListNodeString list2=new ListNodeString("worl");
		ListNodeString list2_2=new ListNodeString("");
		ListNodeString list2_3=new ListNodeString("");
		ListNodeString list2_4=new ListNodeString("d");
		list2.next=list2_2;
		list2_2.next=list2_3;
		list2_3=list2_4;
		System.out.println(compare(list1,list2));

	}

}
