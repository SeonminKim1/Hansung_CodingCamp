/*
 * 문제 48 : Interface를 이용해서 사각형 그리기 
 */
package Day09;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class Problem_48_DrawRectInterface extends JFrame{
	public static int num=0;
	public Problem_48_DrawRectInterface() {
		setTitle("카운트 인터페이스");
		setSize(500,500);
		Container c = getContentPane();
		JLabel la = new JLabel("사각형의 수 "+num);
		MyPanel4 mp2 = new MyPanel4(la);
		la.setOpaque(true);
		la.setBackground(Color.WHITE);
		c.add(la,BorderLayout.NORTH);
		c.add(mp2,BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public static void main(String args[]) {
		new Problem_48_DrawRectInterface();
	}
}

class MyPanel4 extends JPanel {
	private int x=0;
	private int y=0;
	private JLabel la ;
	Vector<Point> v = new Vector<Point>();
	public MyPanel4(JLabel la) {
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				v.add(e.getPoint());
				Problem_48_DrawRectInterface.num++;
				la.setText("사각형의 수 "+Problem_48_DrawRectInterface.num);
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
