package amerika.binarytrees.twowaybinarytree;

import amerika.binarytrees.onewaybinarytree.BinaryTree;
import amerika.nodes.twowaybitreenode.TwoWayBinaryTreeNode;

public class TwoWayBinaryTree extends BinaryTree {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public TwoWayBinaryTree() {
        root = null;
    }

    @Override
    public boolean add(char key) {
        TwoWayBinaryTreeNode inserted = insertNode(key);
        if (inserted == null) return false; // duplicate

        fixInsert(inserted);
        root = getRoot(inserted);
        ((TwoWayBinaryTreeNode) root).setRed(BLACK);
        size++;
        return true;
    }

    private TwoWayBinaryTreeNode insertNode(char key) {
        if (root == null) {
            TwoWayBinaryTreeNode n = new TwoWayBinaryTreeNode(key);
            n.setRed(BLACK);
            root = n;
            return n;
        }

        TwoWayBinaryTreeNode parent = null;
        TwoWayBinaryTreeNode cur = (TwoWayBinaryTreeNode) root;

        while (cur != null) {
            parent = cur;
            if (key == cur.getKey()) return null;   // no duplicate
            if (key < cur.getKey()) cur = (TwoWayBinaryTreeNode) cur.getLeft();
            else cur = (TwoWayBinaryTreeNode) cur.getRight();
        }

        TwoWayBinaryTreeNode newNode = new TwoWayBinaryTreeNode(key);
        newNode.setRed(RED);
        newNode.setParent(parent);

        if (key < parent.getKey()) parent.setLeft(newNode);
        else parent.setRight(newNode);

        return newNode;
    }

    private void fixInsert(TwoWayBinaryTreeNode z) {
        while (z != root && isRed(z.getParent())) {
            TwoWayBinaryTreeNode p = z.getParent();
            TwoWayBinaryTreeNode g = p.getParent();

            if (p == g.getLeft()) {
                TwoWayBinaryTreeNode u = (TwoWayBinaryTreeNode) g.getRight(); // uncle

                if (isRed(u)) {
                    // Case 1
                    p.setRed(BLACK);
                    u.setRed(BLACK);
                    g.setRed(RED);
                    z = g;
                } else {
                    if (z == p.getRight()) {
                        // Case 2
                        z = p;
                        rotateLeft(z);
                        p = z.getParent();
                        g = p.getParent();
                    }
                    // Case 3
                    p.setRed(BLACK);
                    g.setRed(RED);
                    rotateRight(g);
                }
            } else {
                // mirror
                TwoWayBinaryTreeNode u = (TwoWayBinaryTreeNode) g.getLeft(); // uncle

                if (isRed(u)) {
                    p.setRed(BLACK);
                    u.setRed(BLACK);
                    g.setRed(RED);
                    z = g;
                } else {
                    if (z == p.getLeft()) {
                        z = p;
                        rotateRight(z);
                        p = z.getParent();
                        g = p.getParent();
                    }
                    p.setRed(BLACK);
                    g.setRed(RED);
                    rotateLeft(g);
                }
            }
        }
    }

    @Override
    public boolean remove(char key) {
        TwoWayBinaryTreeNode node = findNode((TwoWayBinaryTreeNode) root, key);
        if (node == null) return false;

        deleteNode(node);
        size--;
        return true;
    }

    private void deleteNode(TwoWayBinaryTreeNode z) {
        TwoWayBinaryTreeNode y = z;
        boolean yOriginalRed = y.isRed();

        TwoWayBinaryTreeNode x;
        TwoWayBinaryTreeNode xParent;

        if (z.getLeft() == null) {
            x = (TwoWayBinaryTreeNode) z.getRight();
            xParent = z.getParent();
            transplant(z, x);
        } else if (z.getRight() == null) {
            x = (TwoWayBinaryTreeNode) z.getLeft();
            xParent = z.getParent();
            transplant(z, x);
        } else {
            y = findMin((TwoWayBinaryTreeNode) z.getRight());
            yOriginalRed = y.isRed();
            x = (TwoWayBinaryTreeNode) y.getRight();

            if (y.getParent() == z) {
                xParent = y;
            } else {
                transplant(y, x);
                y.setRight(z.getRight());
                ((TwoWayBinaryTreeNode) y.getRight()).setParent(y);
                xParent = y.getParent();
            }

            transplant(z, y);
            y.setLeft(z.getLeft());
            ((TwoWayBinaryTreeNode) y.getLeft()).setParent(y);
            y.setRed(z.isRed());
        }

        if (!yOriginalRed) {
            fixDelete(x, xParent);
        }

        root = getRoot(xParent);
        if (root != null) ((TwoWayBinaryTreeNode) root).setRed(BLACK);
    }

