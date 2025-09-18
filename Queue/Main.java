// import java.util.Scanner;

// public class Main {
// 	Scanner sc = new Scanner(System.in);
// 	Queue<Object> queue = new Queue<>();
// 	String currentType = "String";
// 	public static void main (String args[]) {
// 		Main m = new Main();
// 		while (true) {
// 			m.menu();
// 		}
// 	}

// 	private void menu(){
// 		print("");
// 		print(l() + " Queue " + currentType + " " + l());
// 		print("1. Lihat semua isi Queue");
// 		print("2. Lihat isi Queue dalam index");
// 		print("3. Tambahkan isi Queue (Enqueue)");
// 		print("4. Keluarkan isi Queue (Dequeue)");
// 		print("5. Tukar isi Queue");
// 		print("6. Ukuran/Size Queue");
// 		print("7. Ganti tipe data");

// 		placeholder("Masukkan pilihan (1-7): ");

// 		int option;
// 		try {
// 			option = Integer.parseInt(sc.nextLine());
// 		} catch (NumberFormatException e) {
// 			print("Input hukan angka yang valid!");
// 			return;
// 		}

// 		switch(option) {
// 			case 1:
// 				getAll();
// 				break;
// 			case 2:
// 				getIndex();
// 				break;
// 			case 3:
// 				add();
// 				break;
// 			case 4:
// 				out();
// 				break;
// 			case 5: 
// 				swap();
// 				break;
// 			case 6:
// 				size();
// 				break;
// 			case 7: 
// 				change();
// 				break;
// 			default:
// 				print("Anda tidak memilih sesuai opsi yang tersedia!");
// 		}
// 	}

// 	private void getAll() {
// 		String data = "";

// 		if (queue.size() == 0) {
// 			print("Queue Kosong!");
// 			return;
// 		}
// 		for(int i = 0; i <= queue.size()-1; i++) {
// 				if (i == 0) {
// 					data = data + "[" + queue.peek(i) + "]";
// 				} else {
// 					data = data + ", [" + queue.peek(i) + "]";
// 				}
// 			}

// 			print(data);
		
// 	}

// 	private void getIndex() {
// 		if (queue.size() == 0) {
// 			print("Queue kosong!");
// 			return;
// 		}

// 		placeholder("Masukkan Index yang ingin dilihat: (0-" + (queue.size()-1) + "): "); 
// 		int index;
//                 try {
//                         index = Integer.parseInt(sc.nextLine());
//                 } catch (NumberFormatException e) {
//                         print("Input hukan angka yang valid!");
//                         return;
//                 }

// 		if (index >= queue.size() || index < 0) {
// 			print("Index ada diluar batas yang diperbolehkan!");
// 			return;
// 		}

// 		print("Index " + index + " dari Queue memiliki value: " + queue.peek(index));
// 	}

// 	private void add() {
// 		placeholder("Masukkan nilai yang ingin dimasukkan (" + currentType + "): ");
// 		switch (currentType) {
// 			case "String":
// 				String valueString = sc.nextLine();
// 				queue.enqueue(valueString);
// 				break;
// 			case "int":
// 				try {
// 					int valueInt = Integer.parseInt(sc.nextLine());
// 					queue.enqueue(valueInt);
// 				} catch (NumberFormatException e) {
// 					print("Input bukan angka yang valid!");
// 				}
// 				break;
// 			default:
// 				print("Error");
// 				return;
// 		}
// 		print("Berhasil menambahkan data");
// 	}

// 	private void out() {
// 		if (queue.size() == 0) {
// 			print("Queue Kosong!");
// 			return;
// 		}
// 		print("Data keluar dari Queue: " + queue.dequeue());
// 	}

// 	private void swap() {
// 		if (queue.size() == 0) {
// 			print("Queue kosong!");
// 			return;
// 		}

// 		try {
// 		placeholder("Masukkan index pertama yang ingin di swap (0-" + (queue.size()-1) + "): ");
// 		int index1 = Integer.parseInt(sc.nextLine());
// 		placeholder("Masukkan index kedua yang ingin di swap (0-" + (queue.size()-1) + "): ");
// 		int index2 = Integer.parseInt(sc.nextLine());

// 		if (index1 < 0 || index2 < 0) {
// 			print("Index tidak boleh begatif!");
// 			return;
// 		}
// 		if (index1 >= queue.size() || index2 >= queue.size()) {
// 			print("Index melebihi batas yang diperbolehkan!");
// 			return;
// 		}
// 		queue.swap(index1, index2);

// 		} catch (NumberFormatException e) {
// 			print("Input bukan angka yang valid!");
// 		}
// 	}

// 	private void size() {
// 		print("Ukuran/Size Queue: " + queue.size());
// 	}

// 	private void change() {
// 		print("Pilih tipe data yang mau digunakan (sekarang = " + currentType + "): ");
// 		print("1. String");
// 		print("2. int");
// 		placeholder("Input anda? (1-2): ");
// 		try {
// 		int option = Integer.parseInt(sc.nextLine());
// 		switch (option) {
// 			case 1:
// 				if (currentType.equals("String")) return;
// 				currentType = "String";
// 				placeholder("Apakah anda yakin? Mengganti tipe data akan mereset Queue! (Y/n)");
// 				String conf = sc.nextLine();
// 				if (conf.equals("n")) return;
// 				queue = new Queue<>();
// 				break;
// 			case 2: 
// 				if (currentType.equals("int")) return;
// 				currentType = "int";
// 				placeholder("Apakah anda yakin? Mengganti tipe data akan mereset Queue! (Y/n)");
//                                 String conf2 = sc.nextLine();
// 				if (conf2.equals("n")) return;
// 				queue = new Queue<>();
// 				break;
// 			default:
// 				print("Anda memilih diluar opsi!");
// 		}

// 		} catch (NumberFormatException e) {
// 			print("Input bukan angka yang valid!");
// 		}
// 	}

// 	private void print(String text){
// 		System.out.println(text);
// 	}

// 	private void placeholder(String text) {
// 		System.out.print(text);
// 	}

// 	private String l() {
// 		return "=".repeat(10);
// 	}
// }
