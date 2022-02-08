package edu.escuelaing.arep.services;

import com.google.gson.JsonObject;
import edu.escuelaing.arep.AppTest;
import edu.escuelaing.arep.services.impl.ConverterServiceImpl;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 2/7/2022
 * @project App
 */
public class ConverterServiceTest extends TestCase {
    ConverterService converterService;

    public ConverterServiceTest() {
        converterService = new ConverterServiceImpl();
    }


    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ConverterServiceTest(String testName) {
        super(testName);
        converterService = new ConverterServiceImpl();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ConverterServiceTest.class);
    }

    public void testShouldConvertNegativefahrenheitToCelcius() {
        String expectOutput = "-295.55557";
        String expectedStatus = "200";
        JsonObject asnw = converterService.fahrenheitToCelsius(-500);

        assertEquals(expectOutput, asnw.get("value").toString());
        assertEquals(expectedStatus, asnw.get("status_code").toString());
    }

    public void testShouldConvertZerofahrenheitToCelcius() {
        String expectOutput = "-17.777779";
        String expectedStatus = "200";
        JsonObject asnw = converterService.fahrenheitToCelsius(0);

        assertEquals(expectOutput, asnw.get("value").toString());
        assertEquals(expectedStatus, asnw.get("status_code").toString());

    }

    public void testShouldConvertPositivefahrenheitToCelcius() {
        String expectOutput = "260.0";
        String expectedStatus = "200";
        JsonObject asnw = converterService.fahrenheitToCelsius(500);

        assertEquals(expectOutput, asnw.get("value").toString());
        assertEquals(expectedStatus, asnw.get("status_code").toString());
    }

    public void testShouldConvertNegativeCelsiusToFahrenheit() {
        String expectOutput = "-868.0";
        String expectedStatus = "200";
        JsonObject asnw = converterService.celsiusToFahrenheit(-500);

        assertEquals(expectOutput, asnw.get("value").toString());
        assertEquals(expectedStatus, asnw.get("status_code").toString());
    }

    public void testShouldConvertZeroCelsiusToFahrenheit() {
        String expectOutput = "32.0";
        String expectedStatus = "200";
        JsonObject asnw = converterService.celsiusToFahrenheit(0);

        assertEquals(expectOutput, asnw.get("value").toString());
        assertEquals(expectedStatus, asnw.get("status_code").toString());

    }

    public void testShouldConvertPositiveCelsiusToFahrenheit() {
        String expectOutput = "932.0";
        String expectedStatus = "200";
        JsonObject asnw = converterService.celsiusToFahrenheit(500);

        assertEquals(expectOutput, asnw.get("value").toString());
        assertEquals(expectedStatus, asnw.get("status_code").toString());
    }
}
