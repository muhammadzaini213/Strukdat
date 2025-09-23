package amerika.sorting.simplesorting;

import amerika.linkedlists.twowaylinkedlist.TwoWayLinkedList;
import amerika.linkedlists.twowaylinkedlist.TwoWayLinkedListBool;
import amerika.linkedlists.twowaylinkedlist.TwoWayLinkedListChar;
import amerika.linkedlists.twowaylinkedlist.TwoWayLinkedListFloat;
import amerika.linkedlists.twowaylinkedlist.TwoWayLinkedListInt;

public class BubbleSort {

	public void sort(TwoWayLinkedList linkedList, boolean asc) {
		int n = linkedList.size();

		if (linkedList instanceof TwoWayLinkedListInt) {
			TwoWayLinkedListInt linkedListInt = ((TwoWayLinkedListInt) linkedList);
			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < n - i - 1; j++) {
					if ((linkedListInt.get(j) > linkedListInt.get(j + 1) && asc) || (!asc && linkedListInt.get(j) < linkedListInt.get(j+1))) {
						linkedListInt.swap(j, j + 1);
					}

				}
			}
		} else if (linkedList instanceof TwoWayLinkedListChar) {
			TwoWayLinkedListChar linkedListChar = ((TwoWayLinkedListChar) linkedList);
			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < n - i - 1; j++) {
					if ((linkedListChar.get(j) > linkedListChar.get(j + 1) && asc) || (!asc && linkedListChar.get(j) < linkedListChar.get(j+1))) {
						linkedListChar.swap(j, j + 1);
					}
				}
			}
		} else if (linkedList instanceof TwoWayLinkedListFloat) {
			TwoWayLinkedListFloat linkedListFloat = ((TwoWayLinkedListFloat) linkedList);
			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < n - i - 1; j++) {
					if ((linkedListFloat.get(j) > linkedListFloat.get(j + 1) && asc) || (!asc && linkedListFloat.get(j) < linkedListFloat.get(j+1))) {
						linkedListFloat.swap(j, j + 1);
					}
				}
			}
		} else if (linkedList instanceof TwoWayLinkedListBool) {
			TwoWayLinkedListBool linkedListBool = ((TwoWayLinkedListBool) linkedList);
			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < n - i - 1; j++) {
					if ((asc && linkedListBool.get(j) && !linkedListBool.get(j + 1)) || (!asc && !linkedListBool.get(j) && linkedListBool.get(j + 1))) {
						linkedListBool.swap(j, j + 1);
					}
				}
			}
		}

	}

	public void sort(Object arr, boolean asc) {
		if (arr instanceof int[]) {
			int[] intArr = (int[]) arr;
			for (int i = 0; i < intArr.length - 1; i++) {
				for (int j = 0; j < intArr.length - i - 1; j++) {
					if ((asc && intArr[j] > intArr[j + 1]) || (!asc && intArr[j] < intArr[j + 1])) {
						int temp = intArr[j];
						intArr[j] = intArr[j + 1];
						intArr[j + 1] = temp;
					}
				}
			}
		} else if (arr instanceof float[]) {
			float[] floatArr = (float[]) arr;
			for (int i = 0; i < floatArr.length - 1; i++) {
				for (int j = 0; j < floatArr.length - i - 1; j++) {
					if ((asc && floatArr[j] > floatArr[j + 1]) || (!asc && floatArr[j] < floatArr[j + 1])) {
						float temp = floatArr[j];
						floatArr[j] = floatArr[j + 1];
						floatArr[j + 1] = temp;
					}		
				}
			}
		} else if (arr instanceof char[]) {
			char[] charArr = (char[]) arr;
			for (int i = 0; i < charArr.length - 1; i++) {
				for (int j = 0; j < charArr.length - i - 1; j++) {
					if ((asc && charArr[j] > charArr[j + 1]) || (!asc && charArr[j] < charArr[j + 1])) {
						char temp = charArr[j];
						charArr[j] = charArr[j + 1];
						charArr[j + 1] = temp;
					}
				}
			}
		} else if (arr instanceof boolean[]) {
			boolean[] boolArr = (boolean[]) arr;
			for (int i = 0; i < boolArr.length - 1; i++) {
				for (int j = 0; j < boolArr.length - i - 1; j++) {
					if ((asc && boolArr[j] && !boolArr[j + 1]) || (!asc && !boolArr[j] && boolArr[j + 1])) {
						boolean temp = boolArr[j];
						boolArr[j] = boolArr[j + 1];
						boolArr[j + 1] = temp;
					}
				}
			}
		} else {
			throw new IllegalArgumentException("Tipe array tidak didukung");
		}
	}
}
