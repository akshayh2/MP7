import java.util.Scanner;
/**Using Gauss Elimination to solve multidimensional equations**/
public class EquationSolver {
	public static void main(String[] args) {
		System.out.println("============================================================================");
		Scanner inputReader = new Scanner(System.in);
		System.out.println("Put in the dimensions of the matrix");
		int dimension = inputReader.nextInt();
		System.out.println("This is a " + dimension + " dimensions matrix");
		System.out.println("please put in the coefficients of each term and the result of each equation");
		double[][] originalMatrix = new double[dimension][dimension+1];
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension+1; j++) {
				originalMatrix[i][j]=inputReader.nextDouble();
			}
		}
		System.out.println("============================================================================");
		System.out.println("Before applying Gauss Elimination");
		printMatrix(dimension,originalMatrix);
		Gauss(dimension,originalMatrix);
		System.out.println("After applying Gauss Elimination");
		printMatrix(dimension,originalMatrix);
		getResult(dimension,originalMatrix);
		
	}
	private static void changeRow(int n, int k, double[][] matrix) {
		  double[] temp = new double[n + 1];
		  // if()
		  for (int i = k; i < n; i++) {
		   if (i + 1 == n && matrix[k][k] == 0) {
		    System.out.println("No solution or Mutiple solutions");
		    System.exit(1);
		   }
		   for (int j = 0; j < n + 1; j++) {
		    temp[j] = matrix[k][j];
		    matrix[k][j] = matrix[i + 1][j];
		    matrix[i + 1][j] = temp[j];
		   }
		   if (matrix[k][k] != 0)
		    return;
		  }
		 }
	/**Applying Guass Elimination**/
	public static void Gauss(int n, double[][] matrix) {
		for (int k = 0; k < n; k++) {
			   if (matrix[k][k] == 0) {
			    changeRow(n, k, matrix);
			   }
			   for (int i = 0; i < n; i++) {
			    double temp = matrix[i][k];
			    for (int j = 0; j < n + 1; j++) {
			     if (i < k)
			      break;
			     if (temp == 0)
			      continue;
			     if (temp != 1) {
			      matrix[i][j] /= temp;
			     }
			     if (i > k)
			      matrix[i][j] -= matrix[k][j];
			    }
			   }
			  }
	}
	/**Get the answer
	 * @return return the solution of the multidimensional equations
	 * **/ 
	private static double[] getResult(int n, double[][] matrix) {
		  double[] result = new double[n];
		  for (int i = n - 1; i >= 0; i--) {
		   double temp = matrix[i][n];
		   for (int j = n - 1; j >= 0; j--) {
		    if (i < j && matrix[i][j] != 0) {
		     temp = temp - result[j] * matrix[i][j];
		    }
		   }
		   temp /= matrix[i][i];
		   result[i] = temp;
		  }
		  for (int k = 0; k < result.length; k++) {
		   System.out.println("X" + (k + 1) + " = " + result[k]);
		  }
		  return result;
		 }
	/**print the matrix**/
	public static void printMatrix(int n, double[][] matrix) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n+1; j++) {
				if(j==n) {
					System.out.print("= "+matrix[i][j]);
				}else {
				System.out.print("(" + matrix[i][j] + ") * X" + (j + 1)+ " + ");
				}
			}
			System.out.println();
		}
		System.out.println("============================================================================");
	}
}
