package app.sort;

import app.utils.Inputs;
import app.sort.ListOption;
import java.util.Scanner;
import java.util.Arrays;
import amerika.sorting.simplesorting.SimpleSorting;
import amerika.linkedlists.onewaylinkedlist.LinkedList;
import amerika.linkedlists.onewaylinkedlist.LinkedListInt;
import amerika.linkedlists.onewaylinkedlist.LinkedListFloat;
import amerika.linkedlists.onewaylinkedlist.LinkedListChar;
import amerika.linkedlists.onewaylinkedlist.LinkedListBool;

public class SortOption {

	SimpleSorting sort = new SimpleSorting();

	public void sortAll(LinkedList linkedList, boolean asc, boolean showResult) {
		LinkedList tempList1 = linkedList;
		LinkedList tempList2 = linkedList;
		LinkedList tempList3 = linkedList;
		bubbleSort(tempList1, asc, showResult);

		System.out.println("=" .repeat(10));

		insertionSort(tempList2, asc, showResult);

		System.out.println("=" .repeat(10));

		insertionSort(tempList3, asc, showResult);

		System.out.println("=".repeat(10));
	}


	public void bubbleSort(LinkedList linkedList, boolean asc, boolean showResult) {
		LinkedList tempList1 = linkedList;
		long start1 = System.currentTimeMillis();
		sort.bubbleSort(tempList1, asc);
		long end1 = System.currentTimeMillis();
		System.out.println("Berhasil dalam " + (end1 - start1) + "ms");
		if (showResult) ListOption.getAll(tempList1);
	}


	public void insertionSort(LinkedList linkedList, boolean asc, boolean showResult) {
		LinkedList tempList2 = linkedList;
		long start2 = System.currentTimeMillis();
		sort.insertionSort(tempList2, asc);
		long end2 = System.currentTimeMillis();
		System.out.println("Berhasil dalam " + (end2 - start2) + "ms");
		if (showResult) ListOption.getAll(tempList2);
	}

	public void selectionSort(LinkedList linkedList, boolean asc, boolean showResult) {
		LinkedList tempList3 = linkedList;
		long start3 = System.currentTimeMillis();
		sort.insertionSort(tempList3, asc);
		long end3 = System.currentTimeMillis();
		System.out.println("Berhasil dalam " + (end3 - start3) + "ms");
		if (showResult) ListOption.getAll(tempList3);
	}

	public static void printArray(Object arr) {
		if (arr instanceof int[]) {
			System.out.println(Arrays.toString((int[]) arr));
		} else if (arr instanceof float[]) {
			System.out.println(Arrays.toString((float[]) arr));
		} else if (arr instanceof char[]) {
			System.out.println(Arrays.toString((char[]) arr));
		} else if (arr instanceof boolean[]) {
			System.out.println(Arrays.toString((boolean[]) arr));
		}
	}

	public void sortAll(Object arr, boolean asc, boolean showResult) {
		Object temp1 = cloneArray(arr);
		Object temp2 = cloneArray(arr);
		Object temp3 = cloneArray(arr);
		
		bubbleSort(arr, asc, showResult);
		System.out.println("==========");

		insertionSort(arr, asc, showResult);
		System.out.println("==========");

		selectionSort(arr, asc, showResult);
		System.out.println("==========");
	}

	public static Object cloneArray(Object arr) {
		if (arr instanceof int[]) {
			return ((int[]) arr).clone();
		} else if (arr instanceof float[]) {
			return ((float[]) arr).clone();
		} else if (arr instanceof char[]) {
			return ((char[]) arr).clone();
		} else if (arr instanceof boolean[]) {
			return ((boolean[]) arr).clone();
		} else {
			throw new IllegalArgumentException("Tipe array tidak didukung");
		}
	}

	public void bubbleSort(Object arr, boolean asc, boolean showResult) {
		Object temp1 = cloneArray(arr);
		long start1 = System.currentTimeMillis();
		sort.bubbleSort(temp1, asc);
		long end1 = System.currentTimeMillis();
		System.out.println("Bubble sort berhasil dalam " + (end1 - start1) + "ms");
		if (showResult) printArray(temp1);
		System.out.println("==========");

	}

	public void insertionSort(Object arr, boolean asc, boolean showResult) {
		Object temp2 = cloneArray(arr);	
		long start2 = System.currentTimeMillis();
		sort.insertionSort(temp2, asc);
		long end2 = System.currentTimeMillis();
		System.out.println("Insertion sort berhasil dalam " + (end2 - start2) + "ms");
		if (showResult) printArray(temp2);
		}

	public void selectionSort(Object arr, boolean asc, boolean showResult) {
		Object temp3 = cloneArray(arr);
		long start3 = System.currentTimeMillis();
		sort.selectionSort(temp3, asc);
		long end3 = System.currentTimeMillis();
		System.out.println("Selection sort berhasil dalam " + (end3 - start3) + "ms");
		if (showResult) printArray(temp3);
	}

}
