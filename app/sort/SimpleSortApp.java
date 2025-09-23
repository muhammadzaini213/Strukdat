package app.sort;

import java.util.Scanner;
import java.util.Arrays;
import amerika.linkedlists.twowaylinkedlist.*;
import amerika.sorting.simplesorting.SimpleSorting;
import app.sort.ListOption;
import app.sort.ArrayOption;
import app.sort.SortOption;
import app.utils.Outputs;
import app.utils.Inputs;

public class SimpleSortApp {

	Scanner sc = new Scanner(System.in);
	Outputs o = new Outputs();
	Inputs i = new Inputs();


	// Ini untuk Data.
	String listType = "Array";
	String dataType = "int";
	boolean isAscend = true;
	boolean showProcess = false;
	boolean showResult = false;

	TwoWayLinkedList linkedlist = new TwoWayLinkedListInt();
	int[] intArr = new int[0];
	float[] floatArr = new float[0];
	char[] charArr = new char[0];
	boolean[] booleanArr = new boolean[0];

	SimpleSorting sort = new SimpleSorting();
	ArrayOption arrOption = new ArrayOption();
	ListOption listOption = new ListOption();
	SortOption sortOption = new SortOption();

	public static void main(String args[]) {
		SimpleSortApp app = new SimpleSortApp();
		app.menu();
	}	


	public void menu() {
		while(true) {
			o.print("");
			o.print("==== Selamat datang di aplikasi Sorting! ====");
			o.print("1. " + listType);
			o.print("2. Pengaturan");
			o.placeholder("Masukkan opsi (1-2): ");

			switch(i.optionInput()) {
				case -1:
					break;
				case 1:
					list();
					break;
				case 2:
					typeSettings();
					break;
				default:
					o.print("Anda memilih diluar opsi!");
					break;
			}
		}
	}

	private void list() {
		while(true) {
			o.print("");
			o.print("==== "+ listType + " " + dataType +" ====");
			o.print("1. Masukkan data manual");
			o.print("2. Isi 10 data []");
			o.print("3. Isi data random");
			o.print("4. Cek data pada index");
			o.print("5. Hapus data pada index");
			o.print("6. Swap data");
			o.print("7. Sort data");
			o.print("8. Ukuran " + listType);
			o.print("9. Tampilkan semua data");
			o.print("10. Tampilkan proses " + (showProcess ? "(Ya)" : "(Tidak)"));
			o.print("0. Kembali");
			o.placeholder("Masukkan opsi (0-9): ");

			switch(i.optionInput()) {
				case -1:
					break;
				case 1:
					if (listType == "TwoWayLinkedList") ListOption.addLinkedListData(sc, linkedlist);
					if (listType == "Array") {
						if (dataType == "int") intArr = (int[]) arrOption.inputData(sc, intArr, dataType);
						if (dataType == "float") floatArr = (float[]) arrOption.inputData(sc, floatArr, dataType);
						if (dataType == "char") charArr = (char[]) arrOption.inputData(sc, charArr, dataType);
						if (dataType == "bool") booleanArr = (boolean[]) arrOption.inputData(sc, booleanArr, dataType);



					}
					break;
				case 2:
					if (listType == "TwoWayLinkedList") ListOption.addTenData(linkedlist);
					if (listType == "Array") {
						if (dataType == "int") intArr = (int[]) arrOption.addTenData(dataType);
						if (dataType == "float") floatArr = (float[]) arrOption.addTenData(dataType);
						if (dataType == "char") charArr = (char[]) arrOption.addTenData(dataType);
						if (dataType == "bool") booleanArr = (boolean[]) arrOption.addTenData(dataType);
					}


					break;
				case 3:
					if (listType == "TwoWayLinkedList") ListOption.addRandomData(sc, linkedlist, showProcess);
					if (listType == "Array") {
						if (dataType == "int") intArr = (int[]) arrOption.addRandomData(sc, intArr, dataType, showProcess);
						if (dataType == "float") floatArr = (float[]) arrOption.addRandomData(sc, floatArr, dataType, showProcess);
						if (dataType == "char") charArr = (char[]) arrOption.addRandomData(sc, charArr, dataType, showProcess);
						if (dataType == "bool") booleanArr = (boolean[]) arrOption.addRandomData(sc, booleanArr, dataType, showProcess);

					}

					break;
				case 4:
					if (listType == "TwoWayLinkedList") ListOption.peekLinkedListData(sc, linkedlist);
					break;
				case 5:
					if (listType == "TwoWayLinkedList") ListOption.deleteIndex(sc, linkedlist);
					break;
				case 6:
					if (listType == "TwoWayLinkedList") ListOption.swapData(sc, linkedlist);
					break;
				case 7:
					sortOption();
					break;
				case 8:
					if (listType == "TwoWayLinkedList") ListOption.getSize(linkedlist);
					break;
				case 9:
					if (listType == "TwoWayLinkedList") ListOption.getAll(linkedlist);
					if (listType == "Array") {
						if (dataType == "int") o.print(Arrays.toString(intArr));
						if (dataType == "float") o.print(Arrays.toString(floatArr));
						if (dataType == "char") o.print(Arrays.toString(charArr));
						if (dataType == "bool") o.print(Arrays.toString(booleanArr));
					}
					break;
				case 10:
					if (i.switchOption() == 1) showProcess = true;
					else if (i.switchOption() == 0) showProcess = false;
				case 0:
					return;
				default:
					o.print("Anda memilih diluar opsi!");
					break;
			}

		}
	}

