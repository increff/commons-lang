package com.nextscm.commons.lang;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Utility for performing Date-Time related operations
 */
public class DateUtil {

    /**
     * Check if a date lies within a range (inclusive)
     * @param date Date which to check (in YYYY-MM-DD format)
     * @param startDate Start of date range
     * @param endDate End of date range
     * @return true if date in range, false otherwise
     */
    public static boolean between(String date, String startDate, String endDate) {
        LocalDate startDt = LocalDate.parse(startDate);
        LocalDate endDt = LocalDate.parse(endDate);
        LocalDate day = LocalDate.parse(date);
        return between(day, startDt, endDt);
    }

    public static boolean between(LocalDate day, LocalDate startDate, LocalDate endDate) {
        return ((day.isBefore(endDate) || day.isEqual(endDate)) && (day.isAfter(startDate) || day.isEqual(startDate)));
    }

    /**
     * Get the date a certain duration before/after the specified date
     * @param endDate Date from which to start (in YYYY-MM-DD format)
     * @param durationInDays Duration by which to look forwards/backwards in days
     * @return Date string corresponding after the duration specified
     */
    public static String getStartDate(String endDate, int durationInDays) {
        return LocalDate.parse(endDate).minusDays(durationInDays).toString();
    }

    /**
     * Adds the specified number of months to the specified year to get the date
     * @param month month (1-January, 12-December)
     * @param year year in YYYY format
     * @return Converted Date object
     */
    public static Date getDateForMonth(int month, int year) {
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, 1, 0, 0);
        return c.getTime();
    }

    /**
     * Convert a provided month, year to LocalDate object (Assuming first day of month)
     * @param month month (1-January, 12-December)
     * @param year year in YYYY format
     * @return Converted LocalDate object
     */
    public static LocalDate getLocalDateForMonth(int month, int year) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String prefix = month < 10 ? "0" : "";
        String date = "1/" + prefix + (month) + "/" + year;
        return LocalDate.parse(date, formatter);
    }

    /**
     * Check if a month is within a range (inclusive)
     * @param yearMonth YearMonth object to be checked
     * @param startYearMonth Start of range
     * @param endYearMonth End of range
     * @return true if target belongs to range, false otherwise
     */
    public static boolean isBetween(YearMonth yearMonth ,YearMonth startYearMonth, YearMonth endYearMonth)
    {
        return !(yearMonth.isAfter(endYearMonth) || yearMonth.isBefore(startYearMonth));
    }

}
