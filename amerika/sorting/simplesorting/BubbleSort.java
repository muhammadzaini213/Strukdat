package amerika.sorting.simplesorting;

import amerika.linkedlists.onewaylinkedlist.LinkedList;
import amerika.linkedlists.onewaylinkedlist.LinkedListBool;
import amerika.linkedlists.onewaylinkedlist.LinkedListChar;
import amerika.linkedlists.onewaylinkedlist.LinkedListFloat;
import amerika.linkedlists.onewaylinkedlist.LinkedListInt;

public class BubbleSorting {

    public void sort(LinkedList linkedList) {
        int n = linkedList.size();

        if (linkedList instanceof LinkedListInt) {
            LinkedListInt linkedListInt = (LinkedListInt) linkedList;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (linkedListInt.get(j) > linkedListInt.get(j + 1)) {
                        linkedListInt.swap(j, j + 1);
                    }
                }
            }
        } else if (linkedList instanceof LinkedListChar) {
            LinkedListChar linkedListChar = (LinkedListChar) linkedList;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (linkedListChar.get(j) > linkedListChar.get(j + 1)) {
                        linkedListChar.swap(j, j + 1);
                    }
                }
            }
        } else if (linkedList instanceof LinkedListFloat) {
            LinkedListFloat linkedListFloat = (LinkedListFloat) linkedList;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (linkedListFloat.get(j) > linkedListFloat.get(j + 1)) {
                        linkedListFloat.swap(j, j + 1);
                    }
                }
            }
        } else if (linkedList instanceof LinkedListBool) {
            LinkedListBool linkedListBool = (LinkedListBool) linkedList;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (linkedListBool.get(j) && !linkedListBool.get(j + 1)) {
                        linkedListBool.swap(j, j + 1);
                    }
                }
            }
        }

    }
}
