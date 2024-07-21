package binaryTree;

/**
 * @author : eton.lin
 * @description TODO
 * @date 2024-04-25 下午 09:27
 */
class AVLTreeNode<T extends Comparable<T>> {
    T key;                // 關鍵字(鍵值)
    int height;         // 高度
    AVLTreeNode<T> left;    // 左
    AVLTreeNode<T> right;    // 右

    public AVLTreeNode(T key, AVLTreeNode<T> left, AVLTreeNode<T> right) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.height = 0;
    }
}