public class W5Assignment4 {
    public static class LibraryMember {
        private String membershipId;
        private String name;
        private int age;
        private String gender;
        private boolean premiumMember;
        private String securityAnswerHash;

        public LibraryMember() {
            this(null, null);
        }

        public LibraryMember(String name) {
            this(null, name);
        }

        public LibraryMember(String membershipId, String name) {
            this.membershipId = membershipId;
            this.name = name;
        }

        public String getMembershipId() {
            return membershipId;
        }

        public void setMembershipId(String id) {
            if (membershipId == null)
                membershipId = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public boolean isPremiumMember() {
            return premiumMember;
        }

        public void setPremiumMember(boolean premium) {
            premiumMember = premium;
        }

        public void setSecurityAnswer(String answer) {
            if (answer != null) {
                String newHash = Integer.toHexString(answer.hashCode());
                securityAnswerHash = securityAnswerHash == null ? newHash : securityAnswerHash;
            }
        }
    }

    public static void main(String[] args) {
        LibraryMember member = new LibraryMember();
        member.setMembershipId("LIB-8841");
        member.setMembershipId("FAKE-0000");
        member.setSecurityAnswer("blue");
        System.out.println(member.getMembershipId());
    }
}
