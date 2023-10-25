package Common;

public class DevInfo {
    public String name, pass, id, mail, phone, nid, position;
    public int imgIndex = 0;

    public DevInfo(String name, String pass, String id, String mail, String phone, String nid, String position, int imgIndex) {
        this.name = name;
        this.pass = pass;
        this.id = id;
        this.mail = mail;
        this.phone = phone;
        this.nid = nid;
        this.position = position;
        this.imgIndex = imgIndex;
    }

    public DevInfo() {
    }
}
