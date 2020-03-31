/*
 * 문제  32 : 점찍어서 다각형 만들기 
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
		setTitle("마우스로 페다각형 그리기");
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
////// Point란 객체가 ㅇ미 존재함. 그 객체 안에 getPoint() 함수가 존재해서 마우스 커서 위치가 나옴.
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
			public void mouseReleased(MouseEvent e2) { 		//released 에 repaint() 안붙이면 pressed에서 repaint()를 하는데 endP가 설정 안되어 있어서  이전 endP값으로 그려져서 하나씩  밀림.
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
