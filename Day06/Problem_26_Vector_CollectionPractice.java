/*
 * ���� 26 : ���� & �÷��� ����
 */

package Day06;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;
// v Ű ����    v2 Ű ���� ����
public class Problem_26_Vector_CollectionPractice {
	public Problem_26_Vector_CollectionPractice() {
		System.out.println("2000~2009����� 1�� ������ Ű(cm)�� �Է�");
		Vector <Float> v = new Vector<Float>();
		Vector <Float> v2= new Vector<Float>();
		Scanner scanner = new Scanner(System.in);
		
		for(int i=0; i<10; i++) {
			Float n = scanner.nextFloat();
			v.add(n);
		}
		for(int i=0; i<9; i++) {
			v2.add(v.get(i+1)-v.get(i));
//			System.out.print(v2.get(i) + " "); 
		}
		
		Iterator<Float> it = v2.iterator();
		
		Float max=v2.get(0);
		int j = 0;
		int index=0; // �����ڶ� �ε���
		while(it.hasNext()) {
			Float num=it.next();
			if(num>=max) {
				max=num;
				System.out.println();
				index=j;
			}
			j++;
		}
		int year = 2000+index;
		System.out.println("Ű�� ���� ���� �ڶ��⵵�� "+year);
	}
	public static void main(String[] args) {
		new Problem_26_Vector_CollectionPractice();
	}
}
