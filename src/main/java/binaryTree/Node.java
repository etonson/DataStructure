package binaryTree;

import lombok.Data;

/*
    @author : Eton.lin
    @description TODO
    @date 2024-10-24 上午 12:46
*/
@Data
public class Node<T> {
    T item;
    Node<T> lNext;
    Node<T> rNink;
    int balance;  // For AVL balancing

    public Node(T item) {
        this.item = item;
        this.lNext = null;
        this.rNink = null;
        this.balance = 0;
    }
}