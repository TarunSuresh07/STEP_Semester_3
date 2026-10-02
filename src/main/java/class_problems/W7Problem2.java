public class W7Problem2 {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println("Sum: " + c.add(10, 5));
        System.out.println("Difference: " + c.sub(10, 5));
    }
}

class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    int sub(int a, int b) {
        return a - b;
    }
}
