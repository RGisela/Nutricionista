/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import entidades.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

/**
 *
 * @author pc
 */
public class PacienteData {
        private Connection con = null;

    public PacienteData() {
        con = Conexion.getConnection();
    }
    public void darAlta(Paciente paciente){
    String sql= "INSERT INTO paciente(nombre,dni,domicilio,telefono) VALUES(?,?,?,?)";
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
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Error al acceder a la tabla paciente"+ex.getMessage());
            }
    
    }
    //Baja de Paciente:

public void eliminarPaciente(int idPaciente) {
    try {
        String sql = "DELETE pacientes WHERE idPaciente = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, idPaciente);
        statement.executeUpdate();
    } catch (SQLException e) {
       JOptionPane.showMessageDialog(null,"Error al acceder a la tabla paciente"+e.getMessage()) ;
    }
}

public void modificarPaciente (Paciente paciente) {
    
    String sql = "UPDATE paciente SET nombre = ?, dni = ?, domicilio = ?, telefono = ? WHERE idPaciente = ?";
            try {
                PreparedStatement ps= con.prepareStatement(sql);
                ps.setString(1, paciente.getNombre());
                ps.setInt(2, paciente.getDni());
                ps.setString(3, paciente.getDomicilio());
                ps.setString(4, paciente.getTelefono());
                int exito = ps.executeUpdate();
                if (exito==1){
                    JOptionPane.showMessageDialog(null, "Materia modificada");
                }   
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paciente");
            }
}

}
