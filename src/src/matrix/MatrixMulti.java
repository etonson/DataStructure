package src.matrix;

public class MatrixMulti {

	public static void main(String[] args) {
		int[][] ary1 = { { 1,2 }, { 3,4 }, { 5,6 } };
		int[][] ary2 = { { 7,9,11 }, { 8,10,12 } };
		matrixMulti(ary1, ary2);
	}

	static void matrixMulti(int[][] leftArray, int[][] rightArray) {
		int leftArrayColumn = leftArray[0].length;
		int leftArrayRow = leftArray.length;
		int rightArrayColumn = rightArray[0].length;

		int[][] matrix = new int[leftArrayRow][rightArrayColumn];
		for (int j = 0; j < leftArrayRow; j++) {
			for (int k = 0; k < rightArrayColumn; k++) {
				for (int m = 0; m < leftArrayColumn; m++) {
					matrix[j][k] += leftArray[j][m] * rightArray[m][k];
				}
				System.out.print(matrix[j][k] + "|");
			}
			System.out.println();
		}

	}
}
