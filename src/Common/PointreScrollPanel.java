package Common;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import UserMain.StaticUser;

public class PointreScrollPanel implements CPanel {
    
    private JPanel mainPanel = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.lightGray);
            g2.fillRoundRect(5, 10, 160, 55, 30, 30);
            g2.fillRoundRect(5, 75, 160, 405, 30, 30);
            g2.setColor(new Color(37, 125, 232));
            g2.fillRoundRect(5, 490, 160, 35, 30, 30);
        }
    };
    private JPanel selectPanel = new JPanel();
    private JPanel spPanel = new JPanel();
    private ImageIcon[] images = new ArrayList().mapPin;
    private LinkedList<Object> object = new FileReader().objectList();
    private int imageIndex = (int)object.get(2);
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
                object.set(2, imageIndex);
                new ObjecSaver(object);
                object = new FileReader().objectList();
                StaticUser.update();
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
                g2.fillRoundRect(0, 0, 150, 45, 25, 25);
            }
        };
        p.setPreferredSize(new Dimension(150, 50));
        p.setOpaque(false);
        JButton b = new JButton(images[i]);
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        b.setFocusable(false);
        b.setPreferredSize(new Dimension(150, 45));
        p.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectPanel.removeAll();
                mainPanel.remove(lTic);
                if(i == (int)object.get(2)){
                    mainPanel.remove(selectPanel);
                    mainPanel.add(lTic);
                    mainPanel.add(selectPanel);
                }
                currentProfile = p;
                selectPanel.add(currentProfile);
                spPanel.removeAll();
                for(int i = 0; i<images.length; i++){
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

        lTic.setBounds(140, 25, 200, 20);
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
        scrollPane.setBounds(10, 80, 150, 395);
        scrollPane.setOpaque(false);
        scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));

        spPanel.setLayout(new BoxLayout(spPanel, BoxLayout.Y_AXIS));
        spPanel.setBackground(Color.lightGray);

        for(int i = 0; i<images.length; i++){
            spPanel.add(setSP(i));
        }

        mainPanel.add(save);
        mainPanel.add(selectPanel);
        mainPanel.add(scrollPane);
    }
}
