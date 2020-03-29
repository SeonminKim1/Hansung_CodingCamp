/*
 * 문제 29 : 배경색 스윙 설정
 */
package Day07;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Problem_29_BackgroundColor extends JFrame{
	private Color[] color = {Color.RED,Color.ORANGE,Color.YELLOW,Color.GREEN,Color.CYAN,Color.BLUE,Color.MAGENTA,Color.GRAY,Color.PINK,Color.LIGHT_GRAY};
	public Problem_29_BackgroundColor() {
		setLayout(new GridLayout());
		setTitle("Ten Color Buttons Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		JButton btn[] = new JButton[10];
		
		for(int i=0; i<btn.length; i++) {
			btn[i]=new JButton();
			btn[i].setText(Integer.toString(i));
			btn[i].setBackground(color[i]);
			c.add(btn[i]);
		}
		setSize(500,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Problem_29_BackgroundColor();
	}

}
