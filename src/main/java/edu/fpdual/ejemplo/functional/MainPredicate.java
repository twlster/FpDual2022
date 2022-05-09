package edu.fpdual.ejemplo.functional;

import java.util.function.Predicate;

public class MainPredicate {

    public static void main(String[] args) {

        Predicate<String> stringPredicate = t -> t.startsWith("A") || t.toLowerCase().startsWith("a");

        boolean validationReturn = stringPredicate.test("Veronica");

        System.out.println(validationReturn);

        validationReturn = stringPredicate.test("Alejandro");

        System.out.println(validationReturn);

        validationReturn = stringPredicate.test("Ismael");

        System.out.println(validationReturn);

        validationReturn = stringPredicate.test("Natalia");

        System.out.println(validationReturn);

        validationReturn = stringPredicate.test("Antonio");

        System.out.println(validationReturn);


    }
}
