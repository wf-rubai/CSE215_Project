package DevMain;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Common.CPanel;
import Common.HotelInfoButton;
import Common.Hotels;
import Common.ArrayList;
import Common.fileReader;

public class infoPanel implements CPanel {

    private int xLoc, yLoc;
    private JPanel pInfo = new JPanel();
    private JLabel lx;
    private JLabel ly;
    private JLabel ltf;
    private JLabel lavg;
    private JLabel l1 = new JLabel("1 stat ratting :");
    private JLabel l2 = new JLabel("2 stat ratting :");
    private JLabel l3 = new JLabel("3 stat ratting :");
    private JLabel l4 = new JLabel("4 stat ratting :");
    private JLabel l5 = new JLabel("5 stat ratting :");
    private JLabel l6 = new JLabel("Avarage ratting :");
    private JLabel l7 = new JLabel("Price :");
    private JLabel l8 = new JLabel("Phone :");
    private JButton random = new JButton("Ramdom");
    private JButton add = new JButton("Add");
    private JButton set = new JButton("Set Pointer");
    private JTextField tf1 = new JTextField();
    private JTextField tfx = new JTextField();
    private JTextField tfy = new JTextField();
    private JTextField tfp = new JTextField();
    private JTextField s5 = new JTextField();
    private JTextField s4 = new JTextField();
    private JTextField s3 = new JTextField();
    private JTextField s2 = new JTextField();
    private JTextField s1 = new JTextField();
    private JTextField tfphn = new JTextField();
    private JPanel pPoint = new JPanel();
    private JLabel bdl = new JLabel(new ImageIcon("Images/GeoImage/BD.jpeg"));
    private JComboBox<String> cb = new JComboBox<String>();
    private JPopupMenu option = new JPopupMenu();
    private JMenuItem popRand = new JMenuItem("Add random");
    private JMenuItem popLoc = new JMenuItem("Set location");
    
