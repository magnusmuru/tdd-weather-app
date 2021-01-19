package ee.taltech.testing.courseproject.services;

import ee.taltech.testing.courseproject.DTO.DateDTO;
import ee.taltech.testing.courseproject.DTO.ForecastItemDTO;
import ee.taltech.testing.courseproject.DTO.WeatherDTO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ForecastStubDataGenerator {

    private List<ForecastItemDTO> generateStubDailyData(long date, int humidity, int pressure, double temperature) {
        List<ForecastItemDTO> forecastData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            forecastData.add(ForecastItemDTO.builder()
                    .dt(new DateDTO(date))
                    .main(WeatherDTO.builder()
                            .humidity(humidity)
                            .pressure(pressure)
                            .temp(temperature)
                            .build())
                    .build());
        }
        return forecastData;
    }

    public List<ForecastItemDTO> generateForecastStubData() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        List<ForecastItemDTO> generatedData = new ArrayList<>(generateStubDailyData(date.getTime(), 80, 1000, 6.5));
        for (int i = 1; i < 6; i++) {
            calendar.add(Calendar.DATE, 1);
            date.setTime(calendar.getTime().getTime());
            generatedData.addAll(generateStubDailyData(date.getTime() / 1000, 80 + i, 1000 + i, 6.5 + i));
        }

        return generatedData;
    }
}
