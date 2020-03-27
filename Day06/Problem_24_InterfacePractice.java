/*
 * 문제 24 : 인터페이스 
 */
package Day06;

interface AdderInterface{
	int add(int x, int y);
	int add(int n);
}

public class Problem_24_InterfacePractice implements AdderInterface{	
	public int add(int x, int y) {
		return x+y;
	}
	public int add(int n) {
		return (int)(n*5.5);
	}
	public static void main(String[] args) {
		Problem_24_InterfacePractice q24 = new Problem_24_InterfacePractice();
		System.out.println(q24.add(5,10));
		System.out.println(q24.add(10));
	}
}


