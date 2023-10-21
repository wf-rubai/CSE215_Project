package Common;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class displayImg extends JPanel implements CPanel {

    private ImageIcon[] images;
    private int currentImageIndex;
    
    public void Img(int i) {
        currentImageIndex = i;
        repaint();
    }

    public displayImg() {
        images = new ImageIcon[]{
                new ImageIcon("Images/GeoImage/Bogura 2.jpeg"),
                new ImageIcon("Images/GeoImage/Bogura.jpeg")
        };

        currentImageIndex = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon imageIcon = images[currentImageIndex];
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, 330, 850, this);
    }

    @Override
    public JPanel panel(){
        setBounds(70, 0, 330, 850);
        return this;
    }    
}
