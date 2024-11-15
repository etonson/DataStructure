package binaryTree;

/*
    @author : Eton.lin
    @description TODO
    @date 2024-11-05 上午 01:26
*/
public class AVLTreeTest {
    public static void main(String[] args) {
        BinTree tree = new BinTree();

        int[] values = {10, 20, 30, 40,50,25};
        Node<Integer> root = null;

        for (int value : values) {
            root = tree.addItem(root, value);
        }

        // 打印 AVL 樹的結構
//        tree.inorder(root);
        printTreeStructure(root, "", true);

    }

   // 打印 AVL 樹的結構，以顯示節點和平衡因子
    private static void printTreeStructure(Node<Integer> node, String prefix, boolean isRight) {
        if (node != null) {
            System.out.println(prefix + (isRight ? "└── " : "├── ") + node.item + " (balance: " + node.balance + ")");
            printTreeStructure(node.lNext, prefix + (isRight ? "    " : "│   "), false);
            printTreeStructure(node.rNink, prefix + (isRight ? "    " : "│   "), true);
        }
    }
}