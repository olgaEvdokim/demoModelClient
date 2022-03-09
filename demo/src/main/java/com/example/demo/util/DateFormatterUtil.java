package com.example.demo.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatterUtil {

    public static final String DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm";

    public static String parseDateToString(LocalDateTime dateTime) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
        return dateTime.format(format);
    }
}
