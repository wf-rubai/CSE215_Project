package DevMain;

import javax.swing.JFrame;

public class UIGenerator extends JFrame{
    public UIGenerator(String s){
        super(s);
        setSize(1250, 850);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new MapView().panel());

        setVisible(true);
    }
}
