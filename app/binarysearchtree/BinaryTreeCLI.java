package app.binarysearchtree;

import amerika.binarytrees.onewaybinarytree.BinaryTree;
import amerika.binarytrees.twowaybinarytree.TwoWayBinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BinaryTreeCLI {
    private static Scanner scanner = new Scanner(System.in);
    private static BinaryTree currentTree = null;
    private static String currentTreeType = null;
    private static List<Character> insertionHistory = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("===================================");
        System.out.println(" CLI Binary Tree");
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
        System.out.println("\nSampai jumpa.");
        scanner.close();
    }

    private static void selectTreeType() {
        System.out.println("\nPilih Jenis Binary Tree:");
        System.out.println("1. Binary Tree Satu Arah");
        System.out.println("2. Binary Tree Dua Arah (dengan referensi parent)");
        System.out.println("0. Keluar");
        System.out.print("Masukkan pilihan Anda: ");
        int choice = getIntInput();
        switch (choice) {
            case 1:
                currentTree = new BinaryTree();
                currentTreeType = "Binary Tree Satu Arah";
                System.out.println("\n" + currentTreeType + " berhasil dibuat!");
                break;
            case 2:
                currentTree = new TwoWayBinaryTree();
                currentTreeType = "Binary Tree Dua Arah";
                System.out.println("\n" + currentTreeType + " berhasil dibuat!");
                break;
            case 0:
                System.out.println("\nKeluar...");
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan tidak valid! Silakan coba lagi.");
        }
    }

    private static void showMenu() {
        System.out.println("\n===================================");
        System.out.println(" Tree Saat Ini: " + currentTreeType);
        System.out.println(" Ukuran: " + currentTree.getSize());
        System.out.println("===================================");
        // System.out.println("1. Tambah elemen");
        // System.out.println("2. Hapus elemen");
        // System.out.println("3. Tampilkan traversal Pre-Order");
        // System.out.println("4. Tampilkan traversal In-Order");
        // System.out.println("5. Tampilkan traversal Post-Order");
        System.out.println("1. Tampilkan semua traversal");
        System.out.println("2. Tambah beberapa elemen");
        System.out.println("3. Tambah elemen acak");
        // System.out.println("9. Hapus beberapa elemen");
        // System.out.println("4. Bersihkan Tree (ganti jenis Tree)");
        System.out.println("4. Tampilkan informasi Tree");
        // System.out.println("0. Keluar");

        System.out.print("Masukkan pilihan Anda: ");
    }

        private static boolean handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                displayAllTraversals();
                break;
            case 2:
                addMultipleElements();
                break;
            case 3:
                addRandomElements();
                break;
            case 4:
                showTreeInfo();
                break;
            default:
                System.out.println("Pilihan tidak valid! Silakan coba lagi.");
        }
        return true;
    }

    // private static boolean handleMenuChoice(int choice) {
    //     switch (choice) {
    //         case 1:
    //             addElement();
    //             break;
    //         case 2:
    //             removeElement();
    //             break;
    //         case 3:
    //             displayPreOrder();
    //             break;
    //         case 4:
    //             displayInOrder();
    //             break;
    //         case 5:
    //             displayPostOrder();
    //             break;
    //         case 6:
    //             displayAllTraversals();
    //             break;
    //         case 7:
    //             addMultipleElements();
    //             break;
    //         case 8:
    //             addRandomElements();
    //             break;
    //         case 9:
    //             removeMultipleElements();
    //             break;
    //         case 10:
    //             clearTree();
    //             break;
    //         case 11:
    //             showTreeInfo();
    //             break;
    //         case 0:
    //             return false;
    //         default:
    //             System.out.println("Pilihan tidak valid! Silakan coba lagi.");
    //     }
    //     return true;
    // }

    private static void addElement() {
        System.out.print("Masukkan karakter untuk ditambahkan: ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            System.out.println("Kesalahan: Input tidak boleh kosong!");
            return;
        }
        char key = input.charAt(0);
        boolean success = currentTree.add(key);
        if (success) {
            System.out.println("Berhasil menambahkan '" + key + "' ke Tree.");
        } else {
            System.out.println("Gagal menambahkan '" + key + "' (nilai duplikat).");
        }

        if (success) {
            System.out.println("Berhasil menambahkan '" + key + "' ke Tree.");
            insertionHistory.add(key);
        }

    }

    private static void removeElement() {
        if (currentTree.getSize() == 0) {
            System.out.println("Tree kosong! Tidak ada yang bisa dihapus.");
            return;
        }
        System.out.print("Masukkan karakter untuk dihapus: ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            System.out.println("Kesalahan: Input tidak boleh kosong!");
            return;
        }
        char key = input.charAt(0);
        boolean success = currentTree.remove(key);
        if (success) {
            System.out.println("Berhasil menghapus '" + key + "' dari Tree.");
            insertionHistory.remove(Character.valueOf(key));
        } else {
            System.out.println("Gagal menghapus '" + key + "' (tidak ditemukan di Tree).");
        }
    }

    private static void displayPreOrder() {
        if (currentTree.getSize() == 0) {
            System.out.println("Tree kosong!");
            return;
        }
        System.out.print("Traversal Pre-Order: ");
        currentTree.preOrder();
    }

    private static void displayInOrder() {
        if (currentTree.getSize() == 0) {
            System.out.println("Tree kosong!");
            return;
        }
        System.out.print("Traversal In-Order: ");
        currentTree.inOrder();
    }

    private static void displayPostOrder() {
        if (currentTree.getSize() == 0) {
            System.out.println("Tree kosong!");
            return;
        }
        System.out.print("Traversal Post-Order: ");
        currentTree.postOrder();
    }

    private static void displayAllTraversals() {
        if (currentTree.getSize() == 0) {
            System.out.println("Tree kosong!");
            return;
        }
        System.out.println("\n--- Semua Traversal ---");
        System.out.print("Pre-Order: ");
        currentTree.preOrder();
        System.out.print("In-Order: ");
        currentTree.inOrder();
        System.out.print("Post-Order: ");
        currentTree.postOrder();
    }

    private static void addMultipleElements() {
        System.out.print("Masukkan karakter untuk ditambahkan (contoh: 'ABCDEF' atau 'A B C D E F'): ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            System.out.println("Kesalahan: Input tidak boleh kosong!");
            return;
        }
        int addedCount = 0;
        int duplicateCount = 0;
        for (char c : input.toCharArray()) {
            if (c == ' ')
                continue;
            if (currentTree.add(c)) {
                addedCount++;
                insertionHistory.add(c);
            } else {
                duplicateCount++;
            }
        }
        System.out.println("Menambahkan " + addedCount + " elemen.");
        if (duplicateCount > 0) {
            System.out.println("Melewatkan " + duplicateCount + " duplikat.");
        }
    }

    private static void addRandomElements() {
        System.out.print("Masukkan jumlah elemen acak yang ingin ditambahkan: ");
        int count = getIntInput();
        if (count <= 0) {
            System.out.println("Jumlah harus lebih besar dari 0!");
            return;
        }

        System.out.print("Gunakan huruf (A–Z) atau angka (0–9)? (h/a): ");
        String type = scanner.nextLine().trim().toLowerCase();

        Random random = new Random(System.nanoTime()); // pakai seed unik setiap kali
        int totalPossible = type.equals("a") ? 10 : 26;

        if (count > totalPossible) {
            System.out.println("Jumlah elemen terlalu banyak! Maksimal " + totalPossible + ".");
            return;
        }

        List<Character> possibleChars = new ArrayList<>();
        if (type.equals("a")) {
            for (char c = '0'; c <= '9'; c++)
                possibleChars.add(c);
        } else {
            for (char c = 'A'; c <= 'Z'; c++)
                possibleChars.add(c);
        }

        Collections.shuffle(possibleChars, random);

        int addedCount = 0;
        for (char c : possibleChars) {
            if (addedCount >= count)
                break;
            if (currentTree.add(c)) {
                System.out.println("Menambahkan: " + c);
                insertionHistory.add(c);
                addedCount++;
            }
        }

        System.out.println("\nBerhasil menambahkan " + addedCount + " elemen acak unik.");
        if (addedCount < count) {
            System.out.println("Beberapa elemen dilewati karena sudah ada di tree.");
        }
    }

    private static void removeMultipleElements() {
        if (currentTree.getSize() == 0) {
            System.out.println("Tree kosong! Tidak ada yang bisa dihapus.");
            return;
        }
        System.out.print("Masukkan karakter untuk dihapus (contoh: 'ABC' atau 'A B C'): ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            System.out.println("Kesalahan: Input tidak boleh kosong!");
            return;
        }
        int removedCount = 0;
        int notFoundCount = 0;
        for (char c : input.toCharArray()) {
            if (c == ' ')
                continue;
            if (currentTree.remove(c)) {
                insertionHistory.remove(Character.valueOf(c));
                removedCount++;
            } else {
                notFoundCount++;
            }
        }
        System.out.println("Menghapus " + removedCount + " elemen.");
        if (notFoundCount > 0) {
            System.out.println("Tidak menemukan " + notFoundCount + " elemen.");
        }
    }

    private static void clearTree() {
        System.out.print("Apakah Anda yakin ingin membersihkan Tree dan memilih jenis Tree baru? (y/n): ");
        String confirm = scanner.nextLine().trim().toLowerCase();
        if (confirm.equals("y") || confirm.equals("yes")) {
            currentTree = null;
            currentTreeType = null;
            System.out.println("Tree dibersihkan!");
            insertionHistory.clear();
        } else {
            System.out.println("Operasi dibatalkan.");
        }
    }

    private static void showTreeInfo() {
        System.out.println("\n--- Informasi Tree ---");
        System.out.println("Jenis Tree: " + currentTreeType);
        System.out.println("Ukuran: " + currentTree.getSize());
        System.out.println("Kosong: " + (currentTree.getSize() == 0 ? "Ya" : "Tidak"));
        if (currentTree.getSize() > 0) {
            System.out.println("\nElemen saat ini (berdasarkan urutan penambahan): ");
            for (char c : insertionHistory) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    private static int getIntInput() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Input tidak valid! Silakan masukkan angka: ");
            }
        }
    }
}