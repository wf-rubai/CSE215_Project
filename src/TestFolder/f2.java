package TestFolder;

import javax.swing.JFrame;

import UserMain.UserUIGenerator;

public class f2 {

    public static JFrame f = new UserUIGenerator("akkas");

    public void out(){
        f.setVisible(true);
    }


    public f2(){
    }

    public f2(JFrame f){
        f2.f = f;
    }
}
