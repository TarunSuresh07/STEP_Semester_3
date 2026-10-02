public class W8Assignment2 {
    public static void main(String[] args) {
        Temperature t = new Temperature(35);
        t.convert();
    }
}

class Temperature {
    int celsius;

    Temperature(int celsius) {
        this.celsius = celsius;
    }

    void convert() {
        double fahrenheit = (celsius * 9 / 5.0) + 32;
        System.out.println("Fahrenheit: " + fahrenheit);
    }
}
