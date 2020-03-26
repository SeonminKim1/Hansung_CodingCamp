/*
 * ����  17 : �ؽ�Ʈ ���������� ȸ��
 */

package Day05;

import java.awt.Container;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Problem_17_TextRotation extends JFrame{
	public Problem_17_TextRotation(){
		setTitle("���� ȸ����Ű��");
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
//*********************** �󺧿� ���콺 �ø��� ���������� ȸ���ϰ� Ŭ���ϸ� ������.
class MyPanel2 extends JPanel {
	private JLabel la;
	public static boolean onoff=true;
	public MyPanel2() {
		setLayout(null);
		la = new JLabel("Ŭ���ϸ����");
		la.setBounds(150,50,300,30);
		add(la);
		
		JLabel lala = new JLabel("�ܾ�ٲٱ�");
		lala.setBounds(150,100,200,30);
		add(lala);
		
		JTextField tf = new JTextField(20);
		tf.setBounds(90,150,200,30);
		add(tf);
		
		MoveThread mt = new MoveThread(this);
		mt.start(); 
		
		tf.addActionListener(new ActionListener() { // �ý�Ʈ �ʵ忡 �ִ� �ܾ�� ���� �ٲ�
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
	public JLabel getLabel() { // �����忡�� �г��� ���� �ؽ�Ʈ �����ϱ�����. set get��.
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
			String BunreString = text.substring(text.length()-1); 	// �и��� ���ڻ���
			String a[]=text.split(BunreString);						// �� ���ڸ� �������ڿ��� �и���
			String finalString = BunreString.concat(a[0]);			// �� ���ڸ� �Ǿտ��ٰ� ����.
			p2.setLabel(finalString);									
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // catch
		} // while
	} // run
}