/*
 * ���� 6 : ��ȭ��ȣ�� ����� 
 */
package Day02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Problem_06_PhoneBook {
	private HashMap<String, String> h = new HashMap<String, String>();
	private Scanner scanner;

	public Problem_06_PhoneBook() {
		while (true) {
			scanner = new Scanner(System.in);
			System.out.println("\n<---��ȭ��ȣ��--->");
			System.out.println("1. ����");
			System.out.println("2. ����");
			System.out.println("3. ������");
			System.out.println("4. �˻�");
			System.out.println("5. ����");
			System.out.println("���� ���� �Ǿ� �ִ� �ο� " + h.size());
			int n = scanner.nextInt();
			switch (n) {
			case 1:
				add();
				break;
			case 2:
				del();
				break;
			case 3:
				print();
				break;
			case 4:
				search();
				break;
			case 5:
				FileWrite_Read();
				break;
			default:
				System.out.println("�ٽ� �Է��ϼ���");
			}
		}
	}

	public void add() { // ��ȭ��ȣ�� �߰�
		System.out.print("�̸��� �Է��ϼ��� ");
		String n = scanner.next();
		System.out.println("��ȭ��ȣ�� ���ڸ��� �Է��ϼ���");
		String num = scanner.next();
		h.put(n, num);
		System.out.println("���� �Ϸ�Ǿ����ϴ�!!");
	}

	public void del() { // ��ȭ��ȣ�� ����
		System.out.println("������ �̸��� �Է��ϼ��� ");
		String name = scanner.next();
		h.remove(name);
		System.out.println("���� �Ϸ� �Ǿ����ϴ� !! ");
	}

	public void print() { // ��ȭ��ȣ�� ��� ���
		Set<String> keys = h.keySet(); // key���ڿ��� ���� ���� set�÷��� ����
		Iterator<String> it = keys.iterator(); // key���ڿ��� ������� ������ �� �ִ� iterator ����.
		while (it.hasNext()) {
			String key = it.next();
			String telnum = h.get(key);
			System.out.println("�̸���  " + key + "  ��ȣ�� " + telnum);
		}
		System.out.println("��� �Ϸ�Ǿ����ϴ� !!");
	}

	public void search() { // ��ȭ��ȣ�� �˻� ���
		scanner = new Scanner(System.in);
		System.out.println("ã�� ���� �̸� �Է��ϼ���");
		String searchName = scanner.next();
		System.out.println("��ȭ��ȣ�� " + h.get(searchName));
		System.out.println("�˻� �Ϸ�Ǿ����ϴ�. !!!");
	}

	public void FileWrite_Read() {
		System.out.println("1. ��ȭ��ȣ�ο��� ���Ͽ�  �����ϱ�");
		System.out.println("2. ���Ͽ��� �о ��ȭ��ȣ�ο� �����ϱ�");
		int num = scanner.nextInt();
		
		switch (num) {
		case 1:
			try {
				FileWriter fw = new FileWriter("c:\\tel2.txt");
				Set<String> keys = h.keySet(); // key���ڿ��� ���� ���� set�÷��� ����
				Iterator<String> it = keys.iterator(); // key���ڿ��� ������� ������ �� �ִ� iterator ����.
				while (it.hasNext()) {
					String key = it.next();
					String telnum = h.get(key);
					fw.write(key+" "+telnum+"\r\n");
					System.out.println("���Ͽ� ����Ϸ�.");
				}
				fw.close(); // �����ϰ� �ݱ�.
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case 2:
			String data;
			String arr[];

			try {
				Scanner fs = new Scanner(new File("C:\\tel.txt"));	
				while (fs.hasNextLine()) {
					data = fs.nextLine();		
					arr = data.split(" ");
					h.put(arr[0], arr[1]);
				}
				System.out.println("���� ���ۿϷ�..");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}

	public static void main(String args[]) {
		new Problem_06_PhoneBook();
	}
}
