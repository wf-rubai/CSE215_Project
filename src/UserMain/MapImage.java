package UserMain;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Common.CPanel;
import Common.ArrayList;

public class MapImage extends JPanel implements CPanel {
    
    private ImageIcon[] images;
    private int currentImageIndex;

    public MapImage(){
        images = new ArrayList().geoImages;

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

    @Override
    public JPanel panel(){
        
        setBounds(330, 0, 850, 850);
        // setOpaque(false);

        return this;
    }
}
