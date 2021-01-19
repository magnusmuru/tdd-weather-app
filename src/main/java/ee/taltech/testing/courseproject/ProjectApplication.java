package ee.taltech.testing.courseproject;

import ee.taltech.testing.courseproject.exceptions.InvalidInputPathException;
import ee.taltech.testing.courseproject.services.FileReadWriteService;
import ee.taltech.testing.courseproject.services.FileReportService;
import lombok.AllArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
@AllArgsConstructor
public class ProjectApplication implements ApplicationRunner {

    static Log log = LogFactory.getLog(ProjectApplication.class.getName());
    private final FileReportService fileReportService;

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        try {
            fileReportService.generateReports();
            log.info("Successfully generated Weather reports for existing cities");
        } catch (InvalidInputPathException | IOException e) {
            log.error("No weather reports were generated");
        }
    }

}
