/*
 * 문제 40 : 특정 숫자 갯수 파악해서 리턴 
 */
package Day09;

public class Problem_40_SearchNumber {
	private int arr[];
	private int n=0;
	public Problem_40_SearchNumber(int arr[]) {
		this.arr=arr;
	}
	public int OnetoZero() {
		int sum=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==1) {
				sum++;
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		int arr[]= {1,3,4,5,1,1,7};
		Problem_40_SearchNumber q40 = new Problem_40_SearchNumber(arr);
		System.out.println("1의 갯수는 " + q40.OnetoZero());
	}
}
