public class W8Assignment4 {
    public static void main(String[] args) {
        Mobile m = new Mobile("Samsung", "A52", 25000);
        m.details();
    }
}

class Mobile {
    String brand;
    String model;
    int price;

    Mobile(String brand, String model, int price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    void details() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }
}
