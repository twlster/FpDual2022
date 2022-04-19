package edu.fpdual.ejemplo.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;

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
        persona.setFechaNacimiento(LocalDate.of(1989,5,19));
        persona.setHobbies(Arrays.asList("Trotar", "Video juegos", "Montar en bici"));
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
        Assertions.assertAll(
                () -> Assertions.assertEquals(nombre, persona.getNombre()),
                () -> Assertions.assertEquals("Prieto", persona.getApellido()),
                () -> Assertions.assertEquals(32, persona.getEdad()));
    }

    @Test
    public void setApellido_ok(){
        Assumptions.assumeTrue(persona != null);
        String apellido = "Mesa";
        persona.setApellido(apellido.toUpperCase());
        Assertions.assertEquals(apellido.toUpperCase(), persona.getApellido());
    }

    @Test
    public void setEdad_ok(){
        Assumptions.assumeTrue(persona != null);
        int nuevaEdad = 33;
        persona.setEdad(nuevaEdad);
        assertThat(persona.getEdad(), closeTo(34, 1));
    }

    @Test
    public void setHobbies_ok(){
        Assumptions.assumeTrue(persona != null);
        List<String> nuevosHobbies = Arrays.asList("Trotar", "Video juegos", "Montar en bici", "Nadar");
        persona.setHobbies(nuevosHobbies);
        assertThat(persona.getHobbies(), is(nuevosHobbies));
    }

    @Test
    public void setFechaNacimiento_ok(){
        Assumptions.assumeTrue(persona != null);
        LocalDate nuevaFecha = LocalDate.of(2006,4,24);
        persona.setFechaNacimiento(nuevaFecha);
        assertThat(persona.getFechaNacimiento(), is(nuevaFecha));
    }

    @Test
    public void allArgConstructor_ok(){
        Assumptions.assumeTrue(persona != null);
        Persona persona2 = new Persona(persona.getNombre(), persona.getApellido(),  persona.getFechaNacimiento(),
                persona.getEdad(), persona.getHobbies());
        assertThat(persona, is(persona2));
    }

    @Test
    public void setNombre_ko(){
        Assertions.assertThrows(NullPointerException.class, () -> persona.setNombre(null));
    }

}
