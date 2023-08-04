package com.example.recetas_app;

public class Plato {
    String nombreImagen;
    String nombre;
    String descripcion;
    String ingredientesPrincipales;
    String preparacion;
    String precio;

    public Plato(String nombreImagen, String nombre, String descripcion, String ingredientesPrincipales, String preparacion, String precio) {
        this.nombreImagen = nombreImagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ingredientesPrincipales = ingredientesPrincipales;
        this.preparacion = preparacion;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + "\n" + descripcion;
    }
}
