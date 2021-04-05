
public class LC1650LowestCommonAncestorOfABinaryTreeIII {
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node parent;
	};
	

	/*
	Two Pointer Method

	This solution is very similar to "Intersection of Two Linked Lists" another question frequently asked by Facebook.

	In this solution, we are maintaining two pointers pointerP and pointerQ, initialized to the node P and Q respectively. Then we keep traversing the tree upwards towards the root of the tree using the parent reference in each node.

	When pointerP reaches the root, then we will redirect it to the node Q. Similarly when pointerQ reaches the root, then we will redirect it to the node P. If at any point pointerP == pointerQ, then pointerP or pointerQ is the Lowest Common Ancestor (LCA) of node P and Q.

	Let us consider the following binary tree that fulfills all the given constraints.
	          3
	         /
	        5
	         \
	          2
	           \
	            4
	Root Node = 3, P = 5, Q = 4
	Path from node P to root: 5 -> 3
	Path from Node Q to root: 4 -> 2 -> 5 -> 3

	In this case, pointerP will reach the root node first, as it's closer to the root node and thus has to travel less distance. But pointerQ will take three hops to reach the root node. The difference in depth of both the nodes is two. By redirecting the pointerP to node Q, and pointerQ to node P, we are making pointerP travel two extra hops and pointerQ travel two fewer hops. Thus they end up traveling the same number of hops and are guaranteed to reach the lowest common node at the same time. 

	Total number of hops required to find the LCA = Depth of P + Depth of Q - Depth of LCA node.
	Time Complexity = O(depthP + depthQ - depthLCA)
	depthP -> Depth of the Node p
	depthQ -> Depth of the Node q
	depthLCA -> Depth of the LCA

	Space Complexity = O(1)
	We are using constant space in this solution.
	*/
	class Solution {
	    public Node lowestCommonAncestor(Node p, Node q) {
	        // Invalid Input Condition
	        // Node P and Q must exist in the tree as per the given constraint
	        if (p == null || q == null) {
	            throw new IllegalArgumentException("Invalid Input");
	        }
	        
	        // Optional Base Condition. Due to the given constraint (p != q), this check is redundant
	        // If both the nodes are the same, then the LCA is P or Q.
	        if (p == q) {
	            return p;
	        }
	        
	        // Pointer to Node P
	        Node pointerP = p;
	        
	        // Pointer to Node Q
	        Node pointerQ = q;
	        
	        // This while loop will run till both the node pointers refer to the same node.
	        // Once both the node pointers are referring to the same node, that value will be the Lowest Common Ancestor of node P & Q.
	        while (pointerP != pointerQ) {
	            
	            // Moving the pointers to their parent nodes. 
	            pointerP = pointerP.parent;
	            pointerQ = pointerQ.parent;
	            
	            // If both pointers reach null at the same time, then Node P and Q are not part of the same tree.
	            if (pointerP == null && pointerQ == null) {
	                throw new IllegalArgumentException("Node P & Q are not part of the same tree");
	            }
	            
	            if (pointerP == null) {
	                // If pointerP reaches the root node of the tree, then we will redirect it to node Q
	                pointerP = q;
	            } else if (pointerQ == null) {
	                // If pointerQ reaches the root node of the tree, then we will redirect it to node P
	                pointerQ = p;
	            }
	        }
	        
	        // Both pointerP and pointerQ point to the Lowest Common Ancestor node.
	        return pointerP;
	    }
	}
}
	
	


