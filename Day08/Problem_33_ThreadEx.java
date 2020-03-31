/*
 * 문제 33 : 지름이 50인 원이 랜덤한위치로 이동 
 */

package Day08;

import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Problem_33_ThreadEx extends JFrame{
	public Problem_33_ThreadEx() {
		setTitle("원을 0.5초 간격으로 랜덤생성");
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
	private int x=0; // 원의 중심 x좌표
	private int y=0; // 원의 중심 y좌표
	private int r=50; // 원의 반지름
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
// Thread 역할  0.5초마다 CirclePanel의 원의 x좌표 와 y좌표를 바꿔주고(랜덤으로) repaint()호출
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