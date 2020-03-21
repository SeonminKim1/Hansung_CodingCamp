/*
 * ���� 4.ArrayInt Ŭ���� �ۼ��ϰ�, copy, compare, sum, toString, sort, merge �Լ� ���� 
 */
package Day01;

public class Problem_04_ArrayFunction {
	static void copy(int a[], int b[]) {
		for(int i=0; i<a.length; i++) {
			a[i]=b[i];
		}
		System.out.println("�� �迭 �� �迭�� ���� �Ϸ�");
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
		System.out.println("�� �迭�� ����? "+ n);
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
		System.out.println("\n���ĵ� �迭�� ");
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
		if(Problem_04_ArrayFunction.compare(x, y))System.out.println("�� �迭 ����");
		else System.out.println("�� �迭 �� ����");
		Problem_04_ArrayFunction.sum(x);
		System.out.println(Problem_04_ArrayFunction.toString(y));
		Problem_04_ArrayFunction.sort(x);
		Problem_04_ArrayFunction.merge(x, y);
		Problem_04_ArrayFunction.copy(x, y);
	}
}
