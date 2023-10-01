package DevMain;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MapView {
    private JPanel pMain = new JPanel();
    private JPanel pMap = new JPanel();
    private JPanel pInfo = new JPanel();
    private JPanel pSB = new JPanel();
    private JComboBox<String> cb;
    private JTextField tf1;
    private JLabel lx;
    private JLabel ly;
    private JLabel ltf;
    private JTextField tfx;
    private JTextField tfy;
    private JButton random = new JButton("Ramdom");
    private JButton add = new JButton("Add");
    private JTextField s5 = new JTextField();
    private JTextField s4 = new JTextField();
    private JTextField s3 = new JTextField();
    private JTextField s2 = new JTextField();
    private JTextField s1 = new JTextField();

    public JPanel panel(){
        pMain.setBounds(0, 0, 1250, 850);
        pMain.setLayout(null);

        pMap.setBounds(400, -5, 850, 855);
        // pMap.setBackground(Color.BLACK);
        ImageIcon mapIcon = new ImageIcon("Images/GeoImage/chiottogram.jpg");
        JLabel l1 = new JLabel(mapIcon);
        pMap.add(l1);
        pMain.add(pMap);

        pInfo.setBounds(70, 0, 330, 850);
        pInfo.setBackground(Color.gray);
        pInfo.setLayout(null);
        cb = new JComboBox<>();
        cb.addItem("Chottogram");
        cb.setBounds(30, 50, 270, 50);
        cb.setBorder(null);

        tf1 = new JTextField();
        tf1.setBounds(30, 120, 270, 30);
        tf1.setFont(new Font(null, Font.PLAIN, 13));
        tf1.setBorder(null);
        tfx = new JTextField();
        tfy = new JTextField();
        tfx.setBounds(30, 180, 120, 30);
        tfy.setBounds(180, 180, 120, 30);
        tfx.setBorder(null);
        tfy.setBorder(null);

        lx = new JLabel("X");
        ly = new JLabel("Y");
        ltf = new JLabel("Hotel Name");
        lx.setBounds(35, 150, 120, 30);
        ly.setBounds(185, 150, 120, 30);
        ltf.setBounds(35, 90, 120, 30);

        s5.setBounds(30, 220, 100, 30);
        s4.setBounds(30, 250, 100, 30);
        s3.setBounds(30, 280, 100, 30);
        s2.setBounds(30, 310, 100, 30);
        s1.setBounds(30, 340, 100, 30);

        random.setBounds(30, 750, 120, 40);
        random.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setRand();
            }
        });

        pInfo.add(s5);
        pInfo.add(s4);
        pInfo.add(s3);
        pInfo.add(s2);
        pInfo.add(s1);
        pInfo.add(random);
        pInfo.add(ltf);
        pInfo.add(tfx);
        pInfo.add(tfy);
        pInfo.add(lx);
        pInfo.add(ly);
        pInfo.add(lx);
        pInfo.add(ly);
        pInfo.add(tf1);
        pInfo.add(cb);
        pMain.add(pInfo);

        pSB.setBounds(0, 0, 70, 850);
        pSB.setBackground(Color.darkGray);
        pSB.setLayout(null);
        pMain.add(pSB);
        return pMain;
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
                        "View",
                        "Palae",
                        "White",
                        "River",
                        "","","","",""};
        String[] name2 = {"Hotel",
                        "Inn",
                        "Resort",
                        "","",""};
        tf1.setText(name1[ran.nextInt(name1.length)] + " " +
                    name1[ran.nextInt(name1.length)] + " " +
                    name2[ran.nextInt(name2.length)]);
        tfx.setText((425+(Math.pow(-1,ran.nextInt(2))*ran.nextInt(125))) + "");
        tfy.setText((425+(Math.pow(-1,ran.nextInt(2))*ran.nextInt(125))) + "");
        s5.setText(ran.nextInt(500) + "");
        s4.setText(ran.nextInt(400) + "");
        s3.setText(ran.nextInt(300) + "");
        s2.setText(ran.nextInt(200) + "");
        s1.setText(ran.nextInt(100) + "");
    }
}
