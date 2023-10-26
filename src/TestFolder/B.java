package TestFolder;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class B {
        
    protected static JFrame f = new JFrame();
    protected static JPanel p = new JPanel();
    public static void main(String[] args) {


        p.setSize(1050, 700);
        p.setLayout(null);
        // p.setBackground(Color.darkGray);
        // p.setOpaque(false);

        for(int i = 0; i<30; i++){
            B2 d = new B2();
            Thread t = new Thread(d);
            t.start();
            p.add(d.panel());
        }

        JTextField tf = new JTextField();
        tf.setBounds(200, 500, 500, 40);

        // f.add(tf);
        f.add(p);
        f.setSize(1050, 700);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
    }
}
