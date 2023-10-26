package Data;

import entidades.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

public class PacienteData {

    private Connection con = null;

    public PacienteData() {
        con = Conexion.getConnection();
    }

    public void darAlta(Paciente paciente, double peso, LocalDate fecha) {
        String sql = "INSERT INTO paciente (nombre, dni, domicilio, telefono, peso) VALUES (?,?,?,?,?)";
        String sql2 = "INSERT INTO historial (idPaciente, peso, fechaRegistro) VALUES (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getNombre());
            ps.setInt(2, paciente.getDni());
            ps.setString(3, paciente.getDomicilio());
            ps.setString(4, paciente.getTelefono());
            ps.setDouble(5, peso);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                paciente.setIdPaciente(rs.getInt(1)); // ID del paciente en la base de datos
                JOptionPane.showMessageDialog(null, "Paciente añadido con éxito :) ");
            }
            ps.close();

            PreparedStatement ps2 = con.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
            ps2.setInt(1, paciente.getIdPaciente());
            ps2.setDouble(2, peso);
            ps2.setDate(3, Date.valueOf(fecha));
            ps2.executeUpdate();

            ResultSet rs2 = ps2.getGeneratedKeys();
            if (rs2.next()) {
                // Si es necesario, puedes hacer algo con el ID generado en el historial aquí
                JOptionPane.showMessageDialog(null, "Historial añadido con éxito :) ");
            }
            ps2.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla historial" + ex.getMessage());
        }
    }
    //Baja de Paciente:

    public void eliminarPaciente(int idPaciente) {
        try {
            String sql = "DELETE FROM paciente WHERE idPaciente = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idPaciente);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alumno eliminado con exito");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paciente" + e.getMessage());
        }
    }
    //modificar paciente

    public void modificarPaciente(Paciente paciente) {

        String sql = "UPDATE paciente SET nombre = ?, dni = ?, domicilio = ?, telefono = ? WHERE idPaciente = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, paciente.getNombre());
            ps.setInt(2, paciente.getDni());
            ps.setString(3, paciente.getDomicilio());
            ps.setString(4, paciente.getTelefono());
            ps.setInt(5, paciente.getIdPaciente());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Paciente modificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paciente");
        }
    }

   public List<Paciente> listarPacientes() {
    List<Paciente> pacientes = new ArrayList<>();
    String sql = "SELECT nombre,dni FROM paciente";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String nombre = rs.getString("nombre");
            int dni = rs.getInt("dni");
         

            // Crea un objeto Paciente y asigna los valores de la base de datos
            Paciente paciente = new Paciente();
            paciente.setNombre(nombre);
            paciente.setDni(dni);
            pacientes.add(paciente);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al listar los pacientes: " + ex.getMessage());
    }
    return pacientes;
}

    public Paciente buscarPaciente(int id) {
        String sql = "SELECT * FROM paciente WHERE idPaciente = ?";
        Paciente paciente = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                paciente = new Paciente();
                paciente.setIdPaciente(id);
                paciente.setNombre(rs.getString("nombre"));
                paciente.setDni(rs.getInt("dni"));
                paciente.setDomicilio(rs.getString("domicilio"));
                paciente.setTelefono(rs.getString("telefono"));
            } else {
                JOptionPane.showMessageDialog(null, "Ese paciente no existe");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar pacientes: " + ex.getMessage());
        }
        return paciente;
    }

    public Paciente buscarPacientePorDni(int dni) {
        String sql = "SELECT * FROM paciente WHERE dni = ?";
        Paciente paciente = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("idPaciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setDni(rs.getInt("dni"));
                paciente.setDomicilio(rs.getString("domicilio"));
                paciente.setTelefono(rs.getString("telefono"));
            } else {
                JOptionPane.showMessageDialog(null, "Ese paciente no existe");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar pacientes: " + ex.getMessage());
        }
        return paciente;
    }

}
