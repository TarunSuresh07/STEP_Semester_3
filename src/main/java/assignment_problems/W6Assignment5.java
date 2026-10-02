public class W6Assignment5 {
    public static void main(String[] args) {
        Laptop l = new Laptop("Dell", 16, 75000);
        l.printInfo();
    }
}

class Laptop {
    String brand;
    int ram;
    double price;

    Laptop(String brand, int ram, double price) {
        this.brand = brand;
        this.ram = ram;
        this.price = price;
    }

    void printInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("RAM: " + ram + "GB");
        System.out.println("Price: " + price);
    }
}
