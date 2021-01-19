package ee.taltech.testing.courseproject.API;

import ee.taltech.testing.courseproject.DTO.CityDTO;
import ee.taltech.testing.courseproject.Model.WeatherReportDetails;
import ee.taltech.testing.courseproject.configuration.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class APITests {

    private static WeatherAPI weatherAPI;

    @BeforeAll
    public static void setUp(){
        weatherAPI = new WeatherAPI();
    }

    @Test
    public void connectToOWMAndPullLocalDetails() {
        String city = "Tallinn";

        WeatherReportDetails weatherReportDetails = weatherAPI.getCityDetails(city);

        assertEquals(weatherReportDetails.getCity(), city);
    }

    @Test
    public void checkIfCityLocalDetailsAreCorrect() {
        String city = "Tallinn";

        double expectedLat = 59.437;
        double expectedLon = 24.7535;
        String expectedCity = "Tallinn";

        CityDTO cityDTO = weatherAPI.getCityLocaleDetails(city);

        assertEquals(expectedLat, cityDTO.getLat());
        assertEquals(expectedLon, cityDTO.getLon());
        assertEquals(expectedCity, cityDTO.getName());
    }
}
