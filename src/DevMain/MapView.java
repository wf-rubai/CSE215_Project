package DevMain;

import javax.swing.JPanel;

public class MapView {
    
    private JPanel pMain = new JPanel();

    public JPanel panel(){

        pMain.setBounds(0, 0, 1250, 850);
        pMain.setLayout(null);
        pMain.setOpaque(false);
        
        pMain.add(new infoPanel().panel());
        
        return pMain;
    }
}
