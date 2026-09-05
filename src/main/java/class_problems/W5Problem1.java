class W5Problem1 {
    static class AccessRuleEngine {
        String fieldModifier, accessorContext;

        public AccessRuleEngine(String fieldModifier, String accessorContext) {
            this.fieldModifier = fieldModifier;
            this.accessorContext = accessorContext;
        }

        static String classifyAccess(String fieldModifier, String accessorContext){
            if (fieldModifier.equals("private"))
                return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";

            if (fieldModifier.equals("protected")){
                return accessorContext.equals("SAME_PACKAGE") || 
                accessorContext.equals("SAME_CLASS") || 
                accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE") ? "ALLOWED" : "DENIED";
            }

            if (fieldModifier.equals("default")){
                return accessorContext.equals("SAME_PACKAGE") || accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
            }

            if(fieldModifier.equals("public")){
                return "ALLOWED";
            }

            return "DENIED";
        }

        static String summarizeBatch(String[][] attempts){
            int allowed = 0, denied = 0;

            for(String[] attempt : attempts){
                String result = classifyAccess(attempt[0], attempt[1]);

                if(result.equals("ALLOWED")){
                    allowed++;
                } else {
                    denied++;
                }
            }
            return "Allowed: " + allowed + ", Denied: " + denied;
        }

        static String describeAccess(String accessorContext){
            switch (accessorContext){
                case "SAME_CLASS":
                    return "Same class";
                case "SAME_PACKAGE":
                    return "Same package";
                case "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE":
                    return "Subclass in different package parent type";
                case "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE":
                    return "Subclass in different package own type";
                default:
                    return "Unknown access context";
            }
        }
    }

    static class PatientRecord{
        double vitalsScore;
        String facilityName, patientId, wardCode;

        public PatientRecord(double vitalsScore, String facilityName, String patientId, String wardCode) {
            if(patientId == null || patientId.trim().length() < 4){
                throw new IllegalArgumentException("Invalid PatientID");
            }

            this.vitalsScore = vitalsScore;
            this.facilityName = facilityName;
            this.patientId = patientId;
            this.wardCode = wardCode;
        }
    }

    public static void main(String[] args) {
        AccessRuleEngine engine = new AccessRuleEngine("private", "SAME_CLASS");

        System.out.println(AccessRuleEngine.classifyAccess(engine.fieldModifier, engine.accessorContext));
        System.out.println(AccessRuleEngine.classifyAccess("protected", "SAME_PACKAGE"));
        System.out.println(AccessRuleEngine.classifyAccess("default", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
        System.out.println(AccessRuleEngine.classifyAccess("public", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));

        String[][] batch = new String[][]{
                {"private", "SAME_CLASS"},
                {"protected", "SAME_PACKAGE"},
                {"default", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
                {"public", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };
        System.out.println(AccessRuleEngine.summarizeBatch(batch));

        PatientRecord p1 = new PatientRecord(98.5, "Central Hospital", "P1234", "W-07");

        try {
            PatientRecord p2 = new PatientRecord(75.0, "Central Hospital", "P1", "W-07");
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println(AccessRuleEngine.describeAccess("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
    }
}