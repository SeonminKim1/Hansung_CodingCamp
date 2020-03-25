/*
 * ���� 15 : Snake Game 
 */
package Day04;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;// �Ѱ��� ������ ������ 7��¥�� ������ ���� ����.

public class Problem_15_SnakeGame extends JFrame {
	public Problem_15_SnakeGame() {
		setTitle("������ũ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		MyPanel mp = new MyPanel();
		c.add(mp);
		setSize(800, 600);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		new Problem_15_SnakeGame();
	}
}

class MyPanel extends JPanel{
	private int where=1; // ��, ��, ��, �� ���⼺.
	private ImageIcon Bg = new ImageIcon("universe.jpg");//�����
	private Image img = Bg.getImage();
	public static int startx=30; // x�� �̵��ϰ� ���� �Ÿ�
	public static int starty=30; // y�� �̵��ϰ� ���� �Ÿ�
	public static int width=30;
	public MyPanel() {
		SnakeTh Sth = new SnakeTh(this);//start ����
		Sth.start();
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) { // case 1:������  2:�Ʒ� 3:���� 4:����
				case KeyEvent.VK_RIGHT : where=1; break;
				case KeyEvent.VK_DOWN : where=2; break;
				case KeyEvent.VK_LEFT : where=3; break;
				case KeyEvent.VK_UP : where=4; break;
				}
			}
		});
		setFocusable(true);
		requestFocus(); 
	}
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this.getWidth(),this.getHeight(),this);
		g.setColor(Color.CYAN);
		g.fillRect(startx, starty, width, width);
		System.out.println("���ݱ׷����� ��ġ�� "+startx + starty);
	}
	
	public void setWhere(int num) {
		where=num;
	}
	public int getWhere() {
		return where;
	}
	public void ah() {
		repaint();
	}
}

class SnakeTh extends Thread{ // �������� ����  ����(where)�� ���� ��� ��ǥ�� ���ϰų� ���� , �׸��� ��� �׷���.
	private MyPanel p;
	public SnakeTh(MyPanel p){
		this.p=p; // mypanel�� where ������ ������������.
	}
	public void run() {
		while(true) {
			int n= p.getWhere();
			switch(n) { // case 1:������  2:�Ʒ� 3:���� 4:����
			case 1:MyPanel.startx=MyPanel.startx+30; break;
			case 2:MyPanel.starty=MyPanel.starty+30; break;
			case 3:MyPanel.startx=MyPanel.startx-30; break;
			case 4:MyPanel.starty=MyPanel.starty-30; break;
			}
			if(MyPanel.startx<0){
				MyPanel.startx=770;
			}
			else if(MyPanel.startx>800) {
				MyPanel.startx=0;
			}
			else if (MyPanel.starty<0) {
				MyPanel.starty=570;
			}
			else if(MyPanel.starty>600){
				MyPanel.starty=0;
			}
			p.ah();
			try {
				sleep(500); // 0.5�ʸ��� ������.
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

