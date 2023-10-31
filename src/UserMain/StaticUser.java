package UserMain;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class StaticUser {
    private static JFrame frame;

    public static void start(){
        frame = new UserUIGenerator("User Window");
        frame.setVisible(true);
    }

    public static void exit(){
        frame.setVisible(false);
    }

    public static void reset(){
        frame.dispose();;
        frame = new UserUIGenerator("User Window");
        frame.setVisible(true);
    }

    public static void update(){
        SwingUtilities.updateComponentTreeUI(frame);
    }
}
