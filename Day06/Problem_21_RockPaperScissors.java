/*
 * ����  21 : ���������� 
 */

package Day06;

import java.util.Scanner;

public class Problem_21_RockPaperScissors {
	public Problem_21_RockPaperScissors() {
		System.out.println("��ǻ�Ϳ� ���� ���� �� ������ �մϴ�.");
		Scanner scanner = new Scanner(System.in);
		while(true) {
		System.out.println("���� ���� �� !!->");
		String my = scanner.next();
		
		String com[] = {"����","����","��"};
		
		String a = com[(int)(Math.random()*2)];
		System.out.println("��ǻ��:"+a+"  �����:"+my);
		if(a.equals("����") && my.equals("����"))System.out.println("���");
		else if(a.equals("����") && my.equals("����"))System.out.println("�̱�");
		else if(a.equals("����") && my.equals("��"))System.out.println("��");
		else if(a.equals("����") && my.equals("����"))System.out.println("��");
		else if(a.equals("����") && my.equals("����"))System.out.println("���");
		else if(a.equals("����") && my.equals("��"))System.out.println("�̱�");
		else if(a.equals("��") && my.equals("����"))System.out.println("�̱�");
		else if(a.equals("��") && my.equals("����"))System.out.println("��");
		else if(a.equals("��") && my.equals("��"))System.out.println("���");
		else if(my.equals("�׸�"))break;
		else System.out.println("�ٽ�!!");
		}
	}
	public static void main(String[] args) {
		new Problem_21_RockPaperScissors();
	}
}
