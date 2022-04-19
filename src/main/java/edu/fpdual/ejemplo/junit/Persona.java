package edu.fpdual.ejemplo.junit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private int edad;

    public void setNombre(String nombre){
        this.nombre = nombre.length() <= 1 ? nombre.toUpperCase() :
                nombre.substring(0,1).toUpperCase() + nombre.substring(1).toLowerCase();
    }

}
