package amerika.sorting.simplesorting;

import amerika.linkedlists.onewaylinkedlist.LinkedList;

public class SimpleSorting {
    
    private BubbleSorting bubbleSorting;
    private InsertionSort insertionSort;
    private SelectionSort selectionSort;

    public SimpleSorting() {
        bubbleSorting = new BubbleSorting();
        insertionSort = new InsertionSort();
        selectionSort = new SelectionSort();
    }

    public void bubbleSorting(LinkedList linkedList) {
        bubbleSorting.sort(linkedList);
    }

    public void insertionSort(LinkedList linkedList) {
        insertionSort.sort(linkedList);
    }

    public void selectionSort(LinkedList linkedList) {
        selectionSort.sort(linkedList);
    }
}

