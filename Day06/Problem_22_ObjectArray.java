/*
 * ���� 22 : ��ü�迭  
 */
package Day06;

import java.util.Scanner;

public class Problem_22_ObjectArray {
	private String name;
	private String tel;
	public Problem_22_ObjectArray(String name, String tel) {
		this.name= name;
		this.tel = tel;
	}
	public String getName() {return name;}
	public String getTel() {return tel;}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name[] = new String[2];
		String tel[] = new String[2];
		Problem_22_ObjectArray q22[] = new Problem_22_ObjectArray[2];
		System.out.println("�̸��� ��ȭ��ȣ�� �Է��ϼ��� (2��)");
		for(int i=0; i<2; i++) {
			name[i] = scanner.next();
			tel[i] = scanner.next();
			q22[i] = new Problem_22_ObjectArray(name[i],tel[i]);
		}
		
		for(int i=0; i<2; i++) {
			System.out.println(q22[i].name+"�� ��ȣ "+q22[i].tel);	
		}
	}

}
