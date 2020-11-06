package Chap_10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleTreeNode<E> implements TreeNode<E> {

    private E value = null;
    private List<TreeNode<E>> children = new ArrayList<TreeNode<E>>();
    private TreeNode<E> parent = null;

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public List<? extends TreeNode<E>> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public int addChild(TreeNode<E> child) {
        children.add(child);
        if (child != null) {
            child.setParent(this);
        }
        return children.size();
    }

    protected void setChild(int index, TreeNode<E> child) {
        if (child != null) {
            child.setParent(this);
        }
        children.set(index, child);
    }

    public void deleteChild(int index) {
        final TreeNode<E> node = children.remove(index);
        if (node != null) {
            node.setParent(null);
        }
    }

    public TreeNode<E> getParent() {
        return parent;
    }

    public void setParent(TreeNode<E> parent) {
        this.parent = parent;
    }

    private int getIndex() {
        if (getParent() == null) {
            return -1;
        }
        final List<? extends TreeNode<E>> children = parent.getChildren();
        for (int i = 0; i < children.size(); i++) {
            TreeNode<E> node = children.get(i);
            if (node == this) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode<E> getPreviousSibling() {
        final int index = getIndex();
        if (index <= 0) {
            return null;
        }
        return getParent().getChildren().get(index - 1);
    }

    public TreeNode<E> getNextSibling() {
        final int index = getIndex();
        if (index == -1 || index >= getParent().getChildren().size() - 1) {
            return null;
        }
        return getParent().getChildren().get(index + 1);
    }

    public TreeNode<E> getFirstChild() {
        return getChildren().isEmpty() ? null : getChildren().get(0);
    }

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    @Override
    public String toString() {
        return String.valueOf(value) + (getChildren().isEmpty() ? "" : children.toString());
    }



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
