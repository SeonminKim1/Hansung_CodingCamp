/*
 * 문제 16 : 눈내리는 시스템 스레드로 만들기
 */
package Day05;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Problem_16_Snow extends JFrame{
	public Problem_16_Snow() {
		setTitle("눈 내리는 우주");
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
	private int width = 10; // 원의 크기
	private int height = 10; // 원의 크기
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
		for(int i=0; i<30; i++) {											// 눈 30개그리기
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
		for(int i=0; i<30; i++) {				// 눈 30개 랜덤으로 생성   600 x 600 그림 내에서 
			p.x[i]=(int)(Math.random()*600);
			p.y[i]=(int)(Math.random()*600);
		}
	} // SnowThread 생성자
	
	public void run() {
		while(true) {
			for(int i=0; i<30; i++) {
			p.y[i]=p.y[i]+10;
			if(p.y[i]>600) { 						// 만약 눈이 바닥에 닿으면
				p.y[i]=0;    						// y좌표 맨위로  
				p.x[i]=(int)(Math.random()*600);    // x좌표도 랜덤으로 생성
			}
			} // for문 끝
			try {
				sleep(1000);						// 1초 마다 눈 내려옴
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			p.SnowRepaint(); 						// 눈 다시 그림.
		} // while
	} // run()
}