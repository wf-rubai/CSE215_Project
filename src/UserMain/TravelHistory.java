package UserMain;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Common.CPanel;

public class TravelHistory implements CPanel {
    private JPanel travelMain = new JPanel();
    private JPanel spPanel = new JPanel();

    @Override
    public JPanel panel() {
        travelMain.setBounds(70, 0, 1180, 850);
        travelMain.setLayout(null);

        JScrollPane sPane = new JScrollPane(spPanel,
                                            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER,
                                            JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        return travelMain;
    }
}
