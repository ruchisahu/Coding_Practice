
public class CountofRangeSum327 {
	 public int countRangeSum(int[] nums, int lower, int upper) {
		    long sum = 0;
		    RedBlackTree sumTree = new RedBlackTree();
		    sumTree.add(sum); // zero-length prefix
		    int count = 0;
		    for (int i = 0; i < nums.length; ++i) {
		        sum += nums[i];
		        // we need to count lower <= sums[i] - sums[j] <= upper, j < i, or
		        // -lower >= sums[j] - sums[i] >= -upper, or sums[i] - lower >= sums[j] >= sums[i] - upper, or
		        // sums[i] - lower >= sums[j] > sums[i] - upper - 1
		        count += countLE(sumTree.root, sum - lower) - countLE(sumTree.root, sum - upper - 1);
		        sumTree.add(sum);
		    }
		    return count;
		}

		private static int countLE(RedBlackTree.Node root, long sum) {
		    RedBlackTree.Node current = root;
		    int count = current.totalCount;
		    while (current != RedBlackTree.Node.NIL) {
		        if (current.value == sum) {
		            count -= current.right.totalCount;
		            break;
		        } else if (sum < current.value) {
		            count -= current.valueCount + current.right.totalCount;
		            current = current.left;
		        } else { // we haven't seen anything greater than sum yet
		            current = current.right;
		        }
		    }
		    return count;
		}

		static class RedBlackTree {
		    
		    Node root = Node.NIL;
		    
		    void add(long value) {
		        Node current = root, prev = Node.NIL;
		        while (current != Node.NIL && current.value != value) {
		            ++current.totalCount;
		            prev = current;
		            if (value < current.value) {
		                current = current.left;
		            } else {
		                current = current.right;
		            }
		        }
		        if (current != Node.NIL) { // Note: can't test for current.value == value here because value can be 0.
		            // exact match
		            ++current.totalCount;
		            ++current.valueCount;
		            return;
		        }
		        Node node = new Node(value);
		        if (prev == Node.NIL) {
		            root = node;
		        } else {
		            if (value < prev.value) {
		                assert prev.left == Node.NIL;
		                prev.left = node;
		            } else {
		                assert prev.right == Node.NIL && value > prev.value;
		                prev.right = node;
		            }
		            node.parent = prev;
		        }
		        // fix up the Red-Blackness (CLR, Introduction to Algorithms)
		        while (node.parent.color == Node.Color.RED) {
		            Node parent = node.parent;
		            Node granddad = parent.parent;
		            assert granddad.color == Node.Color.BLACK;
		            boolean left = granddad.left == parent;
		            Node uncle = left ? granddad.right : granddad.left;
		            if (uncle.color == Node.Color.RED) { // case 1
		                granddad.color = Node.Color.RED;
		                parent.color = uncle.color = Node.Color.BLACK;
		                node = granddad;
		            } else {
		                if ((left ? parent.right : parent.left) == node) { // case 2
		                    node = parent;
		                    rotate(node, left);
		                }
		                // case 3
		                parent.color = Node.Color.BLACK;
		                granddad.color = Node.Color.RED;
		                rotate(granddad, !left);
		            }
		        }
		        root.color = Node.Color.BLACK;
		    }
		    
		    void rotate(Node node, boolean left) {
		        Node parent = node.parent;
		        Node child = left ? node.right : node.left;
		        if (left) { node.right = child.left; } else { node.left = child.right; }
		        node.totalCount = node.left.totalCount + node.valueCount + node.right.totalCount;
		        (left ? child.left : child.right).parent = node;
		        child.parent = parent;
		        if (parent == Node.NIL) {
		            root = child;
		        } else {
		            if (parent.left == node) {
		                parent.left = child;
		            } else {
		                assert parent.right == node;
		                parent.right = child;
		            }
		        }
		        if (left) { child.left = node; } else { child.right = node; }
		        child.totalCount = child.left.totalCount + child.valueCount + child.right.totalCount;
		        node.parent = child;
		        Node.NIL.left = Node.NIL.right = Node.NIL.parent = Node.NIL; // fix it up in case we've messed it up
		    }
		    
		    static class Node {
		        static final Node NIL = new Node();
		        
		        static { // need this because we can't initialize fields to NIL until it is created
		            NIL.left = NIL.right = NIL.parent = NIL;
		        }
		        
		        long value;
		        int valueCount, totalCount;
		        Node parent = NIL, left = NIL, right = NIL;
		        Color color;
		        
		        private Node() { // NIL constructor
		            this.color = Color.BLACK;
		        }
		        
		        Node(long value) {
		            this.value = value;
		            this.valueCount = this.totalCount = 1;
		            this.color = Color.BLACK;
		        }
		        
		        enum Color {
		            RED, BLACK
		        }
		    }
		}
		

	public static void main(String[] args) {
		int[] nums = {-2,5,-1};
		int lower = -2;
		int upper = 2;
		CountofRangeSum327 c=new CountofRangeSum327();
		System.out.println(c.countRangeSum(nums,lower,upper));

	}

}
