package app.linkedlist;

import java.util.Arrays;

import amerika.linkedlists.onewaylinkedlist.LinkedListBool;
import amerika.sorting.simplesorting.SelectionSort;

public class LinkedListApp {
	
	LinkedListBool listBool = new LinkedListBool();

	public static void main(String args[]) {
		LinkedListApp app = new LinkedListApp();
		app.menu();
	}

	private void menu() {
		listBool.add(true);
		listBool.add(false);
		listBool.add(true);
		listBool.add(false);
		listBool.add(true);

		System.out.println(Arrays.toString(listBool.getAll()));
		SelectionSort.sort(listBool);
		System.out.println(Arrays.toString(listBool.getAll()));	}
}
