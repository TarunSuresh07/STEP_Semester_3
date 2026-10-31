public class W10Problem3 {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(4, 6);
        System.out.println("Area: " + r.area());
    }
}

class Rectangle {
    int length;
    int breadth;

    Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    int area() {
        return length * breadth;
    }
}
