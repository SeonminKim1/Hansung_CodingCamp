/*
 * 문제  30 : Key Event 연습
 */
package Day07;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Problem_30_KeyEvent_Font extends JFrame{
	private int n = 5;
	public Problem_30_KeyEvent_Font() {
	//	setLayout(null);
		setTitle("+,-키로 폰트 크기 조절하기");
		Container c = getContentPane();
		JLabel la = new JLabel("Love Java");
		la.setFont(new Font("굴림",Font.PLAIN,n));
		la.setHorizontalAlignment(SwingConstants.CENTER);	// 가운데정렬
		c.add(la);
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				//JFrame f = (JFrame)e.getSource();
				if(e.getKeyChar()=='+') {
					if(n<60) {
					n=n+5;
					la.setFont(new Font("굴림",Font.PLAIN,n));
					}
					System.out.println(n);
				}
				else if (e.getKeyChar()=='-') {				// getKeyCode로 하니까 안됨.
					if(n>5) {
						n=n-5;
						la.setFont(new Font("굴림",Font.PLAIN,n));
					}
					System.out.println(n);
				}
			}
		});
		setFocusable(true);
		requestFocus(); 
		setSize(500,250);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Problem_30_KeyEvent_Font();
	}

}
