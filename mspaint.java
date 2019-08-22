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
    // JFrame 상속하고, MouseMotionListener 를 구현함
 
    Image image;
    Graphics graphics;
    JButton jb1 = new ColorButton(); // 색을 바꾸는 버튼 설치, 상속과 다형성 개념 활용
    JButton jb2 = new ColorButton();
    JButton jb3 = new ColorButton();
    JButton jb4 = new ColorButton();
    JButton jb5 = new ColorButton();
    JButton jb6 = new ColorButton();
    JButton jb7 = new ColorButton();
    JButton jb8 = new ColorButton();
 
    public mspaint() { // 생성자
        setBounds(100, 100, 800, 850); // 그림판 틀 만들기
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
        addMouseMotionListener(this); // 마우스모션을 그림판과 연결
    }
 
    class ColorButton extends JButton implements ActionListener { 
        //JButton 을 상속하는 자녀 클래스로 이너 클래스 설정, 액션 리스너를 구현함
        public ColorButton() {
            addActionListener(this); //액션리스너 호출
        }
 
        @Override
        public void actionPerformed(ActionEvent e) {
            graphics.setColor(getBackground()); // 배경색을 따서 글자색으로 설정
            
        }
    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
//         super.paint(g); // 그림판이 깜빡이듯 나타나는 현상을 막기 위해 블락 처리
        g.drawImage(image, 110, 0, this); // 위에서 설정한 도화지 이미지를 그림판의 틀에 띄우기
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new mspaint();
    }
 
    int x, y;
 
    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
 
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
        // TODO Auto-generated method stub
        x = e.getX() - 110;
        y = e.getY();
    }
}