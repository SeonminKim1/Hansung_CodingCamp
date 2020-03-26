/*
 * 문제  18 : 돈의 액수 입력받아서 지폐교환 갯수출력 
 */

package Day05;

import java.util.*;

public class Problem_18_MoneyChange {
	public Problem_18_MoneyChange() {
		System.out.println("돈의 액수를 입력하세요>>");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int a50000 = a/50000;
		int a10000 = (a%50000)/10000;
		int a1000 = ((a%50000)%10000)/1000;
		int a500 = (((a%50000)%10000)%1000)/500;
		int a100 = ((((a%50000)%10000)%1000)%500)/100;
		int a10 = (((((a%50000)%10000)%1000)%500)%100)/10;
		int a1 = (((((a%50000)%10000)%1000)%500)%100)%10;
		System.out.println("동전의 갯수는 50000원짜리 " + a50000 +"  10000원짜리 " + a10000 + "  1000원짜리 " + a1000 +"  500원짜리" + a500 +"  100원짜리" + a100+"  10원짜리 "+a10+"  1원짜리 "+a1);
		
	}
	public static void main(String[] args) {
		new Problem_18_MoneyChange();
	}

}
