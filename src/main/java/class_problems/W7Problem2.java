public class W7Problem2 {
    public static void main(String[] args) {
        Box b = new Box(2, 3, 4);
        b.volume();
    }
}

class Box {
    int length;
    int width;
    int height;

    Box(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    void volume() {
        System.out.println("Volume: " + (length * width * height));
    }
}
