package amerika.binarytrees.onewaybinarytree;

import amerika.nodes.bitreenode.BinaryTreeNode;

public class BinaryTree {
    
    protected BinaryTreeNode root;
    protected int size = 0;

    public boolean add(char key) {
        if (root == null) {
            root = new BinaryTreeNode(key);
            size++;
            return true;
        }
        return insert(root, key);
    }

    private boolean insert(BinaryTreeNode node, char key) {
        if (key == node.getKey()) {
            return false;
        } else if (key < node.getKey()) {
            if (node.getLeft() == null) {
                node.setLeft(new BinaryTreeNode(key));
                size++;
                return true;
            } else {
                return insert(node.getLeft(), key);
            }
        } else  {
            if (node.getRight() == null) {
                node.setRight(new BinaryTreeNode(key));
                size++;
                return true;
            } else {
                return insert(node.getRight(), key);
            }
        }
    }

    public boolean remove(char key) {
        if (root == null) return false;
        if (!contains(root, key)) return false;
        root = delete(root, key);
        size--;
        return true;
    }

    private BinaryTreeNode delete(BinaryTreeNode node, char key) {
        if (node == null) return null;

        if (key < node.getKey()) {
            node.setLeft(delete(node.getLeft(), key));
        } else if (key > node.getKey()) {
            node.setRight(delete(node.getRight(), key));
        } else {

            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            } else if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                BinaryTreeNode succesor = findMin(node.getRight());
                node.setKey(succesor.getKey());
                node.setRight(delete(node.getRight(), succesor.getKey()));
            }
        }
        return node;
    }

    private BinaryTreeNode findMin(BinaryTreeNode node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    private boolean contains(BinaryTreeNode node, char key) {
        if (node == null) return false;
        if (key == node.getKey()) return true;
        return key < node.getKey() ? contains(node.getLeft(), key) : contains(node.getRight(), key);
    }

        public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(BinaryTreeNode node) {
        if (node == null) return;
        System.out.print(node.getKey() + " ");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(BinaryTreeNode node) {
        if (node == null) return;
        inOrder(node.getLeft());
        System.out.print(node.getKey() + " ");
        inOrder(node.getRight());
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(BinaryTreeNode node) {
        if (node == null) return;
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getKey() + " ");
    }

    public int getSize() {
        return size;
    }
}
