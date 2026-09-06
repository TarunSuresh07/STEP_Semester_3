public class W1Problem2 {
    public static boolean isPalindromeIterative(String text) {
        for (int left = 0, right = text.length() - 1; left < right; left++, right--) {
            if (text.charAt(left) != text.charAt(right))
                return false;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        return isPalindromeRecursive(text, 0, text.length() - 1);
    }

    private static boolean isPalindromeRecursive(String text, int left, int right) {
        if (left >= right)
            return true;
        if (text.charAt(left) != text.charAt(right))
            return false;
        return isPalindromeRecursive(text, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] characters = text.toCharArray();
        char[] reversed = new char[characters.length];

        for (int i = 0; i < characters.length; i++)
            reversed[i] = characters[characters.length - 1 - i];

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != reversed[i])
                return false;
        }
        return true;
    }

    private static String result(boolean palindrome) {
        return palindrome ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        printResults("madam");
        printResults("hello");
    }

    private static void printResults(String text) {
        System.out.println("Iterative: " + result(isPalindromeIterative(text))
                + " | Recursive: " + result(isPalindromeRecursive(text))
                + " | Array Reversal: " + result(isPalindromeArrayReversal(text)));
    }
}
