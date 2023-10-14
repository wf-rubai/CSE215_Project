package UserMain;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Common.HotelInfoButton;
import Common.HotelInfoPanel;
import Common.Hotels;
import Common.arrayList;
import Common.fileReader;

public class MapMain extends JButton {

    private JTextField tfSearch = new JTextField(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(3));
            g2.setColor(new Color(255, 255, 255, 255));
            g2.drawRoundRect(7, 7, 675, 35, 35, 35);
        }
    };
    private JButton buttonPop = new JButton(new ImageIcon("/Users/washioferdousrubai/Downloads/dots.png")){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(3));
            g2.setColor(new Color(255, 255, 255, 255));
            g2.drawRoundRect(7, 7, 35, 35, 35, 35);
        }
    };
    private JButton buttonSearch = new JButton(new ImageIcon("/Users/washioferdousrubai/Downloads/search.png")){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(3));
            g2.setColor(new Color(255, 255, 255, 255));
            g2.drawRoundRect(7, 7, 35, 35, 35, 35);
        }
    };
    private JPanel backPanel = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(new Color(255, 255, 255, 150));
            g2.fillRoundRect(7, 7, 675, 35, 35, 35);
            g2.fillRoundRect(697, 7, 35, 35, 35, 35);
            g2.fillRoundRect(767, 7, 35, 35, 35, 35);
        }
    };

    private JPanel mapPanel = new JPanel();
    private JPanel pointPanel = new JPanel();
    private JPanel spPanel = new JPanel();
    private JPopupMenu popSearch = new JPopupMenu();
    private JLabel bdl = new JLabel(new ImageIcon("Images/GeoImage/BD.jpeg"));
    // private JLabel spMsg = new JLabel(new ImageIcon("No hotels found"));
    private HashMap<String, LinkedList<Hotels>> hashHotel = new fileReader().hotelHashMap();
    private String[] citys = new arrayList().cityName;
    private int i = 1;

    public JPanel panel(){
        
        mapPanel.setBounds(70, 0, 1180, 850);
        mapPanel.setLayout(null);

        pointPanel.setBounds(330, 0, 850, 850);
        pointPanel.setLayout(null);
        pointPanel.setOpaque(false);
        pointPanel.setBorder(null);

        bdl.setBounds(330, 0, 850, 850);
        tfSearch.setBounds(360, 30, 690, 50);
        tfSearch.setBackground(new Color(0, 0, 0, 0));
        tfSearch.setBorder(new EmptyBorder(0, 15, 0, 15));

        buttonSearch.setBounds(1050, 30, 50, 50);
        buttonSearch.setOpaque(false);
        buttonSearch.setContentAreaFilled(false);
        buttonSearch.setBorderPainted(false);
        buttonSearch.setFocusable(false);

        buttonPop.setBounds(1120, 30, 50, 50);
        buttonPop.setOpaque(false);
        buttonPop.setContentAreaFilled(false);
        buttonPop.setBorderPainted(false);
        buttonPop.setFocusable(false);

        backPanel.setBounds(360, 30, 1180, 50);
        backPanel.setOpaque(false);

        spPanel.setLayout(new BoxLayout(spPanel, BoxLayout.Y_AXIS));
        spPanel.setOpaque(false);
        spPanel.setBorder(null);

        JScrollPane spHotel = new JScrollPane(spPanel,
                                            JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                                            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER){
                                                @Override
                                                protected void paintComponent(Graphics g) {
                                                    super.paintComponent(g);
                                                    Graphics2D g2 = (Graphics2D) g;
                                                    g2.setColor(Color.white);
                                                    g2.fillRoundRect(0, 0, 310, 650, 45, 45);
                                                }
                                            };
        spHotel.setOpaque(false);
        spHotel.setBounds(10, 190, 310, 650);
        spHotel.setBorder(new EmptyBorder(5, 10, 5, 10));

        JLabel lHotel = new JLabel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.pink);
                g2.fillRoundRect(0, 0, 310, 200, 45, 45);
            }
        };
        lHotel.setOpaque(false);
        lHotel.setBounds(10, 155, 310, 90);
        JLabel lLable = new JLabel("Hotels");
        lLable.setOpaque(false);
        lLable.setBounds(10, 155, 310, 35);
        lLable.setFont(new Font(Font.SERIF, Font.TYPE1_FONT, 18));
        lLable.setForeground(Color.white);
        lLable.setBorder(new EmptyBorder(0, 128, 0, 0));

        mapPanel.add(spHotel);
        mapPanel.add(lLable);
        mapPanel.add(lHotel);
        mapPanel.add(pointPanel);
        mapPanel.add(tfSearch);
        mapPanel.add(buttonPop);
        mapPanel.add(buttonSearch);
        mapPanel.add(backPanel);
        mapPanel.add(bdl);

        popSearch.removeAll();
        for (String key : hashHotel.keySet()) {
            JMenuItem menuItem = new JMenuItem(key);
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tfSearch.setText(menuItem.getText());
                }
            });
            popSearch.add(menuItem);
        }

        buttonPop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popSearch.show(buttonPop, -80, 50);
            }
        });

        MapImage mi = new MapImage();
        mapPanel.add(mi.panel());
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i<citys.length; i++){
                    if(citys[i].toLowerCase().equals(tfSearch.getText().toLowerCase())){
                        mapPanel.remove(bdl);
                        mi.change(i);
                        spPanel.removeAll();
                        pointPanel.removeAll();
                        allHotelPanel(citys[i]);
                        allHotels(citys[i]);
                        SwingUtilities.updateComponentTreeUI(mapPanel);
                        break;
                    }
                }
            }
        });

        return mapPanel;
    }

    private void allHotelPanel(String s){
        LinkedList<Hotels> ll = hashHotel.get(s);
        for(Hotels h: ll){
            HotelInfoPanel hip = new HotelInfoPanel(h);
            JButton bPanel = new JButton();
            JButton bBook = new JButton();

            bBook.setOpaque(false);
            bBook.setContentAreaFilled(false);
            bBook.setBorderPainted(false);
            bBook.setFocusable(false);
            bBook.setBounds(0, 0, 290, 0);
            bBook.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                }
            });

            bPanel.setOpaque(false);
            bPanel.setContentAreaFilled(false);
            bPanel.setBorderPainted(false);
            bPanel.setFocusable(false);
            bPanel.setBounds(0, 0, 290, 190);
            bPanel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    hip.resize();
                    if(i%2 == 1){
                        bPanel.setBounds(0, 50, 290, 290);
                        bBook.setBounds(0, 0, 290, 50);
                    }else{
                        bPanel.setBounds(0, 00, 290, 190);
                        bBook.setBounds(0, 0, 290, 0);
                    }
                    i++;
                    SwingUtilities.updateComponentTreeUI(mapPanel);
                }
            });
            
            hip.panel().add(bBook);
            hip.panel().add(bPanel);
            spPanel.add(hip.panel());
        }
    }

    private void allHotels(String city){
        HashMap<String, LinkedList<Hotels>> hm = new fileReader().hotelHashMap();
        if(hm.containsKey(city)){
            LinkedList<Hotels> ll = hm.get(city);
            int[] a;
            for(Hotels hot: ll){
                a = hot.ratings;
                double d = 0;
                int ii = 0;
                for(int i = 0; i<5; i++){
                    d+= + (a[i]*(5-i));
                    ii+= a[i];
                }
                d = d/ii;
                HotelInfoButton b = new HotelInfoButton(hot.hotName, d, hot.price, hot.x, hot.y);
                pointPanel.add(b.panel());
                SwingUtilities.updateComponentTreeUI(mapPanel);
            }
        }
    }
}
