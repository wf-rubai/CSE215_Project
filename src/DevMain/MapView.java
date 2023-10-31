package DevMain;

import javax.swing.JPanel;

import Common.CPanel;

public class MapView implements CPanel {
    
    private JPanel pMain = new JPanel();

    @Override
    public JPanel panel(){

        pMain.setBounds(0, 0, 1250, 850);
        pMain.setLayout(null);
        pMain.setOpaque(false);
        
        pMain.add(new InfoPanel().panel());
        
        return pMain;
    }
}
