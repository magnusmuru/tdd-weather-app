package ee.taltech.testing.courseproject.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class Weather {
    private int temperature;
    private int humidity;
    private int pressure;
}
