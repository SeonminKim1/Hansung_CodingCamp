/*
 * 문제  41 : 배열 최댓값과 합계 구하기 
 */
package Day09;

import java.util.Scanner;

public class Problem_41_Array_Max_Sum {
	public Problem_41_Array_Max_Sum(double arr[]) {
		Scanner scanner = new Scanner(System.in);
		double sum=0;
		double max=arr[0];
		for(int i=0; i<4; i++) {
			sum=sum+arr[i];
			if(max<arr[i]) {
				arr[i]=max;
			}
		}
		System.out.println("합은 "+sum);
		System.out.println("최댓값은 " + max);
	
	}
	
	
	public static void main(String[] args) {
		double arr[]= {100.2,200.3,401.7,52.0};
		
			Problem_41_Array_Max_Sum q41 = new Problem_41_Array_Max_Sum(arr);
	}
}
