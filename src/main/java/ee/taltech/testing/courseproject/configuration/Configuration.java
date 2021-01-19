package ee.taltech.testing.courseproject.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import okhttp3.OkHttpClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("weather")
public class Configuration {

    private String apiKey = "1b1c8cb63ec2e4b7e011b4c2496a8163";

    @Bean
    public ObjectMapper mapper() {
        return new ObjectMapper();
    }

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }
}
