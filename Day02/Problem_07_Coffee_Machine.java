/*
 * 문제 7 : 커피 자만기 시뮬레이터
 */
package Day02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Problem_07_Coffee_Machine extends JFrame{
	public Problem_07_Coffee_Machine() {
		setTitle("커피머신 !!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		Mypanel panel = new Mypanel();
		c.add(panel);
		setSize(800,500);
		setVisible(true);
	}
	public static void main(String args[]) {
		new Problem_07_Coffee_Machine();
	}
}

class Mypanel extends JPanel{
	private int Weight=50, Height=120;
	private int Cup_n = 10, Coffee_n=10, Water_n=10, Sugar_n=10, Cream_n=10;
	public Mypanel() {
		setLayout(null);
		setSize(800,450);

		JLabel cup = new JLabel("Cup");
		cup.setBounds(90,200,50,30); 
		JLabel Coffee = new JLabel("Coffee");
		Coffee.setBounds(230,200,50,30);
		
		JLabel Water = new JLabel("Water");
		Water.setBounds(370,200,50,30);
		
		JLabel Sugar = new JLabel("Sugar");
		Sugar.setBounds(510,200,50,30);
		
		JLabel Cream = new JLabel("Cream");
		Cream.setBounds(650,200,50,30);
		
		add(cup); add(Coffee); add(Water); add(Sugar); add(Cream);
		
		JButton BlackCoffee= new JButton("Black Coffee");
		BlackCoffee.setBounds(50,300,150,50);
		JButton SugarCoffee= new JButton("Sugar Coffee");
		SugarCoffee.setBounds(220,300,150,50);
		JButton DabangCoffee= new JButton("DabangCoffee");
		DabangCoffee.setBounds(390,300,150,50);
		JButton Reset= new JButton("Reset");
		Reset.setBounds(560,300,150,50);		
		
		BlackCoffee.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Cup_n=Cup_n-1; 
				Coffee_n=Coffee_n-1;
				Water_n=Water_n-1;
				repaint();
				}
		});
		
		SugarCoffee.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Cup_n=Cup_n-1; 
				Coffee_n=Coffee_n-1;
				Water_n=Water_n-1;
				Sugar_n=Sugar_n-1;
				repaint();
			}
		});
		
		DabangCoffee.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Cup_n=Cup_n-1; 
				Coffee_n=Coffee_n-1;
				Water_n=Water_n-1;
				Sugar_n=Sugar_n-1;
				Cream_n=Cream_n-1;
				repaint();
			}
		});		
		Reset.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Cup_n=10; Coffee_n=10; Sugar_n=10;
				Water_n=10; Cream_n=10;
				repaint();
			}
		});
		add(BlackCoffee); add(SugarCoffee); add(DabangCoffee); add(Reset);	
	}	

	public void paintComponent(Graphics g) { // 4개 현재 남은 량 그려주는.
		super.paintComponent(g);
		g.drawRect(90, 60, Weight, Height);
		g.drawRect(230, 60, Weight, Height);
		g.drawRect(370, 60, Weight, Height);
		g.drawRect(510, 60, Weight, Height);
		g.drawRect(650, 60, Weight, Height);
		
		g.setColor(Color.BLUE); // weight 50 height 120
		g.fillRect(90, 60+(Height-(Height*Cup_n/10)), Weight, Height*Cup_n/10);
		g.fillRect(230, 60+(Height-(Height*Coffee_n/10)), Weight, Height*Coffee_n/10);
		g.fillRect(370, 60+(Height-(Height*Water_n/10)), Weight, Height*Water_n/10);
		g.fillRect(510, 60+(Height-(Height*Sugar_n/10)), Weight, Height*Sugar_n/10);
		g.fillRect(650, 60+(Height-(Height*Cream_n/10)), Weight, Height*Cream_n/10);
	}//(Height*(Cup_n-10))
}