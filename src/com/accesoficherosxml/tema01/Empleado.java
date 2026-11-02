package com.accesoficherosxml.tema01;

import java.time.LocalDate;
import java.util.Objects;

public class Empleado {

    private final String id;

    private final String nom;

    private final String departamento;

    private final String moneda;

    private final double salario;

    private final LocalDate fechaAlta;

    public Empleado(String id, String nom, String departamento, String moneda, double salario, LocalDate fechaAlta) {
        this.id = id;
        this.nom = nom;
        this.departamento = departamento;
        this.moneda = moneda;
        this.salario = salario;
        this.fechaAlta = fechaAlta;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getMoneda() {
        return moneda;
    }

    public double getSalario() {
        return salario;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Empleado empleado)) return false;
        return Objects.equals(id, empleado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Empleados{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", departamento='" + departamento + '\'' +
                ", moneda='" + moneda + '\'' +
                ", salario=" + salario +
                ", fechaAlta=" + fechaAlta +
                '}';
    }

}
