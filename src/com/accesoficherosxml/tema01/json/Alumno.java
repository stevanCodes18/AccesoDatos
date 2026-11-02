package com.accesoficherosxml.tema01.json;

import java.time.LocalDate;
import java.util.Objects;

public class Alumno {

    private final String id;

    private final String nombre;

    private final boolean matriculado;

    private final LocalDate fechaNacimiento;


    public Alumno(String id, String nombre, boolean matriculado, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.matriculado = matriculado;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isMatriculado() {
        return matriculado;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Alumno alumno)) return false;
        return matriculado == alumno.matriculado && Objects.equals(id, alumno.id) && Objects.equals(nombre, alumno.nombre) && Objects.equals(fechaNacimiento, alumno.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, matriculado, fechaNacimiento);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", matriculado=" + matriculado +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
