package ee.taltech.testing.courseproject.DTO;

import lombok.Builder;
import lombok.Getter;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Getter
public class DateDTO {
    private final Date date;

    private static final long SECONDS_TO_MILLISECONDS = 1000;

    public DateDTO(long date) {
        this.date = new Date(date * SECONDS_TO_MILLISECONDS);
    }

    public String getFormattedDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
}
