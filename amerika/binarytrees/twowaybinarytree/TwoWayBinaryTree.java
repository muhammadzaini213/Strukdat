package amerika.binarytrees.twowaybinarytree;

import amerika.binarytrees.onewaybinarytree.BinaryTree;
import amerika.nodes.bitreenode.BinaryTreeNode;
import amerika.nodes.twowaybitreenode.TwoWayBinaryTreeNode;


public class TwoWayBinaryTree extends BinaryTree {

    public TwoWayBinaryTree() {
        root = null;
    }

    @Override
    public boolean add(char key) {
        if (root == null) {
            root = new TwoWayBinaryTreeNode(key);
            return true;
        }
        return insert(root, key);
    }

    private boolean insert(BinaryTreeNode root, char key) {
        if (key == root.getKey()) return false; // no duplicates

        if (key < root.getKey()) {
            if (root.getLeft() == null) {
                TwoWayBinaryTreeNode newNode = new TwoWayBinaryTreeNode(key);
                root.setLeft(newNode);
                newNode.setParent((TwoWayBinaryTreeNode) root);
                return true;
            }
            return insert((TwoWayBinaryTreeNode) root.getLeft(), key);
        } else {
            if (root.getRight() == null) {
                TwoWayBinaryTreeNode newNode = new TwoWayBinaryTreeNode(key);
                root.setRight(newNode);
                newNode.setParent((TwoWayBinaryTreeNode) root);
                return true;
            }
            return insert((TwoWayBinaryTreeNode) root.getRight(), key);
        }
    }

    @Override
    public boolean remove(char key) {
        TwoWayBinaryTreeNode node = findNode((TwoWayBinaryTreeNode) root, key);
        if (node == null) return false;

        delete(node);
        return true;
    }

    private void delete(TwoWayBinaryTreeNode node) {
        if (node.getLeft() == null && node.getRight() == null) {
            replaceParentLink(node, null);
        } else if (node.getLeft() == null) {
            TwoWayBinaryTreeNode right = (TwoWayBinaryTreeNode) node.getRight();
            replaceParentLink(node, right);
            right.setParent(node.getParent());
        } else if (node.getRight() == null) {
            TwoWayBinaryTreeNode left = (TwoWayBinaryTreeNode) node.getLeft();
            replaceParentLink(node, left);
            left.setParent(node.getParent());
        } else {
            TwoWayBinaryTreeNode successor = findMin((TwoWayBinaryTreeNode) node.getRight());
            node.setKey(successor.getKey());
            delete(successor);
        }
    }

    private void replaceParentLink(TwoWayBinaryTreeNode oldNode, TwoWayBinaryTreeNode newNode) {
        TwoWayBinaryTreeNode parent = oldNode.getParent();
        if (parent == null) {
            root = newNode;
        } else if (parent.getLeft() == oldNode) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }
        if (newNode != null) {
            newNode.setParent(parent);
        }
    }

    private TwoWayBinaryTreeNode findNode(TwoWayBinaryTreeNode node, char key) {
        if (node == null) return null;
        if (key == node.getKey()) return node;
        if (key < node.getKey()) return findNode((TwoWayBinaryTreeNode) node.getLeft(), key);
        else return findNode((TwoWayBinaryTreeNode) node.getRight(), key);
    }

    private TwoWayBinaryTreeNode findMin(TwoWayBinaryTreeNode node) {
        while (node.getLeft() != null) {
            node = (TwoWayBinaryTreeNode) node.getLeft();
        }
        return node;
    }

    private void rotateToLeft(TwoWayBinaryTreeNode node) {
        TwoWayBinaryTreeNode pivot = (TwoWayBinaryTreeNode) node.getRight();
        if (pivot == null) return;

        node.setRight(pivot.getLeft());
        if (pivot.getLeft() != null) {
            ((TwoWayBinaryTreeNode) pivot.getLeft()).setParent(node);
        }

        pivot.setParent(node.getParent());
        replaceParentLink(node, pivot);

        pivot.setLeft(node);
        node.setParent(pivot);
    }

    private void rotateToRight(TwoWayBinaryTreeNode node) {
        TwoWayBinaryTreeNode pivot = (TwoWayBinaryTreeNode) node.getLeft();
        if (pivot == null) return;

        node.setLeft(pivot.getRight());
        if (pivot.getRight() != null) {
            ((TwoWayBinaryTreeNode) pivot.getRight()).setParent(node);
        }

        pivot.setParent(node.getParent());
        replaceParentLink(node, pivot);

        pivot.setRight(node);
        node.setParent(pivot);
    }
}
