public class W7Problem1 {
    public static void main(String[] args) {
        Circle c = new Circle(7);
        c.display();
    }
}

class Circle {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double area() {
        return 3.14 * radius * radius;
    }

    void display() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + area());
    }
}
