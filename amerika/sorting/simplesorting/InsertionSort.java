package amerika.sorting.simplesorting;

import amerika.linkedlists.twowaylinkedlist.TwoWayLinkedList;
import amerika.linkedlists.twowaylinkedlist.TwoWayLinkedListBool;
import amerika.linkedlists.twowaylinkedlist.TwoWayLinkedListChar;
import amerika.linkedlists.twowaylinkedlist.TwoWayLinkedListFloat;
import amerika.linkedlists.twowaylinkedlist.TwoWayLinkedListInt;

public class InsertionSort {

	public void sort(TwoWayLinkedList linkedList, boolean asc) {
		int n = linkedList.size();

		if (linkedList instanceof TwoWayLinkedListInt) {
			TwoWayLinkedListInt linkedListInt = ((TwoWayLinkedListInt ) linkedList);
			for (int i = 1; i < n; ++i) {
				int key = linkedListInt.get(i);
				int j = i - 1;

				while ((asc && j >= 0 && linkedListInt.get(j) > key) || (!asc && j>= 0 && linkedListInt.get(j) < key)) {
					j = j - 1;
				}
				linkedListInt.remove(i);
				linkedListInt.insert(key, j+1);

			}

		} else if (linkedList instanceof TwoWayLinkedListChar) {
			TwoWayLinkedListChar linkedListChar = ((TwoWayLinkedListChar ) linkedList);
			for (int i = 1; i < n; ++i) {
				char key = linkedListChar.get(i);
				int j = i - 1;

				while ((asc && j >= 0 && linkedListChar.get(j) > key) || (!asc && j>= 0 && linkedListChar.get(j) < key)) {
					j = j - 1;
				}
				linkedListChar.remove(i);
				linkedListChar.insert(key, j+1);
			}
		} else if (linkedList instanceof TwoWayLinkedListFloat) {
			TwoWayLinkedListFloat linkedListFloat = ((TwoWayLinkedListFloat ) linkedList);
			for (int i = 1; i < n; ++i) {
				float key = linkedListFloat.get(i);
				int j = i - 1;
				while ((asc && j >= 0 && linkedListFloat.get(j) > key) || (!asc && j>= 0 && linkedListFloat.get(j) < key)) {
					j = j - 1;
				}
				linkedListFloat.remove(i);
				linkedListFloat.insert(key, j+1);
			}
		} else if (linkedList instanceof TwoWayLinkedListBool) {
			TwoWayLinkedListBool linkedListBool = ((TwoWayLinkedListBool ) linkedList);
			for (int i = 1; i < n; ++i) {
				boolean key = linkedListBool.get(i);
				int j = i - 1;

				while ((asc && j >= 0 && linkedListBool.get(j) && !key) || (!asc & j >= 0 && !linkedListBool.get(j) && key)) {
					j = j - 1;
				}
				linkedListBool.remove(i);
				linkedListBool.insert(key, j+1);
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
