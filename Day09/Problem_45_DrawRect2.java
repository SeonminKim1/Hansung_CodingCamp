/*
 * 문제 45 : 클릭된 모든 곳에 사각형 그리기 
 */

package Day09;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Problem_45_DrawRect2 extends JFrame{
	public Problem_45_DrawRect2() {
		setTitle("사각형 계속 그리기");
		setSize(500,500);
		Container c = getContentPane();
		MyPanel2 mp2 = new MyPanel2();
		c.add(mp2,BorderLayout.CENTER);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		new Problem_45_DrawRect2();
	}
}

class MyPanel2 extends JPanel {
	private int x=0;
	private int y=0;
	Vector<Point> v = new Vector<Point>();
	public MyPanel2() {
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				v.add(e.getPoint());
				//System.out.println(x+" "+y);
				repaint();
			}
		});
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i=0; i<v.size(); i++) {
			g.drawRect((int)v.get(i).getX(), (int)v.get(i).getY(), 50,50);	
		}
	}
}
