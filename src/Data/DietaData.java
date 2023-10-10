
package Data;


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

import javax.swing.JOptionPane;

public class DietaData {
    private Connection conexion;

    public DietaData(Connection conexion) {
        this.conexion = conexion;
    }

    public void agregarDieta(Dieta dieta) {
        String sql = "INSERT INTO dieta (nombre, id_paciente, fecha_inicial, peso_inicial, peso_final, fecha_final) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, dieta.getNombre());
            ps.setInt(2, dieta.getPaciente().getIdPaciente());
            ps.setDate(3, Date.valueOf(dieta.getFechaInicial()));
            ps.setDouble(4, dieta.getPesoInicial());
            ps.setDouble(5, dieta.getPesoFinal());
            ps.setDate(6, Date.valueOf(dieta.getFechaFinal()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dieta añadida con éxito :)");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dieta: " + ex.getMessage());
        }
    }

    public void modificarDieta(Dieta dieta) {
        String sql = "UPDATE dieta SET nombre = ?, id_paciente = ?, fecha_inicial = ?, peso_inicial = ?, peso_final = ?, fecha_final = ? WHERE id_dieta = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, dieta.getNombre());
            ps.setInt(2, dieta.getPaciente().getIdPaciente());
            ps.setDate(3, Date.valueOf(dieta.getFechaInicial()));
            ps.setDouble(4, dieta.getPesoInicial());
            ps.setDouble(5, dieta.getPesoFinal());
            ps.setDate(6, Date.valueOf(dieta.getFechaFinal()));
            ps.setInt(7, dieta.getIdDieta());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dieta modificada con éxito :)");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la dieta: " + ex.getMessage());
        }
    }

    public void eliminarDieta(int idDieta) {
        String sql = "DELETE FROM dieta WHERE id_dieta = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dieta eliminada con éxito :)");
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
                int idDieta = rs.getInt("id_dieta");
                String nombre = rs.getString("nombre");
                int idPaciente = rs.getInt("id_paciente");
                LocalDate fechaInicial = rs.getDate("fecha_inicial").toLocalDate();
                double pesoInicial = rs.getDouble("peso_inicial");
                double pesoFinal = rs.getDouble("peso_final");
                LocalDate fechaFinal = rs.getDate("fecha_final").toLocalDate();

                Paciente paciente = obtenerPacientePorId(idPaciente);

                Dieta dieta = new Dieta(idDieta, nombre, paciente, fechaInicial, pesoInicial, pesoFinal, fechaFinal);
                dietas.add(dieta);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar las dietas: " + ex.getMessage());
        }
        return dietas;
    }

    private Paciente obtenerPacientePorId(int idPaciente) {
        return null;
        
    }
}
