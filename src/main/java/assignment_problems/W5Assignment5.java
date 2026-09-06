public class W5Assignment5 {
    private static final String BOOK_PREFIX;

    static {
        BOOK_PREFIX = "BK-";
    }

    public static class LoanReceipt {
        private final String memberId;
        private final String[] bookIds;

        public LoanReceipt(String memberId, String[] bookIds) {
            if (memberId == null || memberId.length() == 0)
                throw new IllegalArgumentException("memberId cannot be empty");
            validateBookIds(bookIds);
            this.memberId = memberId;
            this.bookIds = bookIds.clone();
        }

        public String getMemberId() {
            return memberId;
        }

        public String[] getBookIds() {
            return bookIds.clone();
        }

        public LoanReceipt withCorrectedBookId(int index, String newId) {
            if (index < 0 || index >= bookIds.length)
                throw new IndexOutOfBoundsException("invalid book index");
            if (!isValidBookId(newId))
                throw new IllegalArgumentException("invalid book ID");

            String[] correctedIds = bookIds.clone();
            correctedIds[index] = newId;
            return new LoanReceipt(memberId, correctedIds);
        }
    }

    public static class ReferenceOnlyLoanReceipt extends LoanReceipt {
        private final String roomNumber;

        public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
            super(memberId, bookIds);
            this.roomNumber = roomNumber;
        }

        public String getRoomNumber() {
            return roomNumber;
        }
    }

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        if (receipts == null)
            return "0 processed | 0 null skipped | 0 reference-only | 0 regular";

        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        for (LoanReceipt receipt : receipts) {
            if (receipt == null) {
                nullSkipped++;
            } else {
                processed++;
                if (receipt instanceof ReferenceOnlyLoanReceipt)
                    referenceOnly++;
                else
                    regular++;
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | "
                + referenceOnly + " reference-only | " + regular + " regular";
    }

    private static void validateBookIds(String[] bookIds) {
        if (bookIds == null || bookIds.length > 20)
            throw new IllegalArgumentException("invalid book list");
        for (String bookId : bookIds) {
            if (!isValidBookId(bookId))
                throw new IllegalArgumentException("invalid book ID");
        }
    }

    private static boolean isValidBookId(String bookId) {
        if (bookId == null || bookId.length() != 6 || !bookId.startsWith(BOOK_PREFIX))
            return false;
        for (int i = 3; i < bookId.length(); i++) {
            if (!Character.isDigit(bookId.charAt(i)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            LoanReceipt rejected = new LoanReceipt(
                    "LIB-8841", new String[]{"BK-100", "bad"});
            System.out.println("unexpected acceptance for " + rejected.getMemberId());
        } catch (IllegalArgumentException exception) {
            System.out.println("construction rejected");
        }

        LoanReceipt receipt = new LoanReceipt("LIB-8841",
                new String[]{"BK-100", "BK-101"});
        String[] ids = receipt.getBookIds();
        ids[0] = "HACKED";
        if (!"HACKED".equals(ids[0]))
            System.out.println("copy was not changed");
        System.out.println(receipt.getBookIds()[0]);

        System.out.println(processNightlyCirculation(new LoanReceipt[]{
                new ReferenceOnlyLoanReceipt("LIB-001", new String[]{"BK-200"},
                        "Reading Room 3"),
                null,
                new LoanReceipt("LIB-002", new String[]{"BK-201"})
        }));
    }
}
