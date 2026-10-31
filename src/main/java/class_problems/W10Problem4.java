public class W10Problem4 {
    public static void main(String[] args) {
        ArrayDemo a = new ArrayDemo();
        a.print();
    }
}

class ArrayDemo {
    int[] arr = {10, 20, 30, 40};

    void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
