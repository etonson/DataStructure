package queue;

import java.util.Arrays;

/*
     @author : eton.lin
     @description 透過陣列方式實作equeue
     @date 2024/3/15
*/
public class ArrayForQueue {
	int[] list;
	private int rear, front, size;
	private static final int CAPACITY = 10;

	ArrayForQueue() {
		list = new int[CAPACITY];
		this.size = 0;
		this.rear = 0;
		this.front = 0;
	}
	public boolean isEmpty() {
		return (size==0);
	}

	public void enqueue(int data) {
		if (rear == CAPACITY) {
			System.out.println("queue is full");
		} else {
			list[rear] = data;
			rear++;
			size++;
		}
	}

public int dequeue() {
		if (isEmpty()) {
			return -1;
		} else {
			int result = list[front];
			size--;
			front++;
			return result;
		}
	}

	public void display() {
		for (int j = front; j < CAPACITY + front; j++)
		{
			System.out.printf("%4d%n", list[j % size]);
		}
		System.out.printf("Front<%d>, Rear<%d>, Count = %d%n%n", front, rear, CAPACITY);
	}

	public int getRear() {
		return rear;
	}


	public int getFront() {
		return front;
	}

	public void setFront(int front) {
		this.front = front;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public static int getCapacity() {
		return CAPACITY;
	}


	@Override
	public String toString() {
		return "ArrayForQueue [list=" + Arrays.toString(list) + ", rear=" + rear + ", front=" + front + ", size=" + size
				+ "]";
	}
}
