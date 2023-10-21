package Common;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HotelInfoPanel extends JPanel implements CPanel {

    private String cityName, hotName, phn;
    // private int x, y;
    private int[] r = new int[5];
    private double p;
    private Color color = randomColor();
    private JPanel container = new JPanel();
    private JPanel starPanel = new JPanel();
    private JLabel lBook = new JLabel();
    private JLabel lHotel = new JLabel();
    private JLabel lCity = new JLabel();
    private JLabel price = new JLabel();
    private JLabel phone = new JLabel();
    private JLabel star = new JLabel();
    private JLabel s5 = new JLabel();
    private JLabel s4 = new JLabel();
    private JLabel s3 = new JLabel();
    private JLabel s2 = new JLabel();
    private JLabel s1 = new JLabel();
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();
    private JPanel p4 = new JPanel();
    private JPanel p5 = new JPanel();
    private int hight = 150;
    private int yShift = 0;
    private int btnh = 0;
    private int track = 0;
    private double avg = 0;
    private ImageIcon icon = new ImageIcon("/Users/washioferdousrubai/Downloads/star.png");

    public HotelInfoPanel(Hotels h){
        cityName = h.cityName;
        hotName = h.hotName;
        phn = h.phone;
        r = h.ratings;
        p = h.price;
    }

    public HotelInfoPanel() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.fillRoundRect(0, 5+yShift, 290, hight, 35, 35);
        g2.fillRoundRect(0, 5, 290, btnh, 35, 35);
        g2.setColor(new Color(255, 255, 255, 100));
        int s = 290;
        g2.fillRoundRect(80, -190+yShift, s, s, s, s);
        s = 400;
        g2.fillRoundRect(-260, -190+yShift, s, s, s, s);
        s = 330;
        g2.fillRoundRect(160, 160+yShift, s, s, s, s);
    }

    @Override
    public JPanel panel(){
        setPreferredSize(new Dimension(290, hight+10));
        setOpaque(false);
        setBorder(null);
        setLayout(null);

        container.setBounds(0, 0, 290, hight+10);
        container.setOpaque(false);
        container.setBorder(null);
        container.setLayout(null);

        lHotel.setFont(new Font(null, Font.BOLD, 20));
        lHotel.setBounds(10, 10, 270, 40);
        lHotel.setText(hotName);

        lCity.setBounds(10, 50, 270, 20);
        lCity.setText(cityName + ", Bangladesh");
        
        int ii = 0;
        for(int i = 0; i<5; i++){
            avg+= + (r[i]*(5-i));
            ii+= r[i];
        }
        avg = avg/ii;

        phone.setText("Phone no :  " + phn);
        phone.setFont(new Font(null, Font.BOLD, 13));
        phone.setBounds(10, 260, 270, 30);

        star.setText("Ratings\t   :  " + String.format("%.2f", avg));
        star.setFont(new Font(null, Font.BOLD, 13));
        star.setBounds(10, 100, 270, 30);

        price.setText("Pricing\t    :  " + p);
        price.setFont(new Font(null, Font.BOLD, 13));
        price.setBounds(10, 120, 270, 30);

        lBook.setText("Book your room here                              ➤");
        lBook.setBounds(10, 5, 290, 35);
        lBook.setFont(new Font(null, Font.PLAIN, 13));

        double d = ii;
        int rate;
        rate = (int) ((r[0]/d)*200.0);
        p1.setBounds(130, 13, rate, 5);
        rate = (int) ((r[1]/d)*200.0);
        p2.setBounds(130, 33, rate, 5);
        rate = (int) ((r[2]/d)*200.0);
        p3.setBounds(130, 53, rate, 5);
        rate = (int) ((r[3]/d)*200.0);
        p4.setBounds(130, 73, rate, 5);
        rate = (int) ((r[4]/d)*200.0);
        p5.setBounds(130, 93, rate, 5);
        p1.setBackground(Color.black);
        p2.setBackground(Color.black);
        p3.setBackground(Color.black);
        p4.setBackground(Color.black);
        p5.setBackground(Color.black);

        s5.setIcon(new CachedCompositeIcon( icon, icon, icon, icon, icon).getIcon());
        s4.setIcon(new CachedCompositeIcon( icon, icon, icon, icon).getIcon());
        s3.setIcon(new CachedCompositeIcon( icon, icon, icon).getIcon());
        s2.setIcon(new CachedCompositeIcon( icon, icon).getIcon());
        s1.setIcon(new CachedCompositeIcon( icon).getIcon());

        starPanel.setBounds(10, 90, 290, 120);
        starPanel.setLayout(null);
        starPanel.setOpaque(false);

        s5.setBounds(10, 0, 110, 30);
        s4.setBounds(32, 20, 110, 30);
        s3.setBounds(54, 40, 110, 30);
        s2.setBounds(76, 60, 110, 30);
        s1.setBounds(98, 80, 110, 30);

        starPanel.add(p1);
        starPanel.add(p2);
        starPanel.add(p3);
        starPanel.add(p4);
        starPanel.add(p5);
        starPanel.add(s5);
        starPanel.add(s4);
        starPanel.add(s3);
        starPanel.add(s2);
        starPanel.add(s1);

        container.add(lHotel);
        container.add(lCity);
        container.add(star);
        container.add(price);
        container.add(phone);

        add(container);
        return this;
    }

    public void resize(){
        if(track%2 == 0){
            hight = 290;
            yShift = 45;
            btnh = 35;
            container.add(starPanel);
            star.setBounds(10, 220, 270, 30);
            price.setBounds(10, 240, 270, 30);
            add(lBook);
        }else{
            hight = 150;
            yShift = 0;
            btnh = 0;
            container.remove(starPanel);
            star.setBounds(10, 100, 270, 30);
            price.setBounds(10, 120, 270, 30);
            remove(lBook);
        }
        track++;
        container.setBounds(0, yShift, 290, hight+10);
        setPreferredSize(new Dimension(290, yShift+hight+10));
        repaint();
    }

    private static Color randomColor() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return new Color(r, g, b, 100);
    }
}
