public class Question2 {
    public static void main(String[] args) {

        String original = "hello world";
        String typed = "hello worlt";

        int match = 0;
        int first = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i))
                match++;
            else if (first == -1)
                first = i;
        }

        double accuracy = (match * 100.0) / original.length();

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%",
                match, original.length(), accuracy);

        if (first == -1)
            System.out.println(" | No Mismatches");
        else
            System.out.println(" | First Mismatch at position " + (first + 1));
    }
}
