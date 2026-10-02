public class W8Assignment4 {
    public static void main(String[] args) {
        ArrayDemo a = new ArrayDemo();
        a.printArray();
    }
}

class ArrayDemo {
    int[] arr = {2, 4, 6, 8, 10};

    void printArray() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
