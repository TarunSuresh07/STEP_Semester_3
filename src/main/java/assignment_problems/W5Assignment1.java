public class W5Assignment1 {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || accessorContext == null)
            return "DENIED";

        if (fieldModifier.equals("private"))
            return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
        if (fieldModifier.equals("default"))
            return accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")
                    ? "ALLOWED" : "DENIED";
        if (fieldModifier.equals("protected"))
            return accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")
                    ? "ALLOWED" : "DENIED";
        if (fieldModifier.equals("public"))
            return "ALLOWED";
        return "DENIED";
    }

    public static String summarizeByModifier(String[][] attempts) {
        String[] modifiers = {"private", "default", "protected", "public"};
        int[] allowed = new int[modifiers.length];
        int[] denied = new int[modifiers.length];

        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt == null || attempt.length < 2)
                    continue;

                for (int i = 0; i < modifiers.length; i++) {
                    if (modifiers[i].equals(attempt[0])) {
                        if (classifyAccess(attempt[0], attempt[1]).equals("ALLOWED"))
                            allowed[i]++;
                        else
                            denied[i]++;
                        break;
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < modifiers.length; i++) {
            if (i > 0)
                result.append(" | ");
            result.append(modifiers[i]).append(": ").append(allowed[i])
                    .append(" allowed / ").append(denied[i]).append(" denied");
        }
        return result.toString();
    }

    public static class LibraryMember {
        private String membershipId;
        String branchCode;
        protected double finesOwed;
        public String displayName;

        public LibraryMember(String membershipId, String branchCode,
                double finesOwed, String displayName) {
            String trimmedId = membershipId == null ? "" : membershipId.trim();
            if (trimmedId.length() < 4)
                throw new IllegalArgumentException("construction rejected");

            this.membershipId = trimmedId;
            this.branchCode = branchCode;
            this.finesOwed = finesOwed;
            this.displayName = displayName;
        }

        public String getMembershipId() {
            return membershipId;
        }

        public String getBranchCode() {
            return branchCode;
        }

        public double getFinesOwed() {
            return finesOwed;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));
        System.out.println(summarizeByModifier(new String[][]{
                {"private", "SAME_CLASS"},
                {"private", "SAME_PACKAGE"},
                {"default", "SAME_PACKAGE"},
                {"default", "DIFFERENT_PACKAGE"},
                {"protected", "SAME_PACKAGE"},
                {"protected", "SAME_CLASS"},
                {"public", "DIFFERENT_PACKAGE"}
        }));
    }
}
