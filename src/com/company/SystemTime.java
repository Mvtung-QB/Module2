package com.company;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class SystemTime {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.MONTH)+1);
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.getMonth());
    }
}