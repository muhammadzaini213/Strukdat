package amerika.sorting.advancesorting;

public class QuickSort {
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j <= right - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            // partition index
            int pi = partition(arr, left, right);

            // recursive call
            // sort left partition
            quickSort(arr, left, pi - 1);
            // sort right partition
            quickSort(arr, pi + 1, right);
        }
    }
}