/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import entidades.Dieta;
import entidades.Comida;
import entidades.DietaComida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

/**
 *
 * @author pc
 */
public class DietaComidaData {
    private Connection con=null;
    private DietaData dd=new DietaData();
   private ComidaData cd= new ComidaData();
   
    public DietaComidaData  (){
    con = Conexion.getConnection();
    }
    
   public void agregarDietaComida(DietaComida dietacomida){
String sql = "INSERT INTO dietaComida(idComida, idDieta)VALUES(?,?)";
try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dietacomida.getComida().getIdComida());
            ps.setInt(2, dietacomida.getDieta().getIdDieta());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                
                dietacomida.setId(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "dietaComida registrada");
            }
            
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dietaComida");
        }
} 
}
