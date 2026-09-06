public class W1Problem5 {
    public static String reverseCustomerName(String customerName) {
        char[] characters = customerName.toCharArray();
        StringBuilder reversedName = new StringBuilder();

        for (int i = characters.length - 1; i >= 0; i--)
            reversedName.append(characters[i]);

        return reversedName.toString();
    }

    public static void main(String[] args) {
        String customerName = "Sunil";
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reverseCustomerName(customerName));
    }
}
