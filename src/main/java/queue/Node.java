package queue;

/**
 * @author : eton.lin
 * @description 節點
 * @date 2024-03-05 下午 11:27
 */
//定義鏈結串列的節點
class Node{
    int item;
    Node next;

    //定義建構函式 - 傳入數值
    Node(int data){
        this.item = data;
        this.next = null;
    }
    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                ", next=" + next +
                '}';
    }
}