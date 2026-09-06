public class Question5 {
    public static void main(String[] args) {

        String review = "This movie was absolutely fantastic and thrilling";

        String[] words = review.split(" ");

        int shortWord = 0;
        int mediumWord = 0;
        int longWord = 0;

        for (int i = 0; i < words.length; i++) {

            int len = words[i].length();

            if (len <= 4)
                shortWord++;
            else if (len <= 8)
                mediumWord++;
            else
                longWord++;
        }

        System.out.println("Short: " + shortWord);
        System.out.println("Medium: " + mediumWord);
        System.out.println("Long: " + longWord);
    }
}
