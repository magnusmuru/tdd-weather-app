package ee.taltech.testing.courseproject.services;

import ee.taltech.testing.courseproject.API.WeatherAPI;
import ee.taltech.testing.courseproject.Model.Report;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
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
    public void shouldReturnNoReportInCaseOfUnknownCityName() throws IOException {
        String city = "Karbanalanda";

        Report weatherReport = weatherReportService.getCityDetails(city);

        assertNull(weatherReport);
    }

    @Test
    public void getForecastFromService() throws IOException {
        String city = "Tartu";

        Report forecastReport = weatherReportService.getForecast(city);

        assertThat(forecastReport).isNotNull();
    }

    @Test
    public void shouldReturnNoForecastForUnknownCityName() throws IOException {
        String city = "Acdccdca";

        Report forecastReport = weatherReportService.getForecast(city);

        assertNull(forecastReport);
    }

    @Test
    public void threeDayForecastIsOfNextThreeDays() throws IOException {
        String city = "Rapla";

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date todayDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(todayDate);
        String expectedDay;

        Report forecastReport = weatherReportService.getForecast(city);

        for (int i = 0; i < 3; i++) {
            calendar.add(Calendar.DATE, 1);
            expectedDay = dateFormatter.format(calendar.getTime());
            assertEquals(expectedDay, forecastReport.getForecastReport().get(i).getDate());
        }
    }

}
