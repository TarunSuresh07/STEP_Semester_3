public class W8Assignment3 {
    public static void main(String[] args) {
        Employee e = new Employee(102, "Priya");
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
