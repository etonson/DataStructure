package queue;

public class TestArrayForQueue {

    public static void main(String[] args) {
        ArrayForQueue arrayForQueue = new ArrayForQueue();
        int[] arr = {11, 21, 31, 41, 51, 61,71,81,91,101};
        for (int j : arr) {
            arrayForQueue.enqueue(j);
        }

    }
}
