/*
 * 문제 47 : 마우스 드래그 해서 사각형 그리기 
 */
package Day09;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Problem_47_DragDrowRect extends JFrame{
	public Problem_47_DragDrowRect() {
		setTitle("드래그로 사각형 그리기");
		setSize(500,500);
		Container c = getContentPane();
		MyPanel3 mp3 = new MyPanel3();
		c.add(mp3,BorderLayout.CENTER);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		new Problem_47_DragDrowRect();
	}
}

class MyPanel3 extends JPanel {
	private int startx=0;
	private int starty=0;
	private int endx=0;
	private int endy=0;
	public MyPanel3() {
		addMouseMotionListener(new MouseMotionAdapter() {		
			public void mouseDragged(MouseEvent arg0) {
				endx=arg0.getX();
				endy=arg0.getY();
				repaint();	
			}
		});
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				startx=e.getX();
				starty=e.getY();
			}
		});
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(startx, starty, Math.abs(endx-startx),Math.abs(endy-starty));
	}
}
