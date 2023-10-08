package test;

import javax.swing.*;
import java.awt.*;

public class E {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("ScrollPane with Colored Panels Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLayout(null);

            // Create a JPanel to hold the colored panels vertically
            JPanel contentPanel = new JPanel();
            contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

            // Create and add 10 colored subpanels
            for (int i = 1; i <= 1000; i++) {
                JPanel coloredPanel = new JPanel();
                coloredPanel.setPreferredSize(new Dimension(180, 10));
                coloredPanel.setBackground(getRandomColor());
                contentPanel.add(coloredPanel);
            }

            // Create a JScrollPane and set the content panel as its viewport
            JScrollPane scrollPane = new JScrollPane(contentPanel);
            scrollPane.setBounds(100, 0, 200, 200);

            frame.add(scrollPane);
            frame.setVisible(true);
        });
    }

    // Utility method to generate a random color
    private static Color getRandomColor() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return new Color(r, g, b);
    }
}
