package DevMain;

import javax.swing.JPanel;

public class MapView {
    private JPanel pMain = new JPanel();

    public JPanel panel(){

        pMain.setBounds(0, 0, 1250, 850);
        pMain.setLayout(null);
        // pMain.setBackground(Color.BLACK);
        
        pMain.add(new infoPanel().panel());
        // pMain.add(new displayImg().panel());
        // pMain.add(new mapPanel().panel());
        
        return pMain;
    }
}
