package com.boostudy.danielarguello.boostudy;


public class Anime {
    private int imagen;
    private String nombre;


    public Anime(int imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }


    public int getImagen() {
        return imagen;
    }
}
