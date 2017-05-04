package net.tralfamadore;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
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
}
