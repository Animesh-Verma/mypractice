package Basics;

import java.time.*;
import java.util.Date;

public class InbuiltMethodDateTime {
    public static void main(String[] args){

        long val = 1615814182;
        Date datee = new Date(val);
        System.out.println(datee);
        System.out.println(System.currentTimeMillis()/100);
        LocalDateTime date =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(val), ZoneOffset.UTC);
        System.out.println(date);
        LocalDate dat =
                Instant.ofEpochMilli(val).atZone(ZoneId.of("UTC")).toLocalDate();
        System.out.println(date);
    }

}
