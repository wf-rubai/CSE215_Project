package Common;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;

import DevMain.DevLogInPanel;

public class DevFrame {

    private JButton bUpdate = new JButton("Update Password"){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(2));
            g2.setColor(new Color(255, 255, 255, 170));
            g2.drawRoundRect(1, 1, 396, 496, 30, 30);
        }
    };
    private JButton done2 = new JButton("Update Password"){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(2));
            g2.setColor(new Color(255, 255, 255, 170));
            g2.drawRoundRect(1, 1, 198, 38, 30, 30);
        }
    };
    private JPanel pInfo = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("Images/HotelImage/ss0.png");
            Image image = imageIcon.getImage();
            g.drawImage(image, 0, 0, 400, 501, this);
        }
    };
    private JPanel pPass = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("Images/HotelImage/ss2.png");
            Image image = imageIcon.getImage();
            g.drawImage(image, 0, 0, 400, 501, this);
        }
    };
    private JFrame f = new JFrame("asdkjf");
    private JButton bExit = new JButton(new ImageIcon("Images/Icons/cross.png"));
    private JButton bBack = new JButton(new ImageIcon("Images/Icons/back1.png"));
    private DevInfo user = DevLogInPanel.logerInfo;
    private JButton id = new JButton("ID : " + user.id);
    private JButton mail = new JButton("Email : " + user.mail);
    private JButton phone = new JButton("Phone : +88" + user.phone);
    private JButton nid = new JButton("NID no. : " + user.nid);
    private JButton l3 = new JButton("Update Password");
    private JPanel pp = new ProfilePanel(user.name, user.imgIndex).panel();
    private JLabel lPass = new JLabel("Password :");
    private JLabel lCPass = new JLabel("Confirm password :");
    private JPasswordField tfPass = new JPasswordField();
    private JPasswordField tfCPass = new JPasswordField();
    private HashMap<String, DevInfo> uInfo = new fileReader().devoloperHashMap();
    
    public DevFrame(){

        setUp();
        f.setVisible(true);

        bUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.remove(pInfo);
                f.add(bBack);
                f.add(pPass);
                SwingUtilities.updateComponentTreeUI(f);
            }
        });

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.remove(bBack);
                f.remove(pPass);
                f.add(pInfo);
                SwingUtilities.updateComponentTreeUI(f);
            }
        });

        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
            }
        });

        done2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(new String(tfPass.getPassword()).equals(new String(tfCPass.getPassword())) && !new String(tfPass.getPassword()).equals("")){
                    uInfo.remove(user.pass);
                    user.pass = new String(tfPass.getPassword());
                    uInfo.put(user.pass, user);
                }
                new ResaveDev(uInfo);

                f.remove(bBack);
                f.remove(pPass);
                f.add(pInfo);
                SwingUtilities.updateComponentTreeUI(f);
            }
        });
    }

    private void setUp(){

        f.setSize(400, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setUndecorated(true);
        f.setLayout(null);
        f.setOpacity(0.85f);

        bExit.setBounds(350, 18, 32, 32);
        bExit.setOpaque(false);
        bExit.setContentAreaFilled(false);
        bExit.setBorderPainted(false);
        bExit.setFocusable(false);

        bBack.setBounds(18, 18, 32, 32);
        bBack.setOpaque(false);
        bBack.setContentAreaFilled(false);
        bBack.setBorderPainted(false);
        bBack.setFocusable(false);

        id.setBounds(0, 240, 400, 30);
        id.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
        id.setForeground(Color.white);
        id.setOpaque(false);
        id.setContentAreaFilled(false);
        id.setBorderPainted(false);
        id.setFocusable(false);

        mail.setBounds(0, 270, 400, 30);
        mail.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
        mail.setForeground(Color.white);
        mail.setOpaque(false);
        mail.setContentAreaFilled(false);
        mail.setBorderPainted(false);
        mail.setFocusable(false);

        phone.setBounds(0, 300, 400, 30);
        phone.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
        phone.setForeground(Color.white);
        phone.setOpaque(false);
        phone.setContentAreaFilled(false);
        phone.setBorderPainted(false);
        phone.setFocusable(false);

        nid.setBounds(0, 330, 400, 30);
        nid.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
        nid.setForeground(Color.white);
        nid.setOpaque(false);
        nid.setContentAreaFilled(false);
        nid.setBorderPainted(false);
        nid.setFocusable(false);

        l3.setBounds(0, 30, 400, 40);
        l3.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        l3.setForeground(Color.white);
        l3.setOpaque(false);
        l3.setContentAreaFilled(false);
        l3.setBorderPainted(false);
        l3.setFocusable(false);

        pPass.setBounds(0, 0, 400, 500);
        pPass.setLayout(null);
        pPass.setOpaque(false);

        done2.setBounds(100, 400, 200, 40);
        done2.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
        done2.setForeground(Color.white);
        done2.setOpaque(false);
        done2.setContentAreaFilled(false);
        done2.setBorderPainted(false);
        done2.setFocusable(false);

        lPass.setBounds(50, 160, 300, 20);
        lCPass.setBounds(50, 220, 300, 20);

        tfPass.setBounds(50, 180, 300, 30);
        tfCPass.setBounds(50, 240, 300, 30);

        pPass.add(l3);
        pPass.add(lPass);
        pPass.add(lCPass);
        pPass.add(tfPass);
        pPass.add(tfCPass);
        pPass.add(done2);

        pInfo.setBounds(0, 0, 400, 500);
        pInfo.setLayout(null);
        pInfo.setOpaque(false);

        bUpdate.setBounds(250, 460, 150, 40);
        bUpdate.setFont(new Font(null, Font.PLAIN, 11));
        bUpdate.setForeground(Color.white);
        bUpdate.setOpaque(false);
        bUpdate.setContentAreaFilled(false);
        bUpdate.setBorderPainted(false);
        bUpdate.setFocusable(false);

        pp.setLocation(50, 40);
        pInfo.add(pp);
        pInfo.add(id);
        pInfo.add(mail);
        pInfo.add(phone);
        pInfo.add(nid);
        pInfo.add(bUpdate);

        f.add(bExit);
        f.add(pInfo);
    }

    public static void main(String[] args) {
        new DevFrame();
    }
}
