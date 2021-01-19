package ee.taltech.testing.courseproject.services;

import ee.taltech.testing.courseproject.API.WeatherAPI;
import ee.taltech.testing.courseproject.DTO.CityDTO;
import ee.taltech.testing.courseproject.Model.Coordinate;
import ee.taltech.testing.courseproject.Model.CurrentWeatherReport;
import ee.taltech.testing.courseproject.Model.Report;
import ee.taltech.testing.courseproject.Model.WeatherReportDetails;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherReportService {

    private WeatherAPI weatherAPI = new WeatherAPI();

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
            currentWeatherReport.setTemperature(cityLocale.getMain().getTemp());

            return weatherReport;
        } else {
            return null;
        }
    }
}
