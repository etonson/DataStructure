package binaryTree;

import lombok.Data;

/*
    @author : Eton.lin
    @description TODO
    @date 2024-10-24 上午 12:46
*/
@Data
public class Node<T> {
    public T item;                //資料欄
    public int balance;             //平衡係數
    public Node lNext, rNink;       //指向前一個、下一個節點鏈結

    Node(T data){   //定義建構式 - 傳入數值
        this.item = data;
        this.balance = 0;
        this.lNext = null;
        this.rNink = null;
    }
}