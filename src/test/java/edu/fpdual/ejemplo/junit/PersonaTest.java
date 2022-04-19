package edu.fpdual.ejemplo.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PersonaTest {

    Persona persona;

    @BeforeAll
    public static void initAll(){
        System.out.println("========BeforeAll========");
    }

    @BeforeEach
    public void init(){
        System.out.println("========BeforeEach========");
        persona = new Persona();
        persona.setNombre("JOSE");
        persona.setApellido("Prieto");
        persona.setEdad(32);
        persona.setFechaNacimiento(LocalDate.of(1989,05,19));
    }

    @AfterEach
    public void destroy(){
        System.out.println("========DestroyEach========");
        persona = null;
    }

    @AfterAll
    public static void destroyAll(){
        System.out.println("========DestroyAll========");
    }

    @Test
    public void setNombre_ok(){
    }

    @Test
    public void setNombre_ko(){
    }

}
