/*
 * ���� 44 : �׷��� - repaint ���콺 Ŭ���� �簢�� �׷��� 
 */

package Day09;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Problem_44_DrawRect extends JFrame{
	public Problem_44_DrawRect() {
		setTitle("�簢�� �׸���");
		setSize(500,500);
		Container c = getContentPane();
		MyPanel mp = new MyPanel();
		c.add(mp,BorderLayout.CENTER);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		new Problem_44_DrawRect();
	}
}

class MyPanel extends JPanel {
	private int x=250;
	private int y=250;
	public MyPanel() {
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				x=e.getX();
				y=e.getY();
				//System.out.println(x+" "+y);
				repaint();
			}
		});
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(x, y, 50,50);
	}
}