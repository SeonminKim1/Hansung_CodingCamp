/*
 * 문제  42 : 이중반복문 사용 
 */

package Day09;

public class Problem_42_DoubleLoop {
	public Problem_42_DoubleLoop() {
		int h=1;
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(j<10-h)System.out.print(" ");
				else System.out.print(j);
			}
			System.out.print(" ");
			for(int k=0; k<10; k++) {
				if(k<h-1)System.out.print(" ");
				else System.out.print(k);
			}
			System.out.println();
			h++;
		}
	}
	public static void main(String args[]) {
		new Problem_42_DoubleLoop();
	}
}
