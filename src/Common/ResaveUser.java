package Common;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class ResaveUser {
    
    public ResaveUser(HashMap<String,UserInfo> uInfo){
        File file = new File("Files/userInfo.txt");
        file.delete();
        try{
            FileWriter fw = new FileWriter(file);
            for(UserInfo u: uInfo.values()){
                fw.write("\n" +
                        u.name.replace(" ", "_") + "\t" +
                        u.mail.replace(" ", "_") + "\t" +
                        u.phone.replace(" ", "_") + "\t" +
                        u.nid.replace(" ", "_") + "\t" +
                        u.pass.replace(" ", "_") + "\t" +
                        u.status.replace(" ", "_") + "\t" +
                        u.imgIndex
                        );	
            }
            fw.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "ADDING ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
