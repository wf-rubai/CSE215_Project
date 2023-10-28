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
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import UserMain.UserLogPanel;

public class UserFranme extends JFrame {

    private JButton bUpdate = new JButton("Update Information"){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(2));
            g2.setColor(new Color(255, 255, 255, 170));
            g2.drawRoundRect(1, 1, 396, 496, 30, 30);
        }
    };
    private JButton done1 = new JButton("Update Information"){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(2));
            g2.setColor(new Color(255, 255, 255, 170));
            g2.drawRoundRect(1, 1, 198, 38, 30, 30);
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
    private JButton bInfo = new JButton("Update Information"){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(2));
            g2.setColor(new Color(255, 255, 255, 170));
            g2.drawRoundRect(1, 1, 198, 38, 30, 30);
        }
    };
    private JButton bPass = new JButton("Update Password"){
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
            ImageIcon imageIcon = new ImageIcon("Images/HotelImage/ss1.png");
            Image image = imageIcon.getImage();
            g.drawImage(image, 0, 0, 400, 501, this);
        }
    };
    private JPanel pUpdate = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("Images/HotelImage/ss2.png");
            Image image = imageIcon.getImage();
            g.drawImage(image, 0, 0, 400, 501, this);
        }
    };
    private JPanel pOthers = new JPanel(){
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
            ImageIcon imageIcon = new ImageIcon("Images/HotelImage/ss0.png");
            Image image = imageIcon.getImage();
            g.drawImage(image, 0, 0, 400, 501, this);
        }
    };
    private JFrame f = new JFrame("asdkjf");
    private JButton bExit = new JButton(new ImageIcon("Images/Icons/cross.png"));
    private JButton bBack = new JButton(new ImageIcon("Images/Icons/back1.png"));
    private UserInfo user = UserLogPanel.logerID;
    private JButton mail = new JButton("Email : " + user.mail);
    private JButton phone = new JButton("Phone : +88" + user.phone);
    private JButton nid = new JButton("NID no. : " + user.nid);
    private JButton l1 = new JButton("Update");
    private JButton l2 = new JButton("Update Information");
    private JButton l3 = new JButton("Update Password");
    private JPanel pp = new ProfilePanel(user.name, user.imgIndex).panel();
    private JLabel lName = new JLabel("Name :");
    private JLabel lMail = new JLabel("Email :");
    private JLabel lPhn = new JLabel("Phone :");
    private JLabel lNID = new JLabel("NID no. :");
    private JLabel lPass = new JLabel("Password :");
    private JLabel lCPass = new JLabel("Confirm password :");
    private JTextField tfName = new JTextField(user.name);
    private JTextField tfMail = new JTextField(user.mail);
    private JTextField tfPhn = new JTextField(user.phone);
    private JTextField tfNID = new JTextField(user.nid);
    private JPasswordField tfPass = new JPasswordField();
    private JPasswordField tfCPass = new JPasswordField();
    private HashMap<String,UserInfo> uInfo = new fileReader().userHashMap();
    private LinkedList<Object> o = new fileReader().objectList();

    public UserFranme(){

        if(UserLogPanel.isLoged){
            setUp();
            f.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "You are not logged");
        }

        bUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.remove(pInfo);
                f.add(bBack);
                f.add(pUpdate);
                SwingUtilities.updateComponentTreeUI(f);
            }
        });

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.remove(bBack);
                f.remove(pUpdate);
                f.remove(pPass);
                f.remove(pOthers);
                f.add(pInfo);
                SwingUtilities.updateComponentTreeUI(f);
            }
        });

        bInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.remove(pUpdate);
                f.add(pOthers);
                SwingUtilities.updateComponentTreeUI(f);
            }
        });

        bPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.remove(pUpdate);
                f.add(pPass);
                SwingUtilities.updateComponentTreeUI(f);
            }
        });

        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
            }
        });

        done1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!tfName.getText().equals("")){
                    user.name = tfName.getText();
                }else if(!tfMail.getText().equals("")){
                    user.mail = tfMail.getText();
                }else if(!tfPhn.getText().equals("")){
                    user.phone = tfPhn.getText();
                }else if(!tfNID.getText().equals("")){
                    user.nid = tfNID.getText();
                }
                uInfo.replace(user.pass, user);
                saveInfo();

                f.remove(bBack);
                f.remove(pUpdate);
                f.remove(pPass);
                f.remove(pOthers);
                f.add(pInfo);
                SwingUtilities.updateComponentTreeUI(f);
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
                saveInfo();

                f.remove(bBack);
                f.remove(pUpdate);
                f.remove(pPass);
                f.remove(pOthers);
                f.add(pInfo);
                SwingUtilities.updateComponentTreeUI(f);
            }
        });
    }

    private void saveInfo(){
        
        File file = new File("Files/userInfo.txt");
        file.delete();
        try{
            FileWriter fw = new FileWriter(file);
            for(UserInfo u: uInfo.values()){
                fw.write("\n" +
                        u.name.replace(" ", "_") + "\t" +
                        u.mail.replace(" ", "_") + "\t" +
                        u.phone.replace(" ", "_") + "\t" +
                        u.nid.replace(" ", "_") + "\t" +
                        u.pass.replace(" ", "_") + "\t" +
                        u.status.replace(" ", "_") + "\t" +
                        u.imgIndex
                        );	
            }
            fw.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "ADDING ERROR", JOptionPane.ERROR_MESSAGE);
        }
        o.set(1, user);
        new ObjecSaver(o);
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

        pUpdate.setBounds(0, 0, 400, 500);
        pUpdate.setLayout(null);
        pUpdate.setOpaque(false);

        l1.setBounds(0, 30, 400, 40);
        l1.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        l1.setForeground(Color.white);
        l1.setOpaque(false);
        l1.setContentAreaFilled(false);
        l1.setBorderPainted(false);
        l1.setFocusable(false);

        l2.setBounds(0, 30, 400, 40);
        l2.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        l2.setForeground(Color.white);
        l2.setOpaque(false);
        l2.setContentAreaFilled(false);
        l2.setBorderPainted(false);
        l2.setFocusable(false);

        l3.setBounds(0, 30, 400, 40);
        l3.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        l3.setForeground(Color.white);
        l3.setOpaque(false);
        l3.setContentAreaFilled(false);
        l3.setBorderPainted(false);
        l3.setFocusable(false);

        bInfo.setBounds(100, 205, 200, 40);
        bInfo.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
        bInfo.setForeground(Color.white);
        bInfo.setOpaque(false);
        bInfo.setContentAreaFilled(false);
        bInfo.setBorderPainted(false);
        bInfo.setFocusable(false);

        bPass.setBounds(100, 255, 200, 40);
        bPass.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
        bPass.setForeground(Color.white);
        bPass.setOpaque(false);
        bPass.setContentAreaFilled(false);
        bPass.setBorderPainted(false);
        bPass.setFocusable(false);

        pUpdate.add(l1);
        pUpdate.add(bInfo);
        pUpdate.add(bPass);
        
        pOthers.setBounds(0, 0, 400, 500);
        pOthers.setLayout(null);
        pOthers.setOpaque(false);

        lName.setBounds(50, 100, 300, 20);
        lMail.setBounds(50, 160, 300, 20);
        lPhn.setBounds(50, 220, 300, 20);
        lNID.setBounds(50, 280, 300, 20);

        tfName.setBounds(50, 120, 300, 30);
        tfMail.setBounds(50, 180, 300, 30);
        tfPhn.setBounds(50, 240, 300, 30);
        tfNID.setBounds(50, 300, 300, 30);

        tfName.setBorder(new EmptyBorder(0, 15, 0, 15));
        tfMail.setBorder(new EmptyBorder(0, 15, 0, 15));
        tfPhn.setBorder(new EmptyBorder(0, 15, 0, 15));
        tfNID.setBorder(new EmptyBorder(0, 15, 0, 15));

        done1.setBounds(100, 395, 200, 40);
        done1.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
        done1.setForeground(Color.white);
        done1.setOpaque(false);
        done1.setContentAreaFilled(false);
        done1.setBorderPainted(false);
        done1.setFocusable(false);

        pOthers.add(l2);
        pOthers.add(lName);
        pOthers.add(lMail);
        pOthers.add(lPhn);
        pOthers.add(lNID);
        pOthers.add(tfName);
        pOthers.add(tfMail);
        pOthers.add(tfPhn);
        pOthers.add(tfNID);
        pOthers.add(done1);

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
        pInfo.add(mail);
        pInfo.add(phone);
        pInfo.add(nid);
        pInfo.add(bUpdate);

        f.add(bExit);
        f.add(pInfo);
    }

    public static void main(String[] args) {
        new UserFranme();
    }
}
