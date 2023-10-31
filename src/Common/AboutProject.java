package Common;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AboutProject extends JPanel implements CPanel {

    private JLabel lPie = new JLabel(new ImageIcon("Images/HotelImage/pie.png"));
    private JLabel l9 = new JLabel("Basic Java (9%)");
    private JLabel l25 = new JLabel("Algorithom & File Process (25%)");
    private JLabel l60 = new JLabel("Swing & Graphics (60%)");
    private JLabel l6 = new JLabel("Image Process (6%)");
    private JLabel l1 = new JLabel(" Washio Ferdous Rubai");
    private JLabel l2 = new JLabel(" Nabila Tabassum Oyshi");
    private JLabel l3 = new JLabel(" Mahmuda Jannat ");
    private JLabel l4 = new JLabel(" Wasif Haider ");
    private JLabel id1 = new JLabel("2231107642");
    private JLabel id2 = new JLabel("2231386042");
    private JLabel id3 = new JLabel("2231518642");
    private JLabel id4 = new JLabel("2232829642");
    private JLabel m1 = new JLabel("washio.ferdous@northsouth.edu");
    private JLabel m2 = new JLabel("nabila.oyshi@northsouth.edu");
    private JLabel m3 = new JLabel("mahmuda.punny@northsouth.edu");
    private JLabel m4 = new JLabel("wasif.haider@northsouth.edu");
    private JButton b1 = new JButton("About Developers");
    private JButton b2 = new JButton("About Project");
    private JLabel[] l = new JLabel[10];

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(10, 10, 580,830, 30, 30);
        g2.setColor(new Color(0, 0, 0, 50));
        g2.fillRoundRect(10, 10, 580,830, 30, 30);
    }

    @Override
    public JPanel panel() {

        setup();

        return this;
    }

    private void setup(){

        JPanel frame = new JPanel();
        frame.setBounds(0,0,600,350);
        frame.setLayout(null);
        frame.setOpaque(false);

        b2.setBounds(50,270, 500,40);
        b1.setBounds(50,50,500,40);
        id4.setBounds(220,210,300,30);
        id3.setBounds(220,180,300,30);
        id2.setBounds(220,150,300,30);
        id1.setBounds(220,120,300,30);
        l4.setBounds(50,210,200,30);
        l3.setBounds(50,180,200,30);
        l2.setBounds(50,150,200,30);
        l1.setBounds(50,120,200,30);
        m4.setBounds(340,210,220,30);
        m3.setBounds(340,180,220,30);
        m2.setBounds(340,150,220,30);
        m1.setBounds(340,120,220,30);

        m1.setForeground(Color.white);
        m2.setForeground(Color.white);
        m3.setForeground(Color.white);
        m4.setForeground(Color.white);
        l1.setForeground(Color.white);
        l2.setForeground(Color.white);
        l3.setForeground(Color.white);
        l4.setForeground(Color.white);
        id1.setForeground(Color.white);
        id2.setForeground(Color.white);
        id3.setForeground(Color.white);
        id4.setForeground(Color.white);
        b1.setForeground(Color.white);
        b2.setForeground(Color.white);

        frame.add(m1);
        frame.add(m2);
        frame.add(m3);
        frame.add(m4);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(id1);
        frame.add(id2);
        frame.add(id3);
        frame.add(id4);
        frame.add(b1);
        frame.add(b2);

        b1.setOpaque(false);
        b1.setContentAreaFilled(false);
        b1.setBorderPainted(false);
        b1.setFocusable(false);
        b1.setFont(new Font(Font.SERIF, Font.PLAIN, 25));
        b2.setOpaque(false);
        b2.setContentAreaFilled(false);
        b2.setBorderPainted(false);
        b2.setFocusable(false);
        b2.setFont(new Font(Font.SERIF, Font.PLAIN, 25));

        setBounds(580, 0, 600, 850);
        setLayout(null);
        setOpaque(false);

        lPie.setBounds(100, 500, 450, 300);
        lPie.setBorder(new EmptyBorder(100, 160, 0, 100));

        l25.setBounds(0, 150, 200, 20);
        l25.setForeground(new Color(124, 163, 127));

        l9.setBounds(260, 125, 200, 20);
        l9.setForeground(new Color(255, 125, 131));

        l60.setBounds(130, 260, 200, 20);
        l60.setForeground(new Color(130, 195, 255));

        l6.setBounds(305, 150, 250, 20);
        l6.setForeground(new Color(255, 224, 138));

        File file = new File("Files/info.txt");
        try{
            Scanner sc = new Scanner(file);
            for(int i = 0; i<9; i++){
                l[i] = new JLabel();
                l[i].setText(sc.nextLine());
                l[i].setBounds(50, 340+(i*30), 500, 30);
                l[i].setForeground(Color.white);
                l[i].setFont(new Font(null, Font.PLAIN, 12));
                add(l[i]);
            }
            sc.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "File reading error", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "File reading error", JOptionPane.ERROR_MESSAGE);
        }

        lPie.add(l25);
        lPie.add(l6);
        lPie.add(l9);
        lPie.add(l60);

        add(frame);
        add(lPie);
    }
    
}
