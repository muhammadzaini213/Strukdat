package amerika.sorting.simplesorting;

import amerika.linkedlists.onewaylinkedlist.LinkedList;
import amerika.linkedlists.onewaylinkedlist.LinkedListBool;
import amerika.linkedlists.onewaylinkedlist.LinkedListChar;
import amerika.linkedlists.onewaylinkedlist.LinkedListFloat;
import amerika.linkedlists.onewaylinkedlist.LinkedListInt;

public class SelectionSort {

    public void sort(LinkedList linkedList) {
        int n = linkedList.size();

        for (int i = 0; i < n - 1; ++i) {
            int minIndex = i;

            if (linkedList instanceof LinkedListInt) {
                LinkedListInt linkedListInt = (LinkedListInt) linkedList;
                for (int j = i + 1; j < n; ++j) {
                    if (linkedListInt.get(j) < linkedListInt.get(minIndex)) {
                        minIndex = j;
                    }
                }
            } else if (linkedList instanceof LinkedListChar) {
                LinkedListChar linkedListChar = (LinkedListChar) linkedList;
                for (int j = i + 1; j < n; ++j) {
                    if (linkedListChar.get(j) < linkedListChar.get(minIndex)) {
                        minIndex = j;
                    }
                }
            } else if (linkedList instanceof LinkedListFloat) {
                LinkedListFloat linkedListFloat = (LinkedListFloat) linkedList;
                for (int j = i + 1; j < n; ++j) {
                    if (linkedListFloat.get(j) < linkedListFloat.get(minIndex)) {
                        minIndex = j;
                    }
                }
            } else if (linkedList instanceof LinkedListBool) {
                LinkedListBool linkedListBool = (LinkedListBool) linkedList;
                for (int j = i + 1; j < n; ++j) {
                    if (linkedListBool.get(j) && !linkedListBool.get(minIndex)) {
                        minIndex = j;
                    }
                }
            }

            linkedList.swap(i, minIndex);
        }
    }
}
