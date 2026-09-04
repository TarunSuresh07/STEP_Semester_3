public class W3Assignment4 {

    public static void main(String[] args) {
        System.out.println("--- Broken version ---");
        runBrokenVersion();

        System.out.println("--- Fixed version ---");
        runFixedVersion();
    }

    private static void runBrokenVersion() {
        BrokenLibraryMember aditi = new BrokenLibraryMember("Aditi");
        BrokenLibraryMember rohan = new BrokenLibraryMember("Rohan");

        System.out.println(aditi.getName());
        System.out.println(rohan.getName());
    }

    private static void runFixedVersion() {
        LibraryMember aditi = new LibraryMember("Aditi");
        LibraryMember rohan = new LibraryMember("Rohan");

        aditi.printMemberCard();
        rohan.printMemberCard();
        LibraryMember.printTotalMembers();
    }

    static class BrokenLibraryMember {
        static String name;
        static String memberId;
        static int booksIssued;

        public BrokenLibraryMember(String name) {
            BrokenLibraryMember.name = name;
            BrokenLibraryMember.memberId = "LM-" + name;
            BrokenLibraryMember.booksIssued = 0;
        }

        public String getName() {
            return name;
        }
    }

    static class LibraryMember {
        private String name;
        private String memberId;
        private int booksIssued;

        static String libraryName = "Central Library";
        static int memberCount = 0;

        public LibraryMember(String name) {
            this.name = name;
            this.memberId = "LM-" + (1001 + memberCount);
            this.booksIssued = 0;
            memberCount++;
        }

        public void printMemberCard() {
            System.out.println(name + " | " + memberId);
        }

        public static void printTotalMembers() {
            System.out.println("Total members: " + memberCount);
        }
    }
}
