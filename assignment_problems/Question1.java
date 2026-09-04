public class Question1 {
    public static void main(String[] args) {

        int[] seat = {101, 102, 103, 102, 105};
        boolean found = false;

        for (int i = 0; i < seat.length; i++) {
            for (int j = i + 1; j < seat.length; j++) {
                if (seat[i] == seat[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seat[i]);
                    found = true;
                }
            }
        }

        if (!found)
            System.out.println("No Duplicate Seats Found");
    }
}
