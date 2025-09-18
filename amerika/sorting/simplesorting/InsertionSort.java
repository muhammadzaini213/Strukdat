package amerika.sorting.simplesorting;

import amerika.linkedlists.onewaylinkedlist.LinkedList;
import amerika.linkedlists.onewaylinkedlist.LinkedListBool;
import amerika.linkedlists.onewaylinkedlist.LinkedListChar;
import amerika.linkedlists.onewaylinkedlist.LinkedListFloat;
import amerika.linkedlists.onewaylinkedlist.LinkedListInt;

public class InsertionSort {

    public void sort(LinkedList linkedList) {
        int n = linkedList.size();

        if (linkedList instanceof LinkedListInt) {
            LinkedListInt linkedListInt = (LinkedListInt) linkedList;
            for (int i = 1; i < n; ++i) {
                int key = linkedListInt.get(i);
                int j = i - 1;

                while (j >= 0 && linkedListInt.get(j) > key) {
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

                while (j >= 0 && linkedListChar.get(j) > key) {
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

                while (j >= 0 && linkedListFloat.get(j) > key) {
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

                while (j >= 0 && linkedListBool.get(j) && !key) {
                    boolean temp = linkedListBool.get(j);
                    linkedListBool.remove(j+1);
                    linkedListBool.insert(temp, j+1);
                    j = j - 1;
                }
                linkedList.swap(i, j + 1);
            }
        }

    }

}
