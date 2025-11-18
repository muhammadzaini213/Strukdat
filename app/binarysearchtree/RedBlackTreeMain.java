
package app.binarysearchtree;

import amerika.binarytrees.onewaybinarytree.BinaryTree;
import amerika.binarytrees.twowaybinarytree.TwoWayBinaryTree;
import app.utils.Inputs;

import java.util.Random;
import java.util.Scanner;

public class RedBlackTreeMain {

    private static BinaryTree tree;
    private static String treeType;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Inputs inputs = new Inputs();

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║      RED-BLACK TREE & BINARY SEARCH TREE       ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println();

        chooseTreeType();
        mainMenu();
    }

    private static void chooseTreeType() {
        while (true) {
            System.out.println("\n=== PILIH JENIS BINARY TREE ===");
            System.out.println("1. Binary Search Tree (BST Biasa)");
            System.out.println("2. Red-Black Tree");
            System.out.print("Masukkan pilihan (1-2): ");

            int choice = inputs.optionInput();

            if (choice == 1) {
                tree = new BinaryTree();
                treeType = "Binary Search Tree";
                System.out.println("✓ Binary Search Tree dipilih.");
                break;
            } else if (choice == 2) {
                tree = new TwoWayBinaryTree();
                treeType = "Red-Black Tree";
                System.out.println("✓ Red-Black Tree dipilih.");
                break;
            } else {
                System.out.println("✗ Pilihan tidak valid! Silakan pilih 1 atau 2.");
            }
        }
    }

    private static void mainMenu() {
        while (true) {
            System.out.println("\n╔════════════════════════════════════════════════╗");
            System.out.println("║   MENU UTAMA - " + treeType);
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.println("1. Generate Karakter Acak");
            System.out.println("2. Tambah Karakter");
            System.out.println("3. Hapus Karakter");
            System.out.println("4. Cari Karakter");
            System.out.println("5. Tampilkan Tree (Traversal)");
            System.out.println("6. Ganti Jenis Tree");
            System.out.println("0. Keluar");
            System.out.print("Pilihan (0-6): ");

            int choice = inputs.optionInput();

            switch (choice) {
                case 1:
                    generateRandomCharacters();
                    break;
                case 2:
                    addCharacter();
                    break;
                case 3:
                    removeCharacter();
                    break;
                case 4:
                    findCharacter();
                    break;
                case 5:
                    traversalMenu();
                    break;
                case 6:
                    if (inputs.confirmation()) {
                        chooseTreeType();
                    }
                    break;
                case 0:
                    System.out.println("\nBye.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("✗ Pilihan tidak valid!");
            }
        }
    }

    private static void generateRandomCharacters() {
        System.out.println("\n=== GENERATE KARAKTER ACAK ===");

        // Pilih jenis karakter
        boolean includeUppercase;
        boolean includeLowercase;
        boolean includeNumbers;

        System.out.println("Pilih jenis karakter yang ingin di-generate:");
        System.out.print("Huruf BESAR (A-Z)? (Y/n): ");
        String input1 = scanner.nextLine().trim().toLowerCase();
        includeUppercase = input1.isEmpty() || input1.charAt(0) == 'y';

        System.out.print("Huruf kecil (a-z)? (Y/n): ");
        String input2 = scanner.nextLine().trim().toLowerCase();
        includeLowercase = input2.isEmpty() || input2.charAt(0) == 'y';

        System.out.print("Angka (0-9)? (Y/n): ");
        String input3 = scanner.nextLine().trim().toLowerCase();
        includeNumbers = input3.isEmpty() || input3.charAt(0) == 'y';

        if (!includeUppercase && !includeLowercase && !includeNumbers) {
            System.out.println("✗ Tidak ada jenis karakter yang dipilih!");
            return;
        }

        // Input panjang
        System.out.print("Masukkan jumlah karakter yang ingin di-generate: ");
        int length = inputs.optionInput();

        if (length <= 0) {
            System.out.println("✗ Jumlah karakter harus lebih dari 0!");
            return;
        }

        // Generate karakter secara acak
        String characterPool = buildCharacterPool(includeUppercase, includeLowercase, includeNumbers);
        Random random = new Random();
        char[] randomChars = new char[length];
        
        for (int i = 0; i < length; i++) {
            randomChars[i] = characterPool.charAt(random.nextInt(characterPool.length()));
        }

        // Konfirmasi
        System.out.println("\nKarakter yang akan ditambahkan:");
        if (randomChars.length > 20) {
            System.out.println(new String(randomChars, 0, 20) + "... (menampilkan 20 dari " + randomChars.length + " karakter)");
        } else {
            System.out.println(new String(randomChars));
        }
        System.out.print("Lanjutkan menambahkan ke tree? (Y/n): ");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (!confirm.isEmpty() && confirm.charAt(0) != 'y') {
            System.out.println("✗ Dibatalkan.");
            return;
        }

        // Tambahkan ke tree
        long startTime = System.nanoTime();
        for (char c : randomChars) {
            tree.add(c);
        }
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0;

        System.out.println("✓ Berhasil menambahkan " + randomChars.length + " karakter ke tree.");
        System.out.printf("⏱ Waktu eksekusi: %.4f ms\n", duration);
    }

    private static String buildCharacterPool(boolean uppercase, boolean lowercase, boolean numbers) {
        StringBuilder pool = new StringBuilder();
        if (uppercase) pool.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        if (lowercase) pool.append("abcdefghijklmnopqrstuvwxyz");
        if (numbers) pool.append("0123456789");
        return pool.toString();
    }

    private static void addCharacter() {
        System.out.println("\n=== TAMBAH KARAKTER ===");
        System.out.print("Masukkan karakter yang ingin ditambahkan: ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("✗ Input tidak boleh kosong!");
            return;
        }

        long startTime = System.nanoTime();
        for (char c : input.toCharArray()) {
            tree.add(c);
        }
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0;

        System.out.println("✓ Berhasil menambahkan " + input.length() + " karakter.");
        System.out.printf("⏱ Waktu eksekusi: %.4f ms\n", duration);
    }

    private static void removeCharacter() {
        System.out.println("\n=== HAPUS KARAKTER ===");
        System.out.print("Masukkan karakter yang ingin dihapus: ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("✗ Input tidak boleh kosong!");
            return;
        }

        long startTime = System.nanoTime();
        int removedCount = 0;
        for (char c : input.toCharArray()) {
            if (tree.remove(c)) {
                removedCount++;
            }
        }
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0;

        System.out.println("✓ Berhasil menghapus " + removedCount + " dari " + input.length() + " karakter.");
        System.out.printf("⏱ Waktu eksekusi: %.4f ms\n", duration);
    }

    private static void findCharacter() {
        System.out.println("\n=== CARI KARAKTER ===");
        System.out.print("Masukkan karakter yang ingin dicari: ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("✗ Input tidak boleh kosong!");
            return;
        }

        System.out.println("\nHasil pencarian:");
        long totalTime = 0;

        for (char c : input.toCharArray()) {
            long startTime = System.nanoTime();
            boolean found = tree.find(c);
            long endTime = System.nanoTime();
            double duration = (endTime - startTime) / 1_000_000.0;
            totalTime += (endTime - startTime);

            System.out.printf("  '%c': %s (%.4f ms)\n", c, found ? "✓ Ditemukan" : "✗ Tidak ditemukan", duration);
        }

        double totalDuration = totalTime / 1_000_000.0;
        System.out.printf("⏱ Total waktu pencarian: %.4f ms\n", totalDuration);
    }

    private static void traversalMenu() {
        System.out.println("\n=== PILIH METODE TRAVERSAL ===");
        System.out.println("1. Inorder");
        System.out.println("2. Preorder");
        System.out.println("3. Postorder");
        System.out.println("4. Semua (Inorder, Preorder, Postorder)");
        System.out.print("Pilihan (1-4): ");

        int choice = inputs.optionInput();

        switch (choice) {
            case 1:
                performTraversal("Inorder", () -> tree.inOrder());
                break;
            case 2:
                performTraversal("Preorder", () -> tree.preOrder());
                break;
            case 3:
                performTraversal("Postorder", () -> tree.postOrder());
                break;
            case 4:
                performAllTraversals();
                break;
            default:
                System.out.println("✗ Pilihan tidak valid!");
        }
    }

    private static void performTraversal(String name, Runnable traversalMethod) {
        System.out.println("\n=== TRAVERSAL: " + name + " ===");

        long startTime = System.nanoTime();
        traversalMethod.run();
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0;

        System.out.printf("\n⏱ Waktu eksekusi %s: %.4f ms\n", name, duration);
    }

    private static void performAllTraversals() {
        System.out.println("\n=== SEMUA TRAVERSAL ===");

        System.out.println("\n--- Inorder ---");
        long startTime1 = System.nanoTime();
        tree.inOrder();
        long endTime1 = System.nanoTime();
        double duration1 = (endTime1 - startTime1) / 1_000_000.0;
        System.out.printf("\n⏱ Waktu eksekusi Inorder: %.4f ms\n", duration1);

        System.out.println("\n--- Preorder ---");
        long startTime2 = System.nanoTime();
        tree.preOrder();
        long endTime2 = System.nanoTime();
        double duration2 = (endTime2 - startTime2) / 1_000_000.0;
        System.out.printf("\n⏱ Waktu eksekusi Preorder: %.4f ms\n", duration2);

        System.out.println("\n--- Postorder ---");
        long startTime3 = System.nanoTime();
        tree.postOrder();
        long endTime3 = System.nanoTime();
        double duration3 = (endTime3 - startTime3) / 1_000_000.0;
        System.out.printf("\n⏱ Waktu eksekusi Postorder: %.4f ms\n", duration3);

        double totalDuration = duration1 + duration2 + duration3;
        System.out.printf("\n⏱ Total waktu semua traversal: %.4f ms\n", totalDuration);
    }
}
