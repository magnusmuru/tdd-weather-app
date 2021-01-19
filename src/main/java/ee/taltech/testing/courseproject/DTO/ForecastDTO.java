package ee.taltech.testing.courseproject.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ee.taltech.testing.courseproject.Model.ForecastReport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDTO {
    private int cod;
    private Object message;
    private List<ForecastItemDTO> list;
}
