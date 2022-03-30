package com.yi.timedate;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.Date;
import java.util.SimpleTimeZone;

public class TimenDate {


    @Test
    public void testDate(){

        Date date = new Date();

        System.out.println(date);

        long time = date.getTime();

        System.out.println(time);

        java.sql.Date date2 = new java.sql.Date(date.getTime());

        System.out.println(date2.toString());

    }

    @Test
    public void testSimpleDateFormat() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat();

        Date date = new Date();

        System.out.println(date);

        // Date - > String

        String format = sdf.format(date);
        System.out.println(format);

        //String - > Date

        String sdate = new String("8/23/21 4:21 PM");

        Date parse = sdf.parse(sdate);
        System.out.println(parse.toString());

    }

    @Test
    public void testSimpleDateFormat_dev() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ===()(()))()(= hh:mm:ss");

        String format = sdf.format(new Date());

        System.out.println(format);

        Date date = sdf.parse("2021-08-23 ===()(()))()(= 04:39:45");
        System.out.println(date);


    }

    @Test
    public void testSimpleDateFormat_practice() throws ParseException {

        // 2020-02-19 to java.sql.date

        String time = "2020-02-19";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date1 = sdf.parse(time);

        java.sql.Date date = new java.sql.Date(date1.getTime());

        System.out.println(date);

    }

    @Test
    public void JDK8_timeTest(){




        // Assigned locatdatetime to String;
        //Self defined
        LocalDateTime time_assigned = LocalDateTime.of(1999, 9, 9, 9, 9, 9);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy MM dd --- hh mm ss");

        String format = dateTimeFormatter.format(time_assigned);

        String format1 = dateTimeFormatter.format(LocalDateTime.now());

        System.out.println(format);

        // String --> LocalDateTime

        String time ="1999 09 09 --- 09 09 09";

        TemporalAccessor accessor = dateTimeFormatter.parse(time);

        System.out.println(accessor);



    }

    @Test
    public void JDK8_timeTest_standard_1(){

        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;

        String isoDateTime_String = isoDateTime.format(LocalDateTime.now());

        DateTimeFormatter isoLocalDateTime = DateTimeFormatter.BASIC_ISO_DATE;

        String isoLocalDateTime_String = isoLocalDateTime.format(LocalDateTime.now());


        System.out.println(isoDateTime_String);

        System.out.println(isoLocalDateTime_String);


    }


    @Test
    public void JDK8_timeTest_standard_2(){

        DateTimeFormatter format_medium = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        DateTimeFormatter format_long = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        DateTimeFormatter format_full = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        DateTimeFormatter format_short = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);


        String medium_string = format_medium.format(LocalDateTime.now());
        //String long_string = format_long.format(LocalDateTime.now());
        //String full_string = format_full.format(LocalDateTime.now());
        String short_string = format_short.format(LocalDateTime.now());

        System.out.println(short_string);
        System.out.println(medium_string);
        //System.out.println(long_string);
        //System.out.println(full_string);

        LocalDateTime localDateTime = LocalDateTime.now();

//        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
//        //格式化
//        String str2 = formatter1.format(localDateTime);
//        System.out.println(str2);
    }

    @Test
    public void LocalTimeDateZone(){

        LocalDateTime now = LocalDateTime.now(ZoneId.of("-05:00"));
        //LocalDateTime.now(ZoneId.of())
        System.out.println(now);

        LocalDateTime localDateTime = now.withDayOfMonth(30);

        System.out.println(localDateTime);

    }

    @Test
    public void TestInstant(){

        Instant now = Instant.now();
        Instant old_now = Instant.ofEpochSecond(1629917078); //static and called by class instant

        //now.getEpochSecond();

        long toEpochMilli = now.toEpochMilli(); // called by the object of class instant


        System.out.println(now);
        System.out.println(now.getEpochSecond());
        System.out.println(old_now);


    }

    @Test
    public void ZonedDateTime(){

        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("-08:00"));

        System.out.println(now);

        //Duration
        LocalDateTime now1 = LocalDateTime.of(2000,9,9,9,9,9);
        LocalDateTime localDateTime = LocalDateTime.of(1999, 9, 9, 9, 9, 9);

        Duration duration = Duration.between(now1,localDateTime);

        System.out.println(duration.toString());


        LocalDate localDate = LocalDate.of(1999, 9, 9);
        LocalDate localDate2 = LocalDate.of(2001, 9, 9);

        Period p = Period.between(localDate,localDate2);

        System.out.println(p.getDays());



    }

}
