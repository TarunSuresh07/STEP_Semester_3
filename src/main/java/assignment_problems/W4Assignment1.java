public class W4Assignment1 {
    public static class FoodOrder {
        private String studentName;
        private String dishName;
        private boolean delivered;

        public FoodOrder(String studentName, String dishName) {
            if (!validText(studentName) || !validText(dishName)) {
                throw new IllegalArgumentException("Student name and dish name are required");
            }
            this.studentName = studentName.trim();
            this.dishName = dishName.trim();
        }

        private static boolean validText(String value) {
            return value != null && !value.trim().isEmpty();
        }

        public void markDelivered() {
            if (!delivered) {
                delivered = true;
                System.out.println("Order delivered");
            } else {
                System.out.println("Order was already delivered");
            }
        }

        public static void processBatch(String[][] rawOrders) {
            int valid = 0;
            int rejected = 0;
            if (rawOrders != null) {
                for (String[] order : rawOrders) {
                    try {
                        if (order == null || order.length < 2) {
                            throw new IllegalArgumentException();
                        }
                        new FoodOrder(order[0], order[1]);
                        valid++;
                    } catch (IllegalArgumentException exception) {
                        rejected++;
                    }
                }
            }
            System.out.println("Valid: " + valid + " | Rejected: " + rejected);
        }
    }

    public static void main(String[] args) {
        String[][] rawOrders = {
            {"Ravi", "Paneer Butter Masala"},
            {"", "Chole Bhature"},
            {"Meera", " "},
            {"Divya", "Veg Biryani"}
        };
        FoodOrder.processBatch(rawOrders);

        FoodOrder order = new FoodOrder("Ravi", "Paneer Butter Masala");
        order.markDelivered();
        order.markDelivered();
    }
}