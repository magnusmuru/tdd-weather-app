package ee.taltech.testing.courseproject.API;

import ee.taltech.testing.courseproject.DTO.CityDTO;
import ee.taltech.testing.courseproject.Model.WeatherReportDetails;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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
    public void checkIfCityLocaleDetailsAreCorrect() throws IOException {
        String city = "Tallinn";

        double expectedLat = 59.437;
        double expectedLon = 24.7535;
        String expectedCity = "Tallinn";

        CityDTO cityDTO = weatherAPI.getCityLocaleDetails(city);

        assertEquals(expectedLat, cityDTO.getCoord().getLat());
        assertEquals(expectedLon, cityDTO.getCoord().getLon());
        assertEquals(expectedCity, cityDTO.getName());
    }
}
