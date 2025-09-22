package amerika.sorting.simplesorting;

import amerika.linkedlists.onewaylinkedlist.LinkedList;
import amerika.linkedlists.onewaylinkedlist.LinkedListBool;
import amerika.linkedlists.onewaylinkedlist.LinkedListChar;
import amerika.linkedlists.onewaylinkedlist.LinkedListFloat;
import amerika.linkedlists.onewaylinkedlist.LinkedListInt;

public class SelectionSort {

	public void sort(LinkedList linkedList, boolean asc) {
		int n = linkedList.size();

		for (int i = 0; i < n - 1; ++i) {
			int minIndex = i;

			if (linkedList instanceof LinkedListInt) {
				LinkedListInt linkedListInt = (LinkedListInt) linkedList;
				for (int j = i + 1; j < n; ++j) {
					if ((asc && linkedListInt.get(j) < linkedListInt.get(minIndex)) || (!asc && linkedListInt.get(j) > linkedListInt.get(minIndex))) {
						minIndex = j;
					}
				}
			} else if (linkedList instanceof LinkedListChar) {
				LinkedListChar linkedListChar = (LinkedListChar) linkedList;
				for (int j = i + 1; j < n; ++j) {
					if ((asc && linkedListChar.get(j) < linkedListChar.get(minIndex)) || (!asc && linkedListChar.get(j) > linkedListChar.get(minIndex))) {
						minIndex = j;
					}
				}
			} else if (linkedList instanceof LinkedListFloat) {
				LinkedListFloat linkedListFloat = (LinkedListFloat) linkedList;
				for (int j = i + 1; j < n; ++j) {
					if ((asc && linkedListFloat.get(j) < linkedListFloat.get(minIndex)) || (!asc && linkedListFloat.get(j) > linkedListFloat.get(minIndex))) {
						minIndex = j;
						minIndex = j;
					}
				}
			} else if (linkedList instanceof LinkedListBool) {
				LinkedListBool linkedListBool = (LinkedListBool) linkedList;
				for (int j = i + 1; j < n; ++j) {
					if ((asc && linkedListBool.get(j) && !linkedListBool.get(minIndex)) || (!asc && !linkedListBool.get(j) && linkedListBool.get(minIndex))) {
						minIndex = j;
					}
				}
			}

			linkedList.swap(i, minIndex);
		}
	}

	public void sort(Object arr, boolean asc) {
		if (arr instanceof int[]) {
			int[] a = (int[]) arr;
			for (int i = 0; i < a.length - 1; i++) {
				int minIndex = i;
				for (int j = i + 1; j < a.length; j++) {
					if ((asc && a[j] < a[minIndex]) || (!asc && a[j] > a[minIndex])) {
						minIndex = j;
					}
				}
				int temp = a[i];
				a[i] = a[minIndex];
				a[minIndex] = temp;
			}
		} else if (arr instanceof float[]) {
			float[] a = (float[]) arr;
			for (int i = 0; i < a.length - 1; i++) {
				int minIndex = i;
				for (int j = i + 1; j < a.length; j++) {
					if ((asc && a[j] < a[minIndex]) || (!asc && a[j] > a[minIndex])) {
						minIndex = j;
					}
				}
				float temp = a[i];
				a[i] = a[minIndex];
				a[minIndex] = temp;
			}
		} else if (arr instanceof char[]) {
			char[] a = (char[]) arr;
			for (int i = 0; i < a.length - 1; i++) {
				int minIndex = i;
				for (int j = i + 1; j < a.length; j++) {
					if ((asc && a[j] < a[minIndex]) || (!asc && a[j] > a[minIndex])) {
						minIndex = j;
					}
				}
				char temp = a[i];
				a[i] = a[minIndex];
				a[minIndex] = temp;
			}
		} else if (arr instanceof boolean[]) {
			boolean[] a = (boolean[]) arr;
			for (int i = 0; i < a.length - 1; i++) {
				int minIndex = i;
				for (int j = i + 1; j < a.length; j++) {
					if ((asc && a[j] && !a[minIndex]) || (!asc && !a[j] && a[minIndex])) {
						minIndex = j;
					}
				}
				boolean temp = a[i];
				a[i] = a[minIndex];
				a[minIndex] = temp;
			}
		} else {
			throw new IllegalArgumentException("Tipe array tidak didukung");
		}
	}

}
