package ee.taltech.testing.courseproject.services;

import ee.taltech.testing.courseproject.API.WeatherAPI;
import ee.taltech.testing.courseproject.configuration.Configuration;
import ee.taltech.testing.courseproject.exceptions.InvalidInputPathException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileReadWriteService {

    private final WeatherReportService weatherReportService = new WeatherReportService(new WeatherAPI());
    private final Configuration configuration = new Configuration();
    static Log log = LogFactory.getLog(FileReadWriteService.class.getName());

    public List<String> getInputFileContents() throws InvalidInputPathException, IOException {
        if (!configuration.getWorkingFile().endsWith(".txt")) {
            String errorMessage = "Invalid input format, please use input.txt";
            throw new InvalidInputPathException(errorMessage);
        }
        Path path = Paths.get(configuration.getWorkingFile());

        if (path.toFile().isFile()) {
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        } else {
            throw new InvalidInputPathException("File not present, please add input.txt to input folder");
        }
    }

    public void writeWeatherReport(String cityName) {
        String filePath = configuration.getWorkingPath() + cityName.toLowerCase() + ".json";
        if (new File(filePath).exists()) {
            log.info("File already exists, overwriting!");
        }
        try {
            String outputJson = weatherReportService.fetchWeatherReport(cityName);
            FileWriter writer = new FileWriter(filePath);
            writer.write(outputJson);
            writer.close();
            log.info("Weather report generated for city " + cityName);
        } catch (Exception e) {
            log.error("Failed to get weather report for city " + cityName);
        }
    }
}
