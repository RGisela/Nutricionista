
package entidades;

import java.time.LocalDate;


public class Dieta {
    private String nombre;
    private Paciente paciente;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private int idDieta;

    public Dieta() {
    }

    public Dieta(String nombre, Paciente paciente, LocalDate fechaInicial, LocalDate fechaFinal, int idDieta) {
        this.nombre = nombre;
        this.paciente = paciente;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.idDieta = idDieta;
    }

    public Dieta(String nombre, Paciente paciente, LocalDate fechaInicial, LocalDate fechaFinal) {
        this.nombre = nombre;
        this.paciente = paciente;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
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
    
    
}
