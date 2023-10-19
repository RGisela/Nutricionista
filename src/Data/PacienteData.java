
package Data;

import entidades.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public void darAlta(Paciente paciente){
    String sql= "INSERT INTO paciente(nombre,dni,domicilio,telefono) VALUES(?,?,?,?)";
    String sql2 ="INSERT INTO historial(idPaciente, peso, fechaRegistro VALUES(?,?,? )";
            try {
                PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, paciente.getNombre());
                ps.setInt(2, paciente.getDni());
                ps.setString(3, paciente.getDomicilio());
                ps.setString(4, paciente.getTelefono());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                paciente.setIdPaciente(rs.getInt(1));//id del paciente en la base de datos que tiene que estar en a posicion 1
                JOptionPane.showMessageDialog(null,"Paciente añadido con exito :) ");
                }
                ps.close();
                
                PreparedStatement ps2 = con.prepareStatement(sql2,Statement.RETURN_GENERATED_KEYS);
                ps2.setInt(1, paciente.getIdPaciente());
                ps2.setDouble(2, );
                ps2.close();
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Error al acceder a la tabla paciente"+ex.getMessage());
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
       JOptionPane.showMessageDialog(null,"Error al acceder a la tabla paciente"+e.getMessage()) ;
    }
}
            //modificar paciente
public void modificarPaciente (Paciente paciente) {
    
    String sql = "UPDATE paciente SET nombre = ?, dni = ?, domicilio = ?, telefono = ? WHERE idPaciente = ?";
            try {
                PreparedStatement ps= con.prepareStatement(sql);
                ps.setString(1, paciente.getNombre());
                ps.setInt(2, paciente.getDni());
                ps.setString(3, paciente.getDomicilio());
                ps.setString(4, paciente.getTelefono());
                ps.setInt(5, paciente.getIdPaciente());
                int exito = ps.executeUpdate();
                if (exito==1){
                    JOptionPane.showMessageDialog(null, "Paciente modificado");
                }   
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paciente");
            }
}
public List<Paciente> listarPacientes(){
    List<Paciente> pacientes = new ArrayList<>();
    String sql = "SELECT * FROM paciente";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    int idPaciente = rs.getInt("idPaciente");
                    String nombre = rs.getString("nombre");
                    int dni = rs.getInt("dni");
                    String domicilio = rs.getString("domicilio");
                    String telefono = rs.getString("telefono");
                    
                    Paciente paciente = new Paciente();
                    pacientes.add(paciente);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al listar los pacientes: " + ex.getMessage());
            }
            return pacientes;
}
public Paciente buscarPaciente(int id){
    String sql = "SELECT * FROM paciente WHERE idPaciente = ?";
    Paciente paciente = null; 
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    paciente = new Paciente();
                    paciente.setIdPaciente(id);
                    paciente.setNombre(rs.getString("nombre"));
                    paciente.setDni(rs.getInt("dni"));
                    paciente.setDomicilio(rs.getString("domicilio"));
                    paciente.setTelefono(rs.getString("telefono"));
                }else{JOptionPane.showMessageDialog(null,"Ese paciente no existe" );
                }ps.close();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al buscar pacientes: " + ex.getMessage());
            }
            return paciente;
}
public Paciente buscarPacientePorDni(int dni){
    String sql = "SELECT * FROM paciente WHERE dni = ?";
    Paciente paciente = null; 
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, dni);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    paciente = new Paciente();
                    paciente.setIdPaciente(rs.getInt("idPaciente"));
                    paciente.setNombre(rs.getString("nombre"));
                    paciente.setDni(rs.getInt("dni"));
                    paciente.setDomicilio(rs.getString("domicilio"));
                    paciente.setTelefono(rs.getString("telefono"));
                }else{JOptionPane.showMessageDialog(null,"Ese paciente no existe" );
                }ps.close();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al buscar pacientes: " + ex.getMessage());
            }
            return paciente;
}

}
