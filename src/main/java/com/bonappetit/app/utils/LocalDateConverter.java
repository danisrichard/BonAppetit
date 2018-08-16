package com.bonappetit.app.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class LocalDateConverter {

    public static String localDateTimeToString(LocalDate localDateTime){
        final DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return outputFormat.format(localDateTime);
    }

    public static LocalDateTime stringToLocalDateTime(String date){
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date,formatter).atStartOfDay();
    }
}
