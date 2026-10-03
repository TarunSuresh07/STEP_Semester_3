public class W9Assignment1 {
    public static void main(String[] args) {
        Student s = new Student(12, "Riya");
        s.display();
    }
}

class Student {
    int rollNo;
    String name;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
    }
}
