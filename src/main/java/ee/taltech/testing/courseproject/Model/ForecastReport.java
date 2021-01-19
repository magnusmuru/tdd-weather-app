package ee.taltech.testing.courseproject.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ForecastReport {
    private String date;
    private Weather weather;
}
