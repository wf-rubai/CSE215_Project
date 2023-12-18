package Common;

public class DevInfo extends Info {
    public String pass, id, position;
    public int imgIndex = 0;

    public DevInfo(String name, String pass, String id, String mail, String phone, String nid, String position, int imgIndex) {
        super(name, mail, phone, nid);
        this.pass = pass;
        this.id = id;
        this.position = position;
        this.imgIndex = imgIndex;
    }

    public DevInfo() {
    }
}
