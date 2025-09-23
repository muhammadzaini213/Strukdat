package app.sort;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import amerika.linkedlists.twowaylinkedlist.TwoWayLinkedList;
import amerika.linkedlists.twowaylinkedlist.TwoWayLinkedListInt;
import amerika.linkedlists.twowaylinkedlist.TwoWayLinkedListChar;
import amerika.linkedlists.twowaylinkedlist.TwoWayLinkedListFloat;
import amerika.linkedlists.twowaylinkedlist.TwoWayLinkedListBool;

public class ListOption {

	public static void addLinkedListData(Scanner sc, TwoWayLinkedList linkedList) {
		System.out.print("Masukkan data: ");

		String input = sc.nextLine();

		if (input.isEmpty()) return;

		if (linkedList instanceof TwoWayLinkedListInt) {
			try {
				((TwoWayLinkedListInt) linkedList).add(Integer.parseInt(input));
			} catch (NumberFormatException e){
				System.out.println("Masukkan bilangan bulat!");
			}
		}
		
		else if (linkedList instanceof TwoWayLinkedListFloat) {
			try {
				((TwoWayLinkedListFloat) linkedList).add(Float.parseFloat(input));
			} catch (NumberFormatException e) {
				System.out.println("Masukkan angka, jika pecahan gunakan titik ( . )!");
			}
		}

		else if (linkedList instanceof TwoWayLinkedListChar) {
			((TwoWayLinkedListChar) linkedList).add(input.charAt(0));
		}

		else if (linkedList instanceof TwoWayLinkedListBool) {
			if (input.toLowerCase().equals("true")) ((TwoWayLinkedListBool) linkedList).add(true);
			else if (input.toLowerCase().equals("false")) ((TwoWayLinkedListBool) linkedList).add(false);
		}
		System.out.println("Berhasil!");
	}

	public static void addTenData(TwoWayLinkedList linkedList) {
		int[] intArr = {3, 1, 5, 2 , 10, 4, 7, 9, 8, 11};
		float[] floatArr = {12.5f, 3.8f, 99.1f, 45.2f, 7.7f, 28.9f, 61.3f, 14.6f, 82.4f, 0.1f};
		char[] charArr = {'a', 'z', 't', 'k', 'm', 'j', 'x', 'q', 'i', 'f'};
		boolean[] boolArr = {true, false, true, true, false, false, true, false, true, false};

		if (linkedList instanceof TwoWayLinkedListInt) {
			for (int i = 0; i < intArr.length; i++) {
				((TwoWayLinkedListInt) linkedList).add(intArr[i]);
			}
		}

		else if (linkedList instanceof TwoWayLinkedListFloat) {
			for (int i = 0; i < floatArr.length; i++) {
				((TwoWayLinkedListFloat) linkedList).add(floatArr[i]);
			}
		}

		else if (linkedList instanceof TwoWayLinkedListChar) {
			for (int i = 0; i < charArr.length; i++) {
				((TwoWayLinkedListChar) linkedList).add(charArr[i]);
			}
		}

		else if (linkedList instanceof TwoWayLinkedListBool) {
			for (int i = 0; i < boolArr.length; i++) {
				((TwoWayLinkedListBool) linkedList).add(boolArr[i]);
			}
		}
		System.out.println("Berhasil!");
	}


	public static void addRandomData(Scanner sc, TwoWayLinkedList linkedList, boolean showProcess) {
		Random r = new Random();
		System.out.println("Masukkan jumlah data random: ");
		int limit = 0;
		try {
			limit = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Masukkan angka yang valid!");
			return;
		}

		if (linkedList instanceof TwoWayLinkedListInt) {
			for (int i = 0; i <= limit; i++) {
				int data = r.nextInt(100000);
				((TwoWayLinkedListInt) linkedList).add(data);
				if (showProcess) System.out.println("Iterasi ["+i+"/"+limit+"] dengan data: "+data);
			}
		}

	else if (linkedList instanceof TwoWayLinkedListFloat) {
			for (int i = 0; i <= limit; i++) {
				float data = r.nextFloat() * 100000;
				((TwoWayLinkedListFloat) linkedList).add(data);
				if (showProcess) System.out.println("Iterasi ["+i+"/"+limit+"] dengan data: "+data);
			}
		}
		else if (linkedList instanceof TwoWayLinkedListChar) {
			for (int i = 0; i <= limit; i++) {
				char data = (char) ('A' + r.nextInt(26));
				((TwoWayLinkedListChar) linkedList).add(data);
				if (showProcess) System.out.println("Iterasi ["+i+"/"+limit+"] dengan data: "+data);
			}
		}

		else if (linkedList instanceof TwoWayLinkedListBool) {
			for (int i = 0; i <= limit; i++) {
				boolean data = r.nextBoolean();
				((TwoWayLinkedListBool) linkedList).add(data);
				if (showProcess) System.out.println("Iterasi ["+i+"/"+limit+"] dengan data: "+data);
			}


		}

		
		System.out.println("Berhasil!");
	}

