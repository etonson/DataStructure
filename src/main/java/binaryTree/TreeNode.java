package binaryTree;

/**
 * @author : eton.lin
 * @description TODO
 * @date 2024-04-11 下午 11:46
 * @reference:https://chikuwa-tech-study.blogspot.com/2021/06/java-binary-tree.html
 */
public class TreeNode<E> {
    private E value;
    private TreeNode<E> leftNode;
    private TreeNode<E> rightNode;
    private int height;

    public void initNode(E v, TreeNode<E> leftNode, TreeNode<E> rightNode, int height) {
        this.value = v;
        this.rightNode = rightNode;
        this.leftNode = leftNode;
        this.height = height;
    }

    public TreeNode(E value) {
        this.value = value;
    }

    public int getHeight() {
        return height;
    }

    public E getValue() {
        return value;
    }

    public TreeNode<E> getRightNode() {
        return rightNode;
    }

    public void setLeftNode(TreeNode<E> leftNode) {
        this.leftNode = leftNode;
    }


    public void setRightNode(TreeNode<E> rightNode) {
        this.rightNode = rightNode;
    }

    public TreeNode<E> getLeftNode() {
        return leftNode;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }
}
