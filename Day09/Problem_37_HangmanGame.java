/*
 * 문제 37 : 행맨게임 
 */
package Day09;

import java.util.Scanner;
import java.util.Vector;

public class Problem_37_HangmanGame {
	private Vector<String> v = new Vector <String>(); 			
	private String[] s = {"apple","gracias","motherfather"};
	private StringBuffer QuestionWord;  					// stringBuffer는 replace함수에서 숫자와 숫자까지로 하면 되는데 string함수는 문자열로 해야되서 stringbuffer로 씀.
	private StringBuffer ChangeWord;						// stringbuffer에서 equals를 쓸 때는 	k.toString().equals(k2.toString()) 이런식으로 써야함. 
	private Scanner scanner = new Scanner(System.in);		// equals는 문자열을 비교하는건데 이건 string이 아닌 stringbuffer니까 equals전에 tostring()으로 변환해줘야함.
	public Problem_37_HangmanGame() {
		for(int i=0; i<s.length; i++) {
			v.add(s[i]);
		}
		System.out.println("지금부터 행맨 게임을 시작합니다.");
		init();
		System.out.print("몇 칸 없앨까요? ");
		int n = scanner.nextInt();
		Makeword(n);
		while(true) {
			System.out.println(ChangeWord);
			System.out.print(">>");
			String ss = scanner.next();
			char s = ss.charAt(0);
			Check(s);
			if(QuestionWord.toString().equals(ChangeWord.toString())==true) {
				System.out.println("맞추기 성공 !!");
				break;
			}
		}
	}
	
	public void init() { // 랜덤으로 단어 정함.
		int wordNum = (int)(Math.random()*s.length);
		QuestionWord=new StringBuffer(v.get(wordNum));
		System.out.println(QuestionWord);
		ChangeWord=new StringBuffer(QuestionWord);
		}
	
	public void Makeword(int n) { // '_' 가 있는 글자로 바꿔줌.
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
		if(k==0)System.out.println("떙 없어 !");
	}
	
	public static void main(String[] args) {
		new Problem_37_HangmanGame();
	}

}
