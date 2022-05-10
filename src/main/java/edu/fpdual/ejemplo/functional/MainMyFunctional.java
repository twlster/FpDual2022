package edu.fpdual.ejemplo.functional;

public class MainMyFunctional {

    public static void main(String[] args) {
        InterfazFuncional<Integer, Double> operacion = value -> (double) (value / 2);

        System.out.println(operacion.operar(4));
        System.out.println(operacion.operar(1452));

    }
}
