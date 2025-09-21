package app.sort;

import java.util.Scanner;
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
			o.print("3. Isi 100.000 data random");
			o.print("4. Cek data pada index");
			o.print("5. Hapus dats pada index");
			o.print("6. Swap data");
			o.print("7. Sort data");
			o.print("8. Tampilkan semua data");
			o.print("0. Kembali");
			o.placeholder("Masukkan opsi (0-8): ");

			switch(i.optionInput()) {
				case -1:
					break;
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					sortOption();
					break;
				case 8:
					break;
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
			o.print("5. Pengaturan");
			o.print("0. Kembali");
			o.placeholder("Masukkan opsi (0-5): ");

			switch(i.optionInput()) {
				case -1:
					break;
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					sortSettings();
					break;
				case 0:
					return;
				default:
					o.print("Anda memilih diluar opsi!");
					break;
			}
		}
	}

	private void sortSettings() {
		while(true) {
			o.print("");
			o.print("==== Pengaturan Sorting ====");
			o.print("1. Ascending " + (isAscend ? "Ya" : "Tidak"));
			o.print("2. Tampilkan Proses " + (showProcess ? "Ya" : "Tidak"));
			o.print("0. Kembali");
			o.placeholder("Masukkan opsi (0-2): ");

			switch(i.optionInput()) {
				case -1:
					break;
				case 1:
					break;
				case 2:
					break;
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
			o.print("1. Tipe List (Array/LinkedList)");
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
			o.print("2. LinkedList");
			o.print("0. Kembali");
			o.placeholder("Masukkan opsi (0-2): ");

			switch(i.optionInput()) {
				case -1:
					break;
				case 1:
					break;
				case 2:
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
					break;
				case 2: 
					break;
				case 3:
					break;
				case 4:
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
