package edu.fpdual.ejemplo.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
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
        Assumptions.assumeTrue(persona != null);
        String nombre = "Mesa";
        persona.setNombre(nombre.toUpperCase());
        Assertions.assertEquals(nombre, persona.getNombre());
    }

    @Test
    public void setApellido_ok(){
        Assumptions.assumeTrue(persona != null);
        String apellido = "Mesa";
        persona.setApellido(apellido.toUpperCase());
        Assertions.assertEquals(apellido.toUpperCase(), persona.getApellido());
    }

    @Test
    public void setNombre_ko(){
        Assertions.assertThrows(NullPointerException.class, () -> persona.setNombre(null));
    }

}
