package Chap_10;

import java.util.List;

public interface TreeNode<E> {

    E getValue();

    void setValue(E value);

    List<? extends TreeNode<E>> getChildren();

    int addChild(TreeNode<E> child);

    void deleteChild(int index);

    TreeNode<E> getParent();

    void setParent(TreeNode<E> parent);

    TreeNode<E> getPreviousSibling();

    TreeNode<E> getNextSibling();

    TreeNode<E> getFirstChild();

    boolean isRoot();

    boolean isLeaf();

}
