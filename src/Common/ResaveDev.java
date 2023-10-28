package Common;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class ResaveDev {
    public ResaveDev(HashMap<String, DevInfo> uInfo){

        File file = new File("Files/devInfo.txt");
        file.delete();
        for(DevInfo d: uInfo.values()){
            try{
                FileWriter fw = new FileWriter(file, true);
                fw.write("\n" + 
                        d.name.replace(" ", "_") + "\t" +
                        d.pass.replace(" ", "_") + "\t" +
                        d.id.replace(" ", "_") + "\t" +
                        d.mail.replace(" ", "_") + "\t" +
                        d.phone.replace(" ", "_") + "\t" +
                        d.nid.replace(" ", "_") + "\t" +
                        d.position.replace(" ", "_") + "\t" +
                        d.imgIndex + "\t"
                        );
                fw.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Something Went Wrong Adding Hotel Information", "ADDING ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
