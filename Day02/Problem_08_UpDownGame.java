/*
 * 문제 8 : UP DOWN 게임 만들기. 스윙이용
 */

package Day02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Problem_08_UpDownGame extends JFrame{
	private int num;
	private int front=0, end=99;
	public Problem_08_UpDownGame() {
		setTitle("UP & DOWN 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		num=(int)(Math.random()*100);
		String a;
		
		Container c = getContentPane();
		
		JLabel la = new JLabel("수를 결정하였습니다. 맞추어 보세요 0-99");
		la.setBounds(120,200,300,30);
		
		JTextField tf = new JTextField();
		tf.setBounds(200,250,50,30);
		
		JLabel ans = new JLabel();
		ans.setBounds(170,300,300,30);
		
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int wordnum = Integer.parseInt(tf.getText());
				if(wordnum==num) {
					ans.setText("같습니다 !! "); 
				}
				else if (wordnum>num && wordnum<=end) {					
					setEnd(wordnum);
					ans.setText("더 작게  "+front + " ~ " + wordnum);
					tf.setText("");
				}
				else if (wordnum<num && wordnum>=front) {
					setFront(wordnum);
					ans.setText("더 크게 "+ wordnum + " ~ " + end);
					tf.setText("");
				}
				else if(front>wordnum || end<wordnum)ans.setText("다시 ! "+front +" ~ "+end);
			}
		});
		c.add(la);
		c.add(tf);
		c.add(ans);
		
		setSize(500,500);
		setVisible(true);
	}
	public void setFront(int a) {
		this.front=a;
	}
	public void setEnd(int a) {
		this.end=a;
	}
	public static void main(String[] args) {
		new Problem_08_UpDownGame();
	}
}

/* do while, while 되게 깔끔함.
import java.util.*;

public class aa {
	public static int randomNumberGenerator() {
		return (int) ((Math.random() * 100));
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String choice = null;
		do {
			int a = randomNumberGenerator();
			System.out.println("수를 결정하였습니다. 맞추어 보세요");
			int low = 0, high = 99;
			int i = 1;
			while (true) {
				System.out.println(low + "-" + high);
				System.out.print(i + ">>");
				int reply = scanner.nextInt();
				if (reply > a) {
					System.out.println("더 낮게");
					high = reply;
					i++;
				} 
				else if (reply < a) {
					System.out.println("더 높게");
					low = reply;
					i++;
				} 
				else if (reply == a) {
					System.out.println("맞았습니다");
					break;
				}
			}
			System.out.print("다시 하시겠습니까?(y/n)");
			choice = scanner.next();
		} while (choice.equals("y"));
	}
}*/