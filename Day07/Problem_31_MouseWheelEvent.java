/*
 * ����  31 : ���콺 �� ������ ���� ũŰ ��� 
 */

package Day07;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Problem_31_MouseWheelEvent extends JFrame{
	private int n = 5;
	public Problem_31_MouseWheelEvent() {
		setTitle("���콺 �� ������");
		Container c = getContentPane();
		JLabel la = new JLabel("Love Java");
		la.setFont(new Font("����",Font.PLAIN,n));
		la.setHorizontalAlignment(SwingConstants.CENTER);	// �������
		
		addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				if(e.getWheelRotation()>0) { 					// �Ʒ��� ������ ���
						n=n+5;
						la.setFont(new Font("����",Font.PLAIN,n));
						System.out.println(n);
					}
				else {											// �Ʒ��� ������ ����
						n=n-5;
						la.setFont(new Font("����",Font.PLAIN,n));
					System.out.println(n);
				}
			}
		}); 
		c.add(la);
		setSize(500,250);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Problem_31_MouseWheelEvent();
	}

}
