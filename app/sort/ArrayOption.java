package app.sort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class ArrayOption {

	public static int[] addIntArray(int[] arr, int data) {
		int[] newArr = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		newArr[newArr.length - 1] = data;
		return newArr;
	}


	public static float[] addFloatArray(float[] arr, float data) {
		float[] newArr = new float[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		newArr[newArr.length - 1] = data;
		return newArr;
	}

	public static char[] addCharArray(char[] arr, char data) {
		char[] newArr = new char[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		newArr[newArr.length - 1] = data;
		return newArr;
	}

	public static boolean[] addBooleanArray(boolean[] arr, boolean data) {
		boolean[] newArr = new boolean[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
newArr[i] = arr[i];
		}
		newArr[newArr.length - 1] = data;
		return newArr;
	}

	public static Object inputData(Scanner sc, Object arr, String type) {
		System.out.print("Masukkan data: ");
		String input = sc.nextLine();

		int[] intArr = new int[0];
		float[] floatArr = new float[0];
		char[] charArr = new char[0];
		boolean[] boolArr = new boolean[0];

		if (type.equals("int")) intArr = (int[]) arr;
		if (type.equals("float")) floatArr = (float[]) arr;
		if (type.equals("char")) charArr = (char[]) arr;
		if (type.equals("bool")) boolArr = (boolean[]) arr;

		
		try {
			if (type.equals("int")) return addIntArray(intArr, Integer.parseInt(input));
			if (type.equals("float")) return addFloatArray(floatArr, Float.parseFloat(input));
		} catch (NumberFormatException e) {
			System.out.println("Masukkan angka yang valid!");
			return arr;
		}

		if (type.equals("char")) return addCharArray(charArr, input.charAt(0));
		if ((type.equals("bool") && (input.toLowerCase().equals("true")) || (input.toLowerCase().equals("false")))) return addBooleanArray(boolArr, Boolean.parseBoolean(input));
		return null;
	}

	public static Object addTenData(String type) {
		int[] intArr = {3, 1, 5, 2 , 10, 4, 7, 9, 8, 11};
		float[] floatArr = {12.5f, 3.8f, 99.1f, 45.2f, 7.7f, 28.9f, 61.3f, 14.6f, 82.4f, 0.1f};
		char[] charArr = {'a', 'z', 't', 'k', 'm', 'j', 'x', 'q', 'i', 'f'};
		boolean[] boolArr = {true, false, true, true, false, false, true, false, true, false};
		if (type.equals("int")) return intArr;
		if (type.equals("float")) return floatArr;
		if (type.equals("char")) return charArr;
		if (type.equals("bool")) return boolArr;

		return null;
	}

	public static Object addRandomData(Scanner sc, Object arr, String type, boolean showProcess){
		Random r = new Random();
		System.out.println("Masukkan jumlah data random: ");
		int limit = 0;
		try {
			limit = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Masukkan angka yang valid!");
			return arr;
		}

		if (type == "int") {
			int[] intArr = new int[0];
			for (int i = 0; i<=limit; i++) {
				int data = r.nextInt(100000);
				intArr = addIntArray(intArr, data);
				if (showProcess) System.out.println("Iterasi ["+i+"/"+limit+"] dengan data: "+data);

			}
			return intArr;
		}

		if (type == "float") {
			float[] floatArr = new float[0];
			for (int i = 0; i<=limit; i++) {
				float data = r.nextFloat() * 100000;
				floatArr = addFloatArray(floatArr, data);
				if (showProcess) System.out.println("Iterasi ["+i+"/"+limit+"] dengan data: "+data);

			}                                                                                                    return floatArr;
		}

		if (type == "char") {
			char[] charArr = new char[0];
			for (int i = 0; i<=limit; i++) {
				char data = (char) ('A' + r.nextInt(26));
				charArr = addCharArray(charArr, data);
				if (showProcess) System.out.println("Iterasi ["+i+"/"+limit+"] dengan data: "+data);

			}                                                                                                    return charArr;
		}

		if (type == "bool") {
			boolean[] boolArr = new boolean[0];
			for (int i = 0; i<=limit; i++) {                                                                             boolean data = r.nextBoolean();
				boolArr = addBooleanArray(boolArr, data);
				if (showProcess) System.out.println("Iterasi ["+i+"/"+limit+"] dengan data: "+data);

			}                                                                                                    return boolArr;
		}

		return null;
	}

}
