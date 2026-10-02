public class W8Assignment1 {
    public static void main(String[] args) {
        Number n = new Number(18);
        n.show();
    }
}

class Number {
    int value;

    Number(int value) {
        this.value = value;
    }

    void show() {
        System.out.println("Value: " + value);
    }
}
