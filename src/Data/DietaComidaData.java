
package Data;

import entidades.Dieta;
import entidades.Comida;
import entidades.DietaComida;
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
   
   public void borrarDietaComida (int idPaciente,int idComida){
       String sql="delete FROM dietacomida WHERE idPaciente = ? AND idComida = ?";
       try {
       PreparedStatement ps=con.prepareStatement(sql);
       ps.setInt(1,idPaciente);
       ps.setInt(2,idComida);
       int filas = ps.executeUpdate();
       if (filas>0){
           JOptionPane.showMessageDialog(null,"ComidaData borrada");
                   }
       ps.close();
       
       }catch (SQLException ex){
       JOptionPane.showMessageDialog(null,"Error al acceder a la tabla dietacomida"+ex.getMessage());
       
       }
       
   }
   
   public void modificarDietaComida(int idPaciente, int idComida){
       String sql="UPDATE dietacomida SET idPaciente = ?, idComida = ? WHERE idDietaComida = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,idPaciente);
            ps.setInt(2,idComida);
            ps.setInt(3,idDietaComida);
        } catch (SQLException ex) {
            Logger.getLogger(DietaComidaData.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   
}
