package src.matrix;

public class Trans {

	public static void main(String[] args) {
		int[][] ary1 = { { 11, 12, 13, 14 }, { 22, 24, 26, 28 }, { 33, 36, 39, 41 } };
		int[][] ary2 = new int[4][3];
		Transpose(ary1, ary2);

	}

	static void Transpose(int[][] ary1, int[][] ary2) {
		int ary1Raw = ary1.length;
		System.out.println("ary1Raw: " + ary1Raw);
		int ary1Column = ary1[0].length;
		for (int j = 0; j < ary1Raw; j++) {
			for (int k = 0; k < ary1Column; k++) {
				ary2[k][j] = ary1[j][k];
			}
		}

		for (int i = 0; i < ary2.length; i++) {
			for (int j = 0; j < ary2[i].length; j++) {
				System.out.print(ary2[i][j] + "|");
			}
			System.out.println();
		}

	}
}
