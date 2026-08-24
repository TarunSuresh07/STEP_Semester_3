public class Question3 {
    public static void main(String[] args) {

        String signal = "RRGGGYRR";

        char maxChar = signal.charAt(0);
        int max = 1;
        int count = 1;

        for (int i = 1; i < signal.length(); i++) {

            if (signal.charAt(i) == signal.charAt(i - 1))
                count++;
            else
                count = 1;

            if (count > max) {
                max = count;
                maxChar = signal.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + maxChar + "' repeated " + max + " times");
    }
}
