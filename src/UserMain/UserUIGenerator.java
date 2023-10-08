package UserMain;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class UserUIGenerator extends JFrame {

    private JPanel mainPanel = new JPanel();
    private JPanel pSB = new JPanel();

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

        setUp();

        mainPanel.add(pSB);
        mainPanel.add(new MapMain().panel());

        add(mainPanel);
        
        setVisible(true);
    }

    private void setUp(){
        pSB.setBounds(0, 0, 70, 850);
        pSB.setBackground(Color.darkGray);
        pSB.setLayout(null);
    }
}
