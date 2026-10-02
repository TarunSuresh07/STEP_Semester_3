public class W7Assignment5 {
    public static void main(String[] args) {
        Circle c = new Circle(9);
        System.out.println("Area: " + c.area());
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
}
