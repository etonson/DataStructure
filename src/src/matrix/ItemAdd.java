package src.matrix;

public class ItemAdd {

	public static void main(String[] args) {
		int[][] ary1 = { { 5, 3, 2 }, { 11, 7, 3 }, { 9, 13, 15 } };
		int[][] ary2 = { { 1, 6, 8 }, { 4, 12, 16 }, { 9, 18, 21 } };
		itemAdd(ary1,ary2);
	}

	static void itemAdd(int[][] ary1, int[][] ary2) {
		int[][] matrix = new int[3][3];
		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 3; k++) {
				matrix[j][k] = ary1[j][k] + ary2[j][k];
				System.out.print(matrix[j][k]+"|");
			}
			System.out.println();
		}
	}
}
