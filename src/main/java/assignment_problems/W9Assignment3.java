public class W9Assignment3 {
    public static void main(String[] args) {
        Product p = new Product(102, "Mobile");
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
