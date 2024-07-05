package lab1;

public class Exercise1 {

	public static int[][] matrixProduct (int[][] A, int[][] B) {
		
		int n = A.length; 
		int[][] C = new int[n][n];
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				for (int k=0; k<n; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		
		return C; 
	}
	
	public static void main(String[] args) {
		
		// Example matrices
        int[][] A = {
            {0, 3, 1},
            {2, 1, -2},
            {0, 3, 3}
        };
        
        int[][] B = {
            {4, 1, 0},
            {0, 5, -1},
            {-3, 2, 3}
        };
        
        int[][] C = matrixProduct(A, B);
        
        System.out.println("Resulting Matrix:");
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[i].length; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }

	}

}
