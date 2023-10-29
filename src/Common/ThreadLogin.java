package Common;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class ThreadLogin implements Runnable, CPanel {

    private int x;
    private JPanel p;
    private int s;
    private int ii;
    private Color c = getRandomColor();
    private int a = (int)(Math.random()*2);
    // private int iii = (int) -(Math.random()*700);

    public ThreadLogin(){
        int i = (int) (30+Math.random()*300);
        ii = i;
        p = new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g.setColor(c);
                if(a == 1){
                    g2.fillRoundRect(0, 0, i, i, i, i);
                }else{
                    g2.setStroke(new BasicStroke(2));
                    g2.drawRoundRect(2, 2, i-4, i-4, i-4, i-4);
                }
            }
        };
        this.x = (int)((Math.random()*800));
        this.s = (int)(2+(Math.random()*8));
        p.setBounds(x, -i, i, i);
        p.setOpaque(false);
        // p.setBackground(Color.black);
    }

    @Override
    public JPanel panel(){
        return p;
    }

    @Override
    public void run() {
        int iii = (int) (ii + 700+ Math.random()*1100);
        // int iii = 0;
        while(true){
            p.setLocation(x, iii-ii);
            iii--;
            if(iii<0)
                iii = 850+ii;
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
