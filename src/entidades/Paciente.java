
package entidades;


public class Paciente {
    private String nombre;
    private int dni;
    private String domicilio;
    private String telefono;
    private int idPaciente;
    private double pesoInicial;
    private double pesoFinal;

    public Paciente() {
    }

    public Paciente(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public Paciente(String nombre, int dni, String domicilio, String telefono, int idPaciente, double pesoInicial, double pesoFinal) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.idPaciente = idPaciente;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
    }

    public Paciente(String nombre, int dni, String domicilio, String telefono) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public double getPesoInicial() {
        return pesoInicial;
    }

    public double getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoInicial(double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public void setPesoFinal(double pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    @Override
    public String toString() {
        return nombre + "-" + dni;
    }
}
