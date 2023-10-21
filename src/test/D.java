package test;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import DevMain.HotelTable;

public class D implements Runnable {
    private static JPanel p = new JPanel();

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(1250, 850);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setBackground(Color.pink);

        p.setBounds(0, 0, 1250, 850);
        p.setLayout(null);
        // Thread t = new Thread(new D());
        // t.start();
        p.add(new HotelTable().panel());
        f.add(p);
        f.setVisible(true);
    }

    @Override
    public void run() {
        int r = 100;
        int g = 100;
        int b = 100;
        int i = 1;
        int j = 1;
        int k = 1;
        while(true){
            p.setBackground(new Color(r, g, b, 100));

            if(i == 1){
                r++;
                if(r == 255)
                    i = 0;
            }else if(i == 0){
                r--;
                if(r == 1)
                    i = 1;
            }


            if(r == 0 || r == 255){
                if(j == 1){
                    g++;
                    if(g == 255)
                        j = 0;
                }else if(j == 1){
                    g--;
                    if(g == 0)
                        j = 1;
                }
            }
            if(g == 0 || g == 255){
                if(k == 1){
                    b++;
                    if(b == 256)
                        k = 0;
                }else if(k == 0){
                    b--;
                    if(b == 1)
                        k = 1;
                }
            }
            
            // int i = (int)(Math.random()*3);
            // if(i==0){
            //     int a = (int)(Math.random()*2);
            //     if((r>254 &&  a == 0) || (r<1 &&  a == 1)){

            //     }else if(a == 0){
            //         r++;
            //     }else if(a == 1){
            //         r--;
            //     }
            //     p.setBackground(new Color(r, g, b, 100));
            // }else if(i==1){
            //     int a = (int)(Math.random()*2);
            //     if((g>254 &&  a == 0) || (g<1 &&  a == 1)){

            //     }else if(a == 0){
            //         g++;
            //     }else if(a == 1){
            //         g--;
            //     }
            //     p.setBackground(new Color(r, g, b, 100));
            // }else if(i==2){
            //     int a = (int)(Math.random()*2);
            //     if((b>254 &&  a == 0) || (b<1 &&  a == 1)){

            //     }else if(a == 0){
            //         b++;
            //         // System.out.println("kdkd");
            //     }else if(a == 1){
            //         b--;
            //         // System.out.println("ieie");
            //     }
            //     p.setBackground(new Color(r, g, b, 100));
            // }
            // System.out.println(i);
            // if(r>254){
            //     r = 0;
            // }
            // if(g>254){
            //     g = 0;
            // }
            // if(b>254){
            //     b = 0;
            // }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
            }
        }
    }
    
}
