package app.utils;

public class Outputs {

	public void print(String text) {
		System.out.println(text);
	}

	public void placeholder(String text) {
		System.out.print(text);
	}

	public void dangerText(String text) {
		System.err.println(text);
	}
}
