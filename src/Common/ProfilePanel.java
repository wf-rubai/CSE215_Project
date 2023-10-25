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
    private String name;
    private int index;
    private JPanel profilePanel = new JPanel();
    private JButton bName;

    public ProfilePanel(String name, int i){
        image = new ArrayList().profile;
        this.name = name;
        this.index = i;
        bName = new JButton(name);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon imageIcon = image[index];
        Image image = imageIcon.getImage();
        g.drawImage(image, 75, 0, 150, 150, this);
    }

    @Override
    public JPanel panel() {
        profilePanel.setBounds(0, 70, 300, 200);
        profilePanel.setOpaque(false);
        profilePanel.setLayout(null);
        // profilePanel.setBackground(Color.pink);

        bName.setBounds(0, 150, 300, 50);
        bName.setForeground(Color.black);
        bName.setFont(new Font(null, Font.BOLD, 20));
        bName.setOpaque(false);
        bName.setContentAreaFilled(false);
        bName.setBorderPainted(false);
        bName.setFocusable(false);

        setBounds( 0, 0, 300, 150);
        setOpaque(false);
        // setBackground(Color.orange);

        profilePanel.add(this);
        profilePanel.add(bName);
        return profilePanel;
    }
}
