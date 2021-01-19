package ee.taltech.testing.courseproject.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class CityDTO {
    private String name;
    private int lon;
    private int lat;
}
