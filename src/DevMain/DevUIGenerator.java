package DevMain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DevUIGenerator extends JFrame{
    
    private int tracOpt = 1;
    private JPanel pSB = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Point2D p1 = new Point2D.Float(0, 0);
            Point2D p2 = new Point2D.Float(0, 850);
            Color c1 = new Color(181, 51, 0);
            Color c2 = new Color(252, 159, 45);
            LinearGradientPaint gradientPaint = new LinearGradientPaint(p1, p2,
                                                new float[]{0.3f, 1.0f},
                                                new Color[]{c1, c2});
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(gradientPaint);
            g2.fillRoundRect(-50, 0, 350, 850, 40, 40);
        }
    };
    private JButton logBtn = new JButton("Log in");
    private LogInPanel logPanel = new LogInPanel();
    private MapView mapView = new MapView();
    private JButton option = new JButton();
    private JButton home = new JButton();
    private JButton settings = new JButton();
    private JButton travel = new JButton();
    private JButton logOut = new JButton();
    private JPanel UIPanel = new JPanel();

    private ImageIcon i1 = new ImageIcon("/Users/washioferdousrubai/Downloads/option.png");
    private ImageIcon i2 = new ImageIcon("/Users/washioferdousrubai/Downloads/home.png");
    private ImageIcon i3 = new ImageIcon("/Users/washioferdousrubai/Downloads/user.png");
    private ImageIcon i4 = new ImageIcon("/Users/washioferdousrubai/Downloads/hotel.png");
    private ImageIcon i5 = new ImageIcon("/Users/washioferdousrubai/Downloads/back.png");
    private ImageIcon i6 = new ImageIcon("/Users/washioferdousrubai/Downloads/logout.png");

    private JLabel l1 = new JLabel("Home");
    private JLabel l2 = new JLabel("User and Devoloper");
    private JLabel l3 = new JLabel("Hotels");
    private JLabel l4 = new JLabel(i2);
    private JLabel l5 = new JLabel(i3);
    private JLabel l6 = new JLabel(i4);

    public DevUIGenerator(String s){

        super(s);
        setSize(1250, 850);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.gray);

        UIPanel.setBounds(0, 0, 1250, 850);
        UIPanel.setLayout(null);
        UIPanel.setOpaque(false);
        UIPanel.setBorder(null);

        add(UIPanel);

        logBtn.setBounds(500, 620, 250, 40);
        logBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(logPanel.isLoged()){
                    rmv(1);
                }
            }
        });

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swap(1);
            }
        });

        travel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swap(2);
            }
        });

        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swap(3);
            }
        });

        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swap(4);
            }
        });

        option.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(tracOpt == 1){
                        pSB.setSize(300, 850);
                        option.setLocation(240, 30);
                        option.setIcon(i5);
                        home.setSize(280, 50);
                        travel.setSize(280, 50);
                        settings.setSize(280, 50);
                        pSB.add(logOut);
                        pSB.add(l1);
                        pSB.add(l2);
                        pSB.add(l3);
                        tracOpt = 0;
                    }else{
                        pSB.setSize(70, 850);
                        option.setLocation(10, 30);
                        option.setIcon(i1);
                        home.setSize(50, 50);
                        travel.setSize(50, 50);
                        settings.setSize(50, 50);
                        pSB.remove(logOut);
                        pSB.remove(l1);
                        pSB.remove(l2);
                        pSB.remove(l3);
                        tracOpt = 1;
                    }
                }catch(Exception ex){

                }
            }
        });

        UIPanel.add(logBtn);             // this is final
        UIPanel.add(logPanel.panel());   // this is final

        // UIPanel.add(pSB);                   //this is temporary
        // UIPanel.add(mapView.panel());       //this is temporary
        // SetUp();                            //this is temporary

        setVisible(true);
    }

    public DevUIGenerator(){

    }

    private void swap(int i){
        UIPanel.removeAll();
        UIPanel.add(pSB);
        if(i == 1){
            pSB.setBounds(0, 0,70, 850);
            option.setLocation(10, 30);
            option.setIcon(i1);
            home.setSize(50, 50);
            travel.setSize(50, 50);
            settings.setSize(50, 50);
            pSB.remove(logOut);
            pSB.remove(l1);
            pSB.remove(l2);
            pSB.remove(l3);
            tracOpt = 1;
            UIPanel.add(mapView.panel());
        }else if(i == 2){
            JPanel p1 = new JPanel();
            p1.setBounds(70, 0, 1180, 850);
            p1.setBackground(Color.GREEN);
            UIPanel.add(p1);
        }else if(i == 3){
            JPanel p2 = new JPanel();
            p2.setBounds(70, 0, 1180, 850);
            p2.setBackground(Color.BLUE);
            UIPanel.add(p2);
        }else if(i == 4){
            pSB.setBounds(0, 0,70, 850);
            option.setLocation(10, 30);
            option.setIcon(i1);
            home.setSize(50, 50);
            travel.setSize(50, 50);
            settings.setSize(50, 50);
            pSB.remove(logOut);
            pSB.remove(l1);
            pSB.remove(l2);
            pSB.remove(l3);
            tracOpt = 1;
            UIPanel.remove(pSB);
            UIPanel.add(logBtn);
            logPanel = new LogInPanel();
            UIPanel.add(logPanel.panel());
        }
        SwingUtilities.updateComponentTreeUI(UIPanel);
    }

    public void rmv(int i){
        if(i == 1){
            UIPanel.remove(logPanel.panel());
            UIPanel.remove(logBtn);
            UIPanel.add(pSB);
            UIPanel.add(mapView.panel());
            SetUp();
            SwingUtilities.updateComponentTreeUI(this);
        }
    }

    private void SetUp(){
        option.setBounds(10, 30, 50, 50);
        home.setBounds(10, 320, 50, 50);
        travel.setBounds(10, 400, 50, 50);
        settings.setBounds(10, 480, 50, 50);
        logOut.setBounds(75, 800, 150, 50);
        
        l1.setBounds(60, 320, 200, 50);
        l2.setBounds(60, 400, 200, 50);
        l3.setBounds(60, 480, 200, 50);
        l4.setBounds(10, 320, 50, 50);
        l5.setBounds(10, 400, 50, 50);
        l6.setBounds(10, 480, 50, 50);

        option.setIcon(i1);
        option.setOpaque(false);
        option.setContentAreaFilled(false);
        option.setBorderPainted(false);
        option.setFocusable(false);
        
        home.setOpaque(false);
        home.setContentAreaFilled(false);
        home.setBorderPainted(false);
        home.setFocusable(false);
        
        travel.setOpaque(false);
        travel.setContentAreaFilled(false);
        travel.setBorderPainted(false);
        travel.setFocusable(false);
        
        settings.setOpaque(false);
        settings.setContentAreaFilled(false);
        settings.setBorderPainted(false);
        settings.setFocusable(false);

        logOut.setOpaque(false);
        logOut.setContentAreaFilled(false);
        logOut.setBorderPainted(false);
        logOut.setFocusable(false);
        logOut.setText("Log out");
        logOut.setFont(new Font(null, Font.PLAIN, 12));
        logOut.setIcon(i6);

        l1.setFont(new Font(null, Font.PLAIN, 20));
        l2.setFont(new Font(null, Font.PLAIN, 20));
        l3.setFont(new Font(null, Font.PLAIN, 20));

        pSB.setBounds(0, 0, 70, 850);
        pSB.setLayout(null);

        pSB.add(option);
        pSB.add(l4);
        pSB.add(l5);
        pSB.add(l6);
        pSB.add(home);
        pSB.add(travel);
        pSB.add(settings);
    }
}
