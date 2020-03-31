/*
 * 문제 46 : 더블 버퍼링을 이용하여 자유 곡선 그리기 
 */

package Day09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class Problem_46_DoubleBuffering extends JFrame {
	public Problem_46_DoubleBuffering() {
		setTitle("자유곡선 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		FreePanel fp = new FreePanel();
		c.add(fp, BorderLayout.CENTER);

		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Problem_46_DoubleBuffering();
	}
}
//// double buffering 기법  메모리상의 판떼기에 먼저 그림을 다 그려놓고(mgc판) 맨 마지막에 실제로 꺼내와서 그리는거임(g) 계속 그림을 그릴 떄 않끊긴다는 장점이 있음.
class FreePanel extends JPanel {
	private int startx;
	private int starty;
	private int prevx;
	private int prevy;
	private Image memoryimage; // 1. 메모리상에 실제 화면사이즈 만큼의 이미지 버퍼 생성.
	private Graphics mgc; // 2. 생성한 이미지 버퍼에 대한 Graphics 객체를 얻어옴.
	Vector<Point> vStart = new Vector<Point>();
	Vector<Point> vEnd = new Vector<Point>();

	public FreePanel(){
		addMouseMotionListener(new MouseAdapter() {			
			public void mouseDragged(MouseEvent e) {
				Point startP=e.getPoint();
				vStart.add(startP);
				repaint();
			}
		});;
	}

	public void paint(Graphics g) {
		memoryimage = createImage(500,500);
		mgc=memoryimage.getGraphics();
		for (int i = 0; i < vStart.size(); i++) {
			Point s = vStart.elementAt(i);
			mgc.drawOval((int) s.getX(), (int) s.getY(), 2,2);
		}
		g.drawImage(memoryimage,0,0,null);
	}
}