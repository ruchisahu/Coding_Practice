public class BstNode<T> {
    public T data;
    public BstNode<T> left, right;

    public BstNode(T data) {
        this.data = data;
    }

    public BstNode(T data, BstNode left, BstNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "BSTNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}