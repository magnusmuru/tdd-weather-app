package ee.taltech.testing.courseproject.services;

import ee.taltech.testing.courseproject.API.WeatherAPI;
import ee.taltech.testing.courseproject.DTO.CityDTO;
import ee.taltech.testing.courseproject.DTO.CoordinateDTO;
import ee.taltech.testing.courseproject.DTO.DateDTO;
import ee.taltech.testing.courseproject.DTO.ForecastDTO;
import ee.taltech.testing.courseproject.DTO.WeatherDTO;
import ee.taltech.testing.courseproject.Model.Report;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceMockTest {

    @Mock
    WeatherAPI weatherAPIMock;

    @Test
    public void shouldReturnValidReportForGivenCity() throws IOException {
        String city = "Narva";
        WeatherReportService weatherReportService = new WeatherReportService(weatherAPIMock);
        CityDTO cityStubData = CityDTO.builder()
                .coord(CoordinateDTO.builder().lon(28.1903).lat(59.3772).build())
                .dt(new DateDTO(1611053595L))
                .main(WeatherDTO.builder().humidity(96).pressure(1014).temp(-8).build())
                .name("Narva")
                .build();

        when(weatherAPIMock.getCityLocaleDetails(anyString())).thenReturn(cityStubData);

        Report weatherReport = weatherReportService.getCityDetails(city);

        assertEquals(96, weatherReport.getCurrentWeatherReport().getHumidity());
        assertEquals("2021-01-19", weatherReport.getCurrentWeatherReport().getDate());
        assertEquals("Narva", weatherReport.getWeatherReportDetails().getCity());
    }

    @Test
    public void shouldReturnValidForecastForGivenCity() throws IOException {
        WeatherReportService weatherReportService = new WeatherReportService(weatherAPIMock);
        ForecastStubDataGenerator generator = new ForecastStubDataGenerator();

        ForecastDTO forecastStub = ForecastDTO.builder()
                .cod(200)
                .message(0)
                .list(generator.generateForecastStubData())
                .build();

        when(weatherAPIMock.getForecast(anyString())).thenReturn(forecastStub);

        Report forecastReport = weatherReportService.getForecast("Tallinn");

        assertThat(forecastReport.getForecastReport().size()).isEqualTo(3);
        assertEquals(1001, forecastReport.getForecastReport().get(0).getWeather().getPressure());
        assertEquals(1002, forecastReport.getForecastReport().get(1).getWeather().getPressure());
        assertEquals(1003, forecastReport.getForecastReport().get(2).getWeather().getPressure());

    }
}