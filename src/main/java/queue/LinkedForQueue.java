package queue;

/**
 * @author : eton.lin
 * @description 透過linked方式建構queue結構
 * @date 2024-03-05 下午 11:23
 */
public class LinkedForQueue {
    private Node front, rear;

    public void enqueue(int data) {
        Node newNode = new Node(data);
        newNode.item = data;
        newNode.next = null;
        if (rear == null) {
            front = newNode;
            rear = front;
        }
        rear.next = newNode;
        rear = newNode;
    }

    //定義方法來移除佇列項目
    public int dequeue() {
        int number;
        Node current = front;  //指向目前節點的參考為頂端節點
        if (front == null) throw
                new IllegalStateException("空白佇列");
        else {
            //佇列有節點的情形下才做刪除
            //取得刪除節點的值給變數number儲存
            number = front.item;
            //front參考指向第二個節點
            front = current.next;
        }
        return number;
    }

    //定義方法回傳佇列前端項目

    public int peek() {
        if (front == null) throw
                new IllegalStateException("空白佇列");
        return front.item;
    }

    @Override
    public String toString() {
        return "LinkedForQueue{" +
                "front=" + front +
                ", rear=" + rear +
                '}';
    }
}
