package app.binarysearchtree;

import java.util.Random;

import amerika.binarytrees.onewaybinarytree.BinaryTree;
import amerika.binarytrees.twowaybinarytree.TwoWayBinaryTree;

public class Main {
    
    public static void main(String[] args) {
        Main app = new Main();
        app.runTest();
        app.runTest2();
    }

    public void runTest() {
        System.out.println("\nONE WAY BST\n");
        BinaryTree tree = new BinaryTree();
        Random random = new Random();

        while (tree.getSize() < 11) {
            tree.add((char) ('A' + random.nextInt(26)));
        }

        System.out.println("Pre-Order");
        tree.preOrder();

        System.out.println("In-Order");
        tree.inOrder();

        System.out.println("Post-Order");
        tree.postOrder();
    }

    public void runTest2() {
        System.out.println("\nTWO WAY BST\n");
        TwoWayBinaryTree tree = new TwoWayBinaryTree();
        Random random = new Random();
        while (tree.getSize() < 11) {
            tree.add((char) ('A' + random.nextInt(26)));
        }

        System.out.println("Pre-Order");
        tree.preOrder();

        System.out.println("In-Order");
        tree.inOrder();

        System.out.println("Post-Order");
        tree.postOrder();
    }
}
