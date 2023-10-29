package TestFolder;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class f1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Transparent JScrollPane Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.getContentPane().setBackground(Color.red);

            // Create a JPanel with a transparent background
            JPanel panel = new JPanel();
            // panel.setOpaque(false); // Make the panel transparent
            panel.setBackground(new Color(0, 0, 0, 0));
            panel.setLayout(new BorderLayout());

            // Add some content to the panel
            JLabel label = new JLabel("This is a transparent JScrollPane:");
            panel.add(label, BorderLayout.NORTH);

            // Create a JScrollPane and set its background color to transparent
            JScrollPane scrollPane = new JScrollPane(panel);
            scrollPane.setOpaque(false); // Make the scroll pane transparent

            // Add the JScrollPane to the frame
            frame.add(scrollPane);

            frame.setVisible(true);
        });
    }
}
