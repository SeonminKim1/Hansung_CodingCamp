/*
 * ����  14 : Thread �̿��� ���ý���
 */
package Day04;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Problem_14_ThreadCalculator extends JFrame{
	private String tfnum="";
	private String tfnum2="";
	public Problem_14_ThreadCalculator() {
		setTitle("��� ������ !!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		Container c = getContentPane();
		
		JTextField tf = new JTextField();
		tf.setBounds(100,100,100,30);

		JTextField tf2 = new JTextField();
		tf2.setBounds(100,150,100,30);
		

		JLabel la = new JLabel("���� : ");
		la.setBounds(130,200,70,30);
		
		JButton btn = new JButton("���");
		btn.setBounds(230,120,80,50);
		ExThread th = new ExThread(tf,tf2,la);
		th.start();
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized(th) {
						th.notify();
						System.out.println("�ƿ�� �Ϸ�");
					}
				}	
		});
	
		add(tf); add(tf2); add(la); add(btn);
		setSize(500,500);
		setVisible(true);
	}	
	public static void main(String[] args) {
		new Problem_14_ThreadCalculator();
	}
}


class ExThread extends Thread{
	private JLabel l1;
	private JTextField tf1;
	private JTextField tf2;
	public ExThread(JTextField tf1, JTextField tf2, JLabel l1) {
		this.tf1 = tf1;	
		this.tf2 = tf2;	
		this.l1=l1;
	}
	public void run() {
		System.out.println("������ start");
		while(true) {
		try {
			synchronized(this) {
			System.out.println("�����µ���");
				wait();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int sum=0;
		for(int i=Integer.parseInt(tf1.getText()); i<=Integer.parseInt(tf2.getText()); i++) {
			sum=sum+i;
		}
		l1.setText("���� : " + sum);
		}
	}
}