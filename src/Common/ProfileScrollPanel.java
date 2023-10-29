package Common;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class ProfileScrollPanel implements CPanel {
    
    private JPanel mainPanel = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.lightGray);
            g2.fillRoundRect(5, 10, 160, 155, 30, 30);
            g2.fillRoundRect(5, 175, 160, 305, 30, 30);
            g2.setColor(new Color(37, 125, 232));
            g2.fillRoundRect(5, 490, 160, 35, 30, 30);
        }
    };
    private JPanel selectPanel = new JPanel();
    private JPanel spPanel = new JPanel();
    private ImageIcon[] images = new ArrayList().profile;
    private LinkedList<Object> object = new fileReader().objectList();
    private HashMap<String,UserInfo> uInfo = new fileReader().userHashMap();
    private UserInfo user = (UserInfo) object.get(1);
    private int imageIndex = user.imgIndex;
    private JPanel currentProfile = setSP(imageIndex);
    private JButton save = new JButton("Save Profile");
    private JLabel lTic = new JLabel("✓ ");
    private JScrollPane scrollPane;

    @Override
    public JPanel panel() {

        setup();

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.remove(selectPanel);
                mainPanel.add(lTic);
                mainPanel.add(selectPanel);
                user.imgIndex = imageIndex;
                object.set(1, user);
                new ObjecSaver(object);
                uInfo.replace(user.pass, user);
                new ResaveUser(uInfo);
                SwingUtilities.updateComponentTreeUI(mainPanel);
            }
        });

        return mainPanel;
    }

    private JPanel setSP(int i){
        JPanel p = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.gray);
                g2.fillRoundRect(0, 0, 150, 145, 25, 25);
                ImageIcon imageIcon = images[i];
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, 150, 150, this);
            }
        };
        p.setPreferredSize(new Dimension(150, 150));
        p.setOpaque(false);
        JButton b = new JButton();
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        b.setFocusable(false);
        b.setPreferredSize(new Dimension(150, 150));
        p.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectPanel.removeAll();
                mainPanel.remove(lTic);
                if(i == user.imgIndex){
                    mainPanel.remove(selectPanel);
                    mainPanel.add(lTic);
                    mainPanel.add(selectPanel);
                }
                currentProfile = p;
                selectPanel.add(currentProfile);
                spPanel.removeAll();
                for(int i = 3; i<=12; i++){
                    spPanel.add(setSP(i));
                }
                SwingUtilities.updateComponentTreeUI(mainPanel);
                imageIndex = i;
            }
        });

        return p;
    }

    private void setup(){

        mainPanel.setBounds(795, 160, 170, 530);
        mainPanel.setLayout(null);
        mainPanel.setOpaque(false);

        lTic.setBounds(140, 20, 200, 20);
        lTic.setFont(new Font(null, Font.PLAIN, 20));
        lTic.setForeground(Color.green);

        selectPanel.setBounds(10, 10, 150, 150);
        selectPanel.setOpaque(false);
        mainPanel.add(lTic);
        selectPanel.add(currentProfile);

        save.setBounds(5, 490, 160, 37);
        save.setOpaque(false);
        save.setContentAreaFilled(false);
        save.setBorderPainted(false);
        save.setFocusable(false);

        scrollPane = new JScrollPane(spPanel, 
                                                JScrollPane.VERTICAL_SCROLLBAR_NEVER, 
                                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(10, 180, 150, 295);
        scrollPane.setOpaque(false);
        scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));

        spPanel.setLayout(new BoxLayout(spPanel, BoxLayout.Y_AXIS));
        spPanel.setBackground(Color.lightGray);

        for(int i = 3; i<=12; i++){
            spPanel.add(setSP(i));
        }

        mainPanel.add(save);
        mainPanel.add(selectPanel);
        mainPanel.add(scrollPane);
    }
}
