/*
 * ���� 10 : ��ȭ��ȣ�� �������� 
 */
package Day03;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Problem_10_PhoneBook_Swing extends JFrame{
	private HashMap<String, String> h = new HashMap<String,String>();
	public Problem_10_PhoneBook_Swing() {
		setTitle("��ȭ��ȣ�� !!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		Container c = getContentPane();
		
		String s="010.1234.5678";
		System.out.println();
		
		JButton AdBtn = new JButton("�߰�");
		AdBtn.setBounds(50,50,100,30);
		AdBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				addDialog ad = new addDialog(h);
			}
		});
		JButton SearchByNameBtn = new JButton("�̸����� �˻�");
		SearchByNameBtn.setBounds(200,50,150,30);
		SearchByNameBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SearchByNameClass Sbnc= new SearchByNameClass(h);
			}
		});		
		JButton SearchByTelNumBtn = new JButton("��ȣ�� �˻�");
		SearchByTelNumBtn.setBounds(400,50,150,30);
		SearchByTelNumBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SearchByTelNumClass Sbtnc = new SearchByTelNumClass(h);
			}
		});
		
		c.add(AdBtn); c.add(SearchByNameBtn); c.add(SearchByTelNumBtn); 
		
		setSize(700,300);
		setVisible(true);		
	}
	public static void main(String args[]) {
		new Problem_10_PhoneBook_Swing();
	}
}

class addDialog extends JDialog{
	private String name="";
	private String telNum="";
	
	public addDialog(HashMap<String,String> h) {
		setLayout(null);
		setTitle("��ȭ��ȣ�� ���� !!! ");
		JLabel nameLabel = new JLabel("�̸�");
		nameLabel.setBounds(20,50,70,30);
		JLabel ConfirmLabel1 = new JLabel("");
		ConfirmLabel1.setBounds(190,50,160,30);
		JLabel ConfirmLabel2 = new JLabel("");
		ConfirmLabel2.setBounds(190,100,160,30);
		
		JTextField nametf = new JTextField();
		nametf.setBounds(80,50,100,30);
		nametf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField tf = (JTextField)e.getSource();
				name=tf.getText();
				tf.setText("");
				ConfirmLabel1.setText(name + " �Է¿Ϸ�");
			}
		});
		JLabel telLabel = new JLabel("��ȭ��ȣ");
		telLabel.setBounds(20,100,70,30);

		JTextField telnumtf = new JTextField();
		telnumtf.setBounds(80,100,100,30);
		telnumtf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField tf = (JTextField)e.getSource();
				telNum=tf.getText();
				tf.setText("");
				ConfirmLabel2.setText(telNum + " �Է¿Ϸ�");
			}
		});
		JLabel AddLabel = new JLabel(""); // ����Ϸ��
		AddLabel.setBounds(200,150,80,50);
		
		JButton Confirmbtn = new JButton("����"); // ���� �����ư
		Confirmbtn.setBounds(100,150,80,50);
		Confirmbtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(!ConfirmLabel1.getText().equals("") && !ConfirmLabel2.getText().equals("")) {
					h.put(name,telNum);
				}
				AddLabel.setText("����Ϸ�");
			}
		});
		add(nameLabel); add(nametf); add(telLabel); add(telnumtf); add(ConfirmLabel1); add(ConfirmLabel2); add(Confirmbtn); add(AddLabel);
		System.out.println();
		setSize(360,300);
		setVisible(true);
	}

}
////�̸����� �˻��ϱ�
class SearchByNameClass extends JDialog{
	private String str="";
	public SearchByNameClass(HashMap<String, String> h) {
		setTitle("�̸����� ã�� !!");
		setLayout(null);
		Set<String> keys =h.keySet();
		Iterator<String> it = keys.iterator();
		JLabel l = new JLabel("�̸� �˻� : ");
		l.setBounds(50,50,80,30);
		
		JTextArea printtext =new JTextArea(str,5,10);
		printtext.setBounds(20,90,240,150);
		
		JTextField tf = new JTextField("");
		tf.setBounds(140,50,80,30);
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField tt = (JTextField)e.getSource();
				printtext.setText(""); str="";
				String myword = tt.getText();
				while(it.hasNext()) {
					String key = it.next();
					String value = h.get(key);
						if(key.contains(myword) == true) {
							str=str+"�̸��� : " + key + "  ��ȭ��ȣ�� : " + value + "\n"; 
							tf.setText("");
						}
				} // while
				printtext.setText(str);
			} // actionPerformed
		}); // ActionListener
		
		add(l); add(tf); add(printtext);
		setSize(300,300);
		setVisible(true);
	}
}
//// ��ȭ��ȣ�� �˻��ϱ�.
class SearchByTelNumClass extends JDialog{
	String str="";
	public SearchByTelNumClass(HashMap<String,String> h) {
		setTitle("��ȭ��ȣ�� ã�� !!");
		setLayout(null);
		Set<String> keys =h.keySet();
		Iterator<String> it = keys.iterator();
		JLabel l = new JLabel("��ȭ��ȣ �˻� : ");
		l.setBounds(40,50,100,30);
		
		JTextArea printtext =new JTextArea(str,5,10);
		printtext.setBounds(20,90,240,150);
		
		JTextField tf = new JTextField("");
		tf.setBounds(140,50,80,30);
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField tt = (JTextField)e.getSource();
				printtext.setText(""); str="";
				while(it.hasNext()) {
					String myword = tt.getText();
					String key = it.next();
					String value = h.get(key);
						if(value.contains(myword)  == true) {
							str=str+"�̸��� : " + key + "  ��ȭ��ȣ�� : " + value + "\n"; 
							tf.setText("");
						}
				} // while
				printtext.setText(str);
			} // actionPerformed
		}); // ActionListener
		
		add(l); add(tf); add(printtext);
		setSize(300,300);
		setVisible(true);
	}
}

