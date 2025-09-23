package app.utils;

import java.util.Scanner;

public class Inputs {
	Scanner sc = new Scanner(System.in);

	public int optionInput() {
		String input = sc.nextLine();
		int angka = -1;

		if (input.isEmpty()) return -1;

		try {
			angka = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.err.println("Input bukan angka yang valid!");
		}

		return angka;
	}

	public boolean confirmation() {
		System.out.print("Apakah anda yakin? Semua data yang dimasukkan sebelumnya akan hilang!(Y/n)");

		String input = sc.nextLine().toLowerCase();
        if (input.isEmpty()) return true;
        return input.charAt(0) == 'y';
    }

	public int switchOption() {
		while(true) {
			System.out.print("Aktifkan(Y), Matikan(n), Batalkan(e): ");

			char input = sc.nextLine().toLowerCase().charAt(0);

			if (input == 'y') return 1;
			else if (input == 'n') return 0;
			else return -1;
		}
	}
}
