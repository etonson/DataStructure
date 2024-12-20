package binaryTree;

import java.util.Optional;

/*
    @author : Eton.lin
    @description TODO
    @date 2024-10-24 上午 12:41
*/
public class BinTree {
    private Node<Integer> root;

    public BinTree() {
        root = null;
    }

    public Node<Integer> appenditem(int data) {
        Node<Integer> ptr, papa = null;
        Node<Integer> newNode = new Node(data);
        newNode.item = data;
        newNode.lNext = null;
        newNode.rNink = null;

        if (root == null)
            return newNode;
        else {
            ptr = root;

            while (ptr != null) {
                papa = ptr;

                if (ptr.item > data)
                    ptr = ptr.lNext;
                else
                    ptr = ptr.rNink;
            }

            if (papa.item > data)
                papa.lNext = newNode;
            else
                papa.rNink = newNode;
        }
        return root;
    }

    //定義方法-前序走訪二元樹
    public void preorder(Node root) {
        if (root != null) {
            inorder(root.lNext);              //2.再走訪左子樹
            inorder(root.rNink);              //3.最後走訪右子樹
        }
    }

    //定義方法-中序走訪二元樹
    public void inorder(Node root) {
        Optional<Node> o = Optional.ofNullable(root);
        if (o.isPresent()) {
            System.out.println(root.item);
        }
        if (root != null) {
            inorder(root.lNext);              //1.先走訪左子樹
            inorder(root.rNink);              //3.最後走訪右子樹
        }
    }

    //定義方法-後序走訪二元樹
    public void postorder(Node root) {
        if (root != null) {
            inorder(root.lNext);        //1.先走訪左子樹
            inorder(root.rNink);        //2.再拜訪右子樹
        }
    }
    public Node<Integer> addItem(Node<Integer> ptr, int data) {
        if (ptr == null) return new Node<>(data);

        if (data < ptr.item) {
            ptr.lNext = addItem(ptr.lNext, data);
            if (height(ptr.lNext) - height(ptr.rNink) == 2) {
                if (data < (Integer) ptr.lNext.item) {
                    ptr = rotateRight(ptr);  // LL 旋轉
                } else {
                    ptr.lNext = rotateLeft(ptr.lNext);  // LR 旋轉左子節點
                    ptr = rotateRight(ptr);             // 再右旋根節點
                }
            }
        } else if (data > ptr.item) {
            ptr.rNink = addItem(ptr.rNink, data);
            if (height(ptr.rNink) - height(ptr.lNext) == 2) {
                if (data > (Integer)ptr.rNink.item) {
                    ptr = rotateLeft(ptr);  // RR 旋轉
                } else {
                    ptr.rNink = rotateRight(ptr.rNink); // RL 旋轉右子節點
                    ptr = rotateLeft(ptr);              // 再左旋根節點
                }
            }
        }
        return ptr;
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

    public int height(Node<Integer> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.lNext), height(node.rNink));
    }

    private void updateBalance(Node<Integer> node) {
        if (node != null) {
            node.balance = height(node.lNext) - height(node.rNink);
        }
    }
}