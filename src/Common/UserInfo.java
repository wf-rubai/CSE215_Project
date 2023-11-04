package Common;

public class UserInfo extends Info {
    
    // public String name ,mail , phone , nid;
    public String pass, status = "Active";
    public int imgIndex = 11;

    public UserInfo(String name, String mail, String phone, String nid, String pass, String status, int imgIndex) {
        super(name, mail, phone, nid);
        // this.name = name;
        // this.mail = mail;
        // this.phone = phone;
        // this.nid = nid;
        this.pass = pass;
        this.status = status;
        this.imgIndex = imgIndex;
    }
    
    public UserInfo() {
    }
}
