package DevMain;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class LogInPanel {
    
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
    private ImageIcon ii = new ImageIcon("/Users/washioferdousrubai/Downloads/beige-leafy-watercolor-backgroun.jpg");
    private JLabel l = new JLabel(ii);
    private JLabel lname = new JLabel("ID or name");
    private JLabel lpass = new JLabel("Password");
    
    public JPanel panel(){
        pLog.setBounds(0, 0, 1250, 850);
        pLog.setLayout(null);
        
        l.setBounds(0, 0, 1250, 850);

        tf.setBounds(500, 500, 250, 40);
        tf.setBackground(new Color(0, 0, 0, 0));
        tf.setBorder(new EmptyBorder(0, 15, 0, 15));

        pf.setBounds(500, 560, 250, 40);
        pf.setBackground(new Color(0, 0, 0, 0));
        pf.setBorder(new EmptyBorder(0, 15, 0, 15));


        lname.setBounds(500, 480, 150, 20);
        lpass.setBounds(500, 540, 150, 20);
        
        pLog.add(tf);
        pLog.add(pf);
        pLog.add(lname);
        pLog.add(lpass);
        pLog.add(l);

        return pLog;
    }

    public boolean isLoged(){
        String s = new String(pf.getPassword());
        if(tf.getText().equals("lll") && s.equals("1234")){
            return true;
        }
        
        return false;
    }
}
