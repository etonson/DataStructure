package binaryTree;

import lombok.Data;

/*
  @author : eton.lin
  @description TODO
  @date 2024-04-11 下午 11:46
  @reference:https://chikuwa-tech-study.blogspot.com/2021/06/java-binary-tree.html
*/
@Data
public class TreeNode<E> {
    private E value;
    private TreeNode<E> leftNode;
    private TreeNode<E> rightNode;
    private int height;

    public void initNode(E v, TreeNode<E> leftNode, TreeNode<E> rightNode, int height) {
        this.value = v;
        this.rightNode = rightNode;
        this.leftNode = leftNode;
        this.height = height;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }
}
