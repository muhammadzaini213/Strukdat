package amerika.sorting.simplesorting;

import amerika.linkedlists.onewaylinkedlist.LinkedList;

public class SimpleSorting {
    
    private BubbleSort bubbleSorting;
    private InsertionSort insertionSort;
    private SelectionSort selectionSort;

    public SimpleSorting() {
        bubbleSorting = new BubbleSort();
        insertionSort = new InsertionSort();
        selectionSort = new SelectionSort();
    }

    public void bubbleSort(LinkedList linkedList) {
        bubbleSorting.sort(linkedList);
    }

    public void insertionSort(LinkedList linkedList) {
        insertionSort.sort(linkedList);
    }

    public void selectionSort(LinkedList linkedList) {
        selectionSort.sort(linkedList);
    }
}

