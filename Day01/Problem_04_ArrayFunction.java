/*
 * 문제 4.ArrayInt 클래스 작성하고, copy, compare, sum, toString, sort, merge 함수 구현 
 */
package Day01;

public class Problem_04_ArrayFunction {
	static void copy(int a[], int b[]) {
		for(int i=0; i<a.length; i++) {
			a[i]=b[i];
		}
		System.out.println("뒤 배열 앞 배열에 복사 완료");
	} // copy
	static boolean compare(int a[], int b[]) {
		for(int i=0; i<a.length; i++) {
			if(a[i]!=b[i])return false;
		}
		return true;
	} // compare
	static void sum(int a[]) {
		int n=0;
		for(int i=0; i<a.length; i++) {
			n = n+a[i];
		}
		System.out.println("앞 배열의 합은? "+ n);
	} // sum
	static String toString(int a[]) {
		String str="";
		for (int i=0; i<a.length; i++) {
			str = str + a[i];
		}
		return str;
	} // toString
	static void sort(int a[]) {
		for(int i=1; i<=a.length-1; i++){
			for(int j=0; j<i; j++) {
				if(a[j]>a[j+1]) {
					int tmp=a[j];
					a[j]=a[j+1];
					a[j+1]=tmp;
				}
			}
		}
		System.out.println("\n정렬된 배열은 ");
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	} //sort
	
	static void merge(int a[], int b[]) {
		int size=a.length+b.length;
		int c[]=new int[size];
		int i=0;
		
		for(i=0; i<a.length; i++) {
			c[i]=a[i];
		}
		
		for(int j=i; j<b.length+i; j++) {
			c[j]=b[j-i];
		}
		sort(c);
	}
	public static void main(String[] args) {
		int x[]= {7,5,6};
		int y[]= {4,5,6};
		if(Problem_04_ArrayFunction.compare(x, y))System.out.println("두 배열 같음");
		else System.out.println("두 배열 안 같음");
		Problem_04_ArrayFunction.sum(x);
		System.out.println(Problem_04_ArrayFunction.toString(y));
		Problem_04_ArrayFunction.sort(x);
		Problem_04_ArrayFunction.merge(x, y);
		Problem_04_ArrayFunction.copy(x, y);
	}
}
