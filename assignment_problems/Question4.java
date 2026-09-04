public class Question4 {
    public static void main(String[] args) {

        int[] A = {20, 15, 30};
        int[] B = {25, 10, 30};

        int sumA = 0, sumB = 0;
        int max = A[0];
        String section = "Section A";
        int item = 1;

        for (int i = 0; i < A.length; i++) {
            sumA += A[i];

            if (A[i] > max) {
                max = A[i];
                section = "Section A";
                item = i + 1;
            }
        }

        for (int i = 0; i < B.length; i++) {
            sumB += B[i];

            if (B[i] > max) {
                max = B[i];
                section = "Section B";
                item = i + 1;
            }
        }

        System.out.println("Section A Total: " + sumA);
        System.out.println("Section B Total: " + sumB);

        if (sumA == sumB)
            System.out.println("Status: Balanced");
        else
            System.out.println("Status: Not Balanced");

        System.out.println("Highest Quantity: " + max + " (" + section + ", Item " + item + ")");
    }
}
