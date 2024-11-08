package binaryTree;

/*
    @author : Eton.lin
    @description TODO
    @date 2024-11-05 上午 01:26
*/
public class AVLTreeTest1 {
    public static void main(String[] args) {
        BinTree tree = new BinTree();

        int[] values = {10, 20, 30, 40,50};
        Node root = null;

        for (int value : values) {
            root = tree.addItem(root, value);
            System.out.println("Inserted " + value + " into AVL Tree.");
        }

        // 打印 AVL 樹的結構
        System.out.println("In-order traversal of AVL Tree:");
        tree.inorder(root);

        System.out.println("\nTree structure:");
        printTreeStructure(root, "", true);

        int h = tree.height(root.getLNext());
        System.out.println(h);
    }

   // 打印 AVL 樹的結構，以顯示節點和平衡因子
    private static void printTreeStructure(Node node, String prefix, boolean isRight) {
        if (node != null) {
            System.out.println(prefix + (isRight ? "└── " : "├── ") + node.item + " (balance: " + node.balance + ")");
            printTreeStructure(node.lNext, prefix + (isRight ? "    " : "│   "), false);
            printTreeStructure(node.rNink, prefix + (isRight ? "    " : "│   "), true);
        }
    }
}