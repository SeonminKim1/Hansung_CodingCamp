/*
 * 문제  17 : 텍스트 오른쪽으로 회전
 */

package Day05;

import java.awt.Container;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Problem_17_TextRotation extends JFrame{
	public Problem_17_TextRotation(){
		setTitle("글자 회전시키기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		MyPanel2 mp = new MyPanel2();
		c.add(mp);
		setSize(400, 300);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		new Problem_17_TextRotation();
	}
}
//*********************** 라벨에 마우스 올리면 오른쪽으로 회전하고 클릭하면 정지함.
class MyPanel2 extends JPanel {
	private JLabel la;
	public static boolean onoff=true;
	public MyPanel2() {
		setLayout(null);
		la = new JLabel("클릭하면멈춤");
		la.setBounds(150,50,300,30);
		add(la);
		
		JLabel lala = new JLabel("단어바꾸기");
		lala.setBounds(150,100,200,30);
		add(lala);
		
		JTextField tf = new JTextField(20);
		tf.setBounds(90,150,200,30);
		add(tf);
		
		MoveThread mt = new MoveThread(this);
		mt.start(); 
		
		tf.addActionListener(new ActionListener() { // 택스트 필드에 있는 단어로 라벨을 바꿈
			public void actionPerformed(ActionEvent arg0) {
				JTextField tf = (JTextField)arg0.getSource();
				la.setText(tf.getText());
				tf.setText("");
			}
		});
		
		la.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				synchronized(mt) {
					mt.notifyAll();
					onoff=true;
				}
			}
			public void mouseClicked(MouseEvent e) {
				onoff=false;
			}
			});
	}
	public JLabel getLabel() { // 스레드에서 패널의 라벨의 텍스트 조작하기위해. set get씀.
		return la;
	}
	
	public void setLabel(String str) {
		la.setText(str);
	}
}

class MoveThread extends Thread{
	private MyPanel2 p2;
	public MoveThread(MyPanel2 p2) {
		this.p2=p2;
	}
	
	public void run() {
		while(true) {
			if(MyPanel2.onoff==false) {
				try {
					synchronized(this) {
					wait();
					}
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			String text = p2.getLabel().getText();
			String BunreString = text.substring(text.length()-1); 	// 분리할 문자뽑음
			String a[]=text.split(BunreString);						// 그 문자를 원래문자에서 분리함
			String finalString = BunreString.concat(a[0]);			// 그 문자를 맨앞에다가 붙임.
			p2.setLabel(finalString);									
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // catch
		} // while
	} // run
}