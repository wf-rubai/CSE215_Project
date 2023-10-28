package UserMain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Common.CPanel;
import Common.TravelPanel;
import Common.UserInfo;
import Common.fileReader;

public class TravelHistory implements CPanel {

    private JPanel travelMain = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            for(int i = 0; i<20; i++){
                int a = (int)(30+Math.random()*300);
                g2.setColor(randomColor());
                g2.fillRoundRect((int)(Math.random()*1000), (int)(Math.random()*700), a, a, a, a);
                g2.drawRoundRect((int)(Math.random()*1000), (int)(Math.random()*700), a, a, a, a);
            }
        }
    };
    private JPanel spPanel = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            for(int i = 0; i<20; i++){
                int a = (int)(30+Math.random()*300);
                g2.setColor(randomColor());
                g2.fillRoundRect((int)(Math.random()*1000)-300, (int)(Math.random()*700)-100, a, a, a, a);
                g2.drawRoundRect((int)(Math.random()*1000)-300, (int)(Math.random()*700)-100, a, a, a, a);
            }
        }
    };
    private UserInfo uInfo = UserLogPanel.logerID;
    private HashMap<String, LinkedList<String[]>> travel = new fileReader().travelHashMap();

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

    private static Color randomColor() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return new Color(r, g, b, 100);
    }
}
