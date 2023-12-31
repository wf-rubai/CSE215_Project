package UserMain;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Common.ObjectSaver;
import Common.ProfilePanel;
import Common.UserInfo;
import Common.FileReader;

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
    private JPanel mainPanel = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            for(int i = 0; i<20; i++){
                int a = (int)(30+Math.random()*300);
                g2.setColor(randomColor());
                g2.fillRoundRect((int)(Math.random()*1000), (int)(Math.random()*700), a, a, a, a);
                g2.drawRoundRect((int)(Math.random()*1000), (int)(Math.random()*700), a, a, a, a);
            }
        }
    };
    private JPanel pExit = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            int i = 100;
            g2.setColor(new Color(0, 2, 120, 100));
            g2.fillRoundRect(2, 2, i, i, i, i);
            g2.setStroke(new BasicStroke(2));
            g2.setColor(new Color(0, 2, 120));
            g2.drawRoundRect(2, 2, i, i, i, i);
        }
    };
    private JPanel pExit2 = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Point2D p1 = new Point2D.Float(0, 0);
            Point2D p2 = new Point2D.Float(200, 150);
            Color c1 = new Color(102, 0, 255);
            Color c2 = new Color(166, 0, 255);
            LinearGradientPaint gradientPaint = new LinearGradientPaint(p1, p2,
                                                new float[]{0.3f, 1.0f},
                                                new Color[]{c1, c2});
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(gradientPaint);
            g2.fillRoundRect(-50, 0, 350, 850, 40, 40);
        }
    };
    private JFrame fExit = new JFrame("Exited");
    private JButton lExit = new JButton("Sayonara");
    private JButton bExit = new JButton("Exit");
    private JButton option = new JButton();
    private JButton home = new JButton();
    private JButton settings = new JButton();
    private JButton travel = new JButton();
    private JButton logBack = new JButton(new ImageIcon("Images/Icons/back.png"));
    private JButton log = new JButton();
    private MapMain mapView = new MapMain();
    private ImageIcon i1 = new ImageIcon("Images/Icons/option.png");
    private ImageIcon i2 = new ImageIcon("Images/Icons/home.png");
    private ImageIcon i3 = new ImageIcon("Images/Icons/travle.png");
    private ImageIcon i4 = new ImageIcon("Images/Icons/setting.png");
    private ImageIcon i5 = new ImageIcon("Images/Icons/back.png");
    private ImageIcon i6 = new ImageIcon("Images/Icons/logout.png");
    private ImageIcon i7 = new ImageIcon("Images/Icons/login.png");
    private JLabel l1 = new JLabel("Home");
    private JLabel l2 = new JLabel("Travel History");
    private JLabel l3 = new JLabel("Settings");
    private JLabel l4 = new JLabel(i2);
    private JLabel l5 = new JLabel(i3);
    private JLabel l6 = new JLabel(i4);
    private ProfilePanel profile = new ProfilePanel(UserLogPanel.logerID.name, UserLogPanel.logerID.imgIndex);

    public UserUIGenerator(String s){
        super(s);
        setSize(1250, 850);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.gray);
        setUndecorated(true);

        mainPanel.setBounds(0, 0, 1250, 850);
        mainPanel.setLayout(null);
        mainPanel.setOpaque(false);
        mainPanel.setBorder(null);

        SetUp();

        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StaticUser.exit();
                fExit.setVisible(true);
            }
        });

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swap(1);
            }
        });

        logBack.addActionListener(new ActionListener() {
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
                if(!UserLogPanel.isLoged){
                    log.setIcon(i6);
                    log.setText("Log out");
                    swap(4);
                }else{
                    log.setIcon(i7);
                    log.setText("Log in/Sign in");
                    swap(5);
                }
            }
        });

        option.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(tracOpt == 1){
                        profile = new ProfilePanel(UserLogPanel.logerID.name, UserLogPanel.logerID.imgIndex);
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
                        if(UserLogPanel.isLoged){
                            pSB.add(profile.panel());
                        }
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
                        pSB.remove(profile.panel());
                        tracOpt = 1;
                    }
                }catch(Exception ex){

                }
            }
        });

        mainPanel.add(pSB);
        mainPanel.add(mapView.panel());

        pExit.add(bExit);
        add(pExit);
        add(mainPanel);
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
            profile = new ProfilePanel(UserLogPanel.logerID.name, UserLogPanel.logerID.imgIndex);
            pSB.remove(profile.panel());
            tracOpt = 1;
            mapView = new MapMain();
            mainPanel.add(mapView.panel());
        }else if(i == 2){
            if(UserLogPanel.isLoged){
                mainPanel.add(new TravelHistory().panel());
            }
        }else if(i == 3){
            mainPanel.add(new SettingPanel().panel());
        }else if(i == 4){
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
            pSB.remove(profile.panel());
            tracOpt = 1;
            mainPanel.add(logBack);
            mainPanel.add(new UserLogPanel().panel());
        }else if(i == 5){
            swap(1);LinkedList<Object> o = new FileReader().objectList();
            o.set(0, false);
            o.set(1, new UserInfo("", "", "", "", "", "", 13));
            new ObjectSaver(o);
            pSB.removeAll();
            pSB.add(option);
            pSB.add(l4);
            pSB.add(l5);
            pSB.add(l6);
            pSB.add(home);
            pSB.add(travel);
            pSB.add(settings);
            profile = new ProfilePanel("", 13);
            UserLogPanel.isLoged = false;
        }
        SwingUtilities.updateComponentTreeUI(mainPanel);
    }

    private void SetUp(){

        fExit.setSize(200, 150);
        fExit.setLayout(null);
        fExit.setLocationRelativeTo(null);
        fExit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pExit2.setBounds(0, -20, 200, 150);
        lExit.setBounds(0, -20, 200, 150);
        lExit.setFont(new Font(Font.SERIF, Font.PLAIN, 23));
        lExit.setForeground(Color.white);
        lExit.setOpaque(false);
        lExit.setContentAreaFilled(false);
        lExit.setBorderPainted(false);
        lExit.setFocusable(false);

        fExit.add(lExit);
        fExit.add(pExit2);

        pExit.setBounds(1165, 785, 120, 100);
        pExit.setOpaque(false);
        pExit.setLayout(null);

        bExit.setBounds(0, 0, 95, 85);
        bExit.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
        bExit.setForeground(Color.white);
        bExit.setOpaque(false);
        bExit.setContentAreaFilled(false);
        bExit.setBorderPainted(false);
        bExit.setFocusable(false);

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

        l1.setForeground(Color.black);
        l2.setForeground(Color.black);
        l3.setForeground(Color.black);

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
        log.setFont(new Font(null, Font.PLAIN, 12));
        if(UserLogPanel.isLoged){
            log.setIcon(i6);
            log.setText("Log out");
        }else{
            log.setIcon(i7);
            log.setText("Log in/Sign in");
        }

        l1.setFont(new Font(null, Font.PLAIN, 20));
        l2.setFont(new Font(null, Font.PLAIN, 20));
        l3.setFont(new Font(null, Font.PLAIN, 20));

        pSB.setBounds(0, 0, 70, 850);
        pSB.setOpaque(false);
        pSB.setLayout(null);

        logBack.setBounds(100, 30, 32, 32);
        logBack.setOpaque(false);
        logBack.setContentAreaFilled(false);
        logBack.setBorderPainted(false);
        logBack.setFocusable(false);

        pSB.add(option);
        pSB.add(l4);
        pSB.add(l5);
        pSB.add(l6);
        pSB.add(home);
        pSB.add(travel);
        pSB.add(settings);
    }

    private static Color randomColor() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return new Color(r, g, b, 100);
    }
}
