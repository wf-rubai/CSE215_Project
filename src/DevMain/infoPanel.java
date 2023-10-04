package DevMain;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Common.arrayList;

public class infoPanel {
    private JPanel pInfo = new JPanel();
    // {
    //     @Override
    //     protected void paintComponent(Graphics g) {
    //         super.paintComponent(g);
    //         ImageIcon imageIcon = new ImageIcon(img);
    //         Image image = imageIcon.getImage();
    //         g.drawImage(image, 0, 0, 330, 850, this);
    //     }
    // };

    private JTextField tf1;
    private JLabel lx;
    private JLabel ly;
    private JLabel ltf;
    private JLabel lavg;
    private JTextField tfx;
    private JTextField tfy;
    private JTextField tfp;
    private JButton random = new JButton("Ramdom");
    private JButton add = new JButton("Add");
    private JButton set = new JButton("Set Pointer");
    private JTextField s5 = new JTextField();
    private JTextField s4 = new JTextField();
    private JTextField s3 = new JTextField();
    private JTextField s2 = new JTextField();
    private JTextField s1 = new JTextField();
    private JPanel pPoint = new JPanel();
    protected JComboBox<String> cb = new JComboBox<String>();

    public JPanel panel(){

        pInfo.setBounds(70, 0, 1180, 850);
        pInfo.setOpaque(false);
        pInfo.setBackground(new Color(0, 0, 0, 0));
        pInfo.setLayout(null);

        pPoint.setBounds(330, 0, 850, 850);
        pPoint.setLayout(null);
        pPoint.setOpaque(false);

        tf1 = new JTextField();
        tf1.setBounds(30, 120, 270, 30);
        tf1.setFont(new Font(null, Font.PLAIN, 13));
        tfx = new JTextField();
        tfy = new JTextField();
        tfp = new JTextField();
        tfx.setBounds(30, 180, 120, 30);
        tfy.setBounds(180, 180, 120, 30);
        tfp.setBounds(30, 410, 100, 30);
        
        lx = new JLabel("X");
        ly = new JLabel("Y");
        ltf = new JLabel("Hotel Name");
        lavg = new JLabel();
        lx.setBounds(35, 150, 120, 30);
        ly.setBounds(185, 150, 120, 30);
        ltf.setBounds(35, 90, 120, 30);
        
        s5.setBounds(30, 220, 100, 30);
        s4.setBounds(30, 250, 100, 30);
        s3.setBounds(30, 280, 100, 30);
        s2.setBounds(30, 310, 100, 30);
        s1.setBounds(30, 340, 100, 30);
        lavg.setBounds(30, 370, 100, 30);

        pInfo.add(random);
        pPoint.add(cb);
        pInfo.add(pPoint);
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
                            tfp.getText()
                            );
                    fw.close();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(pInfo, "Something Went Wrong Adding Hotel Information", "ADDING ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        String[] citys = new arrayList().cityName;
        for(String s: citys){
            cb.addItem(s);
        }

        cb.setBounds(30, 30, 200, 40);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MapPanel mp = new MapPanel();
                pInfo.add(mp.panel());
                cb.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        mp.change(cb.getSelectedIndex());
                        pPoint.removeAll();
                        pPoint.add(cb);
                        SwingUtilities.updateComponentTreeUI(pPoint);
                    }
                });
            }
        });

        return pInfo;
    }

    public void addPoint(int x, int y){
        ImageIcon ii = new ImageIcon("/Users/washioferdousrubai/Downloads/384501584_3604472916434543_29105.png");
        JButton b = new JButton(ii);
        b.setBounds(x-10, y-30, 20, 30);
        pPoint.add(b);
        SwingUtilities.updateComponentTreeUI(pPoint);
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
                        "","","",""};
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
        tfx.setText((int)(425+(Math.pow(-1,ran.nextInt(2))*ran.nextInt(125))) + "");
        tfy.setText((int)(425+(Math.pow(-1,ran.nextInt(2))*ran.nextInt(125))) + "");
        tfp.setText((10+ran.nextInt(50)) + "99.99");
        double i5 = (double)ran.nextInt(600);
        s5.setText((int)(i5) + "");
        int i4 = ran.nextInt(550);
        s4.setText(i4 + "");
        int i3 = ran.nextInt(300);
        s3.setText(i3 + "");
        int i2 = ran.nextInt(200);
        s2.setText(i2 + "");
        int i1 = ran.nextInt(100);
        s1.setText(i1 + "");
        double d = ((5*i5)+ (4*i4)+ (3*i3)+ (2*i2)+ (1*i1))/(i5+i4+i3+i2+i1);
        lavg.setText("Avg: " + d);
    }
}
