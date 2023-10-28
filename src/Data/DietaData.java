
package Data;


import entidades.Comida;
import entidades.Dieta;
import entidades.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Data.PacienteData;

import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

public class DietaData {
    private Connection conexion=null;

  public DietaData(){
        conexion = Conexion.getConnection();
    
    }

    public void agregarDieta(Dieta dieta) {
        String sql = "INSERT INTO dieta (nombre, idPaciente, fechaInicial, pesoInicial, pesoFinal, fechaFinal) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dieta.getNombre());
            ps.setInt(2, dieta.getPaciente().getIdPaciente());
            ps.setDate(3, Date.valueOf(dieta.getFechaInicial()));
            ps.setDate(6, Date.valueOf(dieta.getFechaFinal()));
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
            dieta.setIdDieta(rs.getInt(1));
            JOptionPane.showMessageDialog(null, "Dieta añadida con éxito :)");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dieta: " + ex.getMessage());
        }
    }

    public void modificarDieta(Dieta dieta) {
        String sql = "UPDATE dieta SET nombre = ?, idPaciente = ?, fechaInicial = ?, pesoInicial = ?, pesoFinal = ?, fechaFinal = ? "
                + "WHERE idDieta = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, dieta.getNombre());
            ps.setInt(2, dieta.getPaciente().getIdPaciente());
            ps.setDate(3, Date.valueOf(dieta.getFechaInicial()));
            ps.setDate(6, Date.valueOf(dieta.getFechaFinal()));
            ps.setInt(7, dieta.getIdDieta());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dieta modificada con éxito :)");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la dieta: " + ex.getMessage());
        }
    }

    public void eliminarDieta(String nombreDeDieta) {
        String sql = "DELETE FROM dieta WHERE nombre = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombreDeDieta);
            int exito=ps.executeUpdate();
            if(exito==1){
                
            JOptionPane.showMessageDialog(null, "Dieta eliminada con éxito :)");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la dieta: " + ex.getMessage());
        }
    }

    public List<Dieta> listarDietas() {
        List<Dieta> dietas = new ArrayList<>();
        String sql = "SELECT * FROM dieta";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idDieta = rs.getInt("idDieta");
                String nombre = rs.getString("nombre");
                int idPaciente = rs.getInt("idPaciente");
                LocalDate fechaInicial = rs.getDate("fechaInicial").toLocalDate();
                double pesoInicial = rs.getDouble("pesoInicial");
                double pesoFinal = rs.getDouble("pesoFinal");
                LocalDate fechaFinal = rs.getDate("fechaFinal").toLocalDate();
                PacienteData pd = new PacienteData();

                Paciente paciente = pd.buscarPacientePorId(idPaciente);

                Dieta dieta = new Dieta(nombre, paciente, fechaInicial, pesoInicial, pesoFinal, fechaFinal, idDieta);
                dietas.add(dieta);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar las dietas: " + ex.getMessage());
        }
        return dietas;
    }
    
    public List<Dieta> listarDietasTerminadas(LocalDate fechaFin) {
        List<Dieta> dietas = new ArrayList<>();
        String sql = "SELECT * FROM dieta WHERE fechaFinal=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fechaFin));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idDieta = rs.getInt("idDieta");
                String nombre = rs.getString("nombre");
                int idPaciente = rs.getInt("idPaciente");
                LocalDate fechaInicial = rs.getDate("fechaInicial").toLocalDate();
                double pesoInicial = rs.getDouble("pesoInicial");
                double pesoFinal = rs.getDouble("pesoFinal");
                PacienteData pd = new PacienteData();

                Paciente paciente = pd.buscarPacientePorId(idPaciente);

                Dieta dieta = new Dieta(nombre, paciente, fechaInicial, pesoInicial, pesoFinal, fechaFin, idDieta);
                dietas.add(dieta);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar las dietas: " + ex.getMessage());
        }
        return dietas;
    }
    
    public Dieta buscarDieta(int id) {
        Dieta dieta = null;
        String sql = "SELECT * FROM dieta WHERE idDieta = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dieta = new Dieta();
                dieta.setIdDieta(id);
                dieta.setNombre(rs.getString("nombre"));
            } else {
                JOptionPane.showMessageDialog(null, "Esa dieta no existe");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar dietas: " + ex.getMessage());
        }
        return dieta;
    }
    public Dieta obtenerDietaPorNombre(String nombreDieta) {
    Dieta dieta = null;
    String sql = "Select * FROM dieta WHERE nombre = ?";
    try {
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, nombreDieta);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            dieta = new Dieta();
            dieta.setIdDieta(rs.getInt("idDieta"));
            dieta.setNombre(rs.getString("nombre"));
            Paciente paciente = new Paciente();
            paciente.setIdPaciente(rs.getInt("idPaciente"));
           
            dieta.setPaciente(paciente);
            dieta.setFechaInicial(rs.getDate("fechaInicial").toLocalDate());
            dieta.setPesoInicial(rs.getDouble("pesoInicial"));
            dieta.setPesoFinal(rs.getDouble("pesoFinal"));
            dieta.setFechaFinal(rs.getDate("fechaFinal").toLocalDate());
            

        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener las comidas de la dieta: " + ex.getMessage());
    }
    return dieta;
}

}
