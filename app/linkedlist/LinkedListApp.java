package app.linkedlist;

import amerika.linkedlists.onewaylinkedlist.LinkedListChar;

public class LinkedListApp {
	
	LinkedListChar listBool = new LinkedListChar();

	public static void main(String args[]) {
		LinkedListApp app = new LinkedListApp();
		app.menu();
	}

	private void menu() {
		listBool.add('s');
		listBool.add('d');
		listBool.add('f');
		listBool.add('g');
		listBool.add('g');

		System.out.println(listBool.getAll());
	}
}
