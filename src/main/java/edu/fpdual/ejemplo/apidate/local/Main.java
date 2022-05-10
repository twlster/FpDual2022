package edu.fpdual.ejemplo.apidate.local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class Main {


    public static void main(String[] args) {

        localDateTime();

    }

    private static void localDate() {
        LocalDate fechaActual = LocalDate.of(2022,5,9);
        LocalDate fechaActualPrecisa = LocalDate.now();
        LocalDate fechaDesdeString = LocalDate.parse("2022-05-10");

        System.out.println(fechaActual);
        System.out.println(fechaActualPrecisa);
        System.out.println(fechaDesdeString);

        System.out.println(fechaActual.isEqual(fechaDesdeString));
        System.out.println(ChronoUnit.DAYS.between(fechaActual, fechaDesdeString));
    }

    private static void localDateTime() {
        LocalDateTime fechaActual = LocalDateTime.now();//LocalDateTime.of(2022,5,10,10,37,15);
        LocalDateTime fechaActualPrecisa = LocalDateTime.now();
        LocalDateTime fechaDesdeString = LocalDateTime.parse("2022-05-10T00:00");

        System.out.println(fechaActual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        System.out.println(fechaActualPrecisa.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));
        System.out.println(fechaDesdeString);

        System.out.println(fechaActual.isBefore(fechaActualPrecisa));
    }

    private static void localTime() {
        LocalTime fechaActual = LocalTime.of(13,3,44);
        LocalTime fechaActualPrecisa = LocalTime.now();
        LocalTime fechaDesdeString = LocalTime.parse("13:03:50");

        System.out.println(fechaActual);
        System.out.println(fechaActualPrecisa);
        System.out.println(fechaDesdeString);

        System.out.println(fechaActual.isBefore(fechaActualPrecisa));
    }

}
