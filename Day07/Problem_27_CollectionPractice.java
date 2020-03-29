/*
 * ���� 27 : ArrayList & �÷��� ����
 */
package Day07;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem_27_CollectionPractice {
	private int x;
	private int y;
	public Problem_27_CollectionPractice(int x, int y) {
		this.x=x; this.y=y;
	}
	public double getDistance(int prevx, int prevy) {
		return Math.sqrt(((x-prevx)*(x-prevx))+((y-prevy)*(y-prevy)));
	}
	
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�㰡 �̵��� ��ġ(x,y)�� 5�� �Է��϶�");
		//Q27 q27[]=new Q27[5];
		ArrayList<Problem_27_CollectionPractice> a = new ArrayList<Problem_27_CollectionPractice>();
		int prevx=0, prevy=0;
		double sum=0;
		for(int i=0; i<6; i++) {
			if(i<5) {
				System.out.print(">>");	
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				a.add(new Problem_27_CollectionPractice(x,y));
				System.out.println("������ǥ:(" + prevx+","+ prevy+")����  ������ǥ:("+x+","+y+")���� ������!!");	
				sum=sum+a.get(i).getDistance(prevx,prevy);			
				prevx=x; 											// �������� ��ǥ�� ������ǥ�� �־���.
				prevy=y;											// �������� ��ǥ�� ������ǥ�� �־���.
				System.out.println("�㰡 ������� ������ �Ÿ� !!" + sum);
			}
				else if (i==5) {
					System.out.println("������ǥ:(" + prevx+","+ prevy+")����  ������ǥ:(0,0)���� ������!!");
					a.add(new Problem_27_CollectionPractice(0,0));
					sum=sum+a.get(i).getDistance(prevx,prevy);			
				}
			}
	System.out.println("�㰡 ���� ������ �Ÿ��� " +sum);
	}

}
