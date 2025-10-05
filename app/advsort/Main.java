package app.advsort;

import amerika.sorting.advancesorting.QuickSort;
import amerika.sorting.advancesorting.ShellSort;
import java.util.Arrays;

public class Main {
    
    public static void main(String args[]) {
        Main app = new Main();
        app.sort();
    }
    
    public void sort() {
        int[] arr = {2,6,8,48,2,5,4,9,7,0,1,5};
        // QuickSort.quickSort(arr, 0, arr.length - 1);
        ShellSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
