/*
 * ���� ���ÿ� �α��� 10�� �Է¹޾� HashMap�� �����ϰ�, ���ø� �Է¹޾� �α��� ����϶�
 */
package Day01;

import java.util.HashMap;
import java.util.Scanner;

public class Problem_05_Hashmap {	
	Scanner scanner = new Scanner(System.in);
	public Problem_05_Hashmap() {
		HashMap<String, Integer> h = new HashMap<String, Integer>();
		for(int i=0; i<5; i++) {
			System.out.println(i+1+"��° ���ÿ� �α��� �Է��ϼ���");
			String city = scanner.next();
			int n = scanner.nextInt();
			h.put(city,n);
		}
		
		while(true) {
			System.out.println("���ø� �ϳ� �Է¹޾� �α��� ����ϼ���");
			String m = scanner.next();
			System.out.println("�α�����" + h.get(m));
		}
	}
	public static void main(String args[]) {
	new Problem_05_Hashmap();	
	}
}