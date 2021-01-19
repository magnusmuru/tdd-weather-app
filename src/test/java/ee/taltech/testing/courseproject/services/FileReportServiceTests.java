package ee.taltech.testing.courseproject.services;

import ee.taltech.testing.courseproject.configuration.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReportServiceTests {

    private static FileReportService fileReportService;
    private static Configuration configuration;

    @BeforeEach
    public static void setUp() {
        fileReportService = new FileReportService();
        configuration = new Configuration();
    }

    @Test
    public void getReportsForAllCorrectCityInputs() throws IOException {
        String filePath = configuration.getWorkingFile();
        FileWriter writer = new FileWriter(filePath);

        List<String> cities = new ArrayList<>();
        cities.add("Tallinn");
        cities.add("Moscow");
        cities.add("London");

        for (String city : cities) {
            writer.write(city + System.lineSeparator());
        }

        fileReportService.generateReports();

        for (String city : cities) {
            Path path = Paths.get(configuration.getWorkingPath() + city.toLowerCase() + ".json");
            assert(path.toFile().isFile());
        }
    }

}
