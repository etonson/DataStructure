package binaryTree;

/*
  @author : eton.lin
  @description TODO
  @reference:https://www.cnblogs.com/skywang12345/p/3577479.html
  @date 2024-04-20 下午 02:33
*/

public class AVLTree<T extends Comparable<T>> {
    private AVLTreeNode<T> mRoot;    // 根結點

    // 構造函數
    public AVLTree() {
        mRoot = null;
    }

    /*
     * 獲取樹的高度
     */
    private int height(AVLTreeNode<T> tree) {
        if (tree != null)
            return tree.height;

        return 0;
    }

    public int height() {
        return height(mRoot);
    }

    /*
     * 比較兩個值的大小
     */
    private int max(int a, int b) {
        return a > b ? a : b;
    }

    /*
     * 前序遍歷"AVL樹"
     */
    private void preOrder(AVLTreeNode<T> tree) {
        if (tree != null) {
            System.out.print(tree.key + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(mRoot);
    }

    /*
     * 中序遍歷"AVL樹"
     */
    private void inOrder(AVLTreeNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.print(tree.key + " ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(mRoot);
    }

    /*
     * 後序遍歷"AVL樹"
     */
    private void postOrder(AVLTreeNode<T> tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.key + " ");
        }
    }

    public void postOrder() {
        postOrder(mRoot);
    }

    /*
     * (遞迴實現)查找"AVL樹"中鍵值為key的節點
     */
    private AVLTreeNode<T> search(AVLTreeNode<T> x, T key) {
        if (x == null)
            return x;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return search(x.left, key);
        else if (cmp > 0)
            return search(x.right, key);
        else
            return x;
    }

    public AVLTreeNode<T> search(T key) {
        return search(mRoot, key);
    }

    /*
     * (非遞迴實現)查找"AVL樹"中鍵值為key的節點
     */
    private AVLTreeNode<T> iterativeSearch(AVLTreeNode<T> x, T key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);

            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else
                return x;
        }

