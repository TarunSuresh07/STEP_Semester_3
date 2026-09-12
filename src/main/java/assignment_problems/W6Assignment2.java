public class W6Assignment2 {
    public static void main(String[] args) {
        Dog d = new Dog("Tommy", 4);
        d.printInfo();
        d.bark();
    }
}

class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }

    void bark() {
        System.out.println(name + " is barking");
    }
}
