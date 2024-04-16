package binaryTree;

/**
 * @author : eton.lin
 * @description TODO
 * @date 2024-04-16 下午 10:29
 * @reference:https://chikuwa-tech-study.blogspot.com/2021/06/java-binary-tree.html
 */
public class TestBinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.createBinaryTree(new int[]{60, 25, 93, 34, 18, 79});
        binarySearchTree.find(18);
    }
}
