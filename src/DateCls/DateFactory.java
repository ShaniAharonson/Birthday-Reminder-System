package DateCls;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFactory {
    // return random date
    public static LocalDate getLocalDate() {
        int day = (int) (Math.random() * 28 + 1);
        int month = (int) (Math.random() * 12 + 1);
        int year = (int) (Math.random() * 51 + 1960); //1960-2010
        LocalDate date = LocalDate.of(year, month, day);
        return date;
    }

    public static String changeFormat(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
