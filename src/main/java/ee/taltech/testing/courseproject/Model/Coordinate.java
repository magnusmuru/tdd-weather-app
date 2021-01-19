package ee.taltech.testing.courseproject.Model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Coordinate {

    public String getCoordinatesAsString(double inputLongitude, double inputLatitude) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setDecimalFormatSymbols(symbols);

        return decimalFormat.format(inputLatitude) + ", " + decimalFormat.format(inputLongitude);
    }
}
