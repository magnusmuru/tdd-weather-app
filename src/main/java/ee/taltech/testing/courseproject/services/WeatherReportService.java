package ee.taltech.testing.courseproject.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import ee.taltech.testing.courseproject.API.WeatherAPI;
import ee.taltech.testing.courseproject.DTO.CityDTO;
import ee.taltech.testing.courseproject.DTO.ForecastDTO;
import ee.taltech.testing.courseproject.Model.Coordinate;
import ee.taltech.testing.courseproject.Model.CurrentWeatherReport;
import ee.taltech.testing.courseproject.Model.ForecastReport;
import ee.taltech.testing.courseproject.Model.Report;
import ee.taltech.testing.courseproject.Model.ThreeDayForecast;
import ee.taltech.testing.courseproject.Model.WeatherReportDetails;
import ee.taltech.testing.courseproject.exceptions.FailedResponseException;
import lombok.AllArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;

@Service
@AllArgsConstructor
public class WeatherReportService {

    private final WeatherAPI weatherAPI;
    static Log log = LogFactory.getLog(WeatherReportService.class.getName());

    public Report getCityDetails(String city) throws IOException {
        Report weatherReport = new Report();
        WeatherReportDetails weatherReportDetails = new WeatherReportDetails();
        CurrentWeatherReport currentWeatherReport = new CurrentWeatherReport();
        Coordinate coordinate = new Coordinate();

        CityDTO cityLocale = weatherAPI.getCityLocaleDetails(city);
        if (cityLocale != null) {
            weatherReportDetails.setCity(cityLocale.getName());
            weatherReportDetails.setCoordinates(coordinate.getCoordinatesAsString(cityLocale.getCoord().getLon(), cityLocale.getCoord().getLat()));
            weatherReport.setWeatherReportDetails(weatherReportDetails);

            currentWeatherReport.setDate(cityLocale.getDt().getFormattedDate());
            currentWeatherReport.setHumidity(cityLocale.getMain().getHumidity());
            currentWeatherReport.setPressure(cityLocale.getMain().getPressure());
            currentWeatherReport.setTemperature((int) cityLocale.getMain().getTemp());
            weatherReport.setCurrentWeatherReport(currentWeatherReport);

            return weatherReport;
        } else {
            return null;
        }
    }

    public Report getForecast(String city) throws IOException {
        Report weatherReport = new Report();
        ForecastReport forecastReport = new ForecastReport();
        ThreeDayForecast threeDayForecast = new ThreeDayForecast();
        ForecastDTO forecastDTO = weatherAPI.getForecast(city);

        if (forecastDTO != null) {
            weatherReport.setForecastReport(threeDayForecast.getForecast(forecastDTO.getList()));
            return weatherReport;
        } else {
            return null;
        }
    }

    public String fetchWeatherReport(String city) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Report localeReport = this.getCityDetails(city);
        Report forecastReport = this.getForecast(city);

        if (localeReport != null && forecastReport != null) {
            log.info("Success");
            Report weatherReport = Report.builder()
                    .weatherReportDetails(localeReport.getWeatherReportDetails())
                    .currentWeatherReport(localeReport.getCurrentWeatherReport())
                    .forecastReport(forecastReport.getForecastReport())
                    .build();
            return objectMapper.writeValueAsString(weatherReport);
        } else {
            throw new FailedResponseException("API request for city " + city + " failed");
        }
    }
}
