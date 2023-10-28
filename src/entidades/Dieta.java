
package entidades;

import java.time.LocalDate;


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

    public Dieta(String nombre, Paciente paciente, LocalDate fechaInicial, LocalDate fechaFinal) {
        this.nombre = nombre;
        this.paciente = paciente;
        this.fechaInicial = fechaInicial;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.fechaFinal = fechaFinal;
    }

    public double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public double getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(double pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public Dieta(String nombre, int idDieta) {
        this.nombre = nombre;
        this.idDieta = idDieta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    @Override
    public String toString() {
        return "Dieta{" + "nombre=" + nombre + ", paciente=" + paciente + ", fechaInicial=" + fechaInicial + ", pesoInicial=" + pesoInicial + ", pesoFinal=" + pesoFinal + ", fechaFinal=" + fechaFinal + ", idDieta=" + idDieta + '}';
    }
    
    
}
