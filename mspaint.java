import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
 
public class mspaint extends JFrame implements MouseMotionListener {
    // JFrame 상속, MouseMotionListener 구현
 
    Image image;
    Graphics graphics;
    JButton jb1 = new ColorButton(); // 색버튼, 상속 다형성
    JButton jb2 = new ColorButton();
    JButton jb3 = new ColorButton();
    JButton jb4 = new ColorButton();
    JButton jb5 = new ColorButton();
    JButton jb6 = new ColorButton();
    JButton jb7 = new ColorButton();
    JButton jb8 = new ColorButton();
 
    public mspaint() { // 생성자
        setBounds(100, 100, 800, 850); // 그림판 틀
        setLayout(null);
        jb1.setBackground(Color.BLUE);
        jb1.setBounds(0, 0, 100, 100);
        jb2.setBackground(Color.RED);
        jb2.setBounds(0, 100, 100, 100);
        jb3.setBackground(Color.ORANGE);
        jb3.setBounds(0, 200, 100, 100);
        jb4.setBackground(Color.GREEN);
        jb4.setBounds(0, 300, 100, 100);
        jb5.setBackground(Color.BLACK);
        jb5.setBounds(0, 400, 100, 100);
        jb6.setBackground(Color.WHITE);
        jb6.setBounds(0, 500, 100, 100);
        jb7.setBackground(Color.PINK);
        jb7.setBounds(0, 600, 100, 100);
        jb8.setBackground(Color.GRAY);
        jb8.setBounds(0, 700, 100, 100);
        add(jb1);
        add(jb2);
        add(jb3);
        add(jb4);
        add(jb5);
        add(jb6);
        add(jb7);
        add(jb8);
        setVisible(true); //시각화
 
        image = createImage(690, 850); //도화지
        graphics = image.getGraphics(); //그래픽
        graphics.setColor(Color.white); //도화지 색 #ffffff
        graphics.fillRect(0, 0, 690, 850); //도화지 사이즈
        setDefaultCloseOperation(EXIT_ON_CLOSE); //종료
 
        graphics.setColor(Color.black);
        repaint(); // paint 메소드를 호출
        addMouseMotionListener(this); // 마우스모션 그림판 연결
    }
 
    class ColorButton extends JButton implements ActionListener { 
        //JButton 상속 자녀 클래스 이너 클래스, 액션 리스너
        public ColorButton() {
            addActionListener(this); //액션리스너 호출
        }
 
        @Override
        public void actionPerformed(ActionEvent e) {
            graphics.setColor(getBackground()); // 배경색 글자색
            
        }
    }

    @Override
    public void paint(Graphics g) {

//         super.paint(g); // 그림판이 깜빡임
        g.drawImage(image, 110, 0, this); // 설정한 도화지 그림판 끼움
    }

    public static void main(String[] args) {
        
        new mspaint();
    }
 
    int x, y;
 
    @Override
    public void mouseDragged(MouseEvent e) {
        
 
        if (e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK) {
            graphics.drawLine(x, y, e.getX() - 110, e.getY());
            x = e.getX() - 110;
            y = e.getY();
        }
        if (e.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK) {
            graphics.setColor(Color.white);
            graphics.fillOval(e.getX() - 125, e.getY() - 15, 50, 50);
 
        }
        repaint();
 
    }
 
    @Override
    public void mouseMoved(MouseEvent e) {
        
        x = e.getX() - 110;
        y = e.getY();
    }
}