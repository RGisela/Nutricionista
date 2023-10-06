/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.time.LocalDate;

/**
 *
 * @author pc
 */
public class Dieta {
    private String nombre;
    private Paciente paciente;
    private LocalDate fechaInicial;
    private double pesoInicial;
    private double pesoFinal;
    private LocalDate fechaFinal;
    private int idDieta;

    public Dieta() {
    }

    public Dieta(String nombre, Paciente paciente, LocalDate fechaInicial, double pesoInicial, double pesoFinal, LocalDate fechaFinal, int idDieta) {
        this.nombre = nombre;
        this.paciente = paciente;
        this.fechaInicial = fechaInicial;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.fechaFinal = fechaFinal;
        this.idDieta = idDieta;
    }

    public Dieta(String nombre, Paciente paciente, LocalDate fechaInicial, double pesoInicial, double pesoFinal, LocalDate fechaFinal) {
        this.nombre = nombre;
        this.paciente = paciente;
        this.fechaInicial = fechaInicial;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.fechaFinal = fechaFinal;
    }
    
}
