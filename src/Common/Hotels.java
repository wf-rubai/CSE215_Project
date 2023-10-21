package Common;

public class Hotels {
    public String cityName, hotName, phone;
    public int x, y;
    public int[] ratings = new int[5];
    public double price;

    public Hotels(String cityName, String hotName, String phone, int x, int y, int s1, int s2, int s3, int s4, int s5, double price) {
        this.cityName = cityName;
        this.hotName = hotName;
        this.phone = phone;
        this.x = x;
        this.y = y;
        this.ratings[0] = s1;
        this.ratings[1] = s2;
        this.ratings[2] = s3;
        this.ratings[3] = s4;
        this.ratings[4] = s5;
        this.price = price;
    }

    public Hotels() {
    }
}
