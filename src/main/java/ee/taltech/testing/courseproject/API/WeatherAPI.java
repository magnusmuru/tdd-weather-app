package ee.taltech.testing.courseproject.API;

import com.fasterxml.jackson.databind.ObjectMapper;
import ee.taltech.testing.courseproject.DTO.CityDTO;
import ee.taltech.testing.courseproject.Model.WeatherReportDetails;
import ee.taltech.testing.courseproject.configuration.Configuration;
import lombok.AllArgsConstructor;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;

@Service
public class WeatherAPI {

    private final Configuration configuration = new Configuration();
    private final ObjectMapper mapper = new ObjectMapper();
    private final OkHttpClient client = new OkHttpClient();

    public WeatherReportDetails getCityDetails(String city) {
        return null;
    }

    private String currentWeatherUrl(String city) {
        return "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&appid=" + configuration.getApiKey();
    }

    public CityDTO getCityLocaleDetails(String city) {
        return null;
    }
}
