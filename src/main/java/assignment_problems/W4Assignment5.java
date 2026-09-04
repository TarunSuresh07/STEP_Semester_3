public class W4Assignment5 {
    public static class DeliveryAccount {
        protected String studentId;
        protected double orderValue;
        protected static double minimumSurgePercent;

        static {
            minimumSurgePercent = 1.0;
        }

        public DeliveryAccount(String studentId, double orderValue) {
            this.studentId = studentId;
            this.orderValue = orderValue;
        }

        public DeliveryAccount(String studentId) {
            this(studentId, 0);
        }

        public final double calculateSurgeFee(int delayMinutes) {
            if (delayMinutes < 0) {
                throw new IllegalArgumentException("Delay cannot be negative");
            }
            if (delayMinutes == 0) {
                return 0.0;
            }
            int firstMinutes = Math.min(delayMinutes, 5);
            int secondMinutes = Math.min(Math.max(delayMinutes - 5, 0), 10);
            int thirdMinutes = Math.max(delayMinutes - 15, 0);
            double fee = orderValue * (firstMinutes * 0.005 + secondMinutes * 0.01 + thirdMinutes * 0.02);
            return Math.max(fee, orderValue * minimumSurgePercent / 100);
        }

        public void processAccount(DeliveryAccount account, double amount, int delayMinutes) {
            if (account == null || amount < 0) {
                return;
            }
            double settledAmount = amount;
            if (account instanceof PremiumAccount) {
                settledAmount = amount * 0.9;
            }
            System.out.println(account.studentId + " settled: Rs " + settledAmount + " | Surge fee: Rs " + account.calculateSurgeFee(delayMinutes));
        }

        public static void processBatch(DeliveryAccount[] accounts, double[] amounts, int[] delayMinutesArray) {
            int length = Math.min(accounts == null ? 0 : accounts.length, Math.min(amounts == null ? 0 : amounts.length, delayMinutesArray == null ? 0 : delayMinutesArray.length));
            int processed = 0;
            int nullSkipped = 0;
            int premium = 0;
            int regular = 0;
            double totalFees = 0;
            for (int i = 0; i < length; i++) {
                DeliveryAccount account = accounts[i];
                if (account == null) {
                    nullSkipped++;
                    continue;
                }
                if (account instanceof PremiumAccount) {
                    premium++;
                } else {
                    regular++;
                }
                account.processAccount(account, amounts[i], delayMinutesArray[i]);
                totalFees += account.calculateSurgeFee(delayMinutesArray[i]);
                processed++;
            }
            System.out.println(processed + " processed | " + nullSkipped + " null skipped | " + premium + " premium | " + regular + " regular | grand total surge fees = " + totalFees);
        }
    }

    public static class PremiumAccount extends DeliveryAccount {
        public PremiumAccount(String studentId, double orderValue) {
            super(studentId, orderValue);
        }

        public PremiumAccount(String studentId) {
            this(studentId, 0);
        }
    }

    public static void main(String[] args) {
        DeliveryAccount[] accounts = {
            new PremiumAccount("STU001", 500),
            null,
            new DeliveryAccount("STU002", 300)
        };
        double[] amounts = {500, 400, 300};
        int[] delayMinutesArray = {10, 5, 0};

        DeliveryAccount.processBatch(accounts, amounts, delayMinutesArray);
    }
}