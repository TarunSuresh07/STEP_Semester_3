public class W7Problem3 {
    public static void main(String[] args) {
        Student s = new Student("Karan", 21);
        s.show();
    }
}

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void show() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
