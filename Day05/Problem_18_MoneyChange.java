/*
 * ����  18 : ���� �׼� �Է¹޾Ƽ� ����ȯ ������� 
 */

package Day05;

import java.util.*;

public class Problem_18_MoneyChange {
	public Problem_18_MoneyChange() {
		System.out.println("���� �׼��� �Է��ϼ���>>");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int a50000 = a/50000;
		int a10000 = (a%50000)/10000;
		int a1000 = ((a%50000)%10000)/1000;
		int a500 = (((a%50000)%10000)%1000)/500;
		int a100 = ((((a%50000)%10000)%1000)%500)/100;
		int a10 = (((((a%50000)%10000)%1000)%500)%100)/10;
		int a1 = (((((a%50000)%10000)%1000)%500)%100)%10;
		System.out.println("������ ������ 50000��¥�� " + a50000 +"  10000��¥�� " + a10000 + "  1000��¥�� " + a1000 +"  500��¥��" + a500 +"  100��¥��" + a100+"  10��¥�� "+a10+"  1��¥�� "+a1);
		
	}
	public static void main(String[] args) {
		new Problem_18_MoneyChange();
	}

}