        return x;
    }

    public AVLTreeNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    /*
     * 查找最小節點：返回tree節點節點的AVL樹的最小節點
     */
    private AVLTreeNode<T> minimum(AVLTreeNode<T> tree) {
        if (tree == null)
            return null;

        while (tree.left != null)
            tree = tree.left;
        return tree;
    }

    public T minimum() {
        AVLTreeNode<T> p = minimum(mRoot);
        if (p != null)
            return p.key;

        return null;
    }

    /*
     * 查找最大結點：返回tree為根結點的AVL樹的最大結點。
     */
    private AVLTreeNode<T> maximum(AVLTreeNode<T> tree) {
        if (tree == null)
            return null;

        while (tree.right != null)
            tree = tree.right;
        return tree;
    }

    public T maximum() {
        AVLTreeNode<T> p = maximum(mRoot);
        if (p != null)
            return p.key;

        return null;
    }

    /*
     * LL：左左對應的情況(左單旋轉)。
     *
     * 返回值：旋轉後的根節點
     */
    private AVLTreeNode<T> leftLeftRotation(AVLTreeNode<T> parentNode) {
        AVLTreeNode<T> tmpNode = parentNode.left;
        parentNode.left = tmpNode.right;
        tmpNode.right = parentNode;

        parentNode.height = max(height(parentNode.left), height(parentNode.right)) + 1;
        tmpNode.height = max(height(tmpNode.left), parentNode.height) + 1;

        return tmpNode;
    }

    /*
     * RR：右右對應的情況(右單旋轉)。
     *
     * 返回值：旋轉後的根節點
     */
    private AVLTreeNode<T> rightRightRotation(AVLTreeNode<T> parentNode) {
        AVLTreeNode<T> tmpNode = parentNode.right;
        parentNode.right = tmpNode.left;
        tmpNode.left = parentNode;

        parentNode.height = max(height(parentNode.left), height(parentNode.right)) + 1;
        tmpNode.height = max(height(tmpNode.right), parentNode.height) + 1;

        return tmpNode;
    }

    /*
     * LR：左右對應的情況(左雙旋轉)。
     *
     * 返回值：旋轉後的根節點
     */
    private AVLTreeNode<T> leftRightRotation(AVLTreeNode<T> k3) {
        k3.left = rightRightRotation(k3.left);

        return leftLeftRotation(k3);
    }

    /*
     * RL：右左對應的情況(右雙旋轉)。
     *
     * 返回值：旋轉後的根節點
     */
    private AVLTreeNode<T> rightLeftRotation(AVLTreeNode<T> k1) {
        k1.right = leftLeftRotation(k1.right);

        return rightRightRotation(k1);
    }

    /*
     * 將結點插入到AVL樹中，並返回根節點
     *
     * 參數說明：
     *     tree AVL樹的根結點
     *     key 插入的結點的鍵值
     * 返回值：
     *     根節點
     */
    private AVLTreeNode<T> insert(AVLTreeNode<T> tree, T key) {
        if (tree == null) {
            tree = new AVLTreeNode<T>(key, null, null);
        } else {
            int cmp = key.compareTo(tree.key);
            if (cmp < 0) {
                // 應該將key插入到"tree的左子樹"的情況
                tree.left = insert(tree.left, key);
                // 插入節點後，若AVL樹失去平衡，則進行相應的調節。
                if (height(tree.left) - height(tree.right) == 2) {
                    if (key.compareTo(tree.left.key) < 0) {
                        System.out.println("case1");
                        tree = leftLeftRotation(tree);
                    } else {
                        System.out.println("case2");
                        tree = leftRightRotation(tree);
                    }
                }
            } else if (cmp > 0) {
                // 應該將key插入到"tree的右子樹"的情況
                tree.right = insert(tree.right, key);
                // 插入節點後，若AVL樹失去平衡，則進行相應的調節。
                if (height(tree.right) - height(tree.left) == 2) {
                    if (key.compareTo(tree.right.key) > 0) {
                        System.out.println("case3");
                        tree = rightRightRotation(tree);
                    } else {
                        System.out.println("case4");
                        tree = rightLeftRotation(tree);
                    }
                }
            } else {    // cmp==0
                System.out.println("添加失敗：不允許添加相同的節點！");
            }
        }

        tree.height = max(height(tree.left), height(tree.right)) + 1;

        return tree;
    }

    public void insert(T key) {
        mRoot = insert(mRoot, key);
    }

    /*
     * 刪除結點(z)，返回根節點
     *
     * 參數說明：
     *     tree AVL樹的根結點
     *     z 待刪除的結點
     * 返回值：
     *     根節點
     */
    private AVLTreeNode<T> remove(AVLTreeNode<T> tree, AVLTreeNode<T> z) {
        // 根為空 或者 沒有要刪除的節點，直接返回null。
        if (tree == null || z == null)
            return null;

        int cmp = z.key.compareTo(tree.key);
        if (cmp < 0) {        // 待刪除的節點在"tree的左子樹"中
            tree.left = remove(tree.left, z);
            // 刪除節點後，若AVL樹失去平衡，則進行相應的調節。
            if (height(tree.right) - height(tree.left) == 2) {
                AVLTreeNode<T> r = tree.right;
                if (height(r.left) > height(r.right))
                    tree = rightLeftRotation(tree);
                else
                    tree = rightRightRotation(tree);
            }
        } else if (cmp > 0) {    // 待刪除的節點在"tree的右子樹"中
            tree.right = remove(tree.right, z);
            // 刪除節點後，若AVL樹失去平衡，則進行相應的調節。
            if (height(tree.left) - height(tree.right) == 2) {
                AVLTreeNode<T> l = tree.left;
                if (height(l.right) > height(l.left))
                    tree = leftRightRotation(tree);
                else
                    tree = leftLeftRotation(tree);
            }
        } else {    // tree是對應要刪除的節點。
            // tree的左右孩子都非空
            if ((tree.left != null) && (tree.right != null)) {
                if (height(tree.left) > height(tree.right)) {
                    // 如果tree的左子樹比右子樹高；
                    // 則(01)找出tree的左子樹中的最大節點
                    //   (02)將該最大節點的值賦值給tree。
                    //   (03)刪除該最大節點。
                    // 這類似於用"tree的左子樹中最大節點"做"tree"的替身；
                    // 採用這種方式的好處是：刪除"tree的左子樹中最大節點"之後，AVL樹仍然是平衡的。
                    AVLTreeNode<T> max = maximum(tree.left);
                    tree.key = max.key;
                    tree.left = remove(tree.left, max);
                } else {
                    // 如果tree的左子樹不比右子樹高(即它們相等，或右子樹比左子樹高1)
                    // 則(01)找出tree的右子樹中的最小節點
                    //   (02)將該最小節點的值賦值給tree。
                    //   (03)刪除該最小節點。
                    // 這類似於用"tree的右子樹中最小節點"做"tree"的替身；
                    // 採用這種方式的好處是：刪除"tree的右子樹中最小節點"之後，AVL樹仍然是平衡的。
                    AVLTreeNode<T> min = maximum(tree.right);
                    tree.key = min.key;
                    tree.right = remove(tree.right, min);
                }
            } else {
                AVLTreeNode<T> tmp = tree;
                tree = (tree.left != null) ? tree.left : tree.right;
                tmp = null;
            }
        }

        return tree;
    }

    public void remove(T key) {
        AVLTreeNode<T> z;

        if ((z = search(mRoot, key)) != null)
            mRoot = remove(mRoot, z);
    }

    /*
     * 銷毀AVL樹
     */
    private void destroy(AVLTreeNode<T> tree) {
        if (tree == null)
            return;

        if (tree.left != null)
            destroy(tree.left);
        if (tree.right != null)
            destroy(tree.right);

        tree = null;
    }

    public void destroy() {
        destroy(mRoot);
    }

    /*
     * 打印"二叉查找樹"
     *
     * key        -- 節點的鍵值
     * direction  --  0，表示該節點是根節點;
     *               -1，表示該節點是它的父結點的左孩子;
     *                1，表示該節點是它的父結點的右孩子。
     */
    private void print(AVLTreeNode<T> tree, T key, int direction) {
        if (tree != null) {
            if (direction == 0)    // tree是根節點
                System.out.printf("%2d is root\n", tree.key, key);
            else                // tree是分支節點
                System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction == 1 ? "right" : "left");

            print(tree.left, tree.key, -1);
            print(tree.right, tree.key, 1);
        }
    }

    public void print() {
        if (mRoot != null)
            print(mRoot, mRoot.key, 0);
    }
}