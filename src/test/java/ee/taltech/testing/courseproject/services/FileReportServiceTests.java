package ee.taltech.testing.courseproject.services;

import ee.taltech.testing.courseproject.configuration.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReportServiceTests {

    @AfterEach


    @Test
    public void getReportsForAllCorrectCityInputs() throws IOException {
        FileReportService fileReportService = new FileReportService();
        Configuration configuration = new Configuration();
        FileWriter writer = new FileWriter(configuration.getWorkingFile());

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
        FileReportService fileReportService = new FileReportService();
        Configuration configuration = new Configuration();
        FileWriter writer = new FileWriter(configuration.getWorkingFile());

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
        FileReportService fileReportService = new FileReportService();
        Configuration configuration = new Configuration();
        FileWriter writer = new FileWriter(configuration.getWorkingFile());
        writer.write("Narva");

    }

}
