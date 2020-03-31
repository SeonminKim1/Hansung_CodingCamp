/*
 * ���� 46 : ���� ���۸��� �̿��Ͽ� ���� � �׸��� 
 */

package Day09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class Problem_46_DoubleBuffering extends JFrame {
	public Problem_46_DoubleBuffering() {
		setTitle("����� �׸���");
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
//// double buffering ���  �޸𸮻��� �Ƕ��⿡ ���� �׸��� �� �׷�����(mgc��) �� �������� ������ �����ͼ� �׸��°���(g) ��� �׸��� �׸� �� �ʲ���ٴ� ������ ����.
class FreePanel extends JPanel {
	private int startx;
	private int starty;
	private int prevx;
	private int prevy;
	private Image memoryimage; // 1. �޸𸮻� ���� ȭ������� ��ŭ�� �̹��� ���� ����.
	private Graphics mgc; // 2. ������ �̹��� ���ۿ� ���� Graphics ��ü�� ����.
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