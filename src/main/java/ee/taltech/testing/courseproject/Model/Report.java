package ee.taltech.testing.courseproject.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report {
    private WeatherReportDetails weatherReportDetails;
    private CurrentWeatherReport currentWeatherReport;
    private List<ForecastReport> forecastReport;
}
