/*
 * 문제  25 : StringTokenizer / Interger.parseInt() / String trim() 연습 
 */
package Day06;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem_25_StringTokenizerPractice {
	public Problem_25_StringTokenizerPractice() {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		StringTokenizer st = new StringTokenizer(a,"+");
		int count = st.countTokens();
		int sum=0;
		for(int i=0; i<count; i++) {
			String token = st.nextToken();
			sum=sum+Integer.parseInt(token.trim());
		}
		System.out.println("합은 "+sum);
	}
	public static void main(String[] args) {
		new Problem_25_StringTokenizerPractice();
	}

}
