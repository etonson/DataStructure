package binaryTree;

/*
    @author : Eton.lin
    @description 平衡樹測試
    @date 2024-11-05 上午 01:26
*/
public class AVLTreeTest {
    public static void main(String[] args) {
        BinTree tree = new BinTree();
//        int[] data = {30, 20, 40, 10, 25, 35, 50, 5, 15};
        int[] data = {10, 20, 30, 40,50,25};

        for (int d : data) {
            tree.appendItem(d);
        }

        System.out.println("中序排序：");
        System.out.println(tree.toSortedList());

        System.out.println("\n樹狀圖輸出：");
        tree.printTree();

        System.out.println("\n刪除 20 後：");
        tree.deleteItem(20);
        tree.printTree();
    }

}