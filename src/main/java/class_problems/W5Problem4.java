class W5Problem4 {
    public static class PatientProfile {
        String patientId, name, gender, lockerPin;
        int age;
        boolean discharged;

        public PatientProfile() {
            this(null, null);
        }

        public PatientProfile(String name) {
            this(null, name);
        }

        public PatientProfile(String patientId, String name) {
            this.patientId = patientId;
            this.name = name;
        }

        public String getPatientId() {
            return patientId;
        }

        public void setPatientId(String patientId) {
            if (this.patientId == null)
                this.patientId = patientId;
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

        public boolean isDischarged() {
            return discharged;
        }

        public void setDischarged(boolean discharged) {
            this.discharged = discharged;
        }

        public void setLockerPin(String pin) {

            if (pin != null && pin.matches("\\d{4,6}"))
                lockerPin = Integer.toHexString(pin.hashCode());
        }

    public static void main(String[] args) {
        PatientProfile p = new PatientProfile("RA101", "Sahaana");

        p.setAge(18);
        p.setGender("Female");
        p.setDischarged(false);
        p.setLockerPin("1234");

        System.out.println("Patient ID: " + p.getPatientId());
        System.out.println("Name: " + p.getName());
        System.out.println("Age: " + p.getAge());
        System.out.println("Gender: " + p.getGender());
        System.out.println("Discharged: " + p.isDischarged());
    }
}
}
