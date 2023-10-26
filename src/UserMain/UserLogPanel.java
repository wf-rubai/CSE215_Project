package UserMain;

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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Common.CPanel;
import Common.ObjecSaver;
import Common.UserInfo;
import Common.fileReader;

public class UserLogPanel implements CPanel {

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
    private JPanel loginPanel = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(new Color(0, 2, 120, 100));
            g2.fillRoundRect(2, 2, 396, 346, 20, 20);
            g2.setStroke(new BasicStroke(2));
            g2.setColor(new Color(0, 2, 120));
            g2.drawRoundRect(2, 2, 396, 346, 20, 20);
        }
    };
    private JPanel createPanel = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(new Color(0, 2, 120, 100));
            g2.fillRoundRect(2, 2, 396, 546, 20, 20);
            g2.setStroke(new BasicStroke(2));
            g2.setColor(new Color(0, 2, 120));
            g2.drawRoundRect(2, 2, 396, 546, 20, 20);
        }
    };
    private JPanel pConfirm = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("Images/Icons/like.png");
            Image image = imageIcon.getImage();
            g.drawImage(image, 80, 20, 96, 96, this);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(new Color(0, 2, 120, 100));
            g2.fillRoundRect(2, 2, 246, 296, 20, 20);
            g2.setStroke(new BasicStroke(2));
            g2.setColor(new Color(0, 2, 120));
            g2.drawRoundRect(2, 2, 246, 296, 20, 20);
        }
    };
    private JTextField name = new JTextField();
    private JTextField email = new JTextField();
    private JTextField logName = new JTextField();
    private JTextField phone = new JTextField();
    private JTextField nid = new JTextField();
    private JPasswordField logPass = new JPasswordField();
    private JPasswordField pw1 =new JPasswordField();
    private JPasswordField pw =new JPasswordField();
    private JButton blogin = new JButton("LogIn");
    private JButton create = new JButton("Create");
    private JButton b1 = new JButton("Create One");
    private JLabel lError = new JLabel("⛒ User name or password is wrong");
    private JLabel lLogIn = new JLabel("Login");
    private JLabel lCreate = new JLabel("Create Account");
    private JLabel loginname = new JLabel("Name / Email ");
    private JLabel password = new JLabel("Password");
    private JLabel account = new JLabel("Don't have a Account ?");
    private JLabel createname = new JLabel("Name");
    private JLabel createmail = new JLabel("Email");
    private JLabel createphone = new JLabel("Phone Number");
    private JLabel createnid = new JLabel("NID Number");
    private JLabel createPass = new JLabel("Password");
    private JLabel createNewPass = new JLabel("Confirm Password");
    private JLabel logBack = new JLabel(new ImageIcon("Images/Icons/back.png"));
    private static LinkedList<Object> object = new fileReader().objectList();
    public static boolean isLoged = (boolean)object.get(0);
    public static UserInfo logerID = (UserInfo)object.get(1);
    
    @Override
    public JPanel panel() {

        mainPanel.setBounds(70, 0, 1180, 850);
        logBack.setBounds(30, 30, 32, 32);
        mainPanel.setLayout(null);

        loginPanel.setBounds(390, 250, 400, 350);
        loginPanel.setOpaque(false);
        loginPanel.setLayout(null);

        createPanel.setBounds(390, 150, 400, 550);
        createPanel.setOpaque(false);
        createPanel.setLayout(null);

        pConfirm.setBounds(465, 275, 250, 300);
        pConfirm.setOpaque(false);
        pConfirm.setBorder(new EmptyBorder(200, 0, 0, 0));
        JLabel done = new JLabel("Done ✔︎");
        done.setFont(new Font(null, Font.PLAIN, 30));
        pConfirm.add(done);

        lError.setBounds(50, 210, 300, 30);
        lError.setForeground(Color.red);
        
        lCreate.setBounds(125, 30, 200, 50);
        name.setBounds(50, 120, 300, 30);
        email.setBounds(50, 180, 300, 30);
        phone.setBounds(50, 240, 300, 30);
        nid.setBounds(50, 300, 300, 30);
        pw.setBounds(50, 360, 300, 30);
        pw1.setBounds(50, 420, 300, 30);

        name.setBorder(new EmptyBorder(0, 10, 0, 10));
        email.setBorder(new EmptyBorder(0, 10, 0, 10));
        phone.setBorder(new EmptyBorder(0, 10, 0, 10));
        nid.setBorder(new EmptyBorder(0, 10, 0, 10));
        pw.setBorder(new EmptyBorder(0, 10, 0, 10));
        pw1.setBorder(new EmptyBorder(0, 10, 0, 10));
        
        createname.setBounds(50, 100, 300, 20);
        createmail.setBounds(50, 160, 300, 20);
        createphone.setBounds(50, 220, 300, 20);
        createnid.setBounds(50, 280, 300, 20);
        createPass.setBounds(50, 340, 300, 20);
        createNewPass.setBounds(50, 400, 300, 20);
        create.setBounds(50, 480, 300, 40);

        lCreate.setFont(new Font(null, Font.BOLD, 20));
        lCreate.setForeground(Color.white);
        
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = new String(pw.getPassword());
                String s1 = new String(pw1.getPassword());
                if(s.equals(s1)){
                    try{
                        File file = new File("Files/userInfo.txt");
                        FileWriter fw = new FileWriter(file, true);

                        fw.write("\n" +
                                name.getText().replace(" ", "_") + "\t" +
                                email.getText() + "\t" +
                                phone.getText() + "\t" +
                                nid.getText() + "\t" +
                                new String(pw.getPassword()) + "\t" +
                                "Active\t0"
                                );
                        fw.close();
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(createPanel, "Something Went Wrong Adding Hotel Information", "ADDING ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    mainPanel.remove(createPanel);
                    mainPanel.add(pConfirm);
                    SwingUtilities.updateComponentTreeUI(mainPanel);

                }else {
                    JOptionPane.showMessageDialog(createPanel,"password doesn't match","Error",JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        
        lLogIn.setBounds(170, 30, 100, 50);
        loginname.setBounds(50, 100, 100, 20);
        logName.setBounds(50, 120, 300, 30);
        password.setBounds(50, 160, 100, 20);
        logPass.setBounds(50, 180, 300, 30);
        blogin.setBounds(50, 240, 300, 40);
        account.setBounds(50,280,150,40);
        b1.setBounds(85,280,300,40);

        logName.setBorder(new EmptyBorder(0, 10, 0, 10));
        logPass.setBorder(new EmptyBorder(0, 10, 0, 10));
        lLogIn.setFont(new Font(null, Font.BOLD, 20));
        lLogIn.setForeground(Color.white);

        
        b1.setOpaque(false);
        b1.setBorderPainted(false);
        b1.setForeground(Color.blue);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainPanel.remove(loginPanel);
                mainPanel.add(createPanel);
                SwingUtilities.updateComponentTreeUI(mainPanel);
            }
        });

        blogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log(logName.getText(), new String(logPass.getPassword()));
                if(isLoged){
                    mainPanel.remove(loginPanel);
                    mainPanel.add(pConfirm);
                }else{
                    loginPanel.add(lError);
                }
                SwingUtilities.updateComponentTreeUI(mainPanel);
            }
        });
        
        loginPanel.add(lLogIn);
        loginPanel.add(blogin);
        loginPanel.add(loginname);
        loginPanel.add(logName);
        loginPanel.add(password);
        loginPanel.add(logPass);
        loginPanel.add(account);
        loginPanel.add(b1);

        createPanel.add(lCreate);
        createPanel.add(name);
        createPanel.add(email);
        createPanel.add(phone);
        createPanel.add(nid);
        createPanel.add(pw1);
        createPanel.add(pw);
        createPanel.add(createNewPass);
        createPanel.add(createPass);
        createPanel.add(createname);
        createPanel.add(createmail);
        createPanel.add(createphone);
        createPanel.add(createnid);
        createPanel.add(create);

        mainPanel.add(logBack);
        mainPanel.add(loginPanel);

        return mainPanel;
    }

    public void log(String name, String pass){
        HashMap<String,UserInfo> loger = new fileReader().userHashMap();
        if(loger.containsKey(pass)){
            UserInfo u = loger.get(pass);
            if(!u.status.equals("Active")){
                isLoged = false;
            }else if(u.name.equals(name)){
                isLoged = true;
                logerID = u;LinkedList<Object> o = new fileReader().objectList();
                o.set(0, true);
                o.set(1, u);
                new ObjecSaver(o);
            }else if(u.mail.equals(name)){
                isLoged = true;
                logerID = u;
                logerID = u;LinkedList<Object> o = new fileReader().objectList();
                o.set(0, true);
                o.set(1, u);
                new ObjecSaver(o);
            }
        }
    }

    private static Color randomColor() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return new Color(r, g, b, 100);
    }
}
