package com.accesoficherosxml.tema01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Libro {
    private final String isbn;
    private final String titulo;
    private final String nombre;
    private final LocalDate fechaNacimiento;
    private final int anio;
    private final List<String> generos;
    private final boolean disponible;



    public Libro(String isbn, String titulo, String nombre, LocalDate fechaNacimiento,int  anio, List<String> generos, boolean disponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.anio = anio;
        this.generos = (generos != null) ? generos : new ArrayList<>();
        this.disponible = disponible;

    }


    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public int getAnio() {
        return anio;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Libro libro)) return false;
        return Objects.equals(isbn, libro.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, titulo, nombre, fechaNacimiento,anio, generos, disponible);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", año=" + anio +
                ", generos='" + generos +
                ", disponible=" + disponible +
                '}';
    }

}
