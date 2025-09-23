package amerika.sorting.simplesorting;

import amerika.linkedlists.twowaylinkedlist.TwoWayLinkedList;

public class SimpleSorting {
    
    private BubbleSort bubbleSorting;
    private InsertionSort insertionSort;
    private SelectionSort selectionSort;

    public SimpleSorting() {
        bubbleSorting = new BubbleSort();
        insertionSort = new InsertionSort();
        selectionSort = new SelectionSort();
    }

    public void bubbleSort(TwoWayLinkedList linkedList, boolean asc) {
        new BubbleSort().sort(linkedList, asc);
    }

    public void insertionSort(TwoWayLinkedList linkedList, boolean asc) {
        new InsertionSort().sort(linkedList, asc);
    }

    public void selectionSort(TwoWayLinkedList linkedList, boolean asc) {
        new SelectionSort().sort(linkedList, asc);
    }

    public void bubbleSort(Object obj, boolean asc) {
        new BubbleSort().sort(obj, asc);
    }

    public void insertionSort(Object obj, boolean asc) {
        new InsertionSort().sort(obj, asc);
    }

    public void selectionSort(Object obj, boolean asc) {
        new SelectionSort().sort(obj, asc);
    }


}

