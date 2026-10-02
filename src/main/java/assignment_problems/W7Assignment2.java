public class W7Assignment2 {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println("Sum: " + c.add(15, 7));
        System.out.println("Difference: " + c.sub(15, 7));
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
