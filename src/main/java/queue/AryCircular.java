package queue;

import java.util.Arrays;

/**
 * @author : eton.lin
 * @description 環狀結構
 * @date 2024-03-07 下午 11:19
 */
public class AryCircular {
    int maxSize;
    int rear, front, count;
    int[] list;

    public AryCircular(int size) {
        this.maxSize = size;
        list = new int[size];
        this.rear = 0;
        this.front = 0;
        this.count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == maxSize;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("this queue is full!!");
        } else {
            list[rear] = data;
            rear = (rear + 1) % maxSize;
            count++;
        }
    }

    public int dequeue() throws Exception {
        int result ;
        if (isEmpty()) {
            throw new Exception("this queue is empty!!");
        }else {
            result = list[front];
            front = (front+1)%maxSize;
            count--;
        }
        return result;
    }
    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "AryCircular{" +
                "rear=" + rear +
                ", front=" + front +
                ", count=" + count +
                ", list=" + Arrays.toString(list) +
                '}';
    }
}
