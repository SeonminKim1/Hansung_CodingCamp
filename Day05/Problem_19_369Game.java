/*
 * ���� 19 : 369���� 
 */

package Day05;

import java.util.Scanner;

public class Problem_19_369Game {

	public Problem_19_369Game() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
		System.out.println("1~99 ������ ������ �Է��ϼ���");
		int num = scanner.nextInt();
		int frontnum= num/10;
		int backnum = num%10;
		int a = checknum(frontnum,backnum);
		if(a==0)System.out.println("�ڼ�����");
		else if (a==1)System.out.println("�ڼ�¦");
		else System.out.println("�ڼ�¦¦");
		}
		}
	public int checknum(int n1, int n2) {
		int num=0;
		for(int i=3; i<=9; i=i+3) {
			if(n1==i)num++;
			if(n2==i)num++;
		}
		return num;
	}
	public static void main(String[] args) {
		new Problem_19_369Game();
	}

}
