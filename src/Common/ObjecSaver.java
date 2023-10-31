package Common;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class ObjecSaver {
    
    public ObjecSaver(LinkedList<Object> o){
        try{
            File file = new File("Files/object.txt");
            file.delete();
            FileWriter fw = new FileWriter(file, true);
            fw.write("\n" + o.get(0) + "\n");
            if((boolean)o.get(0)){
                UserInfo u = (UserInfo) o.get(1);
                fw.write(u.name.replace(" ", "_") + "\t" +
                        u.mail.replace(" ", "_") + "\t" +
                        u.phone.replace(" ", "_") + "\t" +
                        u.nid.replace(" ", "_") + "\t" +
                        u.pass.replace(" ", "_") + "\t" +
                        u.status.replace(" ", "_") + "\t" +
                        u.imgIndex);
            }else{
                fw.write("null");
            }
            fw.write("\n" + o.get(2));

            fw.close();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "File reading error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        LinkedList<Object> o = new LinkedList<>();
        o.add(false);
        o.add(null);
        new ObjecSaver(o);
    }
}
