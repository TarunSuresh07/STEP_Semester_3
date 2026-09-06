public class W1Problem4 {
    public static char findFirstNonRepeatingChar(String text) {
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            int frequency = 0;

            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == current)
                    frequency++;
            }

            if (frequency == 1)
                return current;
        }

        return '\0';
    }

    public static void main(String[] args) {
        printResult("swiss");
        printResult("aabbcc");
    }

    private static void printResult(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result == '\0')
            System.out.println("No Non-Repeating Character Found");
        else
            System.out.println("First Non-Repeating Character: '" + result + "'");
    }
}
