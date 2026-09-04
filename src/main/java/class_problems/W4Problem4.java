public final class W4Problem4 {
    private final double minimumSurgePercent;

    public W4Problem4(double minimumSurgePercent) {
        this.minimumSurgePercent = minimumSurgePercent;
    }

    public final double calculateSurgeFee(double orderValue, int delayMinutes) {
        if (orderValue < 0 || delayMinutes < 0) {
            throw new IllegalArgumentException("Values cannot be negative");
        }
        if (delayMinutes == 0) {
            return 0.0;
        }
        int firstMinutes = Math.min(delayMinutes, 5);
        int secondMinutes = Math.min(Math.max(delayMinutes - 5, 0), 10);
        int thirdMinutes = Math.max(delayMinutes - 15, 0);
        double tieredFee = orderValue * (firstMinutes * 0.005 + secondMinutes * 0.01 + thirdMinutes * 0.02);
        double minimumFee = orderValue * minimumSurgePercent / 100;
        return Math.max(tieredFee, minimumFee);
    }

    public static void main(String[] args) {
        W4Problem4 calculator = new W4Problem4(1);

        System.out.println("Rs " + calculator.calculateSurgeFee(500, 0));
        System.out.println("Rs " + calculator.calculateSurgeFee(500, 1));
        System.out.println("Rs " + calculator.calculateSurgeFee(500, 16));
    }
}