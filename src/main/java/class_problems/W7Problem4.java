public class W7Problem4 {
    public static void main(String[] args) {
        Car c = new Car("Swift", 2019, 500000);
        c.display();
    }
}

class Car {
    String model;
    int year;
    double price;

    Car(String model, int year, double price) {
        this.model = model;
        this.year = year;
        this.price = price;
    }

    void display() {
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Price: " + price);
    }
}
