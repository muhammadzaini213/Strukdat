package amerika.nodes.bitreenode;

public class BinaryTreeNode {

    private char key;
    private BinaryTreeNode left, right;

    public BinaryTreeNode(char key) {
        this.key = key;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public char getKey() {
        return key;
    }
}
