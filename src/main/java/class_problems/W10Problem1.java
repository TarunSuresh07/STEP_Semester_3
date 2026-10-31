public class W10Problem1 {
    public static void main(String[] args) {
        NumberDemo n = new NumberDemo(25);
        n.show();
    }
}

class NumberDemo {
    int value;

    NumberDemo(int value) {
        this.value = value;
    }

    void show() {
        System.out.println("Value: " + value);
    }
}
