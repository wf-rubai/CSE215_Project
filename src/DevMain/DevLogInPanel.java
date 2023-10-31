package DevMain;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Common.CPanel;
import Common.DevInfo;
import Common.ThreadLogin;
import Common.fileReader;

public class DevLogInPanel implements CPanel {
    
    private JPanel pLog = new JPanel();
    private JTextField tf = new JTextField(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(new Color(0, 0, 0, 100));
            g2.fillRoundRect(5, 5, 240, 30, 30, 30);
            g2.setStroke(new BasicStroke(2));
            g2.setColor(new Color(0, 0, 0, 150));
            g2.drawRoundRect(5, 5, 240, 30, 30, 30);
        }
    };
    private JPasswordField pf = new JPasswordField(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(new Color(0, 0, 0, 100));
            g2.fillRoundRect(5, 5, 240, 30, 30, 30);
            g2.setStroke(new BasicStroke(2));
            g2.setColor(new Color(0, 0, 0, 150));
            g2.drawRoundRect(5, 5, 240, 30, 30, 30);
        }
    };
    private JPanel logo = new JPanel() {
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("Images/HotelImage/cover.png");
            Image image = imageIcon.getImage();
            g.drawImage(image, 0, 0, 310, 128, this);
        }
    };
    private JLabel lImage = new JLabel(new ImageIcon("Images/HotelImage/BGI3.jpg"));
    private JLabel lname = new JLabel("ID or name");
    private JLabel lpass = new JLabel("Password");
    private JButton bLog = new JButton("Log in");
    public static DevInfo logerInfo = new DevInfo("Washio Ferdous Rubai", "akkas1234", "2231107", "rubai4483302@gmail.com", "01912653657", "10287384891743", "CEO", 0);
    
    @Override
    public JPanel panel(){
        pLog.setBounds(0, 0, 1250, 850);
        pLog.setLayout(null);
        // pLog.setBackground(new Color(0, 89, 255));
        // lImage.setBounds(0, 0, 1250, 850);
        logo.setBounds(470, 310, 310, 128);
        logo.setOpaque(false);

        
        tf.setBounds(500, 500, 250, 40);
        tf.setBackground(new Color(0, 0, 0, 0));
        tf.setBorder(new EmptyBorder(0, 15, 0, 15));

        pf.setBounds(500, 560, 250, 40);
        pf.setBackground(new Color(0, 0, 0, 0));
        pf.setBorder(new EmptyBorder(0, 15, 0, 15));


        lname.setBounds(500, 480, 150, 20);
        lpass.setBounds(500, 540, 150, 20);
        bLog.setBounds(500, 620, 250, 40);
        
        pLog.add(tf);
        pLog.add(pf);
        pLog.add(lname);
        pLog.add(lpass);
        pLog.add(bLog);

        for(int i = 0; i<30; i++){
            ThreadLogin d = new ThreadLogin();
            Thread t = new Thread(d);
            t.start();
            pLog.add(d.panel());
        }
        pLog.add(logo);
        pLog.add(lImage);

        return pLog;
    }

    public boolean isLoged(){
        HashMap<String, DevInfo> hashDev = new fileReader().devoloperHashMap();

        if(hashDev.containsKey(new String(pf.getPassword()))){
            DevInfo d = hashDev.get(new String(pf.getPassword()));
            if(tf.getText().equals(d.id)){
                logerInfo = d;
                return true;
            }else if(tf.getText().equals(d.name)){
                logerInfo = d;
                return true;
            }else if(tf.getText().equals(d.mail)){
                logerInfo = d;
                return true;
            }
        }
        
        if(tf.getText().equals("admin") && new String(pf.getPassword()).equals("12345")){
            logerInfo = new DevInfo("admin", "12345", "null", "null", "null", "null", "Editor", 2);
            return true;
        }
        
        return false;
    }
}