    private void fixDelete(TwoWayBinaryTreeNode x, TwoWayBinaryTreeNode parent) {
        while ((x != root) && (isBlack(x))) {

            if (x == parent.getLeft()) {
                TwoWayBinaryTreeNode w = (TwoWayBinaryTreeNode) parent.getRight();

                if (isRed(w)) {
                    w.setRed(BLACK);
                    parent.setRed(RED);
                    rotateLeft(parent);
                    w = (TwoWayBinaryTreeNode) parent.getRight();
                }

                if (isBlack((TwoWayBinaryTreeNode) w.getLeft()) &&
                    isBlack((TwoWayBinaryTreeNode) w.getRight())) {

                    w.setRed(RED);
                    x = parent;
                    parent = x.getParent();
                } else {
                    if (isBlack((TwoWayBinaryTreeNode) w.getRight())) {
                        ((TwoWayBinaryTreeNode) w.getLeft()).setRed(BLACK);
                        w.setRed(RED);
                        rotateRight(w);
                        w = (TwoWayBinaryTreeNode) parent.getRight();
                    }

                    w.setRed(parent.isRed());
                    parent.setRed(BLACK);
                    ((TwoWayBinaryTreeNode) w.getRight()).setRed(BLACK);
                    rotateLeft(parent);
                    x = (TwoWayBinaryTreeNode) root;
                    break;
                }

            } else {
                // mirror cases
                TwoWayBinaryTreeNode w = (TwoWayBinaryTreeNode) parent.getLeft();

                if (isRed(w)) {
                    w.setRed(BLACK);
                    parent.setRed(RED);
                    rotateRight(parent);
                    w = (TwoWayBinaryTreeNode) parent.getLeft();
                }

                if (isBlack((TwoWayBinaryTreeNode) w.getLeft()) &&
                    isBlack((TwoWayBinaryTreeNode) w.getRight())) {

                    w.setRed(RED);
                    x = parent;
                    parent = x.getParent();
                } else {
                    if (isBlack((TwoWayBinaryTreeNode) w.getLeft())) {
                        ((TwoWayBinaryTreeNode) w.getRight()).setRed(BLACK);
                        w.setRed(RED);
                        rotateLeft(w);
                        w = (TwoWayBinaryTreeNode) parent.getLeft();
                    }

                    w.setRed(parent.isRed());
                    parent.setRed(BLACK);
                    ((TwoWayBinaryTreeNode) w.getLeft()).setRed(BLACK);
                    rotateRight(parent);
                    x = (TwoWayBinaryTreeNode) root;
                    break;
                }
            }
        }

        if (x != null) x.setRed(BLACK);
    }

    private void transplant(TwoWayBinaryTreeNode u, TwoWayBinaryTreeNode v) {
        if (u.getParent() == null) {
            root = v;
        } else if (u == u.getParent().getLeft()) {
            u.getParent().setLeft(v);
        } else {
            u.getParent().setRight(v);
        }

        if (v != null) v.setParent(u.getParent());
    }

    private boolean isRed(TwoWayBinaryTreeNode n) {
        return n != null && n.isRed();
    }

    private boolean isBlack(TwoWayBinaryTreeNode n) {
        return n == null || !n.isRed();
    }

    private TwoWayBinaryTreeNode getRoot(TwoWayBinaryTreeNode n) {
        if (n == null) return null;
        while (n.getParent() != null) n = n.getParent();
        return n;
    }

    private TwoWayBinaryTreeNode findNode(TwoWayBinaryTreeNode node, char key) {
        if (node == null) return null;
        if (key == node.getKey()) return node;
        if (key < node.getKey()) return findNode((TwoWayBinaryTreeNode) node.getLeft(), key);
        return findNode((TwoWayBinaryTreeNode) node.getRight(), key);
    }

    private TwoWayBinaryTreeNode findMin(TwoWayBinaryTreeNode node) {
        while (node.getLeft() != null) {
            node = (TwoWayBinaryTreeNode) node.getLeft();
        }
        return node;
    }

    private void rotateLeft(TwoWayBinaryTreeNode x) {
        TwoWayBinaryTreeNode y = (TwoWayBinaryTreeNode) x.getRight();
        x.setRight(y.getLeft());
        if (y.getLeft() != null) ((TwoWayBinaryTreeNode) y.getLeft()).setParent(x);

        y.setParent(x.getParent());
        transplant(x, y);

        y.setLeft(x);
        x.setParent(y);
    }

    private void rotateRight(TwoWayBinaryTreeNode x) {
        TwoWayBinaryTreeNode y = (TwoWayBinaryTreeNode) x.getLeft();
        x.setLeft(y.getRight());
        if (y.getRight() != null) ((TwoWayBinaryTreeNode) y.getRight()).setParent(x);

        y.setParent(x.getParent());
        transplant(x, y);

        y.setRight(x);
        x.setParent(y);
    }
}
