package ee.taltech.testing.courseproject.services;

import ee.taltech.testing.courseproject.API.WeatherAPI;
import ee.taltech.testing.courseproject.Model.Report;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ServiceTests {

    private static WeatherReportService weatherReportService;

    @BeforeAll
    public static void setUp() {
        weatherReportService = new WeatherReportService(new WeatherAPI());
    }

    @Test
    public void connectToOWMAndPullLocalDetails() throws IOException {
        String city = "Tallinn";

        String expectedCity = "Tallinn";

        Report weatherReport = weatherReportService.getCityDetails(city);

        assertEquals(weatherReport.getWeatherReportDetails().getCity(), expectedCity);
    }

    @Test
    public void shouldReturnNoReportInCaseOfBadCityName() throws IOException {
        String city = "Karbanalanda";

        Report weatherReport = weatherReportService.getCityDetails(city);

        assertNull(weatherReport);
    }

}
