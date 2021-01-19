package ee.taltech.testing.courseproject.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class WeatherReportDetails {
    private String city;
    private String coordinates;
    private static final String temperatureUnit = "Celsius";
}
