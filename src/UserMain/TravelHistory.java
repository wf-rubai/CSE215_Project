package UserMain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Common.CPanel;
import Common.TravelPanel;
import Common.UserInfo;
import Common.FileReader;

public class TravelHistory implements CPanel {

    private JPanel travelMain = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("Images/HotelImage/open2.png");
            Image image = imageIcon.getImage();
            g.drawImage(image, -20, 0, 1200, 850, this);
        }
    };
    private JPanel spPanel = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("Images/HotelImage/open1.png");
            Image image = imageIcon.getImage();
            g.drawImage(image, -160, -50, 1200, 850, this);
        }
    };
    private UserInfo uInfo = UserLogPanel.logerID;
    private HashMap<String, LinkedList<String[]>> travel = new FileReader().travelHashMap();

    @Override
    public JPanel panel() {
        travelMain.setBounds(70, 0, 1180, 850);
        travelMain.setLayout(null);
        travelMain.setBackground(Color.white);

        JScrollPane jsPane = new JScrollPane(spPanel,
                                            JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                                            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jsPane.setBounds(140, 50, 900, 750);
        jsPane.setOpaque(false);
        jsPane.setBorder(new EmptyBorder(0, 0, 0, 0));

        spPanel.setOpaque(false);
        spPanel.setBackground(new Color(0, 0, 0, 0));
        spPanel.setLayout(new BoxLayout(spPanel, BoxLayout.Y_AXIS));

        if(travel.containsKey(uInfo.name)){
            for(String[] s: travel.get(uInfo.name)){
                TravelPanel tp = new TravelPanel(s);
                spPanel.add(tp.panel());
            }
        }

        travelMain.add(jsPane);

        return travelMain;
    }
}