    @Override
    public JPanel panel(){

        pInfo.setBounds(70, 0, 1180, 850);
        pInfo.setOpaque(false);
        pInfo.setLayout(null);

        pPoint.setBounds(330, 0, 850, 850);
        pPoint.setLayout(null);
        pPoint.setOpaque(false);

        tf1.setBounds(30, 120, 270, 30);
        tf1.setFont(new Font(null, Font.PLAIN, 13));

        tfx.setBounds(30, 180, 120, 30);
        tfy.setBounds(180, 180, 120, 30);
        
        lx = new JLabel("X");
        ly = new JLabel("Y");
        ltf = new JLabel("Hotel Name");
        lavg = new JLabel();
        lx.setBounds(35, 150, 120, 30);
        ly.setBounds(185, 150, 120, 30);
        ltf.setBounds(35, 90, 120, 30);
        lx.setForeground(Color.white);
        ly.setForeground(Color.white);
        ltf.setForeground(Color.white);
        
        s5.setBounds(150, 220, 150, 30);
        s4.setBounds(150, 250, 150, 30);
        s3.setBounds(150, 280, 150, 30);
        s2.setBounds(150, 310, 150, 30);
        s1.setBounds(150, 340, 150, 30);
        lavg.setBounds(150, 370, 40, 30);
        tfp.setBounds(150, 410, 150, 30);
        tfphn.setBounds(150, 440, 150, 30);
        bdl.setBounds(330, 0, 850, 850);

        l1.setBounds(30, 220, 200, 30);
        l2.setBounds(30, 250, 200, 30);
        l3.setBounds(30, 280, 200, 30);
        l4.setBounds(30, 310, 200, 30);
        l5.setBounds(30, 340, 200, 30);
        l6.setBounds(30, 370, 200, 30);
        l7.setBounds(30, 400, 200, 30);
        l8.setBounds(30, 430, 200, 30);

        l1.setForeground(Color.white);
        l2.setForeground(Color.white);
        l3.setForeground(Color.white);
        l4.setForeground(Color.white);
        l5.setForeground(Color.white);
        l6.setForeground(Color.white);
        l7.setForeground(Color.white);
        l8.setForeground(Color.white);

        pInfo.add(l1);
        pInfo.add(l2);
        pInfo.add(l3);
        pInfo.add(l4);
        pInfo.add(l5);
        pInfo.add(l6);
        pInfo.add(l7);
        pInfo.add(l8);
        pInfo.add(random);
        pPoint.add(cb);
        pInfo.add(pPoint);
        pInfo.add(tfphn);
        pInfo.add(lavg);
        pInfo.add(tfp);
        pInfo.add(set);
        pInfo.add(ltf);
        pInfo.add(tfx);
        pInfo.add(tfy);
        pInfo.add(tf1);
        pInfo.add(add);
        pInfo.add(s5);
        pInfo.add(s4);
        pInfo.add(s3);
        pInfo.add(s2);
        pInfo.add(s1);
        pInfo.add(lx);
        pInfo.add(ly);
        pInfo.add(lx);
        pInfo.add(ly);

        option.add(popLoc);
        option.add(popRand);
        option.add(new JMenuItem("Close"));

        set.setBounds(30, 700, 270, 40);
        set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPoint(Integer.parseInt(tfx.getText()), Integer.parseInt(tfy.getText()));
            }
        });

        random.setBounds(30, 750, 120, 40);
        random.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setRand();
                Random ran = new Random();
                tfx.setText((int)(425+(Math.pow(-1,ran.nextInt(2))*ran.nextInt(125))) + "");
                tfy.setText((int)(425+(Math.pow(-1,ran.nextInt(2))*ran.nextInt(125))) + "");
            }
        });

        popRand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setRand();
                tfx.setText(xLoc + "");
                tfy.setText(yLoc + "");
            }
        });

        popLoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfx.setText(xLoc + "");
                tfy.setText(yLoc + "");
            }
        });

        add.setBounds(180, 750, 120, 40);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    File file = new File("Files/hotels.txt");
                    FileWriter fw = new FileWriter(file, true);
                    String s = (String)cb.getSelectedItem();
                    fw.write("\n" + 
                            s.replace(" ", "_") + "\t" +
                            tf1.getText().replace(" ", "_") + "\t" + 
                            tfx.getText() + "\t" + 
                            tfy.getText()+ "\t" + 
                            s5.getText() + "\t" + 
                            s4.getText() + "\t" + 
                            s3.getText() + "\t" + 
                            s2.getText() + "\t" + 
                            s1.getText() + "\t" + 
                            tfp.getText() + "\t" + 
                            tfphn.getText()
                            );
                    fw.close();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(pInfo, "Something Went Wrong Adding Hotel Information", "ADDING ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        String[] citys = new ArrayList().cityName;
        for(String s: citys){
            cb.addItem(s);
        }

        cb.setBounds(30, 30, 200, 40);
        MapPanel mp = new MapPanel();
        pInfo.add(mp.panel());
        cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                pInfo.remove(bdl);
                mp.change(cb.getSelectedIndex());
                pPoint.removeAll();
                pPoint.add(cb);
                allHotels(cb.getSelectedItem().toString());
                SwingUtilities.updateComponentTreeUI(pPoint);
                SwingUtilities.updateComponentTreeUI(pInfo);
            }
        });

        pPoint.addMouseListener(new MouseListener() {

            public void doPopup(MouseEvent e) {          
                xLoc = e.getX();
                yLoc = e.getY();
                option.show(e.getComponent(), xLoc, yLoc);            
            } 


			@Override
			public void mouseClicked(MouseEvent e) {
				doPopup(e);
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
        });
        
        pInfo.add(bdl);

        return pInfo;
    }

    private void addPoint(int x, int y){
        HotelInfoButton b = new HotelInfoButton(tf1.getText(), 
                                                Double.parseDouble(lavg.getText()), 
                                                Double.parseDouble(tfp.getText()), 
                                                x, y);
        pPoint.add(b.panel());
        SwingUtilities.updateComponentTreeUI(pInfo);
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
                pPoint.add(b.panel());
                SwingUtilities.updateComponentTreeUI(pInfo);
            }
        }
    }

    private void setRand(){
        Random ran = new Random();
        String[] name1 = {"Diamond",
                        "Marin",
                        "Park",
                        "Lake", 
                        "Regent",
                        "Royal",
                        "Radisson",
                        "The",
                        "City",
                        "Pacific",
                        "Stat",
                        "Grand",
                        "Paradise",
                        "View",
                        "Palae",
                        "White",
                        "River",
                        "", ""};
        String[] name2 = {"Hotel",
                        "Hotel",
                        "Hotel",
                        "Hotel",
                        "Inn",
                        "Resort",
                        "Resort",
                        ""};
        tf1.setText(name1[ran.nextInt(name1.length)] + " " +
                    name1[ran.nextInt(name1.length)] + " " +
                    name2[ran.nextInt(name2.length)]);

        tfp.setText((10+ran.nextInt(50)) + "99.99");

        double i5 = (double)300 + ran.nextInt(700);
        int i4 = 250 + ran.nextInt(450);
        int i3 = 200 + ran.nextInt(300);
        int i2 = ran.nextInt(200);
        int i1 = ran.nextInt(150);

        s5.setText((int)(i5) + "");
        s4.setText(i4 + "");
        s3.setText(i3 + "");
        s2.setText(i2 + "");
        s1.setText(i1 + "");

        String p = "01";
        for(int i = 0; i<9; i++){
            int s = (int) (Math.random()*10);
            p += s;
        }

        tfphn.setText(p);

        double d = ((5*i5)+ (4*i4)+ (3*i3)+ (2*i2)+ (1*i1))/(i5+i4+i3+i2+i1);
        lavg.setText(Double.toString(d));
    }
}
