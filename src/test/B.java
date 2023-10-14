package test;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class B {
        
    protected static JFrame f = new JFrame();
    protected static JPanel p = new JPanel();
    public static void main(String[] args) {


        p.setSize(1030, 700);
        p.setLayout(null);

        for(int i = 0; i<200; i++){
            D d = new D();
            Thread t = new Thread(d);
            t.start();
            p.add(d.panel());
        }

        f.add(p);
        f.setSize(1030, 700);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
    }
}
