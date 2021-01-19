package ee.taltech.testing.courseproject.services;

import ee.taltech.testing.courseproject.Model.Report;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceTests {

    private static WeatherReportService weatherReportService;

    @BeforeAll
    public static void setUp() {
        weatherReportService = new WeatherReportService();
    }

    @Test
    public void connectToOWMAndPullLocalDetails() throws IOException {
        String city = "Tallinn";

        String expectedCity = "Tallinn";

        Report weatherReport = weatherReportService.getCityDetails(city);

        assertEquals(weatherReport.getWeatherReportDetails().getCity(), expectedCity);
    }
}
