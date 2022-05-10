package edu.fpdual.ejemplo.stream;

import edu.fpdual.ejemplo.Hobbies;
import edu.fpdual.ejemplo.Persona;
import edu.fpdual.ejemplo.Sexo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollection {

    public static void main(String[] args) {

        Persona[] personas = new Persona[3];

        personas[0] =
                Persona.builder().nombre("Alejandro").sexo(Sexo.MASCULINO).edad(20).direccion("Periana").hobbies(Collections.singletonList(Hobbies.ESCUCHAR_MUSICA)).build();
        personas[1] =
                Persona.builder().nombre("Natalia").sexo(Sexo.FEMENINO).edad(45).direccion("Cártama").hobbies(Collections.singletonList(Hobbies.NADAR)).build();
        personas[2] =
                Persona.builder().nombre("Veronica").sexo(Sexo.FEMENINO).edad(18).direccion("Málaga").hobbies(Collections.singletonList(Hobbies.TROTAR)).build();

//        imprimirNombres(personas);
//        agruparPorSexo(personas);
        imprimirHobbies(personas);

    }

    private static Map<Sexo, List<Persona>> agruparPorSexo(Persona[] personas) {
        List<Persona> personaList = Arrays.asList(personas);

//        Forma tradicional sin usar streams.
//        Map<Sexo, List<Persona>> mapa = new HashMap<>();

//        for (Persona per: personaList) {
//            if(mapa.get(per.getSexo())!=null){
//                List<Persona> lista = mapa.get(per.getSexo());
//                lista.add(per);
//                mapa.put(per.getSexo(), lista);
//            }else{
//                List<Persona> lista = new ArrayList<>();
//                lista.add(per);
//                mapa.put(per.getSexo(), lista);
//            }
//        }

        Map<Sexo, List<Persona>> mapa = personaList.stream().collect(Collectors.groupingBy(Persona::getSexo));

        System.out.println(mapa.get(Sexo.MASCULINO));
        System.out.println("--------------------------------------------------------");
        System.out.println(mapa.get(Sexo.FEMENINO));

        return mapa;
    }

    private static void imprimirNombres(Persona[] personas) {

        List<Persona> personaList = Arrays.asList(personas);

//        Forma tradicional sin usar streams.
//        List<String> nameList = new ArrayList<>();
//
//        for (Persona per : personaList) {
//            nameList.add(per.getNombre());
//        }

        List<String> nameList = personaList.stream().map(Persona::getNombre).collect(Collectors.toList());

        nameList.forEach(System.out::println);
    }

    private static void imprimirHobbies(Persona[] personas){

//        Forma tradicional sin usar streams.
//        List<Hobbies> hobbies = new ArrayList<>();
//        for(Persona per : personas){
//            hobbies.addAll(per.getHobbies());
//        }
//        System.out.println(hobbies);

        List<Persona> personaList = Arrays.asList(personas);
        //List<List<Hobbies>> hobbies = personaList.stream().map(persona -> persona.getHobbies()).collect(Collectors.toList());
        List<Hobbies> hobbies = personaList.stream().flatMap(persona -> persona.getHobbies().stream()).collect(Collectors.toList());
        System.out.println(hobbies);


    }
}
