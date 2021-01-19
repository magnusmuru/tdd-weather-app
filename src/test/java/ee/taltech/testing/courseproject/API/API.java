package ee.taltech.testing.courseproject.API;

import ee.taltech.testing.courseproject.Model.WeatherReportDetails;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class API {

    private static WeatherAPI weatherAPI;

    @BeforeAll
    public static void setUp(){
        weatherAPI = new WeatherAPI();
    }

    @Test
    public void connectToOWMAndPullMainDetails() {
        String city = "Tallinn";

        WeatherReportDetails weatherReportDetails = weatherAPI.getCityDetails(city);

        assertEquals(weatherReportDetails.getCity(), city);
    }
}
