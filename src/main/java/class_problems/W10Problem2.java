public class W10Problem2 {
    public static void main(String[] args) {
        Employee e = new Employee(201, "Rohit");
        e.display();
    }
}

class Employee {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}
