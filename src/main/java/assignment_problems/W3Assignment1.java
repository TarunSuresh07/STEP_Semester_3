public class W3Assignment1 {
    static class BookIssue {
        private String title;
        private String borrowerName;
        private int daysOverdue;

        public BookIssue(String title, String borrowerName, int daysOverdue) {
            this.title = title;
            this.borrowerName = borrowerName;
            this.daysOverdue = daysOverdue;
        }

        public String getTitle() {
            return title;
        }

        public int getDaysOverdue() {
            return daysOverdue;
        }

        public double fineAmount() {
            if (daysOverdue > 0) {
                return daysOverdue * 5;
            }
            return 0;
        }

        public boolean isSeverelyOverdue() {
            return daysOverdue > 14;
        }

        public static double totalFineCollected(BookIssue[] issues) {
            double total = 0;
            for (BookIssue issue : issues) {
                total += issue.fineAmount();
            }
            return total;
        }
    }

    public static void main(String[] args) {
        BookIssue[] issues = {
            new BookIssue("Clean Code", "Aditi", 18),
            new BookIssue("Effective Java", "Rohan", 5),
            new BookIssue("Refactoring", "Meera", 0),
            new BookIssue("DSA Handbook", "Karthik", 21),
            new BookIssue("Design Patterns", "Suresh", 9)
        };

        for (BookIssue issue : issues) {
            String status = issue.isSeverelyOverdue() ? "Severely overdue" : "OK";
            System.out.println(issue.getTitle() + " - " + issue.getDaysOverdue() + " days - " + status);
        }

        System.out.println("Total fine collected: Rs " + BookIssue.totalFineCollected(issues));
    }
}
