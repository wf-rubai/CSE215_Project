package UserMain;

import javax.swing.JFrame;

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
        frame.setVisible(false);
        frame = new UserUIGenerator("User Window");
        frame.setVisible(true);
    }
}
