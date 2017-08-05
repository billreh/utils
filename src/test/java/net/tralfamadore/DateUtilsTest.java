package net.tralfamadore;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

/**
 * Test DateUtils.
 * Created by wreh on 5/2/2017.
 */
public class DateUtilsTest {
    @Test
    public void testToDate() throws Exception {
        Date date = new Date();
        System.out.println(date);
        LocalDate localDate = DateUtils.toLocalDate(date);
        System.out.println(localDate);
        LocalDateTime localDateTime = DateUtils.toLocalDateTime(date);
        System.out.println(localDateTime);
        Date date1 = DateUtils.toDate(localDateTime);
        System.out.println(date1);
        assertEquals(date, date1);
    }

    @Test
    public void testParseDate() throws Exception {
        Date date = DateUtils.parseDate("201708051119", "yyyyMMddHHmm");

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR);
        assertEquals(2017, year);

        // Add one to month {0 - 11}
        int month = calendar.get(Calendar.MONTH) + 1;
        assertEquals(8, month);

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        assertEquals(5, day);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        assertEquals(11, hour);

        int minute = calendar.get(Calendar.MINUTE);
        assertEquals(19, minute);
    }
}
