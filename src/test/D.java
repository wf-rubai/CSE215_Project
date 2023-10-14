package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class D extends B implements Runnable {

    private int x;
    private JPanel p;
    private int s;
    private int ii;
    private Color c = getRandomColor();
    // private int iii = (int) -(Math.random()*700);

    public D(){
        int i = (int) (10+Math.random()*20);
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
        this.s = (int)(5+(Math.random()*5));
        p.setBounds(x, -i, i, i);
        p.setOpaque(false);
        // p.setBackground(Color.black);
    }

    public JPanel panel(){
        return p;
    }

    @Override
    public void run() {
        int iii = (int) -(Math.random()*700);
        // int iii = 0;
        while(true){
            p.setLocation(x, (iii%(700+ii))-ii);
            SwingUtilities.updateComponentTreeUI(p);
            iii++;
            iii = (iii%(700+ii));
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
