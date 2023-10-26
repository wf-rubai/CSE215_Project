package TestFolder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A extends JPanel {
    private ImageIcon[] images;
    private int currentImageIndex;

    public A() {
        // Load your images (adjust the file paths)
        images = new ImageIcon[]{
                new ImageIcon("Images/GeoImage/Bogura 2.jpeg"),
                new ImageIcon("Images/GeoImage/Bogura.jpeg")
        };

        currentImageIndex = 0;
    }

    public void switchToNextImage() {
        currentImageIndex = (currentImageIndex + 1) % images.length;
        repaint(); // Redraw the panel with the new image
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the current image
        if (currentImageIndex >= 0 && currentImageIndex < images.length) {
            ImageIcon currentImage = images[currentImageIndex];
            Image image = currentImage.getImage();
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            // currentImage.paintIcon(this, g, 0, 0);/
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Image Switching Example");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 300);
                ImageIcon ii = new ImageIcon("Images/HotelImage/Presentation1.000.png");
                frame.setIconImage(ii.getImage());

                A panel = new A();
                frame.add(panel);

                JButton nextImageButton = new JButton("Next Image");
                nextImageButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panel.switchToNextImage();
                    }
                });
                frame.add(nextImageButton, BorderLayout.SOUTH);

                frame.setVisible(true);
            }
        });

        // SwingUtilities.invokeLater(new Runnable() {
        //     @Override
        //     public void run() {
                
        //     }
        // });
    }
}
