package Day03;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Problem_09_PointClickGame extends JFrame{
	public Problem_09_PointClickGame() {
		setTitle("Ten���̺� Ŭ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c= getContentPane();
		Screen scr = new Screen();
		c.add(scr);
		setSize(600,600);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Problem_09_PointClickGame();
	}
}

class Screen extends JPanel{
	private JLabel la[] = new JLabel[10];
	public static int num=0;
	public Screen() {
		setLayout(null);
		for(int i=0; i<la.length; i++) {
			la[i]= new JLabel();
		}
		init();
		for(int i=0; i<la.length-1; i++) {
			la[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					JLabel label = (JLabel)e.getSource();
					if(label.getText().equals(Integer.toString(num))){
						label.setText("");
						num++;
						System.out.println("�۵���");
					}
				}
			});
			add(la[i]);
		}
		la[la.length-1].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JLabel label = (JLabel)e.getSource();
				if(label.getText().equals(Integer.toString(num))){
					label.setText("");
					num++;
					System.out.println("�۵���");
					int result = JOptionPane.showConfirmDialog(null, "����Ұſ���?","Confirm",JOptionPane.YES_NO_OPTION);
					if(result==JOptionPane.YES_OPTION) {
						num=0; init(); 
					}
					else if (result == JOptionPane.NO_OPTION) {
						System.exit(0);
					}
				}
			}
		});
		add(la[la.length-1]);
	}
	public void init() {// �󺧿� ��ȣ�� �ʱ�ȭ ����.
		for(int i=0; i<la.length; i++) {
			String n = Integer.toString(i);
			la[i].setText(n);
			la[i].setFont(new Font("���� ���",Font.BOLD,15));
			la[i].setBounds((int)(Math.random()*420+50),(int)(Math.random()*420+50),20,20);
		}
	}
}