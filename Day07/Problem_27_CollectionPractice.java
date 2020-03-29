/*
 * 문제 27 : ArrayList & 컬렉션 연습
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
		System.out.println("쥐가 이동한 위치(x,y)를 5개 입력하라");
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
				System.out.println("이전좌표:(" + prevx+","+ prevy+")부터  현재좌표:("+x+","+y+")까지 움직임!!");	
				sum=sum+a.get(i).getDistance(prevx,prevy);			
				prevx=x; 											// 지금현재 좌표를 이전좌표로 넣어줌.
				prevy=y;											// 지금현재 좌표를 이전좌표로 넣어줌.
				System.out.println("쥐가 현재까지 움직인 거리 !!" + sum);
			}
				else if (i==5) {
					System.out.println("이전좌표:(" + prevx+","+ prevy+")부터  현재좌표:(0,0)까지 움직임!!");
					a.add(new Problem_27_CollectionPractice(0,0));
					sum=sum+a.get(i).getDistance(prevx,prevy);			
				}
			}
	System.out.println("쥐가 최종 움직인 거리는 " +sum);
	}

}
