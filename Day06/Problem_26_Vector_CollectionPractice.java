/*
 * 문제 26 : 벡터 & 컬렉션 연습
 */

package Day06;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;
// v 키 벡터    v2 키 차이 벡터
public class Problem_26_Vector_CollectionPractice {
	public Problem_26_Vector_CollectionPractice() {
		System.out.println("2000~2009년까지 1년 단위로 키(cm)를 입력");
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
		int index=0; // 많이자란 인덱스
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
		System.out.println("키가 가장 많이 자란년도는 "+year);
	}
	public static void main(String[] args) {
		new Problem_26_Vector_CollectionPractice();
	}
}
