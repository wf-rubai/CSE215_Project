package UserMain;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Common.AboutProject;
import Common.CPanel;
import Common.PointreScrollPanel;
import Common.ProfileScrollPanel;

public class SettingPanel extends JPanel implements CPanel {

    private JButton bProfile = new JButton("Change Avatar"){
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.white);
            g2.setStroke(new BasicStroke(2));
            g2.drawRect(-20, 2, 240, 36);
            g2.setColor(new Color(255, 255, 255, 10));
            g2.fillRect(-20, 2, 240, 36);
        }
    };
    private JButton bMapPointer = new JButton("Change Map Pointer"){
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.white);
            g2.setStroke(new BasicStroke(2));
            g2.drawRect(-20, 2, 240, 36);
            g2.setColor(new Color(255, 255, 255, 10));
            g2.fillRect(-20, 2, 240, 36);
        }
    };
    private JButton bReset = new JButton("Restart"){
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.white);
            g2.setStroke(new BasicStroke(2));
            g2.drawRect(-20, 2, 240, 36);
            g2.setColor(new Color(255, 255, 255, 10));
            g2.fillRect(-20, 2, 240, 36);
        }
    };
    private JButton bAbout = new JButton("About"){
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.white);
            g2.setStroke(new BasicStroke(2));
            g2.drawRect(-20, 2, 240, 36);
            g2.setColor(new Color(255, 255, 255, 10));
            g2.fillRect(-20, 2, 240, 36);
        }
    };
    private JPanel pReset = new JPanel(){
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.black);
            g2.setStroke(new BasicStroke(2));
            g2.drawRoundRect(2, 2, 396, 246, 30, 30);
            g2.setColor(new Color(0, 0, 0, 50));
            g2.fillRoundRect(2, 2, 396, 246, 30, 30);
            g2.setColor(Color.darkGray);
            g2.fillRoundRect(140, 200, 120, 30, 20, 20);
        }
    };
    private JButton cancel1 = new JButton(new ImageIcon("Images/Icons/back.png"));
    private JButton lProblem = new JButton("Facing Troubles?");
    private JButton restart = new JButton("Restart now");
    private JLabel lTrabel = new JLabel("If you are facing some kind of trouble try restarting the");
    private JLabel lTrabel1 = new JLabel("system.");

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon("Images/HotelImage/open2.png").getImage();
        g.drawImage(image, 0, 0, 1180, 850, this);
        ImageIcon imageIcon = new ImageIcon("Images/HotelImage/cover.png");
        image = imageIcon.getImage();
        g.drawImage(image, 150, 100, 310, 128, this);
    }

    @Override
    public JPanel panel() {

        setup();

        bProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(UserLogPanel.isLoged){
                    swap(1);
                }
            }
        });

        bMapPointer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swap(2);
            }
        });

        bReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swap(3);
            }
        });

        bAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swap(4);
            }
        });

        cancel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swap(0);
            }
        });

        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StaticUser.reset();
            }
        });

        return this;
    }

    private void swap(int i){

        bProfile.setOpaque(false);
        bMapPointer.setOpaque(false);
        bReset.setOpaque(false);
        bAbout.setOpaque(false);
        bProfile.setForeground(Color.white);
        bMapPointer.setForeground(Color.white);
        bReset.setForeground(Color.white);
        bAbout.setForeground(Color.white);
        removeAll();
        add(bProfile);
        add(bMapPointer);
        add(bReset);
        add(bAbout);

        if(i == 1){
            bProfile.setOpaque(true);
            bProfile.setForeground(Color.black);
            add(new ProfileScrollPanel().panel());
            cancel1.setBounds(795, 130, 30, 30);
            add(cancel1);
        }else if(i == 2){
            bMapPointer.setOpaque(true);
            bMapPointer.setForeground(Color.black);
            add(new PointreScrollPanel().panel());
            cancel1.setBounds(795, 130, 30, 30);
            add(cancel1);
        }else if(i == 3){
            bReset.setOpaque(true);
            bReset.setForeground(Color.black);
            add(pReset);
            cancel1.setBounds(700, 320, 30, 30);
            add(cancel1);
        }else if(i == 4){
            bAbout.setOpaque(true);
            bAbout.setForeground(Color.black);
            add(new AboutProject().panel());
            cancel1.setBounds(600, 20, 30, 30);
            add(cancel1);
        }else{

        }
        SwingUtilities.updateComponentTreeUI(this);
    }

    private void setup(){

        setBounds(70, 0, 1180, 850);
        setLayout(null);
        setOpaque(false);

        pReset.setBounds(680, 300, 400, 250);
        pReset.setLayout(null);
        pReset.setOpaque(false);

        pReset.add(lProblem);
        pReset.add(lTrabel);
        pReset.add(lTrabel1);
        pReset.add(restart);

        cancel1.setOpaque(false);
        cancel1.setContentAreaFilled(false);
        cancel1.setBorderPainted(false);
        cancel1.setFocusable(false);

        lProblem.setBounds(50, 20, 300, 30);
        lProblem.setFont(new Font(Font.SERIF, Font.PLAIN, 24));
        lProblem.setForeground(Color.white);
        lProblem.setForeground(Color.white);
        lProblem.setBackground(Color.white);
        lProblem.setBorderPainted(false);
        lProblem.setFocusable(false);

        lTrabel.setBounds(20, 105, 360, 20);
        lTrabel.setForeground(Color.white);

        lTrabel1.setBounds(20, 125, 360, 20);
        lTrabel1.setForeground(Color.white);

        restart.setBounds(140, 200, 120, 30);
        restart.setFont(new Font(null, Font.PLAIN, 13));
        restart.setForeground(Color.white);
        restart.setOpaque(false);
        restart.setBorderPainted(false);
        restart.setFocusable(false);

        bProfile.setBounds(200, 330, 200, 40);
        bProfile.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        bProfile.setForeground(Color.white);
        bProfile.setBackground(Color.white);
        bProfile.setBorderPainted(false);
        bProfile.setFocusable(false);

        bMapPointer.setBounds(200, 380, 200, 40);
        bMapPointer.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        bMapPointer.setBackground(Color.white);
        bMapPointer.setForeground(Color.white);
        bMapPointer.setBorderPainted(false);
        bMapPointer.setFocusable(false);

        bReset.setBounds(200, 430, 200, 40);
        bReset.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        bReset.setForeground(Color.white);
        bReset.setBackground(Color.white);
        bReset.setBorderPainted(false);
        bReset.setFocusable(false);
        
        bAbout.setBounds(200, 480, 200, 40);
        bAbout.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        bAbout.setForeground(Color.white);
        bAbout.setBackground(Color.white);
        bAbout.setBorderPainted(false);
        bAbout.setFocusable(false);

        add(bProfile);
        add(bMapPointer);
        add(bReset);
        add(bAbout);
    }
    
}
