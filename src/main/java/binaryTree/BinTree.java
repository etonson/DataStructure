package binaryTree;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/*
    @author : Eton.lin
    @description 二元樹
    @date 2024-10-24 上午 12:41
*/
@Setter
@Getter
public class BinTree {
    private Node<Integer> root;

    public void appendItem(int data) {
        root = insertNode(root, data);
    }

    public void deleteItem(int data) {
        root = deleteNode(root, data);
    }


    public void preorder(Node<Integer> node) {
        if (node != null) {
            System.out.println(node.item);
            preorder(node.lNext);
            preorder(node.rNink);
        }
    }

    public void inorder(Node<Integer> node) {
        if (node != null) {
            inorder(node.lNext);
            System.out.println(node.item);
            inorder(node.rNink);
        }
    }

    public void postorder(Node<Integer> node) {
        if (node != null) {
            postorder(node.lNext);
            postorder(node.rNink);
            System.out.println(node.item);
        }
    }

    /**
     * 將資料插入 AVL 樹中，並在插入後保持平衡。
     */
    private Node<Integer> insertNode(Node<Integer> node, int data) {
        // 如果目前節點為 null，表示找到插入位置
        if (node == null) return new Node<>(data);

        // 資料小於當前節點：往左子樹遞迴插入
        if (data < node.item) {
            node.lNext = insertNode(node.lNext, data);

            // 檢查是否出現左子樹失衡（高度差 2）
            if (height(node.lNext) - height(node.rNink) == 2) {
                if (data < node.lNext.item) {
                    // LL 失衡：單右旋
                    node = rotateRight(node);
                } else {
                    // LR 失衡：先左旋左子，再右旋自己
                    node.lNext = rotateLeft(node.lNext);
                    node = rotateRight(node);
                }
            }

            // 資料大於當前節點：往右子樹遞迴插入
        } else if (data > node.item) {
            node.rNink = insertNode(node.rNink, data);

            // 檢查是否出現右子樹失衡（高度差 2）
            if (height(node.rNink) - height(node.lNext) == 2) {
                if (data > node.rNink.item) {
                    // RR 失衡：單左旋
                    node = rotateLeft(node);
                } else {
                    // RL 失衡：先右旋右子，再左旋自己
                    node.rNink = rotateRight(node.rNink);
                    node = rotateLeft(node);
                }
            }
        }

        // 更新節點的高度與平衡因子
        updateBalance(node);
        return node;
    }


    /**
     * 從 AVL 樹中刪除指定值的節點，並在刪除後保持樹的平衡。
     */
    private Node<Integer> deleteNode(Node<Integer> node, int data) {
        if (node == null) return null;

        // 遞迴搜尋待刪除節點
        if (data < node.item) {
            node.lNext = deleteNode(node.lNext, data); // 向左子樹遞迴
        } else if (data > node.item) {
            node.rNink = deleteNode(node.rNink, data); // 向右子樹遞迴
        } else {
            // 找到要刪除的節點
            if (node.lNext == null || node.rNink == null) {
                // 只有一個子節點或沒有子節點：直接返回非 null 子節點（或 null）
                node = (node.lNext != null) ? node.lNext : node.rNink;
            } else {
                // 有兩個子節點：
                // 1. 尋找右子樹中最小值（即下一個中序節點）
                Node<Integer> minLarger = findMin(node.rNink);
                // 2. 用該節點取代目前節點值
                node.item = minLarger.item;
                // 3. 遞迴刪除右子樹中該節點（因為它被提升上來）
                node.rNink = deleteNode(node.rNink, minLarger.item);
            }
        }

        // 若刪除後節點為 null，直接返回
        if (node == null) return null;

        // ----------- AVL 平衡處理 -----------
        // 更新當前節點的平衡因子（通常是依據左右子節點高度差計算）
        updateBalance(node);
        int balance = node.balance;

        // 左子樹過重（balance > 1）
        if (balance > 1) {
            // LL 失衡（左子節點的左子樹高）：單右旋
            if (height(node.lNext.lNext) >= height(node.lNext.rNink)) {
                return rotateRight(node);
            } else {
                // LR 失衡（左子節點的右子樹高）：先左旋左子，再右旋自己
                node.lNext = rotateLeft(node.lNext);
                return rotateRight(node);
            }
        }

        // 右子樹過重（balance < -1）
        if (balance < -1) {
            // RR 失衡（右子節點的右子樹高）：單左旋
            if (height(node.rNink.rNink) >= height(node.rNink.lNext)) {
                return rotateLeft(node);
            } else {
                // RL 失衡（右子節點的左子樹高）：先右旋右子，再左旋自己
                node.rNink = rotateRight(node.rNink);
                return rotateLeft(node);
            }
        }

        // 無需旋轉，回傳平衡後的節點
        return node;
    }

    private Node<Integer> rotateRight(Node<Integer> root) {
        Node<Integer> newRoot = root.lNext;
        root.lNext = newRoot.rNink;
        newRoot.rNink = root;
        updateBalance(root);
        updateBalance(newRoot);
        return newRoot;
    }

    private Node<Integer> rotateLeft(Node<Integer> root) {
        Node<Integer> newRoot = root.rNink;
        root.rNink = newRoot.lNext;
        newRoot.lNext = root;
        updateBalance(root);
        updateBalance(newRoot);
        return newRoot;
    }

    private int height(Node<Integer> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.lNext), height(node.rNink));
    }

    private void updateBalance(Node<Integer> node) {
        if (node != null)
            node.balance = height(node.lNext) - height(node.rNink);
    }

    private Node<Integer> findMin(Node<Integer> node) {
        while (node.lNext != null) node = node.lNext;
        return node;
    }

    public List<Integer> toSortedList() {
        List<Integer> result = new ArrayList<>();
        inorderToList(root, result);
        return result;
    }

    private void inorderToList(Node<Integer> node, List<Integer> list) {
        if (node != null) {
            inorderToList(node.lNext, list);
            list.add(node.item);
            inorderToList(node.rNink, list);
        }
    }

    public void printTree() {
        printTree(root, "", true);
    }

    private void printTree(Node<Integer> node, String prefix, boolean isTail) {
        if (node == null) return;
        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.item);
        if (node.lNext != null || node.rNink != null) {
            if (node.lNext != null)
                printTree(node.lNext, prefix + (isTail ? "    " : "│   "), false);
            if (node.rNink != null)
                printTree(node.rNink, prefix + (isTail ? "    " : "│   "), true);
        }
    }

}