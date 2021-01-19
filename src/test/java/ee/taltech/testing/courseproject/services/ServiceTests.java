package ee.taltech.testing.courseproject.services;

import ee.taltech.testing.courseproject.API.WeatherAPI;
import ee.taltech.testing.courseproject.Model.WeatherReportDetails;
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

        WeatherReportDetails weatherReportDetails = weatherReportService.getCityDetails(city);

        assertEquals(weatherReportDetails.getCity(), city);
    }
}
