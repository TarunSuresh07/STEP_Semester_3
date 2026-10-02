public class W8Assignment2 {
    public static void main(String[] args) {
        Product p = new Product("Mouse", 499);
        p.show();
    }
}

class Product {
    String name;
    int price;

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    void show() {
        System.out.println("Product: " + name);
        System.out.println("Price: " + price);
    }
}
