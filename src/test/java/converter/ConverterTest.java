package converter;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    public final static double EPS = 1e-9;

    Converter converter;

    @BeforeEach
    void setUp() {
        converter = new Converter();
    }

    @Test
    void testConvertCelsiusToFahrenheit() {
        double celsius = 10.0;
        double expectedFahrenheit = 50.0;
        double actual = converter.convertCelsiusToFahrenheit(celsius);
        //assertEquals(expectedFahrenheit, actual, EPS);
        assertThat(actual).isCloseTo(expectedFahrenheit, Percentage.withPercentage(0.001));
    }

    @Test
    void testCheckCelsius() {
        //assertTrue(converter.checkCelsius(10.0));
        assertThat(converter.checkCelsius(10.0)).isTrue();
    }

    @Test
    void testCheckCelsiusFalse() {
        //assertFalse(converter.checkCelsius(-777.0));
        assertThat(converter.checkCelsius(-777.0)).isFalse();
    }

    @ParameterizedTest
    @CsvSource({"10.0, 50.0", "0.0, 32.0", "40.0, 104.0"})
    void testCelsiusToFahrenheitParam(double celsius, double expectedFahrenheit) {
        assertThat(converter.convertCelsiusToFahrenheit(celsius))
                .isCloseTo(expectedFahrenheit, Percentage.withPercentage(0.001));
    }
}