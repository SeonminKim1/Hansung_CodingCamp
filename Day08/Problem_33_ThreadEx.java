/*
 * ���� 33 : ������ 50�� ���� ��������ġ�� �̵� 
 */

package Day08;

import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Problem_33_ThreadEx extends JFrame{
	public Problem_33_ThreadEx() {
		setTitle("���� 0.5�� �������� ��������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		CirclePanel cp = new CirclePanel();
		c.add(cp);
		setSize(500,500);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Problem_33_ThreadEx();
	}
}

class CirclePanel extends JPanel{
	private int x=0; // ���� �߽� x��ǥ
	private int y=0; // ���� �߽� y��ǥ
	private int r=50; // ���� ������
	public CirclePanel() {
		CircleThread ct = new CircleThread(this);
		ct.start();
	}
	public void setx(int x) {
		this.x=x;
	}
	public void sety(int y) {
		this.y=y;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawOval(x, y, r, r);
	}
}
// Thread ����  0.5�ʸ��� CirclePanel�� ���� x��ǥ �� y��ǥ�� �ٲ��ְ�(��������) repaint()ȣ��
class CircleThread extends Thread{
	private CirclePanel p;
	public CircleThread(CirclePanel p) {
		this.p=p;
	}
	public void run() {
		while(true) {
			p.setx((int)(Math.random()*400));
			p.sety((int)(Math.random()*400));
			p.repaint();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}//catch
		}//whlie
	}//run
}