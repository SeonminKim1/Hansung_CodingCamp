/*
 * 문제 49 : 하노이탑 만들기 
 */
package Day10;

import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.util.Vector; 
import javax.swing.*; 
public class Problem_49_HanoiTopProblem extends JFrame implements ActionListener 
{ 
   Vector<Disc> pole[] = new Vector[3]; 
   Vector<movePole> move = new Vector<movePole>(); 
   int position = 0; 
   JPanel bottom = new JPanel(); 
   JButton prev = new JButton("<-Prev"); 
   JButton next = new JButton("Next->"); 
   JPanel center; 
   public Problem_49_HanoiTopProblem() 
   { 
      pole[0] = new Vector<Disc>();//첫번째 기둥에 있는 디스크저장할 변수 
      pole[1] = new Vector<Disc>();//두번째 기둥에 있는 디스크저장할 변수 
      pole[2] = new Vector<Disc>();//세번째 기둥에 있는 디스크저장할 변수 
      center = new JPanel() 
      { 
         public void paint(Graphics g) 
         { 
            Graphics2D g2 = (Graphics2D) g; 
            g.clearRect(0, 0, getWidth(), getHeight()); 
            g2.setStroke(new BasicStroke(5.0f)); 
            //기둥그리기 
            g2.drawLine(50, 400, 250, 400); 
            g2.drawLine(300, 400, 500, 400); 
            g2.drawLine(550, 400, 750, 400); 
            g2.drawLine(150, 200, 150, 400); 
            g2.drawLine(400, 200, 400, 400); 
            g2.drawLine(650, 200, 650, 400); 
            //첫번째 기둥에 있는 원반 그리기 
            for (int i = 0; i < pole[0].size(); i++) 
            { 
               Disc d = pole[0].get(i); 
               g.setColor(d.c); 
               g.fillRect(150 - d.size / 2, 400 - (i * 10 + 10) - 2, d.size, 10); 
            } 
            //두번째 기둥에 있는 원반 그리기 
            for (int i = 0; i < pole[1].size(); i++) 
            { 
               Disc d = pole[1].get(i); 
               g.setColor(d.c); 
               g.fillRect(400 - d.size / 2, 400 - (i * 10 + 10) - 2, d.size, 10); 
            } 
            //세번째 기둥에 있는 원반 그리기 
            for (int i = 0; i < pole[2].size(); i++) 
            { 
               Disc d = pole[2].get(i); 
               g.setColor(d.c); 
               g.fillRect(650 - d.size / 2, 400 - (i * 10 + 10) - 2, d.size, 10); 
            } 
         } 
      }; 
      this.add(center, BorderLayout.CENTER); 
      bottom.add(prev); 
      bottom.add(next); 
      this.add(bottom, BorderLayout.SOUTH); 
      this.setSize(800, 500); 
      this.setVisible(true); 
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      //버튼 리스너 등록 
      prev.addActionListener(this); 
      next.addActionListener(this); 
      //첫번째 기둥에 원반 생성 
      Disc d = new Disc(Color.ORANGE, 100); 
      pole[0].add(d); 
      d = new Disc(Color.BLUE, 80); 
      pole[0].add(d); 
      d = new Disc(Color.RED, 60); 
      pole[0].add(d); 
      d = new Disc(Color.MAGENTA, 40); 
      pole[0].add(d); 
      d = new Disc(Color.GREEN, 20); 
      pole[0].add(d); 
      //하노이 탑 쌓기 알고리즘(순서를 move 변수에 저장) 
      hanoi(5, 1, 2, 3); 
   } 
   @Override 
   public void actionPerformed(ActionEvent e) 
   { 
      if (e.getSource() == prev) 
      { 
         if (position > 0) 
         { 
            position--;//이전 위치로 
            movePole m = move.get(position);//순서 얻어오기 
            int s = m.b - 1;//이동할 위치 
            int d = m.a - 1;//이동될 위치 
            pole[d].add(pole[s].get(pole[s].size()-1));//역으로 이동 
            pole[s].remove(pole[s].size()-1);//이동된 순서 지우기 
         } 
      } 
      if (e.getSource() == next) 
      { 
         if (position < move.size()) 
         { 
            movePole m = move.get(position);//순서를 얻어오기 
            position++;//다음 위치로 
            int s = m.a - 1;//이동할 위치 
            int d = m.b - 1;//이동될 위치 
            pole[d].add(pole[s].get(pole[s].size()-1));//이동 
            pole[s].remove(pole[s].size()-1);//이동된 순서 지우기 
         } 
      } 
      repaint(); 
   } 
   public void hanoi(int n, int a, int b, int c)//하노이 알고리즘 
   { 
      movePole m; 
      if (n == 1) 
      { 
         m = new movePole(a, c); 
         move.add(m); 
      } else 
      { 
         hanoi((n - 1), a, c, b); 
         m = new movePole(a, c); 
         move.add(m); 
         hanoi((n - 1), b, a, c); 
      } 
   } 
   public static void main(String[] args) 
   { 
      new Problem_49_HanoiTopProblem(); 
   } 
} 
class Disc//디스크를 나타내는 클래스 
{ 
   Color c; 
   int size; 
   public Disc(Color c, int size) 
   { 
      this.c = c; 
      this.size = size; 
   } 
} 
class movePole//어디에서 어디로 이동하는지 
{ 
   //next라면 a->b 
   //prev라면 b->a 
   int a; 
   int b; 
   public movePole(int a, int b) 
   { 
      this.a = a; 
      this.b = b; 
   } 
}