package app.binarysearchtree;

import amerika.binarytrees.onewaybinarytree.BinaryTree;
import amerika.binarytrees.twowaybinarytree.TwoWayBinaryTree;

import java.util.Scanner;

public class BinaryTreeCLI {

    private static Scanner scanner = new Scanner(System.in);
    private static BinaryTree currentTree = null;
    private static String currentTreeType = null;

    public static void main(String[] args) {
        System.out.println("===================================");
        System.out.println("  Binary Tree Interactive CLI");
        System.out.println("===================================");

        while (true) {
            if (currentTree == null) {
                selectTreeType();
            } else {
                showMenu();
                int choice = getIntInput();

                if (!handleMenuChoice(choice)) {
                    break;
                }
            }
        }

        System.out.println("\nBye.");
        scanner.close();
    }

    private static void selectTreeType() {
        System.out.println("\nSelect Binary Tree Type:");
        System.out.println("1. One-Way Binary Tree");
        System.out.println("2. Two-Way Binary Tree (with parent references)");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                currentTree = new BinaryTree();
                currentTreeType = "One-Way Binary Tree";
                System.out.println("\n" + currentTreeType + " created successfully!");
                break;
            case 2:
                currentTree = new TwoWayBinaryTree();
                currentTreeType = "Two-Way Binary Tree";
                System.out.println("\n" + currentTreeType + " created successfully!");
                break;
            case 0:
                System.out.println("\nExiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

    private static void showMenu() {
        System.out.println("\n===================================");
        System.out.println("  Current Tree: " + currentTreeType);
        System.out.println("  Size: " + currentTree.getSize());
        System.out.println("===================================");
        System.out.println("1.  Add element");
        System.out.println("2.  Remove element");
        System.out.println("3.  Display Pre-Order traversal");
        System.out.println("4.  Display In-Order traversal");
        System.out.println("5.  Display Post-Order traversal");
        System.out.println("6.  Display all traversals");
        System.out.println("7.  Add multiple elements");
        System.out.println("8.  Remove multiple elements");
        System.out.println("9.  Clear tree (switch tree type)");
        System.out.println("10. Show tree information");
        System.out.println("0.  Exit");
        System.out.print("Enter your choice: ");
    }

    private static boolean handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                addElement();
                break;
            case 2:
                removeElement();
                break;
            case 3:
                displayPreOrder();
                break;
            case 4:
                displayInOrder();
                break;
            case 5:
                displayPostOrder();
                break;
            case 6:
                displayAllTraversals();
                break;
            case 7:
                addMultipleElements();
                break;
            case 8:
                removeMultipleElements();
                break;
            case 9:
                clearTree();
                break;
            case 10:
                showTreeInfo();
                break;
            case 0:
                return false;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
        return true;
    }

    private static void addElement() {
        System.out.print("Enter a character to add: ");
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("Error: Input cannot be empty!");
            return;
        }

        char key = input.charAt(0);
        boolean success = currentTree.add(key);

        if (success) {
            System.out.println("Successfully added '" + key + "' to the tree.");
        } else {
            System.out.println("Failed to add '" + key + "' (duplicate value).");
        }
    }

    private static void removeElement() {
        if (currentTree.getSize() == 0) {
            System.out.println("Tree is empty! Nothing to remove.");
            return;
        }

        System.out.print("Enter a character to remove: ");
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("Error: Input cannot be empty!");
            return;
        }

        char key = input.charAt(0);
        boolean success = currentTree.remove(key);

        if (success) {
            System.out.println("Successfully removed '" + key + "' from the tree.");
        } else {
            System.out.println("Failed to remove '" + key + "' (not found in tree).");
        }
    }

    private static void displayPreOrder() {
        if (currentTree.getSize() == 0) {
            System.out.println("Tree is empty!");
            return;
        }

        System.out.print("Pre-Order Traversal: ");
        currentTree.preOrder();
    }

    private static void displayInOrder() {
        if (currentTree.getSize() == 0) {
            System.out.println("Tree is empty!");
            return;
        }

        System.out.print("In-Order Traversal:  ");
        currentTree.inOrder();
    }

    private static void displayPostOrder() {
        if (currentTree.getSize() == 0) {
            System.out.println("Tree is empty!");
            return;
        }

        System.out.print("Post-Order Traversal: ");
        currentTree.postOrder();
    }

    private static void displayAllTraversals() {
        if (currentTree.getSize() == 0) {
            System.out.println("Tree is empty!");
            return;
        }

        System.out.println("\n--- All Traversals ---");
        System.out.print("Pre-Order:  ");
        currentTree.preOrder();
        System.out.print("In-Order:   ");
        currentTree.inOrder();
        System.out.print("Post-Order: ");
        currentTree.postOrder();
    }

    private static void addMultipleElements() {
        System.out.print("Enter characters to add (e.g., 'ABCDEF' or 'A B C D E F'): ");
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("Error: Input cannot be empty!");
            return;
        }

        int addedCount = 0;
        int duplicateCount = 0;

        for (char c : input.toCharArray()) {
            if (c == ' ') continue;

            if (currentTree.add(c)) {
                addedCount++;
            } else {
                duplicateCount++;
            }
        }

        System.out.println("Added " + addedCount + " element(s).");
        if (duplicateCount > 0) {
            System.out.println("Skipped " + duplicateCount + " duplicate(s).");
        }
    }

    private static void removeMultipleElements() {
        if (currentTree.getSize() == 0) {
            System.out.println("Tree is empty! Nothing to remove.");
            return;
        }

        System.out.print("Enter characters to remove (e.g., 'ABC' or 'A B C'): ");
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("Error: Input cannot be empty!");
            return;
        }

        int removedCount = 0;
        int notFoundCount = 0;

        for (char c : input.toCharArray()) {
            if (c == ' ') continue;

            if (currentTree.remove(c)) {
                removedCount++;
            } else {
                notFoundCount++;
            }
        }

        System.out.println("Removed " + removedCount + " element(s).");
        if (notFoundCount > 0) {
            System.out.println("Could not find " + notFoundCount + " element(s).");
        }
    }

    private static void clearTree() {
        System.out.print("Are you sure you want to clear the tree and select a new type? (y/n): ");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("y") || confirm.equals("yes")) {
            currentTree = null;
            currentTreeType = null;
            System.out.println("Tree cleared!");
        } else {
            System.out.println("Operation cancelled.");
        }
    }

    private static void showTreeInfo() {
        System.out.println("\n--- Tree Information ---");
        System.out.println("Tree Type: " + currentTreeType);
        System.out.println("Size: " + currentTree.getSize());
        System.out.println("Empty: " + (currentTree.getSize() == 0 ? "Yes" : "No"));

        if (currentTree.getSize() > 0) {
            System.out.println("\nCurrent elements (In-Order): ");
            currentTree.inOrder();
        }
    }

    private static int getIntInput() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a number: ");
            }
        }
    }
}
