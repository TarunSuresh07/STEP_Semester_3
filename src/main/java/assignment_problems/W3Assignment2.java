public class W3Assignment2 {
    private static double getEffectivePay(Employee employee) {
        if (employee instanceof ManagerEmployee) {
            return ((ManagerEmployee) employee).effectiveSalary();
        }
        if (employee instanceof InternEmployee) {
            return ((InternEmployee) employee).effectiveSalary();
        }
        return employee.getSalary();
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

    public static void main(String[] args) {
        Employee plain = new Employee("E001", "Plain Employee", 40000);
        ManagerEmployee manager = new ManagerEmployee("E002", "Manager", 70000, 8000);
        InternEmployee intern = new InternEmployee("E003", "Intern", 12000, 10000);

        System.out.println("Plain employee pay: Rs " + getEffectivePay(plain));
        System.out.println("Manager effective pay: Rs " + getEffectivePay(manager));
        System.out.println("Intern effective pay: Rs " + getEffectivePay(intern));
    }
}
