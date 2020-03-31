/*
 * ����  32 : ���� �ٰ��� ����� 
 */

package Day08;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class Problem_32_Polygon extends JFrame{
	public Problem_32_Polygon() {
		setTitle("���콺�� ��ٰ��� �׸���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		MyPanel3 mp = new MyPanel3();
		c.add(mp);
		setSize(500,500);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Problem_32_Polygon();
	}

}
////// Point�� ��ü�� ���� ������. �� ��ü �ȿ� getPoint() �Լ��� �����ؼ� ���콺 Ŀ�� ��ġ�� ����.
class MyPanel3 extends JPanel{
	Vector<Point> vStart = new Vector<Point>();
	Vector<Point> vEnd = new Vector<Point>();
	public MyPanel3(){
		vStart.add(new Point(10,10));
		//repaint();
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Point startP=e.getPoint();
				vStart.add(startP);
			}
			public void mouseReleased(MouseEvent e2) { 		//released �� repaint() �Ⱥ��̸� pressed���� repaint()�� �ϴµ� endP�� ���� �ȵǾ� �־  ���� endP������ �׷����� �ϳ���  �и�.
				Point endP=e2.getPoint();
				vEnd.add(endP);
				repaint();
			}
		});
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i=0; i<vEnd.size(); i++) {
			Point s = vStart.elementAt(i);
			Point e = vEnd.elementAt(i);
			g.drawLine((int)s.getX(),(int)s.getY(),(int)e.getX(),(int)e.getY());
		}
	}
}
