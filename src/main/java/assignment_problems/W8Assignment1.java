public class W8Assignment1 {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(5, 4);
        r.printArea();
    }
}

class Rectangle {
    int length;
    int breadth;

    Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    void printArea() {
        System.out.println("Area: " + (length * breadth));
    }
}
