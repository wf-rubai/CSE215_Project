package Common;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileReader {
    
    private HashMap<String, LinkedList<Hotels>> hotMap = new HashMap<>();
    private HashMap<String, LinkedList<String[]>> travelInfo = new HashMap<>();
    private HashMap<String, DevInfo> devMap = new HashMap<>();
    private HashMap<String,UserInfo> userMap = new HashMap<>();
    private LinkedList<Object> objects = new LinkedList<>();

    public HashMap<String, LinkedList<Hotels>> hotelHashMap(){
        hotMap.clear();
        String cn, hn, phn;
        int x, y;
        int[] s = new int[5];
        double p;
        try{
            File file = new File("Files/hotels.txt");
            Scanner sc = new Scanner(file);
            sc.nextLine();
            while(sc.hasNextLine()){
                cn   = sc.next().replace("_", " ");
                hn   = sc.next().replace("_", " ");
                x    = sc.nextInt();
                y    = sc.nextInt();
                s[0] = sc.nextInt();
                s[1] = sc.nextInt();
                s[2] = sc.nextInt();
                s[3] = sc.nextInt();
                s[4] = sc.nextInt();
                p    = sc.nextDouble();
                phn  = sc.next().replace("_", " ");
                Hotels h = new Hotels(cn, hn, phn, x, y, s[0], s[1], s[2], s[3], s[4], p);
                if(!hotMap.containsKey(cn)){
                    LinkedList<Hotels> ll = new LinkedList<>();
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
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "File ends with an empty line");
        }
        return hotMap;
    }

    public HashMap<String, LinkedList<String[]>> travelHashMap(){
        String key;
        String[] arr;
        try{
            File file = new File("Files/travelInfo.txt");
            Scanner sc = new Scanner(file);
            sc.nextLine();
            while(sc.hasNextLine()){
                arr = sc.nextLine().split("\\s");
                for(int i=0; i<arr.length; i++){
                    arr[i] = arr[i].replace("_", " ");
                }
                key = arr[0].substring(7);
                if(!travelInfo.containsKey(key)){
                    LinkedList<String[]> ll = new LinkedList<>();
                    ll.add(arr);
                    travelInfo.put(key, ll);
                }else{
                    LinkedList<String[]> llm = new LinkedList<>();
                    llm = travelInfo.get(key);
                    llm.add(arr);
                    travelInfo.replace(key, llm);
                }
            }
            sc.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "File ends with an empty line");
        }

        return travelInfo;
    }

    public HashMap<String, DevInfo> devoloperHashMap(){
        String name, pass, id, mail, phone, nid, position;
        int imgIndex = 0;
        try{
            File file = new File("Files/devInfo.txt");
            Scanner sc = new Scanner(file);
            sc.nextLine();
            while(sc.hasNextLine()){
                name     = sc.next().replace("_", " ");
                pass     = sc.next().replace("_", " ");
                id       = sc.next().replace("_", " ");
                mail     = sc.next().replace("_", " ");
                phone    = sc.next().replace("_", " ");
                nid      = sc.next().replace("_", " ");
                position = sc.next().replace("_", " ");
                imgIndex = sc.nextInt();
                DevInfo d = new DevInfo(name, pass, id, mail, phone, nid, position, imgIndex);
                devMap.put(pass, d);
            }
            sc.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }catch(Exception e){
        }
        return devMap;
    }

    public HashMap<String,UserInfo> userHashMap(){
        userMap.clear();
        String n , m, p ,nid, pass, state;
        int i;
        try {
            File file = new File("Files/userInfo.txt");
            Scanner sc = new Scanner(file);
            sc.nextLine();
            while (sc.hasNextLine()){
                n      = sc.next().replace("_", " ");
                m      = sc.next().replace("_", " ");
                p      = sc.next().replace("_", " ");
                nid    = sc.next().replace("_", " ");
                pass   = sc.next().replace("_", " ");
                state  = sc.next().replace("_", " ");
                i      = sc.nextInt();
                UserInfo u = new UserInfo(n, m, p, nid, pass, state, i);
                userMap.put(pass,u);
            }
            sc.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "File reading error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "File reading error", JOptionPane.ERROR_MESSAGE);
        }

        return userMap ;
    }

    public LinkedList<Object> objectList(){
        String n , m, p ,nid, pass, state;
        int i;
        String b;
        try{
            File file = new File("Files/object.txt");
            Scanner sc = new Scanner(file);
            sc.nextLine();

            b = sc.next();
            if(b.equals("true")){
                objects.add(true);
            }else{
                objects.add(false);
            }
            if(b.equals("true")){
                n      = sc.next().replace("_", " ");
                m      = sc.next().replace("_", " ");
                p      = sc.next().replace("_", " ");
                nid    = sc.next().replace("_", " ");
                pass   = sc.next().replace("_", " ");
                state  = sc.next().replace("_", " ");
                i      = sc.nextInt();
                UserInfo u = new UserInfo(n, m, p, nid, pass, state, i);
                objects.add(u);
            }else{
                objects.add(new UserInfo("", "", "", "", "", "", 14));
                sc.next();
            }
            objects.add(sc.nextInt());

            sc.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "File reading error", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
        }
        return objects;
    }
}
