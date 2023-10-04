package Common;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class fileReader {
    private HashMap<String, LinkedList<Hotels>> hotMap = new HashMap<>();

    public HashMap<String, LinkedList<Hotels>> hotelHashMap(){
        hotMap.clear();
        String cn, hn;
        int x, y;
        int[] s = new int[5];
        double p;
        try{
            File file = new File("Files/hotels.txt");
            Scanner sc = new Scanner(file);
            sc.nextLine();
            while(sc.hasNextLine()){
                cn = sc.next().replace("_", " ");
                hn = sc.next().replace("_", " ");
                x = sc.nextInt();
                y = sc.nextInt();
                s[0] = sc.nextInt();
                s[1] = sc.nextInt();
                s[2] = sc.nextInt();
                s[3] = sc.nextInt();
                s[4] = sc.nextInt();
                p = sc.nextDouble();
                Hotels h = new Hotels(cn, hn, x, y, s, p);
                if(!hotMap.containsKey(cn)){
                    LinkedList<Hotels> ll = new LinkedList<Hotels>();
                    ll.add(h);
                    hotMap.put(cn, ll);
                }else{
                    LinkedList<Hotels> llm = new LinkedList<>();
                    llm = hotMap.get(cn);
                    llm.add(h);
                    hotMap.replace(cn, llm);
                }
            }
            sc.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "File ends with an empty line");
        }
        return hotMap;
    }
}
