package UserMain;

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

public class UserUIGenerator extends JFrame {

    private int tracOpt = 1;
    private JPanel pSB = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Point2D p1 = new Point2D.Float(0, 0);
            Point2D p2 = new Point2D.Float(0, 850);
            Color c1 = new Color(102, 0, 255);
            Color c2 = new Color(166, 0, 255);
            LinearGradientPaint gradientPaint = new LinearGradientPaint(p1, p2,
                                                new float[]{0f, 0.9f},
                                                new Color[]{c1, c2});
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(gradientPaint);
            g2.fillRoundRect(-50, 0, 350, 850, 40, 40);
        }
    };
    private JPanel mainPanel = new JPanel();
    private JButton option = new JButton();
    private JButton home = new JButton();
    private JButton settings = new JButton();
    private JButton travel = new JButton();
    private JButton log = new JButton();
    private MapMain mapView = new MapMain();

    private ImageIcon i1 = new ImageIcon("Images/Icons/option.png");
    private ImageIcon i2 = new ImageIcon("Images/Icons/home.png");
    private ImageIcon i3 = new ImageIcon("Images/Icons/travle.png");
    private ImageIcon i4 = new ImageIcon("Images/Icons/setting.png");
    private ImageIcon i5 = new ImageIcon("Images/Icons/back.png");
    private ImageIcon i6 = new ImageIcon("Images/Icons/logout.png");
    // private ImageIcon i7 = new ImageIcon("Images/Icons/login.png");

    private JLabel l1 = new JLabel("Home");
    private JLabel l2 = new JLabel("User and Devoloper");
    private JLabel l3 = new JLabel("Hotels");
    private JLabel l4 = new JLabel(i2);
    private JLabel l5 = new JLabel(i3);
    private JLabel l6 = new JLabel(i4);

    public UserUIGenerator(String s){
        super(s);
        setSize(1250, 850);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.gray);

        mainPanel.setBounds(0, 0, 1250, 850);
        mainPanel.setLayout(null);
        mainPanel.setOpaque(false);
        mainPanel.setBorder(null);

        SetUp();

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

        log.addActionListener(new ActionListener() {
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
                        pSB.add(log);
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
                        pSB.remove(log);
                        pSB.remove(l1);
                        pSB.remove(l2);
                        pSB.remove(l3);
                        tracOpt = 1;
                    }
                }catch(Exception ex){

                }
            }
        });

        mainPanel.add(pSB);
        mainPanel.add(mapView.panel());

        add(mainPanel);
        
        setVisible(true);
    }

    private void swap(int i){
        mainPanel.removeAll();
        mainPanel.add(pSB);
        if(i == 1){
            pSB.setBounds(0, 0,70, 850);
            option.setLocation(10, 30);
            option.setIcon(i1);
            home.setSize(50, 50);
            travel.setSize(50, 50);
            settings.setSize(50, 50);
            pSB.remove(log);
            pSB.remove(l1);
            pSB.remove(l2);
            pSB.remove(l3);
            tracOpt = 1;
            mapView = new MapMain();
            mainPanel.add(mapView.panel());
        }else if(i == 2){
            JPanel p1 = new JPanel();
            p1.setBounds(70, 0, 1180, 850);
            p1.setBackground(Color.GREEN);
            mainPanel.add(p1);
        }else if(i == 3){
            JPanel p2 = new JPanel();
            p2.setBounds(70, 0, 1180, 850);
            p2.setBackground(Color.BLUE);
            mainPanel.add(p2);
        }else if(i == 4){
            // pSB.setBounds(0, 0,70, 850);
            // option.setLocation(10, 30);
            // option.setIcon(i1);
            // home.setSize(50, 50);
            // travel.setSize(50, 50);
            // settings.setSize(50, 50);
            // pSB.remove(log);
            // pSB.remove(l1);
            // pSB.remove(l2);
            // pSB.remove(l3);
            // tracOpt = 1;
            // mainPanel.remove(pSB);
            // mainPanel.add(logBtn);
            // logPanel = new LogInPanel();
            // mainPanel.add(logPanel.panel());
        }
        SwingUtilities.updateComponentTreeUI(mainPanel);
    }

    private void SetUp(){
        option.setBounds(10, 30, 50, 50);
        home.setBounds(10, 320, 50, 50);
        travel.setBounds(10, 400, 50, 50);
        settings.setBounds(10, 480, 50, 50);
        log.setBounds(75, 800, 150, 50);
        
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

        log.setOpaque(false);
        log.setContentAreaFilled(false);
        log.setBorderPainted(false);
        log.setFocusable(false);
        log.setText("Log out");
        log.setFont(new Font(null, Font.PLAIN, 12));
        log.setIcon(i6);

        l1.setFont(new Font(null, Font.PLAIN, 20));
        l2.setFont(new Font(null, Font.PLAIN, 20));
        l3.setFont(new Font(null, Font.PLAIN, 20));

        pSB.setBounds(0, 0, 70, 850);
        pSB.setOpaque(false);
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
