package Common;

public class Hotels {
    public String cityName, hotName;
    public int x, y;
    public int[] ratings = new int[5];
    public double price;

    public Hotels(String cityName, String hotName, int x, int y, int[] ratings, double price) {
        this.cityName = cityName;
        this.hotName = hotName;
        this.x = x;
        this.y = y;
        this.ratings = ratings;
        this.price = price;
    }

    public Hotels() {
    }
}
