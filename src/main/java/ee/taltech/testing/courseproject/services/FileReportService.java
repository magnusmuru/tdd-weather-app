package ee.taltech.testing.courseproject.services;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FileReportService {

    private FileReadWriteService fileReadWriteService = new FileReadWriteService();

    public void generateReports() throws IOException {
        List<String> cityNames = fileReadWriteService.getInputFileContents();
        for (String city : cityNames) {
            fileReadWriteService.writeWeatherReport(city);
        }
    }
}
