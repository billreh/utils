package net.tralfamadore;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

/**
 * Utilities class for dealing with dates.
 * Created by wreh on 5/2/2017.
 */
public class DateUtils {
    public static Date toDate(LocalDate localDate) {
        return toDate(localDate, ZoneId.systemDefault());
    }

    public static Date toDate(LocalDate localDate, ZoneId zoneId) {
        return Date.from(localDate.atStartOfDay(zoneId).toInstant());
    }

    public static Date toDate(LocalDateTime localDate) {
        return toDate(localDate, ZoneId.systemDefault());
    }

    public static Date toDate(LocalDateTime localDateTime, ZoneId zoneId) {
        return Date.from(localDateTime.atZone(zoneId).toInstant());
    }

    public static LocalDate toLocalDate(Date date) {
        return toLocalDate(date, ZoneId.systemDefault());
    }

    public static LocalDate toLocalDate(Date date, ZoneId zoneId) {
        return date.toInstant().atZone(zoneId).toLocalDate();
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        return toLocalDateTime(date, ZoneId.systemDefault());
    }

    public static LocalDateTime toLocalDateTime(Date date, ZoneId zoneId) {
        return date.toInstant().atZone(zoneId).toLocalDateTime();
    }

    public static Duration duration(Date start, Date end) {
        LocalDateTime localDateTimeStart = toLocalDateTime(start);
        LocalDateTime localDateTimeEnd = toLocalDateTime(end);
        return Duration.between(localDateTimeStart, localDateTimeEnd);
    }

    public static Period period(Date start, Date end) {
        LocalDate localDateStart = toLocalDate(start);
        LocalDate localDateEnd = toLocalDate(end);
        return Period.between(localDateStart, localDateEnd);
    }

    public static Date parseDate(String rawDate, String format) {
        try {
            return new SimpleDateFormat(format).parse(rawDate);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
