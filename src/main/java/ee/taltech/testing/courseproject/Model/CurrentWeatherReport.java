package ee.taltech.testing.courseproject.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class CurrentWeatherReport {
    private String date;
    private int temperature;
    private int humidity;
    private int pressure;
}
