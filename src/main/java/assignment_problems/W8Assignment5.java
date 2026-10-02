public class W8Assignment5 {
    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println("Factorial: " + f.find(6));
    }
}

class Factorial {
    int find(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
