public class W3Problem5 {

    public static void main(String[] args) {
        SrmStudent ravi = new SrmStudent(
            "Ravi",
            "RA001",
            new FeeAccount("RA001", 200000, 0),
            new HostelRoom("C-214", 2)
        );

        SrmStudent anitha = new SrmStudent(
            "Anitha",
            "RA002",
            new FeeAccount("RA002", 180000, 0),
            new HostelRoom("C-507", 2)
        );

        SrmStudent karthik = new SrmStudent(
            "Karthik",
            "RA003",
            new FeeAccount("RA003", 180000, 0),
            new HostelRoom("C-309", 2)
        );

        ravi.getFeeAccount().payInTwoInstallments(120000);
        karthik.getFeeAccount().setScholarshipPercent(20);

        System.out.println(ravi.fullStatus());
        System.out.println(anitha.fullStatus());
        System.out.println(karthik.fullStatus());
        System.out.println("Total students: " + SrmStudent.totalStudents);
    }

    static class SrmStudent {
        String name;
        String regNo;
        FeeAccount feeAccount;
        HostelRoom room;

        static int totalStudents = 0;

        public SrmStudent(String name, String regNo, FeeAccount feeAccount, HostelRoom room) {
            this.name = name;
            this.regNo = regNo;
            this.feeAccount = feeAccount;
            this.room = room;
            totalStudents++;
        }

        public FeeAccount getFeeAccount() {
            return feeAccount;
        }

        public String fullStatus() {
            return name + " | Due: Rs " + feeAccount.getDue() + " | Room: " + room.roomNo;
        }
    }

    static class FeeAccount {
        private String regNo;
        private double totalFee;
        private double amountPaid;
        private double scholarshipPercent = 0;

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

        public void setScholarshipPercent(double scholarshipPercent) {
            this.scholarshipPercent = scholarshipPercent;
        }

        public double getDue() {
            double due = totalFee - amountPaid;
            return due - (due * scholarshipPercent / 100);
        }

        public void payInTwoInstallments(double amount) {
            pay(amount / 2);
            pay(amount / 2);
        }

        public double effectiveDue(double scholarshipPercent) {
            double due = totalFee - amountPaid;
            return due - (due * scholarshipPercent / 100);
        }
    }

    static class HostelRoom {
        public String roomNo;
        public int beds;
        public int occupied;

        public HostelRoom(String roomNo, int beds) {
            this.roomNo = roomNo;
            this.beds = beds;
            this.occupied = 0;
        }
    }
}
