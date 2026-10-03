public class W9Problem3 {
    public static void main(String[] args) {
        Product p = new Product(101, "Laptop");
        p.show();
    }
}

class Product {
    int id;
    String name;

    Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void show() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}
