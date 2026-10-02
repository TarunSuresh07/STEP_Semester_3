public class W6Problem1 {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Aarav", 88.5);
        s1.printStudent();

        BankAccount acc = new BankAccount("Rohan", 1200);
        acc.deposit(500);
        acc.withdraw(300);
        acc.showBalance();
    }
}

class Student {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    void printStudent() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
    }
}

class BankAccount {
    String name;
    double balance;

    BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance = balance + amount;
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
        } else {
            System.out.println("Not enough balance");
        }
    }

    void showBalance() {
        System.out.println("Account holder: " + name);
        System.out.println("Balance: " + balance);
    }
}
