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

    public TreeNode(E value) {
        this.value = value;
    }

    //前序走訪
    //樹根->左子樹->右子樹
    public void preOrder() {
        System.out.print(value);

        if (leftNode != null) {
            leftNode.preOrder();
        }

        if (rightNode != null) {
            rightNode.preOrder();
        }
    }

    //中序走訪
    //左子樹->樹根->右子樹
    public void inOrder() {
        if (leftNode != null) {
            leftNode.inOrder();
        }
        System.out.print(value);
        if (rightNode != null) {
            rightNode.inOrder();
        }
    }

    //後序走訪
    //左子樹->右子樹->樹根
    public void postOrder() {
        if (leftNode != null) {
            leftNode.postOrder();
        }
        if (rightNode != null) {
            rightNode.postOrder();
        }
        System.out.print(value);
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public TreeNode<E> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode<E> leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode<E> getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode<E> rightNode) {
        this.rightNode = rightNode;
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
