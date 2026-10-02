public class W8Problem4 {
    public static void main(String[] args) {
        ArrayDemo a = new ArrayDemo();
        a.printArray();
    }
}

class ArrayDemo {
    int[] arr = {1, 2, 3, 4, 5};

    void printArray() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
