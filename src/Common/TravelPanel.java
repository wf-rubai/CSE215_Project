package Common;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TravelPanel implements CPanel {

    int r;
    int g;
    int b;
    private JPanel pTravel = new JPanel(){
        protected void paintComponent(Graphics gg){
            super.paintComponent(gg);
            Graphics2D g2 = (Graphics2D) gg;
            g2.setColor(new Color(r, g, b, 100));
            g2.fillRoundRect(10, 10, 880, 230, 35, 35);
            g2.setStroke(new BasicStroke(3));
            g2.setColor(new Color(r, g, b, 255));
            g2.drawRoundRect(10, 10, 880, 230, 35, 35);
        }
    };

    private JButton bi3 = new JButton();
    private JLabel bi1 = new JLabel();
    private JLabel bi2 = new JLabel();
    private JLabel bi4 = new JLabel();
    private JLabel bi5 = new JLabel();
    private JLabel bi6 = new JLabel();

    public TravelPanel(String[] s){
        randomColor();
        s[6] = s[6].substring(7);
        bi1.setText(s[4]);
        bi2.setText(s[5]);
        bi3.setText(s[6]);
        bi4.setText(s[7]);
        bi5.setText(s[8]);
        bi6.setText(s[9]);
    }

    @Override
    public JPanel panel() {
        // pTravel.setLayout(new BoxLayout(pTravel, BoxLayout.Y_AXIS));
        pTravel.setPreferredSize(new Dimension(900, 250));
        pTravel.setBorder(new EmptyBorder(30, 0, 30, 0));

        bi3.setFont(new Font(null, Font.PLAIN, 17));
        bi1.setFont(new Font(null, Font.PLAIN, 14));
        bi2.setFont(new Font(null, Font.PLAIN, 14));
        bi4.setFont(new Font(null, Font.PLAIN, 14));
        bi5.setFont(new Font(null, Font.PLAIN, 14));
        bi6.setFont(new Font(null, Font.PLAIN, 14));

        bi1.setBorder( new EmptyBorder(0, 300, 0, 0));
        bi2.setBorder( new EmptyBorder(0, 300, 0, 0));
        bi4.setBorder( new EmptyBorder(0, 300, 0, 0));
        bi5.setBorder( new EmptyBorder(0, 300, 0, 0));
        bi6.setBorder( new EmptyBorder(0, 300, 0, 0));

        bi3.setOpaque(false);
        bi3.setPreferredSize(new Dimension(900, 50));

        pTravel.add(bi3);
        pTravel.add(bi1);
        pTravel.add(bi2);
        pTravel.add(bi4);
        pTravel.add(bi5);
        pTravel.add(bi6);
        return pTravel;
    }

    private void randomColor() {
        r = (int) (Math.random() * 256);
        g = (int) (Math.random() * 256);
        b = (int) (Math.random() * 256);
    }
}
