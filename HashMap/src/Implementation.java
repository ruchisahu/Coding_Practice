
public class Implementation {
	//assuming length of 10k nodes
	ListNode[] nodes = new ListNode[10000];
	
	public static void main(String[] args) {
		

	}
	
	//PUT Operation
    public void put(int key, int value) {
        int hashCode = hashFunction(key);
        if(nodes[hashCode] == null){
            nodes[hashCode] = new ListNode(-1,-1);
        }
        ListNode prev = find(nodes[hashCode], key);
        if(prev.next ==null){
            prev.next = new ListNode(key,value);
        }else{
            prev.next.val = value; //change existing value
        }
    }
	//GET Operation
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashCode = hashFunction(key);
        if(nodes[hashCode] == null){
            return -1;
        }else{
            ListNode prev = find(nodes[hashCode], key);
            if(prev.next==null){
                return -1;
            }else{
                return prev.next.val;
            }
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashCode = hashFunction(key);
        if(nodes[hashCode] == null){
            return;
        }else{
            ListNode prev = find(nodes[hashCode], key);
            if(prev.next==null){
                return;
            }else{
                prev.next = prev.next.next; //remove that and add the next element to previous one
            }
        }
    }
    
    public ListNode find(ListNode temp, int key){
        ListNode curr = temp;
        ListNode prev = null;
        
        while(curr !=null && curr.key!=key){
            prev = curr;
            curr=curr.next;
        }
        return prev;
    }
    
    // why hasing algorithm here??
    /*In terms of an interview implementation for this case, yes. 
     * But I believe the point here is to use hashing algorithm (e.g. fmix64) to convert a non-uniform distribution dataset to a 
     * uniform distribution data, so that the collision rate can be lowered. */
    public int hashFunction(int key){
        return Integer.hashCode(key) % nodes.length;
    }
}
class ListNode
{
    int key, val;
	ListNode next;

    ListNode(int key, int val)
	{
	    this.key = key;
		this.val = val;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
