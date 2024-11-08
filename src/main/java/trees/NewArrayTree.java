package trees;

/*
  @author : eton.lin
  @description TODO
  @date 2024-04-10 下午 11:44
*/
public class NewArrayTree {
    public static void main(String[] args) {
        int[] fbTree = new int[16];
        int[] ary = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        createBTree(fbTree, ary, 9);
        for (int c : fbTree) {
            System.out.print(c);
            System.out.print(",");
        }
    }

    static void createBTree(int[] tree, int[] ary, int len) {
        int j, level;
        tree[1] = ary[1];
        for (j = 2; j <= len; j++) {
            level = 1;
            while (tree[level] != 0) {
                if (ary[j] > tree[level]) {
                    level = level * 2 + 1;
                } else {
                    level = 2 * level;
                }
            }
            tree[level] = ary[j];
        }
    }
}
