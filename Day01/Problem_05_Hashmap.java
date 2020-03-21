/*
 * 문제 도시와 인구를 10개 입력받아 HashMap에 저장하고, 도시를 입력받아 인구를 출력하라
 */
package Day01;

import java.util.HashMap;
import java.util.Scanner;

public class Problem_05_Hashmap {	
	Scanner scanner = new Scanner(System.in);
	public Problem_05_Hashmap() {
		HashMap<String, Integer> h = new HashMap<String, Integer>();
		for(int i=0; i<5; i++) {
			System.out.println(i+1+"번째 도시와 인구를 입력하세요");
			String city = scanner.next();
			int n = scanner.nextInt();
			h.put(city,n);
		}
		
		while(true) {
			System.out.println("도시를 하나 입력받아 인구를 출력하세요");
			String m = scanner.next();
			System.out.println("인구수는" + h.get(m));
		}
	}
	public static void main(String args[]) {
	new Problem_05_Hashmap();	
	}
}