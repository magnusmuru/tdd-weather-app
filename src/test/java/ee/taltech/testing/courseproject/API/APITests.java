package ee.taltech.testing.courseproject.API;

import ee.taltech.testing.courseproject.DTO.CityDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class APITests {

    private static WeatherAPI weatherAPI;

    @BeforeAll
    public static void setUp() {
        weatherAPI = new WeatherAPI();
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

    @Test
    public void checkForLocaleForCityThatDoesNotExist() throws IOException {
        String city = "Salabara";

        CityDTO cityDTO = weatherAPI.getCityLocaleDetails(city);

        assertNull(cityDTO);
    }

    @Test
    public void cityHasCurrentDate() throws IOException {
        String city = "Tartu";

        CityDTO cityDTO = weatherAPI.getCityLocaleDetails(city);

        assertThat(cityDTO.getDt()).isNotNull();
    }

    @Test
    public void cityDateIsValidAndEqualsToday() throws IOException {
        String city = "Tartu";
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date expectedDate = new Date();

        CityDTO cityDTO = weatherAPI.getCityLocaleDetails(city);

        assertEquals(dateFormatter.format(expectedDate), cityDTO.getDt().getFormattedDate());
    }

    @Test
    public void cityHasWeatherData() throws IOException {
        String city = "Pärnu";

        CityDTO cityDTO = weatherAPI.getCityLocaleDetails(city);

        assertThat(cityDTO.getMain()).isNotNull();
    }


}
