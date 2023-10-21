package UserMain;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Common.CustomExeption;
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
    private JPanel mapPanel = new JPanel(){
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
    private JPanel pBook = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(new Color(0, 2, 120, 100));
            g2.fillRoundRect(2, 2, 396, 496, 20, 20);
            g2.setStroke(new BasicStroke(2));
            g2.setColor(new Color(0, 2, 120));
            g2.drawRoundRect(2, 2, 396, 496, 20, 20);
        }
    };
    private JPanel pBookTime = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(new Color(0, 2, 120, 100));
            g2.fillRoundRect(2, 2, 396, 496, 20, 20);
            g2.fillRoundRect(2, 522, 396, 226, 20, 20);
            g2.setStroke(new BasicStroke(2));
            g2.setColor(new Color(0, 2, 120));
            g2.drawRoundRect(2, 2, 396, 496, 20, 20);
            g2.drawRoundRect(2, 522, 396, 226, 20, 20);
        }
    };
    private JPanel pConfirm = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("/Users/washioferdousrubai/Downloads/like.png");
            Image image = imageIcon.getImage();
            g.drawImage(image, 220, 20, 96, 96, this);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(new Color(0, 2, 120, 100));
            g2.fillRoundRect(2, 2, 546, 546, 20, 20);
            g2.setStroke(new BasicStroke(2));
            g2.setColor(new Color(0, 2, 120));
            g2.drawRoundRect(2, 2, 546, 546, 20, 20);
        }
    };

    private JPanel pMap = new JPanel();
    private JPanel pointPanel = new JPanel();
    private JPanel spPanel = new JPanel();
    private JLabel bdl = new JLabel(new ImageIcon("Images/GeoImage/BD.jpeg"));
    private JLabel userInfo = new JLabel("Your information please");
    private JLabel bookingtime = new JLabel("Booking time table");
    private JLabel lName = new JLabel("Name :");
    private JLabel lMail = new JLabel("E-Mail :");
    private JLabel lPhone = new JLabel("Phone :");
    private JLabel lNid = new JLabel("NID no. :");
    private JLabel lFrom = new JLabel("From :");
    private JLabel lTo = new JLabel("To :");
    private JLabel lAdult = new JLabel("Adult :");
    private JLabel lChild = new JLabel("Children :");
    private JLabel fHotel = new JLabel();
    private JLabel fCity = new JLabel();
    private JLabel fDate = new JLabel();
    private JLabel fTotalDay = new JLabel();
    private JLabel fRoom = new JLabel();
    private JLabel fPrice = new JLabel();
    private JLabel ui = new JLabel("Customer Information");
    private JLabel ui1 = new JLabel();
    private JLabel ui2 = new JLabel();
    private JLabel ui3 = new JLabel();
    private JLabel ui4 = new JLabel();
    private JLabel bi = new JLabel("Booking Information");
    private JLabel bi1 = new JLabel();
    private JLabel bi2 = new JLabel();
    private JLabel bi3 = new JLabel();
    private JLabel bi4 = new JLabel();
    private JLabel bi5 = new JLabel();
    private JLabel bi6 = new JLabel();
    private JTextField tfName = new JTextField();
    private JTextField tfMail = new JTextField();
    private JTextField tfPhone = new JTextField();
    private JTextField tfNid = new JTextField();
    private JTextField tfAdult = new JTextField("0");
    private JTextField tfChild = new JTextField("0");
    private JButton bBook = new JButton("COnfirm Booking");
    private JButton bCont = new JButton("Continue");
    private JButton bconf = new JButton("Confirm");
    private JButton bLogIN = new JButton("---------Log In---------");
    private JButton cancel1 = new JButton(new ImageIcon("/Users/washioferdousrubai/Downloads/cross.png"));
    private JButton cancel2 = new JButton(new ImageIcon("/Users/washioferdousrubai/Downloads/cross.png"));
    private JButton cancel3 = new JButton(new ImageIcon("/Users/washioferdousrubai/Downloads/cross.png"));
    private JComboBox<String> fDay = new JComboBox<>();
    private JComboBox<String> fMonth = new JComboBox<>();
    private JComboBox<String> fYear = new JComboBox<>();
    private JComboBox<String> tDay = new JComboBox<>();
    private JComboBox<String> tMonth = new JComboBox<>();
    private JComboBox<String> tYear = new JComboBox<>();
    private JPopupMenu popSearch = new JPopupMenu();
    private HashMap<String, LinkedList<Hotels>> hashHotel = new fileReader().hotelHashMap();
    private String[] citys = new arrayList().cityName;
    private String bookHotel;
    private String bookCity;
    private double bookPrice = 0;
    private int i = 1;

    public JPanel panel(){

        setup();

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
        pMap.setBounds(0, 0, 1180, 850);
        pMap.setLayout(null);
        pMap.setOpaque(false);

        pMap.add(pointPanel);
        pMap.add(tfSearch);
        pMap.add(buttonPop);
        pMap.add(buttonSearch);
        pMap.add(backPanel);
        pMap.add(bdl);

        mapPanel.add(spHotel);
        mapPanel.add(lLable);
        mapPanel.add(lHotel);
        mapPanel.add(pMap);

        bconf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(fDay.getSelectedIndex()==0 || fMonth.getSelectedIndex()==0 || fYear.getSelectedIndex()==0){
                        throw new CustomExeption("You must select the date when will you go");
                    }else if(tDay.getSelectedIndex()==0 || tMonth.getSelectedIndex()==0 || tYear.getSelectedIndex()==0){
                        throw new CustomExeption("You must select the date when will you check out");
                    }else if(tfAdult.getText().equals("") || tfAdult.getText().equals("0")){
                        throw new CustomExeption("You must mention your guest number");
                    }else{
                        fHotel.setText("Hotel : " + bookHotel);
                        fCity.setText("City : " + bookCity);
                        fDate.setText("Date : From " + fDay.getSelectedItem() + " " + fMonth.getSelectedItem() + ", " + fYear.getSelectedItem() + " to " + tDay.getSelectedItem() + " " + tMonth.getSelectedItem() + ", " + tYear.getSelectedItem());
                        int room = (int) Math.ceil(Math.ceil(Double.parseDouble(tfAdult.getText())/2));
                        if(Double.parseDouble(tfChild.getText()) != 0){
                            room += (int) Math.ceil((Double.parseDouble(tfChild.getText())- Math.ceil(Double.parseDouble(tfAdult.getText())/2))/2);
                        }
                        LocalDate d1 = LocalDate.of(2022+fYear.getSelectedIndex(), fMonth.getSelectedIndex(), fDay.getSelectedIndex());
                        LocalDate d2 = LocalDate.of(2022+tYear.getSelectedIndex(), tMonth.getSelectedIndex(), tDay.getSelectedIndex());
                        int day = (int) ChronoUnit.DAYS.between(d1, d2);
                        fTotalDay.setText("Day(s) : " + day);
                        fRoom.setText("Room(s) : " + room);
                        fPrice.setText("Total bill : " + (Math.round(bookPrice*day*room*100)/100.0));
                        pBookTime.add(fHotel);
                        pBookTime.add(fCity);
                        pBookTime.add(fDate);
                        pBookTime.add(fTotalDay);
                        pBookTime.add(fRoom);
                        pBookTime.add(fPrice);
                        pBookTime.add(bBook);
                        pBookTime.setBounds(760, 50, 400, 750);
                    }
                }catch(CustomExeption ce){
                    JOptionPane.showMessageDialog(pBookTime, ce.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(pBookTime, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                SwingUtilities.updateComponentTreeUI(mapPanel);
            }
        });

        bBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapPanel.remove(pBook);
                mapPanel.remove(pBookTime);
                mapPanel.remove(spHotel);
                mapPanel.remove(lLable);
                mapPanel.remove(lHotel);
                ui1.setText("Name : " + tfName.getText());
                ui2.setText("E-mail : " + tfMail.getText());
                ui3.setText("Phone : " + tfPhone.getText());
                ui4.setText("NID no. : " + tfNid.getText());
                bi1.setText(fHotel.getText());
                bi2.setText(fCity.getText());
                bi3.setText(fDate.getText());
                bi4.setText(fTotalDay.getText());
                bi5.setText(fRoom.getText());
                bi6.setText(fPrice.getText());
                pConfirm.add(cancel3);
                pConfirm.add(ui);
                pConfirm.add(ui1);
                pConfirm.add(ui2);
                pConfirm.add(ui3);
                pConfirm.add(ui4);
                pConfirm.add(bi);
                pConfirm.add(bi1);
                pConfirm.add(bi2);
                pConfirm.add(bi3);
                pConfirm.add(bi4);
                pConfirm.add(bi5);
                pConfirm.add(bi6);
                mapPanel.add(pConfirm);
                try{
                    File file = new File("Files/travelInfo.txt");
                    FileWriter fw = new FileWriter(file, true);
                    fw.write("\n" + 
                            ui1.getText().replace(" ", "_") + "\t" +
                            ui2.getText().replace(" ", "_") + "\t" +
                            ui3.getText().replace(" ", "_") + "\t" +
                            ui4.getText().replace(" ", "_") + "\t" +
                            bi1.getText().replace(" ", "_") + "\t" +
                            bi2.getText().replace(" ", "_") + "\t" +
                            bi3.getText().replace(" ", "_") + "\t" +
                            bi4.getText().replace(" ", "_") + "\t" +
                            bi5.getText().replace(" ", "_") + "\t" +
                            bi6.getText().replace(" ", "_")
                            );
                    fw.close();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(mapPanel, ex.getMessage(), "File saving error", JOptionPane.ERROR_MESSAGE);
                }
                SwingUtilities.updateComponentTreeUI(mapPanel);
            }
        });

        bCont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tfName.getText().equals("")){
                    JOptionPane.showMessageDialog(pBook, "You must provide your name", "Error", JOptionPane.ERROR_MESSAGE);
                }else if(tfMail.getText().equals("")){
                    JOptionPane.showMessageDialog(pBook, "You must provide your Email address", "Error", JOptionPane.ERROR_MESSAGE);
                }else if(tfPhone.getText().equals("")){
                    JOptionPane.showMessageDialog(pBook, "You must provide your phone number", "Error", JOptionPane.ERROR_MESSAGE);
                }else if(tfNid.getText().equals("")){
                    JOptionPane.showMessageDialog(pBook, "You must provide your NID no.", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    mapPanel.add(pBookTime);
                }
                SwingUtilities.updateComponentTreeUI(mapPanel);
            }
        });

        cancel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapPanel.remove(pConfirm);
                mapPanel.remove(pBook);
                mapPanel.remove(pBookTime);
                mapPanel.add(pMap);
                SwingUtilities.updateComponentTreeUI(mapPanel);
            }
        });

        cancel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapPanel.remove(pBookTime);
                SwingUtilities.updateComponentTreeUI(mapPanel);
            }
        });

        cancel3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapPanel.add(spHotel);
                mapPanel.add(lLable);
                mapPanel.add(lHotel);
                mapPanel.add(pMap);
                SwingUtilities.updateComponentTreeUI(mapPanel);
            }
        });

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
        pMap.add(mi.panel());
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i<citys.length; i++){
                    if(citys[i].toLowerCase().equals(tfSearch.getText().toLowerCase())){
                        pMap.remove(bdl);
                        mi.change(i);
                        spPanel.removeAll();
                        pointPanel.removeAll();
                        allHotelPanel(citys[i]);
                        allHotels(citys[i]);
                        SwingUtilities.updateComponentTreeUI(pMap);
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
                    bookPrice = h.price;
                    bookCity = h.cityName;
                    bookHotel = h.hotName;
                    mapPanel.remove(pMap);
                    mapPanel.add(pBook);
                    SwingUtilities.updateComponentTreeUI(mapPanel);
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

    private void setup(){

        pConfirm.setBounds(340, 150, 550, 550);
        pConfirm.setOpaque(false);
        pConfirm.setLayout(null);

        ui.setBounds(150, 150, 400, 50);
        ui1.setBounds(50, 200, 400, 25);
        ui2.setBounds(50, 225, 400, 25);
        ui3.setBounds(50, 250, 400, 25);
        ui4.setBounds(50, 275, 400, 25);
        bi.setBounds(150, 300, 400, 50);
        bi1.setBounds(50, 350, 400, 25);
        bi2.setBounds(50, 375, 400, 25);
        bi3.setBounds(50, 400, 400, 25);
        bi4.setBounds(50, 425, 400, 25);
        bi5.setBounds(50, 450, 400, 25);
        bi6.setBounds(50, 475, 400, 25);
        ui.setFont(new Font(null, Font.BOLD, 18));
        bi.setFont(new Font(null, Font.BOLD, 18));
        ui1.setFont(new Font(null, Font.PLAIN, 14));
        ui2.setFont(new Font(null, Font.PLAIN, 14));
        ui3.setFont(new Font(null, Font.PLAIN, 14));
        ui4.setFont(new Font(null, Font.PLAIN, 14));
        bi1.setFont(new Font(null, Font.PLAIN, 14));
        bi2.setFont(new Font(null, Font.PLAIN, 14));
        bi3.setFont(new Font(null, Font.PLAIN, 14));
        bi4.setFont(new Font(null, Font.PLAIN, 14));
        bi5.setFont(new Font(null, Font.PLAIN, 14));
        bi6.setFont(new Font(null, Font.PLAIN, 14));

        cancel3.setBounds(500, 20, 30, 30);
        cancel3.setOpaque(false);
        cancel3.setContentAreaFilled(false);
        cancel3.setBorderPainted(false);
        cancel3.setFocusable(false);
        
        mapPanel.setLayout(null);
        mapPanel.setBounds(70, 0, 1180, 850);

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

        pBook.setBounds(340, 200, 400, 500);
        pBook.setLayout(null);
        pBook.setOpaque(false);

        userInfo.setFont(new Font("Arial", Font.BOLD, 20));
        userInfo.setBounds(80, 30, 300, 30);

        lName.setBounds(50, 70, 300, 40);
        lMail.setBounds(50, 140, 300, 40);
        lPhone.setBounds(50, 210, 300, 40);
        lNid.setBounds(50, 280, 300, 40);

        tfName.setBounds(50, 110, 300, 30);
        tfMail.setBounds(50, 180, 300, 30);
        tfPhone.setBounds(50, 250, 300, 30);
        tfNid.setBounds(50, 320, 300, 30);

        bCont.setBounds(50, 380, 300, 40);
        bLogIN.setBounds(50, 430, 300, 40);

        tfName.setBorder(new EmptyBorder(0, 10, 0, 10));
        tfMail.setBorder(new EmptyBorder(0, 10, 0, 10));
        tfPhone.setBorder(new EmptyBorder(0, 10, 0, 10));
        tfNid.setBorder(new EmptyBorder(0, 10, 0, 10));

        cancel1.setBounds(350, 20, 30, 30);
        cancel1.setOpaque(false);
        cancel1.setContentAreaFilled(false);
        cancel1.setBorderPainted(false);
        cancel1.setFocusable(false);

        pBook.add(cancel1);
        pBook.add(bCont);
        pBook.add(bLogIN);
        pBook.add(userInfo);
        pBook.add(lName);
        pBook.add(tfName);
        pBook.add(lMail);
        pBook.add(tfMail);
        pBook.add(lPhone);
        pBook.add(tfPhone);
        pBook.add(lNid);
        pBook.add(tfNid);

        cancel2.setBounds(350, 20, 30, 30);
        cancel2.setOpaque(false);
        cancel2.setContentAreaFilled(false);
        cancel2.setBorderPainted(false);
        cancel2.setFocusable(false);

        fDay.addItem("Day");
        for(int i=1; i<=31; i++){
            fDay.addItem(i + "");
        }
        String[] month = new arrayList().month;
        fMonth.addItem("Month");
        for(String m: month){
            fMonth.addItem(m);
        }
        fYear.addItem("Year");
        for(int i=2023; i<=2024; i++){
            fYear.addItem(i + "");
        }

        tDay.addItem("Day");
        for(int i=1; i<=31; i++){
            tDay.addItem(i + "");
        }
        tMonth.addItem("Month");
        for(String m: month){
            tMonth.addItem(m);
        }
        tYear.addItem("Year");
        for(int i=2023; i<=2024; i++){
            tYear.addItem(i + "");
        }
        
        pBookTime.setBounds(760, 200, 400, 500);
        pBookTime.setLayout(null);
        // pBookTime.setBackground(Color.MAGENTA);
        pBookTime.setOpaque(false);

        bookingtime.setFont(new Font("Arial", Font.BOLD, 20));
        bookingtime.setBounds(100, 30, 300, 30);

        lFrom.setBounds(50, 70, 300, 40);
        lTo.setBounds(50, 140, 300, 40);
        lAdult.setBounds(50, 210, 150, 40);
        lChild.setBounds(50, 280, 150, 40);

        fDay.setBounds(50, 110, 90, 30);
        fMonth.setBounds(150, 110, 90, 30);
        fYear.setBounds(250, 110, 90, 30);
        tDay.setBounds(50, 180, 90, 30);
        tMonth.setBounds(150, 180, 90, 30);
        tYear.setBounds(250, 180, 90, 30);
        tfAdult.setBounds(50, 250, 200, 30);
        tfChild.setBounds(50, 320, 200, 30);

        tfAdult.setBorder(new EmptyBorder(0, 10, 0, 10));
        tfChild.setBorder(new EmptyBorder(0, 10, 0, 10));
        
        bconf.setBounds(50, 405, 300, 40);

        fHotel.setBounds(50, 540, 300, 25);
        fCity.setBounds(50, 565, 300, 25);
        fDate.setBounds(50, 590, 300, 25);
        fTotalDay.setBounds(50, 615, 300, 25);
        fRoom.setBounds(50, 640, 300, 25);
        fPrice.setBounds(50, 665, 300, 25);
        bBook.setBounds(50, 695, 300, 40);

        fHotel.setFont(new Font(null, Font.PLAIN, 14));
        fCity.setFont(new Font(null, Font.PLAIN, 14));
        fDate.setFont(new Font(null, Font.PLAIN, 14));
        fTotalDay.setFont(new Font(null, Font.PLAIN, 14));
        fRoom.setFont(new Font(null, Font.PLAIN, 14));
        fPrice.setFont(new Font(null, Font.PLAIN, 14));

        pBookTime.add(bconf);
        pBookTime.add(cancel2);
        pBookTime.add(bookingtime);
        pBookTime.add(lFrom);
        pBookTime.add(lTo);
        pBookTime.add(fDay);
        pBookTime.add(fMonth);
        pBookTime.add(fYear);
        pBookTime.add(tDay);
        pBookTime.add(tMonth);
        pBookTime.add(tYear);
        pBookTime.add(lAdult);
        pBookTime.add(lChild);
        pBookTime.add(tfAdult);
        pBookTime.add(tfChild);
    }

    private static Color randomColor() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return new Color(r, g, b, 100);
    }
}