	public static void peekLinkedListData(Scanner sc, TwoWayLinkedList linkedList) {
		if (linkedList.size() == 0) {
			System.out.println("linkedList kosong!");
		}

		System.out.print("Masukkan index yang ingin dicek (0-"+ (linkedList.size() - 1) + "): ");


		int index = -1000;

		try {
			index = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Masukkan angka yang valid!");
			return;
		}

		if (index == -1000) return;

		if (index < 0 || index > linkedList.size() - 1) {
			System.out.println("Masukkan angka pada interval yang diberikan!");
			return;
		}

		if (linkedList instanceof TwoWayLinkedListInt) {
			System.out.println("Index ke-" + index + " berisi: "+ ((TwoWayLinkedListInt) linkedList).get(index));
		}
		
		else if (linkedList instanceof TwoWayLinkedListFloat) {
			System.out.println("Index ke-" + index + " berisi: "+ ((TwoWayLinkedListFloat) linkedList).get(index));
		}

		else if (linkedList instanceof TwoWayLinkedListChar) {
			System.out.println("Index ke-" + index + " berisi: "+ ((TwoWayLinkedListChar) linkedList).get(index));
		}

		else if (linkedList instanceof TwoWayLinkedListBool) {
			System.out.println("Index ke-" + index + " berisi: "+ ((TwoWayLinkedListBool) linkedList).get(index));
		}
		System.out.println("Berhasil!");
	}

	public static void deleteIndex(Scanner sc, TwoWayLinkedList linkedList) {
		System.out.print("Masukkan index yang ingin dihapus (0-"+(linkedList.size()-1)+"): ");
		int index = -1000;

		try {
			index = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Masukkan angka yang valid!");
			return;
		}

		if (index == -1000) return;
		if (index < 0 || index > linkedList.size() -1) {
			System.out.println("Masukkan angka pada interval yang diberikan!");
			return;
		}

		linkedList.remove(index);

		System.out.println("Berhasil!");
	}

	public static void swapData(Scanner sc, TwoWayLinkedList linkedList) {
		System.out.print("Masukkan index pertama yang ingin ditukar (0-"+(linkedList.size()-1)+"): ");
		int index1 = -1000;

		int index2 = -1000;

		try {
			index1 = Integer.parseInt(sc.nextLine());
			System.out.println("Masukkan index kedua yang ingin ditukar (0-"+(linkedList.size()-1)+"): ");
			index2 = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Masukkan angka yang valid!");
		}

		if (index1 == -1000 || index2 == -1000) return;

		if (index1 < 0 || index1 > (linkedList.size() - 1) || index2 < 0 || index2 > (linkedList.size() - 1)) {

		}

		linkedList.swap(index1, index2);
		System.out.println("Berhasil!");
	}

	public static void getSize(TwoWayLinkedList linkedList) {
		System.out.println("Ukuran dari TwoWayLinkedList adalah: " + linkedList.size());
	}
	public static void getAll(TwoWayLinkedList linkedList) {

		if (linkedList instanceof TwoWayLinkedListInt) {
			System.out.println(Arrays.toString(((TwoWayLinkedListInt) linkedList).getAll()));
		}
		else if (linkedList instanceof TwoWayLinkedListFloat) {
			System.out.println(Arrays.toString(((TwoWayLinkedListFloat) linkedList).getAll()));
		}
		else if (linkedList instanceof TwoWayLinkedListChar) {
			System.out.println(Arrays.toString(((TwoWayLinkedListChar) linkedList).getAll()));
		}
		else if (linkedList instanceof TwoWayLinkedListBool) {
			System.out.println(Arrays.toString(((TwoWayLinkedListBool) linkedList).getAll()));
		}
	}
}
