public class W3Problem1 {

    public static void main(String[] args) {
        SrmStudent[] students = {
            new SrmStudent("Ravi", 82),
            new SrmStudent("Anitha", 68),
            new SrmStudent("Karthik", 91),
            new SrmStudent("Meera", 74),
            new SrmStudent("Suresh", 60)
        };

        for (SrmStudent student : students) {
            String status = student.isEligible() ? "Eligible" : "Detained";
            System.out.println(student.getName() + " - " + student.getAttendance() + "% - " + status);
        }

        System.out.println("Class average: " + SrmStudent.classAverage(students) + "%");
    }

    static class SrmStudent {
        private String name;
        private String regNo;
        private int attendance;

        public SrmStudent(String name, int attendance) {
            this.name = name;
            this.regNo = "REG-" + name;
            this.attendance = attendance;
        }

        public String getName() {
            return name;
        }

        public int getAttendance() {
            return attendance;
        }

        public void addAttendanceUpdate(int newAttendance) {
            this.attendance = newAttendance;
        }

        public boolean isEligible() {
            return attendance >= 75;
        }

        public static double classAverage(SrmStudent[] students) {
            if (students.length == 0) {
                return 0;
            }

            int total = 0;
            for (SrmStudent student : students) {
                total += student.attendance;
            }
            return (double) total / students.length;
        }
    }
}
