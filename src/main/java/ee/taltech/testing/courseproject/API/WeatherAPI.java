package ee.taltech.testing.courseproject.API;

import com.fasterxml.jackson.databind.ObjectMapper;
import ee.taltech.testing.courseproject.DTO.CityDTO;
import ee.taltech.testing.courseproject.Model.Coordinate;
import ee.taltech.testing.courseproject.Model.WeatherReportDetails;
import ee.taltech.testing.courseproject.configuration.Configuration;
import lombok.AllArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Service
public class WeatherAPI {

    private Configuration configuration = new Configuration();
    private ObjectMapper mapper = new ObjectMapper();
    private OkHttpClient client = new OkHttpClient();

    public WeatherReportDetails getCityDetails(String city) throws IOException {
        WeatherReportDetails weatherReportDetails = new WeatherReportDetails();
        CityDTO cityLocale = this.getCityLocaleDetails(city);
        if (cityLocale != null) {
            weatherReportDetails.setCity(cityLocale.getName());

            Coordinate coordinate = new Coordinate();
            weatherReportDetails.setCoordinates(coordinate.getCoordinatesAsString(cityLocale.getCoord().getLon(), cityLocale.getCoord().getLat()));

            return weatherReportDetails;
        } else {
            return null;
        }
    }

    private String currentWeatherUrl(String city) {
        return "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&appid=" + configuration.getApiKey();
    }

    public CityDTO getCityLocaleDetails(String city) throws IOException {
        Request request = new Request.Builder().url(currentWeatherUrl(city)).build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return mapper.readValue(response.body().byteStream(), CityDTO.class);
        } else {
            return null;
        }
    }
}
