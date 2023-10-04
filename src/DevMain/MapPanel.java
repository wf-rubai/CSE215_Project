package DevMain;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Common.arrayList;

public class MapPanel extends JPanel {

    // protected JPanel pPointPanel = new JPanel();
    private ImageIcon[] images;
    private int currentImageIndex;
    protected int n = 1;
    // protected JComboBox<String> cb = new JComboBox<String>();

    public MapPanel(){
        images = new arrayList().geoImages;

        currentImageIndex = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon imageIcon = images[currentImageIndex];
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, 850, 850, this);
    }

    public void change(int i){
        currentImageIndex = i;
        repaint();
    }

    public JPanel panel(){
        
        // pPointPanel.setBounds(400, 0, 850, 850);
        setBounds(330, 0, 850, 850);
        
        // cb = new JComboBox<String>();

        // String[] citys = new arrayList().cityName;
        // for(String s: citys){
        //     cb.addItem(s);
        // }
        // cb.setBounds(30, 50, 270, 50);
        // cb.addItemListener(new ItemListener() {
        //     @Override
        //     public void itemStateChanged(ItemEvent e) {
        //         n--;
        //         currentImageIndex = cb.getSelectedIndex();
        //         repaint();
        //     }
        // });
        // add(cb);

        return this;
    }
}
