/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import entidades.Comida;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author estudiante
 */

public class ComidaData {

    private Connection conexion = null;

    public ComidaData() {
        conexion = Conexion.getConnection();
    }


    public void agregarComida(Comida comida) {
        String sql = "INSERT INTO comida (nombre, detalle, cantCalorias) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, comida.getNombre());
            ps.setString(2, comida.getDetalle());
            ps.setInt(3, comida.getCantCalorias());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Comida añadida con éxito :)");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar la comida: " + ex.getMessage());
        }
    }

    public void modificarComida(Comida comida) {
        String sql = "UPDATE comidas SET nombre = ?, detalle = ?, cantCalorias = ? WHERE idComida = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, comida.getNombre());
            ps.setString(2, comida.getDetalle());
            ps.setInt(3, comida.getCantCalorias());
            ps.setInt(4, comida.getIdComida());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Comida modificada con éxito :)");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la comida: " + ex.getMessage());
        }
    }

    public void eliminarComida(int idComida) {
        String sql = "DELETE FROM comida WHERE idComida = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idComida);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Comida eliminada con éxito :)");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la comida: " + ex.getMessage());
        }
    }

    public Comida buscarComida(int id) {
        Comida comida = null;
        String sql = "SELECT * FROM comida WHERE idComida = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                comida = new Comida();
                comida.setIdComida(id);
                comida.setNombre(rs.getString("nombre"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setCantCalorias(rs.getInt("cantCalorias"));
            } else {
                JOptionPane.showMessageDialog(null, "Esa comida no existe");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar comidas: " + ex.getMessage());
        }
        return comida;
    }

public List<Comida> listarComidas() {
    List<Comida> comidas = new ArrayList<>();
    String sql = "SELECT * FROM comida";
    try {
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int idComida = rs.getInt("idComida");
            String nombre = rs.getString("nombre");
            String detalle = rs.getString("detalle");
            int cantCalorias = rs.getInt("cantCalorias");

            // Crea una instancia de Comida y agrégala a la lista
            Comida comida = new Comida(nombre, detalle, cantCalorias,idComida);
            comidas.add(comida);
        }
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al listar las comidas: " + ex.getMessage());
        ex.printStackTrace();
    }
    return comidas;
}

    public List<Comida> buscarComidasConMenosCalorias(int maxCalorias) {
    List<Comida> comidas = new ArrayList<>();
    try {
        String sql = "SELECT * FROM comida WHERE cantCalorias < ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, maxCalorias);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            int id = rs.getInt("idComida");
            String nombre = rs.getString("nombre");
            String detalle = rs.getString("detalle");
            int caloriasPorGramo = rs.getInt("cantCalorias");
            
            Comida comida = new Comida(nombre, detalle, caloriasPorGramo,id);
            comidas.add(comida);
        }
    } catch (SQLException ex) {
  JOptionPane.showMessageDialog(null, "Error al acceder a la tabla comida: " + ex.getMessage());
    }
    return comidas;
}

}
