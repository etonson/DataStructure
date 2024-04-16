package binaryTree;

/**
 * @author : eton.lin
 * @description TODO
 * @date 2024-04-12 上午 12:05
 */
public class TestTreeMethod {
    public static void main(String[] args) {
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        node2.setLeftNode(node1);
        node2.setRightNode(node3);

        TreeNode<Integer> node8 = new TreeNode<>(8);
        TreeNode<Integer> node9 = new TreeNode<>(9);
        node1.setLeftNode(node8);
        node1.setRightNode(node9);

        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node7 = new TreeNode<>(7);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        node6.setLeftNode(node5);
        node6.setRightNode(node7);

        TreeNode<Integer> node4 = new TreeNode<>(4);
        node4.setLeftNode(node2);
        node4.setRightNode(node6);
        node4.postOrder();

    }
}
