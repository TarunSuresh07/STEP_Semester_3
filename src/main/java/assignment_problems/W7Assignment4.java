public class W7Assignment4 {
    public static void main(String[] args) {
        Student s = new Student(2, "Aditi");
        s.show();
    }
}

class Student {
    int rollNo;
    String name;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    void show() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
    }
}
