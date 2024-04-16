package binaryTree;

/**
 * @author : eton.lin
 * @description TODO
 * @date 2024-04-16 下午 10:18
 * @reference:https://chikuwa-tech-study.blogspot.com/2021/06/java-binary-tree.html
 */
public class BinarySearchTree {
    private TreeNode<Integer> root;

    public BinarySearchTree() {
    }

    public void createBinaryTree(int[] values) {
        if (values.length == 0) {
            return;
        }

        TreeNode<Integer> ptr;
        this.root = new TreeNode<>(values[0]);
        for (int i = 1; i < values.length; i++) {
            ptr = this.root;
            TreeNode<Integer> newNode = new TreeNode<>(values[i]);

            while (true) {
                if (values[i] < ptr.getValue()) {
                    ptr.setLeftNode(newNode);
                    ptr = ptr.getLeftNode();
                } else {
                    ptr.setRightNode(newNode);
                    ptr = ptr.getRightNode();
                }
            }
        }
    }

    public Integer find(int target) {
        if (this.root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder()
                .append("Searching path of ")
                .append(target)
                .append(": Root");
        TreeNode<Integer> ptr = this.root;
        while (ptr.getValue() != target) {
            if (target < ptr.getValue()) {
                ptr = ptr.getLeftNode();
                sb.append(" -> Left");
            } else {
                ptr = ptr.getRightNode();
                sb.append(" -> Right");
            }
            if (ptr == null) {
                return null;
            }
        }
        System.out.println(sb);
        return ptr.getValue();
    }

    public void remove(int target) {
        if (this.root == null) {
            return;
        }

        TreeNode<Integer> parentOfRemovingNode = null;
        TreeNode<Integer> removingNode = this.root;
        boolean isLeftNode = false;
        while (removingNode.getValue() != target) {
            parentOfRemovingNode = removingNode;
            if (target < removingNode.getValue()) {
                removingNode = removingNode.getLeftNode();
                isLeftNode = true;
            } else {
                removingNode = removingNode.getRightNode();
                isLeftNode = false;
            }

            if (removingNode == null) {
                return;
            }
        }

        if (removingNode.getLeftNode() == null && removingNode.getRightNode() == null) {
            removeLeafNode(parentOfRemovingNode, isLeftNode);
        } else if (removingNode.getLeftNode() == null ^ removingNode.getRightNode() == null) {
            removeNodeHavingOneChild(parentOfRemovingNode, isLeftNode);
        } else {
            removeNodeHavingTwoChild(parentOfRemovingNode, isLeftNode);
        }
    }

    private void removeLeafNode(TreeNode<Integer> parentOfRemovingNode, boolean isLeftNode) {
        if (parentOfRemovingNode == null) {
            this.root = null;
        } else if (isLeftNode) {
            parentOfRemovingNode.setLeftNode(null);
        } else {
            parentOfRemovingNode.setRightNode(null);
        }
    }

    private void removeNodeHavingOneChild(TreeNode<Integer> parentOfRemovingNode, boolean isLeftNode) {
        if (parentOfRemovingNode == null) {
            this.root = isLeftNode
                    ? this.root.getLeftNode()
                    : this.root.getRightNode();
            return;
        }

        TreeNode<Integer> removingNode = isLeftNode
                ? parentOfRemovingNode.getLeftNode()
                : parentOfRemovingNode.getRightNode();
        TreeNode<Integer> replacingNode = removingNode.getLeftNode() != null
                ? removingNode.getLeftNode()
                : removingNode.getRightNode();

        if (isLeftNode) {
            parentOfRemovingNode.setLeftNode(replacingNode);
        } else {
            parentOfRemovingNode.setRightNode(replacingNode);
        }
    }

    private void removeNodeHavingTwoChild(TreeNode<Integer> parentOfRemovingNode, boolean isLeftNode) {
        TreeNode<Integer> removingNode;
        if (parentOfRemovingNode == null) {
            removingNode = this.root;
        } else {
            removingNode = isLeftNode
                    ? parentOfRemovingNode.getLeftNode()
                    : parentOfRemovingNode.getRightNode();
        }

        boolean isRemovingNodeHasRightNode = removingNode.getRightNode() != null;
        TreeNode<Integer> parentOfReplacingNode;
        TreeNode<Integer> replacingNode;
        if (isRemovingNodeHasRightNode) {
            parentOfReplacingNode = findParentOfMinInRightTree(removingNode);
            replacingNode = parentOfReplacingNode == removingNode
                    ? removingNode.getRightNode()
                    : parentOfReplacingNode.getLeftNode();
        } else {
            parentOfReplacingNode = findParentOfMaxInLeftTree(removingNode);
            replacingNode = parentOfReplacingNode == removingNode
                    ? removingNode.getLeftNode()
                    : parentOfReplacingNode.getRightNode();
        }

        if (parentOfReplacingNode != removingNode) {
            if (isRemovingNodeHasRightNode) {
                parentOfReplacingNode.setLeftNode(replacingNode.getRightNode());
            } else {
                parentOfReplacingNode.setRightNode(replacingNode.getLeftNode());
            }
        }
        replacingNode.setLeftNode(removingNode.getLeftNode());
        replacingNode.setRightNode(removingNode.getRightNode());

        if (parentOfRemovingNode == null) {
            this.root = replacingNode;
        } else {
            if (isLeftNode) {
                parentOfRemovingNode.setLeftNode(replacingNode);
            } else {
                parentOfRemovingNode.setRightNode(replacingNode);
            }
        }
    }

    private TreeNode<Integer> findParentOfMaxInLeftTree(TreeNode<Integer> node) {
        TreeNode<Integer> parentNode = node;
        TreeNode<Integer> visitedNode = node.getLeftNode();
        while (visitedNode.getRightNode() != null) {
            parentNode = visitedNode;
            visitedNode = visitedNode.getRightNode();
        }

        return parentNode;
    }

    private TreeNode<Integer> findParentOfMinInRightTree(TreeNode<Integer> node) {
        TreeNode<Integer> parentNode = node;
        TreeNode<Integer> visitedNode = node.getRightNode();
        while (visitedNode.getLeftNode() != null) {
            parentNode = visitedNode;
            visitedNode = visitedNode.getLeftNode();
        }

        return parentNode;
    }

}
