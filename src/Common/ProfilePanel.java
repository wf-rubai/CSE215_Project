package Common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ProfilePanel extends JPanel implements CPanel {

    private ImageIcon[] image;
    private int index;
    private JPanel profilePanel = new JPanel();
    private JButton bName;

    public ProfilePanel(String name, int i){
        image = new ArrayList().profile;
        this.index = i;
        bName = new JButton(name);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon imageIcon = image[index];
        Image image = imageIcon.getImage();
        g.drawImage(image, 100, 0, 100, 100, this);
    }

    @Override
    public JPanel panel() {
        profilePanel.setBounds(0, 100, 300, 150);
        profilePanel.setOpaque(false);
        profilePanel.setLayout(null);
        // profilePanel.setBackground(Color.pink);

        bName.setBounds(0, 100, 300, 50);
        bName.setForeground(Color.black);
        bName.setFont(new Font(null, Font.BOLD, 20));
        bName.setOpaque(false);
        bName.setContentAreaFilled(false);
        bName.setBorderPainted(false);
        bName.setFocusable(false);

        setBounds( 0, 0, 300, 100);
        setOpaque(false);
        // setBackground(Color.orange);

        profilePanel.add(this);
        profilePanel.add(bName);
        return profilePanel;
    }
}
