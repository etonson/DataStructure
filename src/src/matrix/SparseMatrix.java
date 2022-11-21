package src.matrix;

public class SparseMatrix {

	public static void main(String[] args) {
		int[][] sparse = { { 0, 0, 0, 27, 0 }, { 0, 0, 13, 0, 0 }, { 0, 41, 0, 0, 36 }, { 52, 0, 9, 0, 0 },
				{ 0, 0, 0, 18, 0 } };
		int nonZeroNumber = 0;
		int j, k;
		int sparseMatrixRow = sparse.length;
		int sparseMatrixColumn = sparse[0].length;
		for (j = 0; j < sparseMatrixRow; j++) {
			for (k = 0; k < sparseMatrixColumn; k++) {
				System.out.print(String.format("%3d |", sparse[j][k]));
				if(sparse[j][k] !=0) 
				{
					nonZeroNumber+=1;
				}
			}
			System.out.println();
		}
		
		int matrixRaw=1;
		int[][] matrix = new int[nonZeroNumber+1][3];
		matrix[0][0] = sparseMatrixRow;
		matrix[0][1] = sparseMatrixColumn;
		matrix[0][2] = nonZeroNumber;
		for (j = 0; j < sparseMatrixRow; j++) {
			for (k = 0; k < sparseMatrixColumn; k++) {
				if(sparse[j][k] !=0) 
				{
					matrix[matrixRaw][0] = j+1;
					matrix[matrixRaw][1] = k+1;
					matrix[matrixRaw][2] = sparse[j][k];
					matrixRaw+=1;
				}
			}
		}
		System.out.println("--------³B²z«á--------");
		for (j = 0; j < nonZeroNumber+1; j++) {
			for (k = 0; k < 3; k++) {
				System.out.print(String.format("%3d |", matrix[j][k]));
			}
			System.out.println();
		}
	}
}
