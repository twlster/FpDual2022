package edu.fpdual.ejemplo;

import lombok.Getter;

@Getter
public enum Hobbies {
    TROTAR(30, null),
    VIDEO_JUEGOS(160, "Shooter"),
    MONTAR_EN_BICI(60, "Montaña"),
    NADAR(30, "50m"),
    ESCUCHAR_MUSICA(60, null);

    private int minutos;
    private String modalidad;

    Hobbies(int minutos, String modalidad){
        this.minutos=minutos;
        this.modalidad = modalidad;
    }
}
