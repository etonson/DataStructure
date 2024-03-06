package queue;

/**
 * @author : eton.lin
 * @description TODO
 * @date 2024-03-06 上午 12:12
 */
public class TestLinkedForQueue {
    public static void main(String[] args) {
        LinkedForQueue linkedForQueue = new LinkedForQueue();
        int[] arr = {11};
        for (int j : arr) {
            linkedForQueue.enqueue(j);
        }
    }
}