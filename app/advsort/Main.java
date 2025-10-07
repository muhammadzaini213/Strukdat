package app.advsort;

import amerika.sorting.advancesorting.QuickSort;
import amerika.sorting.advancesorting.ShellSort;
import amerika.sorting.advancesorting.MergeSort;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Main app = new Main();
        app.runCLI();
    }

    public void runCLI() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===========================================");
        System.out.println("  SORTING ALGORITHM PERFORMANCE COMPARISON");
        System.out.println("===========================================");
        System.out.println();
        
        System.out.print("Masukkan jumlah data yang ingin di-generate: ");
        int size = scanner.nextInt();
        
        System.out.print("Masukkan nilai maksimal untuk random data (contoh: 1000): ");
        int maxValue = scanner.nextInt();
        
        System.out.println();
        System.out.println("Generating " + size + " random data...");
        int[] originalData = generateRandomData(size, maxValue);
        System.out.println("Data berhasil di-generate!");
        
        if (size <= 20) {
            System.out.println("Data original: " + Arrays.toString(originalData));
        } else {
            System.out.println("Sample 10 data pertama: " + Arrays.toString(Arrays.copyOf(originalData, 10)));
        }
        
        System.out.println();
        System.out.println("===========================================");
        System.out.println("  MEMULAI PERBANDINGAN SORTING...");
        System.out.println("===========================================");
        System.out.println();
        
        int[] arrQuick = originalData.clone();
        long startQuick = System.currentTimeMillis();
        QuickSort.quickSort(arrQuick, 0, arrQuick.length - 1);
        long endQuick = System.currentTimeMillis();
        long durationQuick = endQuick - startQuick;
        
        System.out.println("1. QuickSort");
        System.out.println("   Waktu eksekusi: " + durationQuick + " ms");
        if (size <= 20) {
            System.out.println("   Hasil: " + Arrays.toString(arrQuick));
        }
        System.out.println();
        
        int[] arrMerge = originalData.clone();
        long startMerge = System.currentTimeMillis();
        MergeSort.mergeSort(arrMerge, 0, arrMerge.length - 1);
        long endMerge = System.currentTimeMillis();
        long durationMerge = endMerge - startMerge;
        
        System.out.println("2. MergeSort");
        System.out.println("   Waktu eksekusi: " + durationMerge + " ms");
        if (size <= 20) {
            System.out.println("   Hasil: " + Arrays.toString(arrMerge));
        }
        System.out.println();
        
        int[] arrShell = originalData.clone();
        long startShell = System.currentTimeMillis();
        ShellSort.shellSort(arrShell);
        long endShell = System.currentTimeMillis();
        long durationShell = endShell - startShell;
        
        System.out.println("3. ShellSort");
        System.out.println("   Waktu eksekusi: " + durationShell + " ms");
        if (size <= 20) {
            System.out.println("   Hasil: " + Arrays.toString(arrShell));
        }
        System.out.println();
        
        boolean allCorrect = Arrays.equals(arrQuick, arrMerge) && Arrays.equals(arrMerge, arrShell);
        System.out.println("Verifikasi: " + (allCorrect ? "Semua algoritma menghasilkan hasil yang sama" : "Ada perbedaan hasil!"));
        System.out.println();
        
        System.out.println("===========================================");
        System.out.println("  RANKING KECEPATAN");
        System.out.println("===========================================");
        
        SortingResult[] results = {
            new SortingResult("QuickSort", durationQuick),
            new SortingResult("MergeSort", durationMerge),
            new SortingResult("ShellSort", durationShell)
        };
        
        Arrays.sort(results);
        
        for (int i = 0; i < results.length; i++) {
            System.out.println((i + 1) + ". " + results[i].name + " - " + results[i].duration + " ms");
        }
        
        System.out.println();
        System.out.println("Algoritma tercepat: " + results[0].name);
        System.out.println("===========================================");
        
        scanner.close();
    }
    
    private int[] generateRandomData(int size, int maxValue) {
        Random random = new Random();
        int[] data = new int[size];
        
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(maxValue + 1);
        }
        
        return data;
    }
    
    private static class SortingResult implements Comparable<SortingResult> {
        String name;
        long duration;
        
        SortingResult(String name, long duration) {
            this.name = name;
            this.duration = duration;
        }
        
        @Override
        public int compareTo(SortingResult other) {
            return Long.compare(this.duration, other.duration);
        }
    }
}
