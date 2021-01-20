package Chap_12;
import Chap_10.BinaryTreeNode;

public class InOrderTreeWalk<E, N extends BinaryTreeNode<E>> {

   
    public void perform(N root) {
        if (root == null) {
            return;
        }
        final BinaryTreeNode<E> leftChild = root.getLeftChild();
        final BinaryTreeNode<E> rightChild = root.getRightChild();
        if (leftChild != null) {
            perform((N) leftChild);
        }
        System.out.println(root);
        if (rightChild != null) {
            perform((N) rightChild);
        }
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
