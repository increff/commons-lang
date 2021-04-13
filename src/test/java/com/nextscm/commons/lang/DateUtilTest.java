package com.nextscm.commons.lang;

import org.junit.Test;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class DateUtilTest {


    @Test
    public void testBetween() {
        String ld1 = "2019-07-26";
        String ld2 = "2018-12-11";
        String ld3 = "2019-03-15";
        String ld4 = "2019-03-15";
        String ld5 = "2019-15-06";
        assertTrue(DateUtil.between(ld3, ld2, ld1));
        assertFalse(DateUtil.between(ld3, ld1, ld2));
        assertTrue(DateUtil.between(ld4, ld3, ld1));
        try {
            DateUtil.between(ld5, ld3, ld1);
        } catch (DateTimeParseException e) {
            assertEquals("Text '2019-15-06' could not be parsed: Invalid value for MonthOfYear (valid values 1 - 12): 15", e.getMessage());
        }
    }

    @Test
    public void testGetStartDateWithPositiveDuration() {
        String startDate = DateUtil.getStartDate("2019-08-03", 56);
        assertEquals("2019-06-08", startDate);
    }
    
    @Test
    public void testGetStartDateWithNegativeDuration() {
        String startDate = DateUtil.getStartDate("2019-08-03", -80);
        assertEquals("2019-10-22", startDate);
    } 
    
    @Test
    public void testGetStartDateWithInvalidInputDate() {
        try {
            DateUtil.getStartDate("2019-15-06", 34);
        } catch (DateTimeParseException e) {
            assertEquals("Text '2019-15-06' could not be parsed: Invalid value for MonthOfYear (valid values 1 - 12): 15", e.getMessage());
        }
    }

    @Test
    public void testGetDateForMonth() {
        Date date = DateUtil.getDateForMonth(10, 1997);
        assertEquals(1, date.getDate());
        assertEquals(9, date.getMonth());
        assertEquals(97, date.getYear());
    }

    @Test
    public void testGetDateForMonthWithNegativeMonth () {
        Date date = DateUtil.getDateForMonth(-1, 1997);
        assertEquals(1, date.getDate());
        assertEquals(10, date.getMonth());
        assertEquals(96, date.getYear());
    }

    @Test
    public void testGetLocalDateForMonth() {
        LocalDate date = DateUtil.getLocalDateForMonth(10, 1997);
        LocalDate expectedDate = LocalDate.of(1997, 10, 1);
        assertTrue(date.isEqual(expectedDate));
    }

    @Test
    public void testIsBetween() {
        YearMonth startMonth = YearMonth.of(2000, 1);
        YearMonth endMonth = YearMonth.of(2001, 5);

        assertTrue(DateUtil.isBetween(YearMonth.of(2000, 5), startMonth, endMonth));
        assertTrue(DateUtil.isBetween(YearMonth.of(2000, 1), startMonth, endMonth));
        assertTrue(DateUtil.isBetween(YearMonth.of(2001, 5), startMonth, endMonth));

        assertFalse(DateUtil.isBetween(YearMonth.of(2005, 5), startMonth, endMonth));
    }

}
