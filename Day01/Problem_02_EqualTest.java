/*
 * ����2. �� ���� ���� �迭�� ������ �Ǻ��ϴ� equalInt�� �ۼ��ϰ� �� ���� ���� �迭�� ����� ȣ���Ͽ� �Ǻ��϶�
 */

package Day01;

import java.util.Scanner;

public class Problem_02_EqualTest {
	Scanner scanner;
	public Problem_02_EqualTest() {
		while(true) {
		scanner = new Scanner(System.in);
		System.out.println("ù��° �����迭 3��¥�� �Է���!!");
		int f1[] = new int[3];
		int f2[] = new int[3];
		for(int i=0; i<f1.length; i++) {
			f1[i]=scanner.nextInt();
		}
		System.out.println("�ι�° �����迭 3��¥�� �Է���!!");
		for(int i=0; i<f2.length; i++) {
			f2[i]=scanner.nextInt();
		}
		if(equallInt(f1,f2))System.out.println("�� �迭�� �����ϴ�\n");
		else System.out.println("�� �迭�� ���� �ʽ��ϴ�\n");
		}
	}
	
	public boolean equallInt(int f1[], int f2[]) {
		for(int i=0; i<f1.length; i++) {
			if(f1[i]!=f2[i])return false;
		}
		return true;
	}
	public static void main(String[] args) {
		new Problem_02_EqualTest();
	}
}
