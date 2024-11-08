package trees;

/*
  @author : eton.lin
  @description TODO
  @date 2024-04-10 下午 10:28
*/
public class ArrayTree {
    public static void main(String[] args) {
        char[] fbTree = new char[16];
        char[] ary = {' ', 'E', 'D', 'F', 'B', 'H', 'A', 'C', 'G', 'I'};
        createBTree(fbTree, ary, 9);
        for (char c : fbTree) {
            System.out.print(c);
            System.out.print(",");
        }
    }

    static void createBTree(char[] tree, char[] ary, int len) {
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
