package ee.taltech.testing.courseproject.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {
    private String name;
    private CoordinateDTO coord;
    private DateDTO dt;
    private WeatherDTO main;
}
