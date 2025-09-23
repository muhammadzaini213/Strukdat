package amerika.sorting.simplesorting;

import amerika.linkedlists.twowaylinkedlist.TwoWayLinkedList;
import amerika.linkedlists.twowaylinkedlist.TwoWayLinkedListBool;
import amerika.linkedlists.twowaylinkedlist.TwoWayLinkedListChar;
import amerika.linkedlists.twowaylinkedlist.TwoWayLinkedListFloat;
import amerika.linkedlists.twowaylinkedlist.TwoWayLinkedListInt;

public class SelectionSort {

	public void sort(TwoWayLinkedList linkedList, boolean asc) {
		int n = linkedList.size();

		for (int i = 0; i < n - 1; ++i) {
			int minIndex = i;

			if (linkedList instanceof TwoWayLinkedListInt) {
				TwoWayLinkedListInt linkedListInt = ((TwoWayLinkedListInt ) linkedList);
				for (int j = i + 1; j < n; ++j) {
					if ((asc && linkedListInt.get(j) < linkedListInt.get(minIndex)) || (!asc && linkedListInt.get(j) > linkedListInt.get(minIndex))) {
						minIndex = j;
					}
				}
			} else if (linkedList instanceof TwoWayLinkedListChar) {
				TwoWayLinkedListChar linkedListChar = ((TwoWayLinkedListChar ) linkedList);
				for (int j = i + 1; j < n; ++j) {
					if ((asc && linkedListChar.get(j) < linkedListChar.get(minIndex)) || (!asc && linkedListChar.get(j) > linkedListChar.get(minIndex))) {
						minIndex = j;
					}
				}
			} else if (linkedList instanceof TwoWayLinkedListFloat) {
				TwoWayLinkedListFloat linkedListFloat = ((TwoWayLinkedListFloat ) linkedList);
				for (int j = i + 1; j < n; ++j) {
					if ((asc && linkedListFloat.get(j) < linkedListFloat.get(minIndex)) || (!asc && linkedListFloat.get(j) > linkedListFloat.get(minIndex))) {
						minIndex = j;
						minIndex = j;
					}
				}
			} else if (linkedList instanceof TwoWayLinkedListBool) {
				TwoWayLinkedListBool linkedListBool = ((TwoWayLinkedListBool ) linkedList);
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
