/*
 * 문제  39 : array 연습
 */

package Day09;

public class Problem_39_Array_Practice {
	public Problem_39_Array_Practice() {
		int matrix[][]=new int[3][];
		int x=3, y=4, k=5;
			matrix[0]=new int [x];
			matrix[1]=new int [y];
			matrix[2]=new int [k];
		int n=1;
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				matrix[i][j]=n;
				System.out.print(n+" ");
				n++;
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		new Problem_39_Array_Practice();
	}
}
