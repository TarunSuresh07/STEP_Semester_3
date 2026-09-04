public class W3Problem4 {
    static class SrmStudent {
        private String name;
        private String regNo;
        private int attendance;

        static String university = "SRM Institute of Science and Technology";
        static int admissionCount = 0;

        public SrmStudent(String name, int attendance) {
            this.name = name;
            this.regNo = "RA2311003010" + (11 + admissionCount);
            this.attendance = attendance;
            admissionCount++;
        }

        public void printIdCard() {
            System.out.println(name + " | " + regNo + " | " + university);
        }

        public static void printTotalAdmissions() {
            System.out.println("Students admitted so far: " + admissionCount);
        }
    }

    public static void main(String[] args) {
        SrmStudent ravi = new SrmStudent("Ravi", 85);
        SrmStudent meera = new SrmStudent("Meera", 90);
        SrmStudent karthik = new SrmStudent("Karthik", 78);

        ravi.printIdCard();
        meera.printIdCard();
        karthik.printIdCard();

        SrmStudent.printTotalAdmissions();
    }
}
