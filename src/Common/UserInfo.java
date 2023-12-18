package Common;

public class UserInfo extends Info {
    
    public String pass, status = "Active";
    public int imgIndex = 11;

    public UserInfo(String name, String mail, String phone, String nid, String pass, String status, int imgIndex) {
        super(name, mail, phone, nid);
        this.pass = pass;
        this.status = status;
        this.imgIndex = imgIndex;
    }
    
    public UserInfo() {
    }
}
