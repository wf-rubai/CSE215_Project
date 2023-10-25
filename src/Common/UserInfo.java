package Common;

public class UserInfo {
    
    public String name ,mail , phone , nid , pass, status = "Active";
    public int imgIndex = 0;
    
    public UserInfo(String name, String mail, String phone, String nid, String pass) {
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.nid = nid;
        this.pass = pass;
    }
    
    public UserInfo() {
    }
}
