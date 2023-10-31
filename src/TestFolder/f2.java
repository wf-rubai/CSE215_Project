package TestFolder;

// import java.awt.Color;

// import javax.swing.ImageIcon;
// import javax.swing.JButton;
// import javax.swing.JFrame;

// import Common.PointreScrollPanel;
// import Common.ProfileScrollPanel;
// import UserMain.SettingPanel;

// public class f2 {

//     public static JFrame f = new JFrame("asj");
//     private static JButton b = new JButton(new ImageIcon("Images/Avatar/UP3.png"));
//     public static void main(String[] args) {
        
//         f.setSize(1250, 850);
//         f.setLayout(null);
//         f.setLocationRelativeTo(null);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         // f.getContentPane().setBackground(Color.BLACK);

//         b.setBounds( 100, 100, 150, 150);

//         // f.add(b);
//         // f.add(new ProfileScrollPanel().panel());
//         // f.add(new PointreScrollPanel().panel());
//         f.add(new SettingPanel().panel());

//         f.setVisible(true);
//     }
// }
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import Common.AboutProject;

import java.awt.*;

public class f2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create a JFrame
            JFrame frame = new JFrame("Short Article Display");

            // Set the default close operation
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // frame.setUndecorated(true);

            // Create a JTextPane to display the article
            JTextPane textPane = new JTextPane();
            // textPane.setContentType("text/html"); // Set content type to HTML
            textPane.setEditable(true); // Make it non-editable
            textPane.setBackground(Color.gray);

            // Create a SimpleAttributeSet to specify the text attributes
            SimpleAttributeSet attributes = new SimpleAttributeSet();
            StyleConstants.setForeground(attributes, Color.WHITE); // Set font color to white
            // StyleConstants.setBackground(attributes, Color.BLACK); // Set background color to black

            // Add the article content as HTML with specified attributes
            String article = "<html><body>"
                    + "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
                    + "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
                    + "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris.</p>"
                    + "</body></html>";

            textPane.setText(article);

            // Apply the attributes to the entire text
            StyledDocument doc = textPane.getStyledDocument();
            doc.setCharacterAttributes(0, doc.getLength(), attributes, false);

            // Create a JScrollPane to hold the JTextPane
            JScrollPane scrollPane = new JScrollPane(textPane);
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

            // Add the JScrollPane to the JFrame
            
            // Set the size and make the frame visible
            frame.add(scrollPane);
            // frame.setSize(400, 200);
            // frame.setLayout(null);
            // frame.add(new AboutProject().panel());
            frame.setSize(500, 400);
            frame.setVisible(true);
        });
    }
}

