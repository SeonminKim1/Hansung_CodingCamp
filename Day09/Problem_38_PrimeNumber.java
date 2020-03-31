/*
 * 문제 38 : 10이상 50이하 소수 출력
 */

package Day09;

public class Problem_38_PrimeNumber {
	public Problem_38_PrimeNumber() {
		int n=0;
		int m=0;
		int sum=0;
		for(int i=10; i<=50; i++) {
			sum=0;
			for(int j=2; j<i; j++) {
				if(i%j==0) {
					sum=1;
					break;
				}
			}
			if(sum==0)System.out.print(i+" ");
		}
	}
	
	public static void main(String[] args) {
		new Problem_38_PrimeNumber();
	}
}
