package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class D {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("ScrollPane Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            // Create a JPanel to hold components
            JPanel contentPanel = new JPanel();
            contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

            // Add some components (buttons in this case)
            for (int i = 1; i <= 20; i++) {
                JButton button = new JButton("Button " + i);
                button.setAlignmentX(Component.CENTER_ALIGNMENT);
                contentPanel.add(button);
            }

            // Create a JScrollPane and add the contentPanel to it
            JScrollPane scrollPane = new JScrollPane(contentPanel);

            frame.add(scrollPane);
            frame.setVisible(true);
        });
    }
}
