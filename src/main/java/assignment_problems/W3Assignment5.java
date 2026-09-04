public class W3Assignment5 {

    public static void main(String[] args) {
        ParkingSlot slotA1 = new ParkingSlot("A1", 10, 0);
        ParkingSlot slotA2 = new ParkingSlot("A2", 10, 0);

        CompanyEmployeeRecord divya = new CompanyEmployeeRecord(
            "Divya",
            "E101",
            new ManagerEmployee("E101", "Divya", 70000, 8000),
            slotA1
        );

        CompanyEmployeeRecord karan = new CompanyEmployeeRecord(
            "Karan",
            "E102",
            new Employee("E102", "Karan", 40000),
            slotA2
        );

        CompanyEmployeeRecord meera = new CompanyEmployeeRecord(
            "Meera",
            "E103",
            new InternEmployee("E103", "Meera", 12000, 10000),
            null
        );

        ParkingSlot.safeAllot(new ParkingSlot[] { slotA1 }, "TN01AA1111");
        ParkingSlot.safeAllot(new ParkingSlot[] { slotA2 }, "TN01BB2222");

        System.out.println(divya.fullProfile());
        System.out.println(karan.fullProfile());
        System.out.println(meera.fullProfile());
        System.out.println("Total records: " + CompanyEmployeeRecord.totalRecords);
    }

    static class CompanyEmployeeRecord {
        String name;
        String empId;
        Employee employee;
        ParkingSlot slot;

        static int totalRecords = 0;

        public CompanyEmployeeRecord(String name, String empId, Employee employee, ParkingSlot slot) {
            this.name = name;
            this.empId = empId;
            this.employee = employee;
            this.slot = slot;
            totalRecords++;
        }

        public String fullProfile() {
            double pay;
            if (employee instanceof ManagerEmployee) {
                pay = ((ManagerEmployee) employee).effectiveSalary();
            } else if (employee instanceof InternEmployee) {
                pay = ((InternEmployee) employee).effectiveSalary();
            } else {
                pay = employee.getSalary();
            }

            String slotInfo = (slot == null) ? "no parking assigned" : slot.slotNo;
            return name + " | Pay: Rs " + pay + " | Slot: " + slotInfo;
        }
    }

    static class Employee {
        private String empId;
        private String empName;
        private double salary;

        public Employee(String empId, String empName, double salary) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
        }

        public double getSalary() {
            return salary;
        }
    }

    static class ManagerEmployee extends Employee {
        private double teamBonus;

        public ManagerEmployee(String empId, String empName, double salary, double teamBonus) {
            super(empId, empName, salary);
            this.teamBonus = teamBonus;
        }

        public double effectiveSalary() {
            return getSalary() + teamBonus;
        }
    }

    static class InternEmployee extends Employee {
        private double stipendCap;

        public InternEmployee(String empId, String empName, double salary, double stipendCap) {
            super(empId, empName, salary);
            this.stipendCap = stipendCap;
        }

        public double effectiveSalary() {
            return Math.min(getSalary(), stipendCap);
        }
    }

    static class ParkingSlot {
        String slotNo;
        int capacity;
        int occupiedCount;

        public ParkingSlot(String slotNo, int capacity, int occupiedCount) {
            this.slotNo = slotNo;
            this.capacity = capacity;
            this.occupiedCount = occupiedCount;
        }

        public void allot(String vehicleNo) {
            if (occupiedCount < capacity) {
                occupiedCount++;
            }
        }

        public static ParkingSlot findAvailableSlot(ParkingSlot[] slots) {
            for (ParkingSlot slot : slots) {
                if (slot.occupiedCount < slot.capacity) {
                    return slot;
                }
            }
            return null;
        }

        public static void safeAllot(ParkingSlot[] slots, String vehicleNo) {
            ParkingSlot slot = findAvailableSlot(slots);
            if (slot != null) {
                slot.allot(vehicleNo);
            }
        }
    }
}
