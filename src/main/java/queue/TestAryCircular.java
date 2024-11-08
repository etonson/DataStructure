package queue;

/*
  @author : eton.lin
  @description TODO
  @date 2024-03-10 上午 12:45
 */
public class TestAryCircular {
        public static void main(String[] args) {
        int[] testArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        AryCircular aryCircular = new AryCircular(testArr.length);
        for (int i : testArr) {
            aryCircular.enqueue(i);
        }
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println(aryCircular.dequeue());
            }
            aryCircular.display();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}