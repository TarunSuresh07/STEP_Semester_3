public class W9Assignment2 {
    public static void main(String[] args) {
        Bank b = new Bank();
        System.out.println("Account type: " + b.type);
    }
}

class Bank {
    String type = "Current";
}
