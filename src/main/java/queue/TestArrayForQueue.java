package queue;

public class TestArrayForQueue {

	public static void main(String[] args) {
		ArrayForQueue arrayForQueue = new ArrayForQueue();
		int[] arr = { 11, 21, 31, 41, 51, 61 };
		for (int i = 0; i < arr.length; i++) {
			arrayForQueue.enqueue(arr[i]);
//			System.out.println("size===>"+arrayForQueue.getSize());
		}
		System.out.println(arrayForQueue.dequeue());
	}
}
