public class W2Assignment5 {
    public static void printFilteredWordFrequency(String feedback) {
        String cleanedText = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleanedText.split("\\s+");
        String[] uniqueWords = new String[words.length];
        int[] counts = new int[words.length];
        int uniqueCount = 0;

        for (String word : words) {
            if (isStopWord(word))
                continue;

            int index = -1;
            for (int j = 0; j < uniqueCount; j++) {
                if (uniqueWords[j].equals(word)) {
                    index = j;
                    break;
                }
            }

            if (index == -1) {
                uniqueWords[uniqueCount] = word;
                counts[uniqueCount] = 1;
                uniqueCount++;
            } else {
                counts[index]++;
            }
        }

        for (int i = 0; i < uniqueCount - 1; i++) {
            for (int j = i + 1; j < uniqueCount; j++) {
                if (counts[j] > counts[i]) {
                    int tempCount = counts[i];
                    counts[i] = counts[j];
                    counts[j] = tempCount;

                    String tempWord = uniqueWords[i];
                    uniqueWords[i] = uniqueWords[j];
                    uniqueWords[j] = tempWord;
                }
            }
        }

        for (int i = 0; i < uniqueCount; i++)
            System.out.println(uniqueWords[i] + ": " + counts[i]);
    }

    private static boolean isStopWord(String word) {
        return word.equals("the") || word.equals("was") || word.equals("and")
                || word.equals("a") || word.equals("is") || word.equals("of")
                || word.equals("in");
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
