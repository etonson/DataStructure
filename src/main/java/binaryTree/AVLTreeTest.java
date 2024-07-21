package binaryTree;

/**
 * @author : eton.lin
 * @description TODO
 * @date 2024-04-25 下午 10:51
 */

public class AVLTreeTest {
    private static int arr[] = {55, 50, 70, 40, 45};

    public static void main(String[] args) {
        int i;
        AVLTree<Integer> tree = new AVLTree<Integer>();

        System.out.printf("== 依次添加: ");
        for (i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
            tree.insert(arr[i]);
        }

        System.out.printf("\n== 前序遍歷: ");
        tree.preOrder();

        System.out.printf("\n== 中序遍歷: ");
        tree.inOrder();

        System.out.printf("\n== 後序遍歷: ");
        tree.postOrder();
        System.out.printf("\n");

        System.out.printf("== 高度: %d\n", tree.height());
        System.out.printf("== 最小值: %d\n", tree.minimum());
        System.out.printf("== 最大值: %d\n", tree.maximum());
        System.out.printf("== 樹的詳細信息: \n");
        tree.print();

        i = 8;
        System.out.printf("\n== 刪除根節點: %d", i);
        tree.remove(i);

        System.out.printf("\n== 高度: %d", tree.height());
        System.out.printf("\n== 中序遍歷: ");
        tree.inOrder();
        System.out.printf("\n== 樹的詳細信息: \n");
        tree.print();

        // 銷毀二叉樹
        tree.destroy();
    }
}