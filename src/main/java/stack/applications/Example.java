package stack.applications;

public class Example {

	public static void main(String[] args) {
		int i = 1;
		tt(i);
	}

	static boolean tt(int j) {
		System.out.println(j);
		if (j < 10) {
			return true;
		}
		if (tt(j + 1)) {
			return true;
		}
		return false;
	}
}
