package TestFolder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.BoxLayout;
// import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
// import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

// import Common.HotelInfoPanel;
// import Common.Hotels;
import Common.TravelPanel;
import Common.FileReader;

public class C {
    private static JFrame f = new JFrame("test");
    private static JPanel pp = new JPanel();
    // private static int i = 1;

    static int ii = 1;
    // private static HashMap<String, LinkedList<Hotels>> hm = new fileReader().hotelHashMap();
    public static void main(String[] args) {
        f.setLayout(null);
        f.setSize(1250, 850);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBackground(Color.gray);

        // LinkedList<Hotels> ll = hm.get("Bogura");
        LinkedList<String[]> ss = new FileReader().travelHashMap().get("Washio Ferdous Rubai");

        pp.setLayout(new BoxLayout(pp, BoxLayout.Y_AXIS));
        pp.setOpaque(false);
        pp.setBorder(null);
        pp.setBackground(Color.gray);
        JScrollPane sp = new JScrollPane(pp,
                                        JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER){
                                            @Override
                                            protected void paintComponent(Graphics g) {
                                                super.paintComponent(g);
                                                Graphics2D g2 = (Graphics2D) g;
                                                g2.setColor(Color.white);
                                                // g2.fillRoundRect(0, 0, 310, 650, 45, 45);
                                            }
                                        };
        // sp.setOpaque(false);
        // sp.setBounds(80, 190, 310, 650);
        // sp.setBorder(new EmptyBorder(5, 10, 5, 10));
        sp.setOpaque(false);
        sp.setBounds(70, 0, 1180, 550);
        sp.setBorder(new EmptyBorder(50, 140, 50, 140));

        // int i= 1;
        for(String[] s: ss){
            // if(i != 2)
            pp.add(new TravelPanel(s).panel());
            // i++;
        }

        // for(Hotels h: ll){
        //     JButton b = new JButton();
        //     b.setOpaque(false);
        //     b.setContentAreaFilled(false);
        //     b.setBorderPainted(false);
        //     b.setFocusable(false);
        //     HotelInfoPanel hip = new HotelInfoPanel(h);
        //     b.setBounds(0, 0, 290, 190);

        //     b.addActionListener(new ActionListener() {
        //         @Override
        //         public void actionPerformed(ActionEvent e) {
        //             hip.resize();
        //             if(i%2 == 1){
        //                 b.setBounds(0, 50, 290, 290);
        //             }else{
        //                 b.setBounds(0, 00, 290, 190);
        //             }
        //             i++;
        //             SwingUtilities.updateComponentTreeUI(sp);
        //         }
        //     });

        //     hip.panel().add(b);
        //     pp.add(hip.panel());
        // }
        f.add(sp);

        f.setVisible(true);
    }
}

