package DevMain;

import javax.swing.JFrame;

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
}
