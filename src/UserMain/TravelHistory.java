package UserMain;

import javax.swing.JPanel;

import Common.CPanel;

public class TravelHistory implements CPanel {
    private JPanel travelMain = new JPanel();

    @Override
    public JPanel panel() {
        return travelMain;
    }
}
