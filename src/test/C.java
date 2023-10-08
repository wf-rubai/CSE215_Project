package test;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.text.LayoutQueue;

public class C {
    private static JFrame f = new JFrame("test");
    private static JPanel pp = new JPanel();
    static int ii = 1;
    // private static JScrollPane sp = new JScrollPane(pp);
    public static void main(String[] args) {
        f.setLayout(null);
        f.setSize(1250, 850);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBackground(Color.gray);

        
        pp.setBounds(10, 10, 280, 1000);
        pp.setBackground(Color.blue);
        pp.setLayout(new BoxLayout(pp, BoxLayout.Y_AXIS));
        // pp.setLayout(null);
        // pp.setLayout(new GridBagLayout());
        
        // addpane(12);
        for(int i=0; i<80; i++){
            JPanel p = new JPanel();
            p.setLayout(null);
            p.setPreferredSize(new Dimension(280, 100));
            JButton b = new JButton(i + "");
            // p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
            p.setLayout(null);
            b.setBounds(100, 50, 80, 40);
            if(i%2 == 0)
                p.setBackground(Color.gray);
            else
                p.setBackground(Color.red);
            p.add(b);
            
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(ii%2 == 0){
                        p.setPreferredSize(new Dimension(280, 100));
                        SwingUtilities.updateComponentTreeUI(pp);
                        ii++;
                    }else{
                        p.setPreferredSize(new Dimension(280, 100));
                        SwingUtilities.updateComponentTreeUI(pp);
                        ii++;
                    }
                }
            });
            // p.setAlignmentX(Component.CENTER_ALIGNMENT);
            pp.add(p);
        }
        JScrollPane sp = new JScrollPane(pp);
        // sp.setLayout(null);
        sp.setBounds(300, 50, 300, 700);
        // sp.setLayout(null);
        sp.setBackground(Color.black);
        // sp.add(pp);
        f.add(sp);

        f.setVisible(true);
    }

    private static void addpane(int n){
        for(int i=0; i<n; i++){
            JPanel p = new JPanel();
            p.setLayout(null);
            p.setBounds(10, 20+(100*i), 280, 100);
            JButton b = new JButton("span");
            b.setBounds(100, 50, 80, 40);
            p.setBackground(Color.gray);
            p.add(b);
            b.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    p.setSize(280, 300);
                    SwingUtilities.updateComponentTreeUI(f);
                }
                
            });
            pp.add(p);
        }
    }
}

