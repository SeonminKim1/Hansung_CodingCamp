
/*
 * 문제 1. 100에서 200 사이의 수자 10개를 랜덤하게 생성하여 배열에 저장하고 평균에 출력하라
 */
package Day01;

import java.util.*;

public class Problem_01_RandomMath {
	Scanner scanner;
	public Problem_01_RandomMath() {
		scanner = new Scanner(System.in);
		System.out.println("숫자 몇개 랜덤 생성할꺼야 ? ");
		int n = scanner.nextInt();
		int array[] = new int[n];
		System.out.println("숫자 " + n + "개 생성");
		for(int i=0; i<n; i++) {
			array[i]=(int) ((Math.random())*100) + 100;
			System.out.print(array[i] + " ");
		}
	}
	public static void main(String[] args) {
		new Problem_01_RandomMath();
	}
}
