public class W8Assignment3 {
    public static void main(String[] args) {
        Student s = new Student("Riya", 22);
        s.display();
    }
}

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
