/*
 * ���� 16 : �������� �ý��� ������� �����
 */
package Day05;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Problem_16_Snow extends JFrame{
	public Problem_16_Snow() {
		setTitle("�� ������ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		MyPanel mp = new MyPanel();
		c.add(mp);
		setSize(600, 600);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Problem_16_Snow();
	}
}


class MyPanel extends JPanel {
	private ImageIcon imageicon= new ImageIcon("universe.jpg");
	private Image img = imageicon.getImage();
	private int width = 10; // ���� ũ��
	private int height = 10; // ���� ũ��
	public static int x[]= new int[30]; 
	public static int y[]= new int[30];
	public MyPanel() {
		SnowThread snowthread = new SnowThread(this);
		snowthread.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		g.setColor(Color.WHITE);
		for(int i=0; i<30; i++) {											// �� 30���׸���
			g.fillOval(x[i], y[i],width, height);
		}
	}
	public void SnowRepaint() {
		repaint();
	}
}

class SnowThread extends Thread{
	private MyPanel p;
	public SnowThread(MyPanel p) {
		this.p=p;
		for(int i=0; i<30; i++) {				// �� 30�� �������� ����   600 x 600 �׸� ������ 
			p.x[i]=(int)(Math.random()*600);
			p.y[i]=(int)(Math.random()*600);
		}
	} // SnowThread ������
	
	public void run() {
		while(true) {
			for(int i=0; i<30; i++) {
			p.y[i]=p.y[i]+10;
			if(p.y[i]>600) { 						// ���� ���� �ٴڿ� ������
				p.y[i]=0;    						// y��ǥ ������  
				p.x[i]=(int)(Math.random()*600);    // x��ǥ�� �������� ����
			}
			} // for�� ��
			try {
				sleep(1000);						// 1�� ���� �� ������
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			p.SnowRepaint(); 						// �� �ٽ� �׸�.
		} // while
	} // run()
}