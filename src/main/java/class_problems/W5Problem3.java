class W5Problem3 {
    static class PatientVitals {
        double[] initialReadings;
        int count;

        PatientVitals(double[] initialReadings) {
            this.initialReadings = initialReadings;
            count = 0;

            if (initialReadings != null) {
                for (double reading : initialReadings) {
                    recordReading(reading);
                }
            }
        }

        public void recordReading(double reading) {
            if (reading > 0 && reading <= 45) {
                initialReadings[count] = reading;
                count++;
            }
        }

        double[] getAllReadings() {
            double[] correctedReadings = new double[count];
            for (int i = 0; i < count; i++)
                correctedReadings[i] = initialReadings[i];
            return correctedReadings;
        }

        double getAverage() {
            double sum = 0;
            double[] readings = getAllReadings();
            for (double reading : readings) {
                sum += reading;
            }
            return sum / readings.length;
        }
    }

    public static void main(String[] args) {
        double[] initialReadings = { 36.5, 37.0, -2, 39.1, 40.0 };
        PatientVitals patientVitals = new PatientVitals(initialReadings);

        System.out.println("Average :" + patientVitals.getAverage());
        double[] allReadings = patientVitals.getAllReadings();
        System.out.print("All Readings: ");
        for (double reading : allReadings) {
            System.out.print(reading + " ");
        }
        System.out.println();
    }
}