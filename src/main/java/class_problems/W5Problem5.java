public class W5Problem5 {
    private static final String MEDICATION_PREFIX;

    static {
        MEDICATION_PREFIX = "MED-";
    }

    public static class DischargeSummary {
        private final String patientId;
        private final String[] medicationCodes;

        public DischargeSummary(String patientId, String[] medicationCodes) {
            if (patientId == null || patientId.length() == 0)
                throw new IllegalArgumentException("patientId cannot be empty");
            validateMedicationCodes(medicationCodes);
            this.patientId = patientId;
            this.medicationCodes = medicationCodes.clone();
        }

        public String getPatientId() {
            return patientId;
        }

        public String[] getMedicationCodes() {
            return medicationCodes.clone();
        }

        public DischargeSummary withCorrectedMedication(int index, String newCode) {
            if (index < 0 || index >= medicationCodes.length)
                throw new IndexOutOfBoundsException("invalid medication index");
            if (!isValidMedicationCode(newCode))
                throw new IllegalArgumentException("invalid medication code");

            String[] correctedCodes = medicationCodes.clone();
            correctedCodes[index] = newCode;
            return new DischargeSummary(patientId, correctedCodes);
        }
    }

    public static class CriticalCareDischargeSummary extends DischargeSummary {
        private final int icuDays;

        public CriticalCareDischargeSummary(String patientId, String[] medicationCodes, int icuDays) {
            super(patientId, medicationCodes);
            if (icuDays < 0)
                throw new IllegalArgumentException("icuDays cannot be negative");
            this.icuDays = icuDays;
        }

        public int getIcuDays() {
            return icuDays;
        }
    }

    public static String processNightlyBatch(DischargeSummary[] summaries) {
        if (summaries == null)
            return "0 processed | 0 null skipped | 0 critical-care | 0 routine";

        int processed = 0;
        int nullSkipped = 0;
        int criticalCare = 0;
        int routine = 0;

        for (DischargeSummary summary : summaries) {
            if (summary == null) {
                nullSkipped++;
            } else {
                processed++;
                if (summary instanceof CriticalCareDischargeSummary)
                    criticalCare++;
                else
                    routine++;
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " + criticalCare + " critical-care | " + routine + " routine";
    }

    private static void validateMedicationCodes(String[] medicationCodes) {
        if (medicationCodes == null || medicationCodes.length > 20)
            throw new IllegalArgumentException("invalid medication list");

        for (String medicationCode : medicationCodes) {
            if (!isValidMedicationCode(medicationCode))
                throw new IllegalArgumentException("invalid medication code");
        }
    }

    private static boolean isValidMedicationCode(String medicationCode) {
        return medicationCode != null
                && medicationCode.length() == 5
                && medicationCode.startsWith(MEDICATION_PREFIX)
                && medicationCode.charAt(4) >= 'A'
                && medicationCode.charAt(4) <= 'Z';
    }

    public static void main(String[] args) {
        try {
            DischargeSummary rejected = new DischargeSummary(
                    "MT2026-0142", new String[]{"MED-A", "bad"});
                System.out.println("unexpected acceptance for " + rejected.getPatientId());
        } catch (IllegalArgumentException exception) {
            System.out.println("construction rejected");
        }

        DischargeSummary discharge = new DischargeSummary(
                "MT2026-0142", new String[]{"MED-A", "MED-B"});
        String[] codes = discharge.getMedicationCodes();
        codes[0] = "TAMPERED";
        if (!"TAMPERED".equals(codes[0]))
            System.out.println("copy was not changed");
        System.out.println(discharge.getMedicationCodes()[0]);

        System.out.println(processNightlyBatch(new DischargeSummary[]{
                new CriticalCareDischargeSummary("MT001", new String[]{"MED-X"}, 4),
                null,
                new DischargeSummary("MT002", new String[]{"MED-Y"})
        }));
    }
}
