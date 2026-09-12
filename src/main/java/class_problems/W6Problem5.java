public class W6Problem5 {
    public static void main(String[] args) {
        Shape s;

        s = new Circle(5);
        System.out.println("Circle area: " + s.area());

        s = new Rectangle(4, 6);
        System.out.println("Rectangle area: " + s.area());
    }
}

abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    double r;

    Circle(double r) {
        this.r = r;
    }

    double area() {
        return 3.14 * r * r;
    }
}

class Rectangle extends Shape {
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }
}
