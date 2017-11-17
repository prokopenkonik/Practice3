import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class TemperatureConverterTest {
    public double parameter;
    public double expected;
    private TemperatureConverter temperatureConverter;
    private double delta;

    public TemperatureConverterTest(double parameter, double expected) {
        this.parameter = parameter;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][] {
                {204.444, 400},
                {50, 10},
                {330.33, 165.555}
        });
    }


    @Before
    public void init() {
        temperatureConverter = new TemperatureConverter();
        delta = 0.001;
    }

    @Test
    public void convertFtoC() throws Exception {
        assertEquals(expected, temperatureConverter.convertFtoC(parameter), delta);
    }

    @Test
    public void convertCtoF() throws Exception {
        assertEquals(122, temperatureConverter.convertCtoF(50), delta);
    }

    @Test
    public void convertCtoK() throws Exception {
        assertEquals(323.15, temperatureConverter.convertCtoK(50), delta);
    }

    @Test
    public void convertKtoC() throws Exception {
        assertEquals(-273.15, temperatureConverter.convertKtoC(0), delta);
    }

    @Test
    public void convertFtoK() throws Exception {
        assertEquals(255.372, temperatureConverter.convertFtoK(0), delta);
    }

    @Test
    public void convertKtoF() throws Exception {
        assertEquals(-459.67, temperatureConverter.convertKtoF(0), delta);
    }
}
