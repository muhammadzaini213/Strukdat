package amerika.sorting.simplesorting;

import amerika.linkedlists.onewaylinkedlist.LinkedList;
import amerika.linkedlists.onewaylinkedlist.LinkedListBool;
import amerika.linkedlists.onewaylinkedlist.LinkedListChar;
import amerika.linkedlists.onewaylinkedlist.LinkedListFloat;
import amerika.linkedlists.onewaylinkedlist.LinkedListInt;

public class InsertionSort {

	public void sort(LinkedList linkedList, boolean asc) {
		int n = linkedList.size();

		if (linkedList instanceof LinkedListInt) {
			LinkedListInt linkedListInt = (LinkedListInt) linkedList;
			for (int i = 1; i < n; ++i) {
				int key = linkedListInt.get(i);
				int j = i - 1;

				while ((asc && j >= 0 && linkedListInt.get(j) > key) || (!asc && j>= 0 && linkedListInt.get(j) < key)) {
					int temp = linkedListInt.get(j);
					linkedListInt.remove(j+1);
					linkedListInt.insert(temp, j+1);
					j = j - 1;
				}
				linkedList.swap(i, j + 1);
			}

		} else if (linkedList instanceof LinkedListChar) {
			LinkedListChar linkedListChar = (LinkedListChar) linkedList;
			for (int i = 1; i < n; ++i) {
				char key = linkedListChar.get(i);
				int j = i - 1;

				while ((asc && j >= 0 && linkedListChar.get(j) > key) || (!asc && j>= 0 && linkedListChar.get(j) < key)) {

					char temp = linkedListChar.get(j);
					linkedListChar.remove(j+1);
					linkedListChar.insert(temp, j+1);
					j = j - 1;
				}
				linkedList.swap(i, j + 1);
			}
		} else if (linkedList instanceof LinkedListFloat) {
			LinkedListFloat linkedListFloat = (LinkedListFloat) linkedList;
			for (int i = 1; i < n; ++i) {
				float key = linkedListFloat.get(i);
				int j = i - 1;
				while ((asc && j >= 0 && linkedListFloat.get(j) > key) || (!asc && j>= 0 && linkedListFloat.get(j) < key)) {
					float temp = linkedListFloat.get(j);
					linkedListFloat.remove(j+1);
					linkedListFloat.insert(temp, j+1);
					j = j - 1;
				}
				linkedList.swap(i, j + 1);
			}
		} else if (linkedList instanceof LinkedListBool) {
			LinkedListBool linkedListBool = (LinkedListBool) linkedList;
			for (int i = 1; i < n; ++i) {
				boolean key = linkedListBool.get(i);
				int j = i - 1;

				while ((asc && j >= 0 && linkedListBool.get(j) && !key) || (!asc & j >= 0 && !linkedListBool.get(j) && key)) {
					boolean temp = linkedListBool.get(j);
					linkedListBool.remove(j+1);
					linkedListBool.insert(temp, j+1);
					j = j - 1;
				}
				linkedList.swap(i, j + 1);
			}
		}

	}

	public void sort(Object arr, boolean asc) {
		if (arr instanceof int[]) {
			int[] a = (int[]) arr;
			for (int i = 1; i < a.length; i++) {
				int key = a[i];
				int j = i - 1;
				while (j >= 0 && ((asc && a[j] > key) || (!asc && a[j] < key))) {
					a[j + 1] = a[j];
					j--;
				}
				a[j + 1] = key;
			}
		} else if (arr instanceof float[]) {
			float[] a = (float[]) arr;
			for (int i = 1; i < a.length; i++) {
				float key = a[i];
				int j = i - 1;
				while (j >= 0 && ((asc && a[j] > key) || (!asc && a[j] < key))) {
					a[j + 1] = a[j];
					j--;
				}
				a[j + 1] = key;
			}
		} else if (arr instanceof char[]) {
			char[] a = (char[]) arr;
			for (int i = 1; i < a.length; i++) {
				char key = a[i];
				int j = i - 1;
				while (j >= 0 && ((asc && a[j] > key) || (!asc && a[j] < key))) {
					a[j + 1] = a[j];
					j--;
				}
				a[j + 1] = key;
			}
		} else if (arr instanceof boolean[]) {
			boolean[] a = (boolean[]) arr;
			for (int i = 1; i < a.length; i++) {
				boolean key = a[i];
				int j = i - 1;
				while (j >= 0 && ((asc && a[j] && !key) || (!asc && !a[j] && key))) {
					a[j + 1] = a[j];
					j--;
				}
				a[j + 1] = key;
			}
		} else {
			throw new IllegalArgumentException("Tipe array tidak didukung");
		}
	}

}
