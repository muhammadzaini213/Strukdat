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

    public void bubbleSort(LinkedList linkedList, boolean asc) {
        bubbleSorting.sort(linkedList, asc);
    }

    public void insertionSort(LinkedList linkedList, boolean asc) {
        insertionSort.sort(linkedList, asc);
    }

    public void selectionSort(LinkedList linkedList, boolean asc) {
        selectionSort.sort(linkedList, asc);
    }

    public void bubbleSort(Object obj, boolean asc) {
        bubbleSorting.sort(obj, asc);
    }

    public void insertionSort(Object obj, boolean asc) {
        insertionSort.sort(obj, asc);
    }

    public void selectionSort(Object obj, boolean asc) {
        selectionSort.sort(obj, asc);
    }


}

