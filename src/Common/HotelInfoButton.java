package Common;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class HotelInfoButton extends JButton implements CPanel {

    private JPanel popPanel = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(new Color(255, 255, 255, 200));
            g2.fillRoundRect(5, 5, 210, 60, 20, 20);
            g2.setStroke(new BasicStroke(2));
            g2.setColor(new Color(255, 255, 255, 255));
            g2.drawRoundRect(5, 5, 210, 60, 20, 20);
        }
    };
    private JPanel btnPanel = new JPanel();
    private JLabel hml = new JLabel();
    private JLabel hrl = new JLabel();
    private JLabel hpl = new JLabel();
    // private JLabel l = new JLabel();
    private int x, y, i = 1;

    public HotelInfoButton(String n, double r, double p, int x, int y){
        hml = new JLabel(n);
        hrl = new JLabel("Ratigns :\t" + String.format("%.2f", r));
        hpl = new JLabel("Pricing  :\t" + Double.toString(p));
        this.x = x;
        this.y = y;
    }

    @Override
    public JPanel panel(){
        btnPanel.setBounds(x-110, y-100, 220, 100);
        btnPanel.setLayout(null);
        btnPanel.setOpaque(false);
        btnPanel.setBackground(new Color(0, 0, 0, 100));

        popPanel.setBounds(0, 0, 220, 70);
        popPanel.setLayout(null);
        popPanel.setOpaque(false);

        hml.setBounds(10, 5, 200, 20);
        hml.setFont(new Font(null, Font.BOLD, 18));
        hrl.setBounds(10, 27, 200, 20);
        hpl.setBounds(10, 47, 200, 20);

        popPanel.add(hml);
        popPanel.add(hrl);
        popPanel.add(hpl);


        ImageIcon ii = new ImageIcon("/Users/washioferdousrubai/Downloads/pin.png");
        setBounds(94, 68, 32, 32);
        setIcon(ii);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);

        btnPanel.add(this);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(i == 1){
                    btnPanel.add(popPanel);
                    i = 0;
                    SwingUtilities.updateComponentTreeUI(btnPanel);
                }else{
                    btnPanel.remove(popPanel);
                    i = 1;
                    SwingUtilities.updateComponentTreeUI(btnPanel);
                }
            }
        });

        return btnPanel;
    }
    
}
