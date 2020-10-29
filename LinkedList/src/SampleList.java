
public class SampleList {
	public static ListNode createSingleNodeList()
	 {
	  ListNode node1 = new ListNode( 1 );
	  return node1;
	 }
	 
	 public static ListNode createEvenNodeList()
	 {
	     ListNode node1 = new ListNode( 1 );
	     ListNode node2 = new ListNode( 2 );
	     ListNode node3 = new ListNode( 3 );
	     ListNode node4 = new ListNode( 4 );
	     node1.next = node2;
	     node2.next = node3;
	     node3.next = node4;
	     return node1;
	 }
	 
	 public static ListNode createOddNodeList()
	 {
	     ListNode node1 = new ListNode( 1 );
	     ListNode node2 = new ListNode( 2 );
	     ListNode node3 = new ListNode( 3 );
	     ListNode node4 = new ListNode( 4 );
	     ListNode node5 = new ListNode( 5 );
	     node1.next = node2;
	     node2.next = node3;
	     node3.next = node4;
	     node4.next = node5;
	     return node1;
	 }
	  public static ListNode test1()
	 {
	     ListNode node1 = new ListNode( 7 );
	     ListNode node2 = new ListNode( 2 );
	   
	     ListNode node3 = new ListNode( 4 );
	     ListNode node4 = new ListNode( 3 );
	     node1.next = node2;
	     node2.next = node3;
	     node3.next = node4;
	   //  node4.next = node5;
	     return node1;
	}
	   public static ListNode test2()
	 {
	     ListNode node1 = new ListNode( 5 );
	     ListNode node2 = new ListNode( 6 );
	   
	     ListNode node3 = new ListNode( 4 );
	  //   ListNode node5 = new ListNode( 3 );
	     node1.next = node2;
	     node2.next = node3;
	  //   node3.next = node4;
	  //   node4.next = node5;
	     return node1;

	   }
	    public static ListNode test3()
	 {
	     ListNode node1 = new ListNode( 5 );
	     ListNode node2 = new ListNode( 6 );
	   
	     ListNode node3 = new ListNode( 9 );
	  //   ListNode node5 = new ListNode( 3 );
	      ListNode node4 = new ListNode( 12 );
	     node1.next = node2;
	     node2.next = node3;
	     node3.next = node4;
	  //   node4.next = node5;
	     return node1;

	   }
	 public static ListNode mergeKtest1()
	 {
	     ListNode node1 = new ListNode( 7 );
	     ListNode node2 = new ListNode( 9 );
	   
	     ListNode node3 = new ListNode( 14 );
	     ListNode node4 = new ListNode( 30 );
	     node1.next = node2;
	     node2.next = node3;
	     node3.next = node4;
	   //  node4.next = node5;
	     return node1;
	}
	 
	  public static ListNode mergeKtest2()
	 {
	     ListNode node1 = new ListNode( 4 );
	     ListNode node2 = new ListNode( 5);
	   
	     ListNode node3 = new ListNode( 6 );
	     ListNode node4 = new ListNode( 30 );
	     node1.next = node2;
	     node2.next = node3;
	     node3.next = node4;
	   //  node4.next = node5;
	     return node1;
	}
	   public static ListNode mergeKtest3()
	 {
	     ListNode node1 = new ListNode( 2 );
	     ListNode node2 = new ListNode(13);
	   
	     ListNode node3 = new ListNode( 16 );
	     ListNode node4 = new ListNode(19 );
	     node1.next = node2;
	     node2.next = node3;
	     node3.next = node4;
	   //  node4.next = node5;
	     return node1;
	}
	   public static ListNode deleteDuplicates_test1()
	   { 
	       ListNode node1 = new ListNode( 2 );
	       ListNode node2 = new ListNode(3);
	       
	       ListNode node3 = new ListNode( 3 );
	       ListNode node4 = new ListNode(6 );
	       node1.next = node2;
	       node2.next = node3;
	       node3.next = node4;
	       //  node4.next = node5;
	       return node1;
	   }
	   
	   public static ListNode Reorder()
	   { 
	       ListNode node1 = new ListNode( 1 );
	       ListNode node2 = new ListNode(2);
	       
	       ListNode node3 = new ListNode( 3 );
	       ListNode node4 = new ListNode(4 );
	       node1.next = node2;
	       node2.next = node3;
	       node3.next = node4;
	       //  node4.next = node5;
	       return node1;
	   }
	}
