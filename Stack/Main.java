import java.util.Scanner;

public class Main {
	Scanner sc = new Scanner(System.in);
	Stack<Object> stack = new Stack<>();
	String currentType = "String";
	public static void main (String args[]) {
		Main m = new Main();
		while (true) {
			m.menu();
		}
	}

	private void menu(){
		print("");
		print(l() + " Stack " + currentType + " " + l());
		print("1. Lihat semua isi Stack");
		print("2. Lihat isi Stack dalam index");
		print("3. Tambahkan isi Stack (Push)");
		print("4. Keluarkan isi Stack (Pop)");
		print("5. Tukar isi Stack");
		print("6. Ukuran/Size Stack");
		print("7. Ganti tipe data");

		placeholder("Masukkan pilihan (1-7): ");

		int option;
		try {
			option = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			print("Input hukan angka yang valid!");
			return;
		}

		switch(option) {
			case 1:
				getAll();
				break;
			case 2:
				getIndex();
				break;
			case 3:
				add();
				break;
			case 4:
				out();
				break;
			case 5: 
				swap();
				break;
			case 6:
				size();
				break;
			case 7: 
				change();
				break;
			default:
				print("Anda tidak memilih sesuai opsi yang tersedia!");
		}
	}

	private void getAll() {
		String data = "";

		if (stack.size() == 0) {
			print("Stack Kosong!");
			return;
		}
		for(int i = 0; i <= stack.size()-1; i++) {
				if (i == 0) {
					data = data + "[" + stack.peek(i) + "]";
				} else {
					data = data + ", [" + stack.peek(i) + "]";
				}
			}

			print(data);
		
	}

	private void getIndex() {
		if (stack.size() == 0) {
			print("Stack kosong!");
			return;
		}

		placeholder("Masukkan Index yang ingin dilihat: (0-" + (stack.size()-1) + "): "); 
		int index;
                try {
                        index = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                        print("Input hukan angka yang valid!");
                        return;
                }

		if (index >= stack.size() || index < 0) {
			print("Index ada diluar batas yang diperbolehkan!");
			return;
		}

		print("Index " + index + " dari Stack memiliki value: " + stack.peek(index));
	}

	private void add() {
		placeholder("Masukkan nilai yang ingin dimasukkan (" + currentType + "): ");
		switch (currentType) {
			case "String":
				String valueString = sc.nextLine();
				stack.push(valueString);
				break;
			case "int":
				try {
					int valueInt = Integer.parseInt(sc.nextLine());
					stack.push(valueInt);
				} catch (NumberFormatException e) {
					print("Input bukan angka yang valid!");
				}
				break;
			default:
				print("Error");
				return;
		}
		print("Berhasil menambahkan data");
	}

	private void out() {
		if (stack.size() == 0) {
			print("Stack Kosong!");
			return;
		}
		print("Data keluar dari Stack: " + stack.pop());
	}

	private void swap() {
		if (stack.size() == 0) {
			print("Stack kosong!");
			return;
		}

		try {
		placeholder("Masukkan index pertama yang ingin di swap (0-" + (stack.size()-1) + "): ");
		int index1 = Integer.parseInt(sc.nextLine());
		placeholder("Masukkan index kedua yang ingin di swap (0-" + (stack.size()-1) + "): ");
		int index2 = Integer.parseInt(sc.nextLine());

		if (index1 < 0 || index2 < 0) {
			print("Index tidak boleh begatif!");
			return;
		}
		if (index1 >= stack.size() || index2 >= stack.size()) {
			print("Index melebihi batas yang diperbolehkan!");
			return;
		}
		stack.swap(index1, index2);

		} catch (NumberFormatException e) {
			print("Input bukan angka yang valid!");
		}
	}

	private void size() {
		print("Ukuran/Size Stack: " + stack.size());
	}

	private void change() {
		print("Pilih tipe data yang mau digunakan (sekarang = " + currentType + "): ");
		print("1. String");
		print("2. int");
		placeholder("Input anda? (1-2): ");
		try {
		int option = Integer.parseInt(sc.nextLine());
		switch (option) {
			case 1:
				if (currentType.equals("String")) return;
				currentType = "String";
				placeholder("Apakah anda yakin? Mengganti tipe data akan mereset Stack! (Y/n)");
				String conf = sc.nextLine();
				if (conf.equals("n")) return;
				stack = new Stack<>();
				break;
			case 2: 
				if (currentType.equals("int")) return;
				currentType = "int";
				placeholder("Apakah anda yakin? Mengganti tipe data akan mereset Stack! (Y/n)");
                                String conf2 = sc.nextLine();
				if (conf2.equals("n")) return;
				stack = new Stack<>();
				break;
			default:
				print("Anda memilih diluar opsi!");
		}

		} catch (NumberFormatException e) {
			print("Input bukan angka yang valid!");
		}
	}

	private void print(String text){
		System.out.println(text);
	}

	private void placeholder(String text) {
		System.out.print(text);
	}

	private String l() {
		return "=".repeat(10);
	}
}
