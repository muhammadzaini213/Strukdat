package app.binarysearchtree;

import amerika.binarytrees.onewaybinarytree.BinaryTree;
import amerika.binarytrees.twowaybinarytree.TwoWayBinaryTree;

public class RedBlackTreeCLI
 {

    private static final int TEST_COUNT = 10000;

    public static void main(String[] args) {

        char[] dataset = generateAZ(); // A-Z
        System.out.println("=====================================");
        System.out.println(" BENCHMARK: Binary Tree vs Red Black Tree");
        System.out.println(" Dataset: A-Z (" + dataset.length + " elemen)");
        System.out.println(" Loop Test: " + TEST_COUNT + "x");
        System.out.println("=====================================\n");

        benchmark("Binary Tree Biasa", new BinaryTree(), dataset);
        benchmark("Red-Black Tree", new TwoWayBinaryTree(), dataset);
    }

    private static char[] generateAZ() {
        char[] arr = new char[100];
        for (int i = 0; i < 100; i++) arr[i] = (char) ('A' + i);
        return arr;
    }

    private static void benchmark(String name, BinaryTree tree, char[] dataset) {

        long insertTime = 0;
        long searchTime = 0;
        long deleteTime = 0;

        for (int t = 0; t < TEST_COUNT; t++) {

            // INSERT BENCHMARK
            long startInsert = System.nanoTime();
            for (char c : dataset) tree.add(c);
            insertTime += (System.nanoTime() - startInsert);

            // SEARCH BENCHMARK
            long startSearch = System.nanoTime();
            for (char c : dataset) tree.find(c);
            searchTime += (System.nanoTime() - startSearch);

            // DELETE BENCHMARK
            long startDelete = System.nanoTime();
            for (char c : dataset) tree.remove(c);
            deleteTime += (System.nanoTime() - startDelete);
        }

        System.out.println("=== " + name + " ===");
        System.out.println("Insert Time : " + insertTime / 1_000_000.0 + " ms");
        System.out.println("Search Time : " + searchTime / 1_000_000.0 + " ms");
        System.out.println("Delete Time : " + deleteTime / 1_000_000.0 + " ms");
        System.out.println();
    }
}
