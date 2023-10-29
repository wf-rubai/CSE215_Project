package TestFolder;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import Common.ProfileScrollPanel;
import UserMain.UserUIGenerator;

public class f2 {

    public static JFrame f = new JFrame("asj");
    private static JButton b = new JButton(new ImageIcon("Images/Avatar/UP3.png"));
    public static void main(String[] args) {
        
        f.setSize(1180, 850);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.BLACK);

        b.setBounds( 100, 100, 150, 150);

        // f.add(b);
        f.add(new ProfileScrollPanel().panel());

        f.setVisible(true);
    }
}
