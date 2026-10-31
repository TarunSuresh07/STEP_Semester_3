public class W10Problem5 {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println("Sum: " + c.add(8, 4));
    }
}

class Calculator {
    int add(int a, int b) {
        return a + b;
    }
}
