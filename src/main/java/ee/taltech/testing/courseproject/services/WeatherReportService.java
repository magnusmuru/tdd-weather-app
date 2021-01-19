package ee.taltech.testing.courseproject.services;

import ee.taltech.testing.courseproject.API.WeatherAPI;
import ee.taltech.testing.courseproject.DTO.CityDTO;
import ee.taltech.testing.courseproject.Model.Coordinate;
import ee.taltech.testing.courseproject.Model.Report;
import ee.taltech.testing.courseproject.Model.WeatherReportDetails;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherReportService {

    private WeatherAPI weatherAPI = new WeatherAPI();

    public Report getCityDetails(String city) throws IOException {
        WeatherReportDetails weatherReportDetails = new WeatherReportDetails();
        CityDTO cityLocale = weatherAPI.getCityLocaleDetails(city);
        if (cityLocale != null) {
            weatherReportDetails.setCity(cityLocale.getName());

            Coordinate coordinate = new Coordinate();
            weatherReportDetails.setCoordinates(coordinate.getCoordinatesAsString(cityLocale.getCoord().getLon(), cityLocale.getCoord().getLat()));

            return new Report();
        } else {
            return null;
        }
    }
}
