package ee.taltech.testing.courseproject.Model;

import ee.taltech.testing.courseproject.DTO.ForecastItemDTO;
import ee.taltech.testing.courseproject.Model.Weather;

import java.util.ArrayList;
import java.util.List;

public class ThreeDayForecast {

    public List<ForecastReport> getForecast(List<ForecastItemDTO> forecasts) {

        if (forecasts.size() > 0) {
            List<String> forecastDays = new ArrayList<>();
            Weather oneDay = new Weather();
            Weather twoDay = new Weather();
            Weather threeDay = new Weather();

            for (ForecastItemDTO item : forecasts) {
                if (!forecastDays.contains(item.getDt().getFormattedDate())) {
                    forecastDays.add(item.getDt().getFormattedDate());
                }
            }
            if (forecastDays.size() > 0) {
                oneDay = getAllOneDayForecasts(forecasts, forecastDays.get(1));
                twoDay = getAllOneDayForecasts(forecasts, forecastDays.get(2));
                threeDay = getAllOneDayForecasts(forecasts, forecastDays.get(3));
            }
            List<ForecastReport> reportList = new ArrayList<>();
            reportList.add(ForecastReport.builder().date(forecastDays.get(1)).weather(oneDay).build());
            reportList.add(ForecastReport.builder().date(forecastDays.get(2)).weather(twoDay).build());
            reportList.add(ForecastReport.builder().date(forecastDays.get(3)).weather(threeDay).build());

            return reportList;
        }


        return null;
    }

    private Weather getAllOneDayForecasts(List<ForecastItemDTO> forecasts, String day) {
        List<Double> temperatureAverage = new ArrayList<>();
        List<Integer> pressureAverage = new ArrayList<>();
        List<Integer> humidityAverage = new ArrayList<>();

        for (ForecastItemDTO threeHourForecast : forecasts) {
            if (threeHourForecast.getDt().getFormattedDate().equals(day)) {
                temperatureAverage.add(threeHourForecast.getMain().getTemp());
                pressureAverage.add(threeHourForecast.getMain().getPressure());
                humidityAverage.add(threeHourForecast.getMain().getHumidity());
            }
        }
        return Weather.builder()
                .temperature((int) Math.round(temperatureAverage.stream().mapToDouble((a) -> a).summaryStatistics().getAverage()))
                .pressure((int) Math.round(pressureAverage.stream().mapToInt((a) -> a).summaryStatistics().getAverage()))
                .humidity((int) Math.round(humidityAverage.stream().mapToInt((a) -> a).summaryStatistics().getAverage()))
                .build();

    }
}
