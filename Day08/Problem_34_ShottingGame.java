/*
 * ���� 34 : ��ݰ��� 
 */

package Day08;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// ChickenThread�� �¿�� �����̴� ���Ҹ� ��. GunThread�� EnterŰ�� ������ ����ǰ� ChickenThread�� x��ǥ�� �޾ƿͼ� �´� �������� score�ö󰡰� ��. 
// �Ѵ� setBounds�� �ߴµ� Graphics �ᵵ �� �� ����. -> ���� ������� ���ʸ��� ��ġ�� �������ְ�. sleep���� repaint()
public class Problem_34_ShottingGame extends JFrame {
	public Problem_34_ShottingGame() {
		setTitle("��� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();

		ShootingPanel sp = new ShootingPanel();
		c.add(sp, BorderLayout.CENTER);
		setSize(500, 500);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Problem_34_ShottingGame();
	}
}

class ShootingPanel extends JPanel {
	private JLabel scorelabel = new JLabel("Score");
	private JLabel score = new JLabel("0");
	public ShootingPanel() {
		setLayout(null); 
		JLabel la = new JLabel("��");   				// �� �� 
		la.setBounds(0, 0, 30, 50);
		add(la);

		JLabel gla = new JLabel("�Ѿ�");				// �Ѿ� ��
		gla.setBounds(240, 350, 10, 10);
		add(gla);

		scorelabel.setBounds(400, 400, 50, 30);		// ���� ��
		score.setBounds(450, 400, 30, 30);			// ������ ��
		add(scorelabel); add(score);

		JButton btn = new JButton("��");				// �� ��ư
		btn.setBounds(220, 390, 60, 60);
		btn.setBackground(Color.yellow);
		add(btn);

		ChickenThread Ct = new ChickenThread(la);	
		Ct.start();									// �� �����̱� ���� !! ������ ���� !!

		GunThread Gt = new GunThread(gla, score, Ct); 
		Gt.start();									// �Ѿ� �����̱� ���� !! ������ ���� !!
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == e.VK_ENTER) {
					synchronized (Gt) {
						Gt.notify();
					}
				}
			}
		});
		setFocusable(true);
		requestFocus();
	}
}

class GunThread extends Thread {
	private int gunX = 240, gunY;
	private JLabel gla;
	private JLabel score;
	private ChickenThread ct;

	public GunThread(JLabel gla, JLabel score, ChickenThread ct) {
		this.gla = gla;
		this.score = score;
		this.ct = ct;
	}

	public void run() {
		int num = 0;
		while (true) {
			gunY = 380;
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				while (gunY >= 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					gunY = gunY - 10;
					if (gunY == 10 && ct.getChickenX() >= 210 && ct.getChickenX() <= 260) {
						num = Integer.parseInt(score.getText()) + 1;
						score.setText(Integer.toString(num));
						gla.setBounds(gunX, 380, 10, 10);
						break;
					}
					gla.setBounds(gunX, gunY, 10, 10);
				}
			}
		}
	}
}

class ChickenThread extends Thread { // ���� �ڵ����� ������.
	private int ChickenX = 5; // ���� ó�� x��ǥ
	private int ChickenY = 0; // ���� ó�� y��ǥ
	private int where = 1; // ���� (�� :1 , ��:-1
	private JLabel la;

	public ChickenThread(JLabel la) {
		this.la = la;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			la.setBounds(ChickenX, ChickenY, 30, 50);
			if (where == 1) {
				ChickenX = ChickenX + 30;
				if (ChickenX > 440)
					where = -1;
			} else if (where == -1) {
				ChickenX = ChickenX - 30;
				if (ChickenX < 30)
					where = 1;
			}
		}
	}

	public int getChickenX() {
		return ChickenX;
	}
}