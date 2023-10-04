package DevMain;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class UIGenerator extends JFrame{
    
    private JPanel pSB = new JPanel();

    public UIGenerator(String s){

        super(s);
        setSize(1250, 850);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.gray);

        pSB.setBounds(0, 0, 70, 850);
        pSB.setBackground(Color.darkGray);
        pSB.setLayout(null);

        add(pSB);
        add(new MapView().panel());

        setVisible(true);
    }

    public UIGenerator(){

    }
}
