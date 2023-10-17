package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class B2 extends B implements Runnable {

    private int x;
    private JPanel p;
    private int s;
    private int ii;
    private Color c = getRandomColor();
    // private int iii = (int) -(Math.random()*700);

    public B2(){
        int i = (int) (20+Math.random()*20);
        ii = i;
        p = new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g.setColor(c);
                g2.fillRoundRect(0, 0, i, i, i, i);
            }
        };
        this.x = (int)(100+(Math.random()*800));
        this.s = (int)(3+(Math.random()*7));
        p.setBounds(x, -i, i, i);
        p.setOpaque(false);
        // p.setBackground(Color.black);
    }

    public JPanel panel(){
        return p;
    }

    @Override
    public void run() {
        int iii = (int) (ii + 700+ Math.random()*700);
        // int iii = 0;
        while(true){
            p.setLocation(x, iii-ii);
            iii--;
            if(iii<0)
                iii = 700+ii;
            try {
                Thread.sleep(s);
            } catch (InterruptedException e) {
            }

        }
    }

    private static Color getRandomColor() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return new Color(r, g, b, 100);
    }
}
