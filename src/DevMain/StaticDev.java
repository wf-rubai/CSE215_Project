package DevMain;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class StaticDev {
    private static JFrame frame;

    public static void start(){
        frame = new DevUIGenerator("Devoloper Window");
        frame.setVisible(true);
    }

    public static void exit(){
        frame.setVisible(false);
    }

    public static void reset(){
        frame.setVisible(false);
        frame = new DevUIGenerator("Devoloper Window");
        frame.setVisible(true);
    }

    public static void update(){
        SwingUtilities.updateComponentTreeUI(frame);
    }
}
