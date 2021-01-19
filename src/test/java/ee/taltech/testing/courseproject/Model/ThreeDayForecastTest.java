package ee.taltech.testing.courseproject.Model;

import ee.taltech.testing.courseproject.API.WeatherAPI;
import ee.taltech.testing.courseproject.DTO.ForecastDTO;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ThreeDayForecastTest {

    @Test
    public void shouldReturnThreeDayForecast() throws IOException {
        WeatherAPI weatherAPI = new WeatherAPI();
        ThreeDayForecast forecast = new ThreeDayForecast();
        String city = "Tallinn";
        ForecastDTO forecastDTO = weatherAPI.getForecast(city);

        List<ForecastReport> forecastReports = forecast.getForecast(forecastDTO.getList());

        assertThat(forecastReports).isNotNull();
        assertThat(forecastReports.size()).isEqualTo(3);
        assertThat(forecastReports.get(0)).isNotNull();
    }
}