	private void sortOption() {
		while(true) {
			o.print("");
			o.print("==== Opsi Sorting " + (isAscend ? "(Ascending)" : "(Descending)") + (showProcess ? "(Proses Ditampilkan)" : "") + " ====");
			o.print("1. Semua");
			o.print("2. BubbleSort");
			o.print("3. InsertionSort");
			o.print("4. SelectionSort");
			o.print("5. Arah sort " + (isAscend ? "(Asc)" : "(Dsc)"));
			o.print("6. Tampilkan hasil " + (showResult ? "(Ya)" : "(Tidak)"));
			o.print("0. Kembali");
			o.placeholder("Masukkan opsi (0-5): ");

			switch(i.optionInput()) {
				case -1:
					break;
				case 1:
					if (listType == "TwoWayLinkedList") sortOption.sortAll(linkedlist, isAscend, showResult);
					if (listType == "Array") {
						if (dataType == "int") sortOption.sortAll(intArr, isAscend, showResult);
						if (dataType == "float") sortOption.sortAll(floatArr, isAscend, showResult);
						if (dataType == "char") sortOption.sortAll(charArr, isAscend, showResult);
						if (dataType == "bool") sortOption.sortAll(booleanArr, isAscend, showResult);
					}
					
					break;	
				case 2:
					if (listType == "TwoWayLinkedList") sortOption.bubbleSort(linkedlist, isAscend, showResult);
	if (listType == "Array") {
						if (dataType == "int") sortOption.bubbleSort(intArr, isAscend, showResult);
						if (dataType == "float") sortOption.bubbleSort(floatArr, isAscend, showResult);
						if (dataType == "char") sortOption.bubbleSort(charArr, isAscend, showResult);
						if (dataType == "bool") sortOption.bubbleSort(booleanArr, isAscend, showResult);
					}
					
					break;
				case 3:
					if (listType == "TwoWayLinkedList") sortOption.insertionSort(linkedlist, isAscend, showResult);
	if (listType == "Array") {
						if (dataType == "int") sortOption.insertionSort(intArr, isAscend, showResult);
						if (dataType == "float") sortOption.insertionSort(floatArr, isAscend, showResult);
						if (dataType == "char") sortOption.insertionSort(charArr, isAscend, showResult);
						if (dataType == "bool") sortOption.insertionSort(booleanArr, isAscend, showResult);
					}
					
					break;
				case 4:
					if (listType == "TwoWayLinkedList") sortOption.selectionSort(linkedlist, isAscend, showResult);
	if (listType == "Array") {
						if (dataType == "int") sortOption.selectionSort(intArr, isAscend, showResult);
						if (dataType == "float") sortOption.selectionSort(floatArr, isAscend, showResult);
						if (dataType == "char") sortOption.selectionSort(charArr, isAscend, showResult);
						if (dataType == "bool") sortOption.selectionSort(booleanArr, isAscend, showResult);
					}
					
					break;
				case 5:
					if (i.switchOption() == 1) isAscend = true;
					else if (i.switchOption() == 0) isAscend = false;
					break;
				case 6:
					if (i.switchOption() == 1) showResult = true;
					else if (i.switchOption() == 0) showResult = false;
				case 0:
					return;
				default:
					o.print("Anda memilih diluar opsi!");
					break;
			}
		}
	}

	private void typeSettings() {
		while(true) {
			o.print("");
			o.print("==== Pengaturan Tipe Data ====");
			o.print("1. Tipe List (Array/TwoWayLinkedList)");
			o.print("2. Tipe data (int/char/float/bool)");
			o.print("0. Kembali");
			o.placeholder("Masukkan opsi (0-2): ");
			switch(i.optionInput()) {
				case -1:
					break;
				case 1: 
					typeOption();
					break;
				case 2:
					typeDataOption();
					break;
				case 0:
					return;
				default:
					o.print("Anda memilih diluar opsi!");
					break;
			}
		}
	}

	private void typeOption() {
		while(true) {
			o.print("");
			o.print("==== Ubah Tipe List ====");
			o.print("1. Array");
			o.print("2. TwoWayLinkedList");
			o.print("0. Kembali");
			o.placeholder("Masukkan opsi (0-2): ");

			switch(i.optionInput()) {
				case -1:
					break;
				case 1:
					if (i.confirmation()) listType = "Array";
					break;
				case 2:
					if (i.confirmation()) listType = "TwoWayLinkedList";
					break;
				case 0:
					return;
				default:
					o.print("Anda memilih diluar opsi!");
					break;
			}
		}
	}

	private void typeDataOption() {
		while(true) {
			o.print("");
			o.print("==== Ubah Tipe Data ====");
			o.print("1. int");
			o.print("2. float");
			o.print("3. char");
			o.print("4. bool");
			o.print("0. Kembali");
			o.placeholder("Masukkan opsi (0-4): ");

			switch(i.optionInput()) {
				case -1:
					break;
				case 1:
					if (i.confirmation()) {
						if (dataType == "int") continue;
						dataType = "int";
						linkedlist = new TwoWayLinkedListInt();
						intArr = new int[0];
					}
					break;
				case 2: 
					if (i.confirmation()) {
						if (dataType == "float") continue;
						dataType = "float";
						linkedlist = new TwoWayLinkedListFloat();
						floatArr = new float[0];
					}

					break;
				case 3:
					if (i.confirmation()) {
						if (dataType == "char") continue;
						dataType = "char";
						linkedlist = new TwoWayLinkedListChar();
						charArr = new char[0];
					}

					break;
				case 4:
					if (i.confirmation()) {
						if (dataType == "bool") continue;
						dataType = "bool";
						linkedlist = new TwoWayLinkedListBool();
						booleanArr = new boolean[0];
					}

					break;
				case 0:
					return;
				default:
					o.print("Anda memilih diluar opsi!");
					break;
			}
		}
	}


}
