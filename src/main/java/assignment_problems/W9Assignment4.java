public class W9Assignment4 {
    public static void main(String[] args) {
        Counter c = new Counter();
        System.out.println("Count: " + c.getCount());
    }
}

class Counter {
    int count = 0;

    int getCount() {
        return count;
    }
}
