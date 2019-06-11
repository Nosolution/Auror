package org.seec.muggle.auror.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/11 17:34
 * @Version 1.0
 **/
public class DateUtil {
    public static String dateToString(Date input){
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
        return sdf.format(input);
    }

    public static Date stringToDate(String input){
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
        try {
            return sdf.parse(input);
        }catch (ParseException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static LocalDateTime stringToLocalDateTime(String input) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(input,df);
    }

    public static String localDateTimeToString(LocalDateTime input){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return df.format(input);
    }

    public static String timestampToString(Timestamp input){
        return localDateTimeToString(input.toLocalDateTime());
    }

    public static Timestamp stringToTimestamp(String input){
        LocalDateTime now = stringToLocalDateTime(input);
        return Timestamp.valueOf(now);
    }

    public static String TimestampToTimeString(Timestamp input){
        String in = timestampToString(input);
        return in.split(" ")[1];
    }

    public static Timestamp datesToTimestamp(Date year, LocalTime time){
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
        String yearStr = sdf.format(year);

        String totalTime = yearStr+" "+time.toString();
        return stringToTimestamp(totalTime);

    }
}
