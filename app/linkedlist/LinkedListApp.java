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

		listBool.remove(2);
		listBool.insert('z', 2);
		for(int i = 0; i < 4; i++) {
			System.out.println(listBool.get(i));
		}
		
	}
}
