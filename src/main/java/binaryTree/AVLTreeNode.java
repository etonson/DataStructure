package binaryTree;

/**
 * @author : eton.lin
 * @description TODO
 * @date 2024-04-25 下午 09:27
 */
class AVLTreeNode<T extends Comparable<T>> {
    T key;                // 关键字(键值)
    int height;         // 高度
    AVLTreeNode<T> left;    // 左孩子
    AVLTreeNode<T> right;    // 右孩子

    public AVLTreeNode(T key, AVLTreeNode<T> left, AVLTreeNode<T> right) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.height = 0;
    }
}