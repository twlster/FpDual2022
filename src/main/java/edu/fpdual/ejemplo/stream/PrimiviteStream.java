package edu.fpdual.ejemplo.stream;

import edu.fpdual.ejemplo.Persona;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

public class PrimiviteStream {

    public static void main(String[] args) {

        int[] integers = new int[3];

        integers[0] = 20;
        integers[1] = 18;
        integers[2] = 45;

        System.out.println(IntStream.of(integers).count());

        System.out.println("-----------------------------------------------");

        IntStream.of(integers).filter(integer -> integer <= 30).sorted().forEach(System.out::println);
        IntStream.of(integers).anyMatch(integer -> integer <= 30);

        System.out.println("-----------------------------------------------");

        Function<Integer, Integer> consumer = data -> {return (data*-1);};

        IntStream.range(0, 12).map(consumer::apply).sorted().map(consumer::apply).forEach(System.out::println);

    }

}
