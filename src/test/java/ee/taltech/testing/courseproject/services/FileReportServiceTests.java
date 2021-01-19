package ee.taltech.testing.courseproject.services;

import ee.taltech.testing.courseproject.configuration.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FileReportServiceTests {

    private static FileReportService fileReportService;
    private static Configuration configuration;
    private static FileWriter writer;

    @BeforeAll
    public static void setUp() throws IOException {
        fileReportService = new FileReportService();
        configuration = new Configuration();
        writer = new FileWriter(configuration.getWorkingFile());
    }

    @Test
    public void getReportsForAllCorrectCityInputs() throws IOException {

        List<String> cities = new ArrayList<>();
        cities.add("Tallinn");
        cities.add("Moscow");
        cities.add("London");

        for (String city : cities) {
            writer.write(city + System.lineSeparator());
        }
        writer.close();

        fileReportService.generateReports();

        for (String city : cities) {
            Path path = Paths.get(configuration.getWorkingPath() + city.toLowerCase() + ".json");
            assert(path.toFile().isFile());
        }
    }

    @Test
    public void getReportsWithInvalidAndValidCityNames() throws IOException {
        writer = new FileWriter(configuration.getWorkingFile());
        List<String> cities = new ArrayList<>();
        cities.add("Tallinn");
        cities.add("ZiguliCity");
        cities.add("London");
        cities.add("Bangladesh");
        cities.add("Skyrim");

        for (String city : cities) {
            writer.write(city + System.lineSeparator());
        }
        writer.close();

        fileReportService.generateReports();
        cities.remove("Skyrim");
        cities.remove("ZiguliCity");

        for (String city : cities) {
            Path path = Paths.get(configuration.getWorkingPath() + city.toLowerCase() + ".json");
            assert(path.toFile().isFile());
        }
    }

    @Test
    public void validateReportMainData() throws IOException {
        writer = new FileWriter(configuration.getWorkingFile());
        writer.write("Narva");
        writer.close();

        fileReportService.generateReports();

        Path path = Paths.get(configuration.getWorkingPath() + "narva.json");

        String result = Files.readAllLines(path, StandardCharsets.UTF_8).get(0);

        assertThat(result).contains("\"city\":\"Narva\"");
        assertThat(result).contains("\"coordinates\":\"59.38, 28.19\"");
    }

}
