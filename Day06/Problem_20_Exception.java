/*
 * ���� 20 : ����ó�� 
 */

package Day06;

import java.util.Scanner;

public class Problem_20_Exception {
	public Problem_20_Exception() {
		String day[]= {"��","��","ȭ","��","��","��","��"};
		while(true) {
		System.out.println("������ �Է��ϼ���(0-6)");
		Scanner scanner = new Scanner(System.in);
		String num = scanner.next();
		int n=Integer.parseInt(num);
		if(n<0) {
			System.out.println("�����մϴ�....");break;
		} 
		else if (n%7>=0 && n%7<7)System.out.println(day[n%7]);
		else System.out.println("���! ���� �Է����� �ʾҽ��ϴ�. !");
		}
	}
	public static void main(String args[]) {
		new Problem_20_Exception();
	}
}
