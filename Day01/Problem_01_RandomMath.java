
/*
 * ���� 1. 100���� 200 ������ ���� 10���� �����ϰ� �����Ͽ� �迭�� �����ϰ� ��տ� ����϶�
 */
package Day01;

import java.util.*;

public class Problem_01_RandomMath {
	Scanner scanner;
	public Problem_01_RandomMath() {
		scanner = new Scanner(System.in);
		System.out.println("���� � ���� �����Ҳ��� ? ");
		int n = scanner.nextInt();
		int array[] = new int[n];
		System.out.println("���� " + n + "�� ����");
		for(int i=0; i<n; i++) {
			array[i]=(int) ((Math.random())*100) + 100;
			System.out.print(array[i] + " ");
		}
	}
	public static void main(String[] args) {
		new Problem_01_RandomMath();
	}
}
