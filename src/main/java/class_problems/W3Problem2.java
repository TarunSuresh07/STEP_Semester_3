public class W3Problem2 {

    public static void main(String[] args) {
        FeeAccount accountA = new FeeAccount("RA001", 200000, 0);
        accountA.payInTwoInstallments(120000);

        FeeAccount accountB = new FeeAccount("RA002", 180000, 0);
        double accountBDue = accountB.effectiveDue(20);

        System.out.println("Account A due: Rs " + accountA.getDue());
        System.out.println("Account B effective due (20% scholarship): Rs " + accountBDue);
    }

    static class FeeAccount {
        private String regNo;
        private double totalFee;
        private double amountPaid;

        public FeeAccount(String regNo, double totalFee, double amountPaid) {
            this.regNo = regNo;
            this.totalFee = totalFee;
            this.amountPaid = amountPaid;
        }

        public void pay(double amount) {
            if (amount <= 0) {
                System.out.println("Invalid payment: amount must be positive.");
                return;
            }
            amountPaid += amount;
        }

        public double getDue() {
            return totalFee - amountPaid;
        }

        public void payInTwoInstallments(double amount) {
            pay(amount / 2);
            pay(amount / 2);
        }

        public double effectiveDue(double scholarshipPercent) {
            double due = getDue();
            return due - (due * scholarshipPercent / 100);
        }
    }
}
