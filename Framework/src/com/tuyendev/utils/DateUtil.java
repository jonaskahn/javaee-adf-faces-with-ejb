package com.tuyendev.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * <h1>DateUtil</h1>
 * This s a util class that supply some ways to validate,covert Datetime before use.
 * Class was made by so many authors, I just recompile and optimize this.
 *
 * @author tuyendev
 * @version 1.0
 * @since 8/24/2017
 */

public class DateUtil {

    /**
     * @param strDate
     * @param pattern
     * @return
     */
    public static Date stringToDateByPattern(String strDate, String pattern) {
        return localDateToDate(LocalDate.parse(strDate, DateTimeFormatter.ofPattern(pattern)));
    }

    /**
     * @param date
     * @param pattern
     * @return
     */
    public static String dateToStringByPattern(Date date, String pattern) {
        return localDateToStringByPattern(dateToLocalDate(date), pattern);
    }

    /**
     * @param strDate
     * @param pattern
     * @return
     */
    public static LocalDate stringToLocalDateByPattern(String strDate, String pattern) {
        return LocalDate.parse(strDate, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * @param localDate
     * @param pattern
     * @return
     */
    public static String localDateToStringByPattern(LocalDate localDate, String pattern) {
        return localDate.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * @param localDate
     * @return
     */
    public static Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * @param date
     * @return
     */
    public static LocalDate dateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isAfer(Date date1, Date date2) {
        LocalDate localDate1 = dateToLocalDate(date1);
        LocalDate localDate2 = dateToLocalDate(date2);
        return localDate1.isAfter(localDate2);
    }

    /**
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isBefore(Date date1, Date date2) {
        LocalDate localDate1 = dateToLocalDate(date1);
        LocalDate localDate2 = dateToLocalDate(date2);
        return localDate1.isBefore(localDate2);
    }

    /**
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isEqual(Date date1, Date date2) {
        LocalDate localDate1 = dateToLocalDate(date1);
        LocalDate localDate2 = dateToLocalDate(date2);
        return localDate1.isEqual(localDate2);
    }

    /**
     * @param value
     * @return
     */
    public static String date2MMyyyyStringWithSplash(Date value) {
        return dateToStringByPattern(value, "MM/yyyy");
    }

    /**
     * @param value
     * @return
     */
    public static String date2MMyyyyStringNoPartition(Date value) {
        return dateToStringByPattern(value, "MMyyyy");
    }

    /**
     * @param value
     * @return
     */
    public static String date2ddMMyyyyStringNoPartition(Date value) {
        return dateToStringByPattern(value, "ddMMyyyy");
    }

    /**
     * @param value
     * @return
     */
    public static String date2ddMMyyyyStringWithSplash(Date value) {
        return dateToStringByPattern(value, "dd/MM/yyyy");
    }

    /**
     * @param value
     * @return
     */
    public static String date2yyyyMMddHHStringNoPartition(Date value) {
        return dateToStringByPattern(value, "yyyyMMddHH");
    }

    /**
     * @param value
     * @return
     */
    public static String date2yyyyMMddHHStringWithSplash(Date value) {
        return dateToStringByPattern(value, "yyyy/MM/dd HH");
    }

    /**
     * @param value
     * @return
     */
    public static String date2yyyyMMddStringWithSplash(Date value) {
        return dateToStringByPattern(value, "yyyy/MM/dd");
    }

    /**
     * @param value
     * @return
     */
    public static String date2yyyyMMddStringNoPartition(Date value) {
        return dateToStringByPattern(value, "yyyyMMdd");
    }

    /**
     * @param value
     * @return
     */
    public static String date2yyyyMMddHHmmssStringNoPartition(Date value) {
        return dateToStringByPattern(value, "yyyyMMddHHmmss");
    }

    /**
     * @param value
     * @return
     */
    public static String date2yyyyMMddHHmmssStringWithSplash(Date value) {
        return dateToStringByPattern(value, "yyyy/MM/dd HH:mm:ss");
    }

    /**
     * @param value
     * @return
     */
    public static String date2yyyyMMddHHmmssStringWithDash(Date value) {
        return dateToStringByPattern(value, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @param value
     * @return
     */
    public static String date2MMddStringWithSplash(Date value) {
        return dateToStringByPattern(value, "MM/dd");
    }

    /**
     * @param value
     * @return
     */
    public static String date2MMddStringNoPartition(Date value) {
        return dateToStringByPattern(value, "MMdd");
    }

    /**
     * @param value Date
     * @return String
     */
    public static String date2HHMMssNoPartition(Date value) {
        return dateToStringByPattern(value, "HHmmss");
    }

    /**
     * @param value Date
     * @return String
     */
    public static String date2HHMMssWithColon(Date value) {
        return dateToStringByPattern(value, "HH:mm:ss");
    }

    /**
     * @param value Date
     * @return String
     */
    public static String date2ddMMyyyyHHMMssNoPartition(Date value) {
        return dateToStringByPattern(value, "ddMMyyyyHHmmss");
    }

    /**
     * @param value
     * @return
     */
    public static String date2yyyyMMddStringWithDash(Date value) {
        return dateToStringByPattern(value, "yyyy-MM-dd");
    }

    /**
     * @param before
     * @param after
     * @return
     */
    public static long countLiteralDaysBetween(LocalDate before, LocalDate after) {
        return Duration.between(before.atStartOfDay(), after.atStartOfDay()).toDays();
    }

    /**
     * @param before
     * @param after
     * @return
     */
    public static long countDaysBetween(LocalDate before, LocalDate after) {
        return ChronoUnit.DAYS.between(before, after);
    }

    /**
     * @param before
     * @param after
     * @return
     */
    public static long countMonthsBetween(LocalDate before, LocalDate after) {
        return ChronoUnit.MONTHS.between(before, after);
    }

    /**
     * @param before
     * @param after
     * @return
     */
    public static long countYearsBetween(LocalDate before, LocalDate after) {
        return ChronoUnit.YEARS.between(before, after);
    }

    /**
     * @param date1
     * @param date2
     * @return
     */
    public static long countDaysBetween(Date date1, Date date2) {
        return countDaysBetween(dateToLocalDate(date1), dateToLocalDate(date2));
    }

    /**
     * @param date1
     * @param date2
     * @return
     */
    public static long countMonthsBetween(Date date1, Date date2) {
        return countMonthsBetween(dateToLocalDate(date1), dateToLocalDate(date2));
    }

    /**
     * @param date1
     * @param date2
     * @return
     */
    public static long countYearsBetween(Date date1, Date date2) {
        return countYearsBetween(dateToLocalDate(date1), dateToLocalDate(date2));
    }

    /**
     * @param day integer
     * @return Date
     */
    public static Date nextDate(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE) + day, 0, // hour
                0, // min
                0); // sec
        /**
         * clear millisecond field
         */
        calendar.clear(Calendar.MILLISECOND);
        return calendar.getTime();
    }

    /**
     * @param date Date
     * @param day  integer
     * @return Date
     */
    public static Date nextDate(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE) + day, 0, // hour
                0, // min
                0); // sec
        /**
         * clear millisecond field
         */
        calendar.clear(Calendar.MILLISECOND);
        return calendar.getTime();
    }

    /**
     * get the next n month.
     *
     * @param date  Date
     * @param month number of next month
     * @return Date
     */
    public static Date nextMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + month,
                calendar.get(Calendar.DATE),
                0, // hour
                0, // min
                0); // sec
        /**
         * clear millisecond field
         */
        calendar.clear(Calendar.MILLISECOND);
        return calendar.getTime();
    }

    public static Date nextMonthDateTime(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    /**
     * get the previos n month
     *
     * @param date  Date
     * @param month integer
     * @return Date
     */
    public static Date getPreMonthDate(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) - month,
                calendar.get(Calendar.DATE),
                0, // hour
                0, // min
                0); // sec
        /**
         * clear millisecond field
         */
        calendar.clear(Calendar.MILLISECOND);
        return calendar.getTime();

    }

    public static boolean greaterOrEqualsByDateOfMonth(Date date1, Date date2) {
        return greaterOrEquals(date1, date2, Calendar.DAY_OF_MONTH);
    }

    public static boolean greaterOrEqualsByDateOfWeek(Date date1, Date date2) {
        return greaterOrEquals(date1, date2, Calendar.DAY_OF_WEEK);
    }

    public static boolean greaterOrEqualsByDateOfWeekInMonth(Date date1, Date date2) {
        return greaterOrEquals(date1, date2, Calendar.DAY_OF_WEEK_IN_MONTH);
    }

    public static boolean greaterOrEqualsByDateOfYear(Date date1, Date date2) {
        return greaterOrEquals(date1, date2, Calendar.DAY_OF_YEAR);
    }

    public static boolean greaterOrEqualsByMonth(Date date1, Date date2) {
        return greaterOrEquals(date1, date2, Calendar.MONTH);
    }

    public static boolean lowerOrEqualsByDateOfMonth(Date date1, Date date2) {
        return greaterOrEquals(date2, date1, Calendar.DAY_OF_MONTH);
    }

    public static boolean lowerOrEqualsByDateOfWeek(Date date1, Date date2) {
        return greaterOrEquals(date2, date1, Calendar.DAY_OF_WEEK);
    }

    public static boolean lowerOrEqualsByDateOfWeekInMonth(Date date1, Date date2) {
        return greaterOrEquals(date2, date1, Calendar.DAY_OF_WEEK_IN_MONTH);
    }

    public static boolean lowerOrEqualsByDateOfYear(Date date1, Date date2) {
        return greaterOrEquals(date2, date1, Calendar.DAY_OF_YEAR);
    }

    public static boolean lowerOrEqualsByMonth(Date date1, Date date2) {
        return greaterOrEquals(date2, date1, Calendar.MONTH);
    }

    public static boolean greaterOrEquals(String strDate1, String strDate2, String pattern, int type) {
        Date date1 = stringToDateByPattern(strDate1, pattern);
        Date date2 = stringToDateByPattern(strDate2, pattern);
        return greaterOrEquals(date1, date2, type);
    }

    public static boolean lowerOrEquals(String strDate1, String strDate2, String pattern, int type) {
        return greaterOrEquals(strDate2, strDate1, pattern, type);
    }

    private static boolean greaterOrEquals(Date date1, Date date2, int type) {
        return date1.compareTo(date2) > 0 || equals(date1, date2, type);
    }

    private static boolean equals(Date date1, Date date2, int type) {
        return equalOnlyField(date1, date2, type) && equalOnlyField(date1, date2, Calendar.YEAR);
    }

    private static boolean equalOnlyField(Date date1, Date date2, int type) {
        if (date1 == null || date2 == null) {
            return false;
        }
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date1);
        c2.setTime(date2);
        return c1.get(type) == c2.get(type);

    }

}
