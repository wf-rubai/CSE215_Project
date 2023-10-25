package TestFolder;

import javax.swing.*;
import java.awt.*;
// import java.awt.geom.AffineTransform;

public class F {

    public static int a=0;

    public  static int s(){
        a++;
        return a;
    }

    public int getA() {
        return F.a;
    }

    public void setA(int a) {
        // this.a = a;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Scaled Down JFrame Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600); // Set the original size
            frame.setLayout(new FlowLayout());

            // Add some components (buttons in this example)
            JButton button1 = new JButton("Button 1");
            JButton button2 = new JButton("Button 2");
            frame.add(button1);
            frame.add(button2);

            // Apply scaling to the frame's content pane
            // double scale = .5; // Scaling factor (50% of the original size)
            Container contentPane = frame.getContentPane();
            // AffineTransform scaleTransform = AffineTransform.getScaleInstance(scale, scale);
            contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            contentPane.setIgnoreRepaint(true);
            contentPane.setLocale(null);
            ((JComponent) contentPane).setTransferHandler(null);
            ((JComponent) contentPane).setDoubleBuffered(false);
            contentPane.setBounds(contentPane.getBounds());
            contentPane.setComponentOrientation(contentPane.getComponentOrientation());

            // Pack the frame to fit the scaled components
            frame.pack();

            frame.setVisible(true);
        });
    }
}
