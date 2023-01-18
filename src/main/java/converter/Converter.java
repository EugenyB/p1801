package converter;

public class Converter {
    private static final int ABSOLUTE_ZERO = -273;

    public double convertCelsiusToFahrenheit(double celsius) {
        if(celsius < ABSOLUTE_ZERO) {
            throw new IllegalArgumentException("error data");
        }
        return celsius * 1.8 + 32;
    }

    public boolean checkCelsius(double celsius) {
        return celsius >= ABSOLUTE_ZERO;
    }

}
