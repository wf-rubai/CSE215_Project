package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import DevMain.LogInPanel;

public class B {

        private static JFrame f = new JFrame("test");
        private static LogInPanel lp = new LogInPanel();
        private static JButton b = new JButton("asd");

    public static void main(String[] args) {
        f.setSize(1250, 850);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);

        b.setBounds(500, 620, 250, 40);

        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(lp.isLoged()){
                    rmv(1);
                }
            }
            
        });
        f.add(b);

        // SwingUtilities.invokeLater(new Runnable() {
        //     @Override
        //     public void run() {
                f.add(lp.panel());
                // b.addActionListener(new ActionListener() {
                //     @Override
                //     public void actionPerformed(ActionEvent e) {
                //         System.out.println("sldfj");
                //         if(lp.isLoged()){
                //             System.out.println("zcxnm");
                //             rmv(1);
                //         }
                //     }
                // });
        //     }
        // });

        // f.add(new D());
        // f.getContentPane().add(new Shapes1());
        f.setVisible(true);
    }

    public static void rmv(int i){
        if(i == 1){
            f.remove(lp.panel());
            f.remove(b);
            SwingUtilities.updateComponentTreeUI(f);
        }
    }
}
