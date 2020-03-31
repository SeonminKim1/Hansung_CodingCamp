/*
 * ���� 37 : ��ǰ��� 
 */
package Day09;

import java.util.Scanner;
import java.util.Vector;

public class Problem_37_HangmanGame {
	private Vector<String> v = new Vector <String>(); 			
	private String[] s = {"apple","gracias","motherfather"};
	private StringBuffer QuestionWord;  					// stringBuffer�� replace�Լ����� ���ڿ� ���ڱ����� �ϸ� �Ǵµ� string�Լ��� ���ڿ��� �ؾߵǼ� stringbuffer�� ��.
	private StringBuffer ChangeWord;						// stringbuffer���� equals�� �� ���� 	k.toString().equals(k2.toString()) �̷������� �����. 
	private Scanner scanner = new Scanner(System.in);		// equals�� ���ڿ��� ���ϴ°ǵ� �̰� string�� �ƴ� stringbuffer�ϱ� equals���� tostring()���� ��ȯ�������.
	public Problem_37_HangmanGame() {
		for(int i=0; i<s.length; i++) {
			v.add(s[i]);
		}
		System.out.println("���ݺ��� ��� ������ �����մϴ�.");
		init();
		System.out.print("�� ĭ ���ٱ��? ");
		int n = scanner.nextInt();
		Makeword(n);
		while(true) {
			System.out.println(ChangeWord);
			System.out.print(">>");
			String ss = scanner.next();
			char s = ss.charAt(0);
			Check(s);
			if(QuestionWord.toString().equals(ChangeWord.toString())==true) {
				System.out.println("���߱� ���� !!");
				break;
			}
		}
	}
	
	public void init() { // �������� �ܾ� ����.
		int wordNum = (int)(Math.random()*s.length);
		QuestionWord=new StringBuffer(v.get(wordNum));
		System.out.println(QuestionWord);
		ChangeWord=new StringBuffer(QuestionWord);
		}
	
	public void Makeword(int n) { // '_' �� �ִ� ���ڷ� �ٲ���.
		int k=0;
		int i=0;
		while(i<n) {
			int m = (int)(Math.random()*QuestionWord.length());
			if(ChangeWord.charAt(m)=='_') {
				continue;
			}
			else{
				ChangeWord.replace(m,m+1, "_");
				i++;
			}
		}
	}
	
	public void Check(char s) {
		int k=0;
		for(int i=0; i<QuestionWord.length(); i++) {
			if(QuestionWord.charAt(i)==s && ChangeWord.charAt(i)=='_') {
				ChangeWord.replace(i,i+1, Character.toString(s)); 
				k=1; break;
			}
		}
		if(k==0)System.out.println("�� ���� !");
	}
	
	public static void main(String[] args) {
		new Problem_37_HangmanGame();
	}

}
