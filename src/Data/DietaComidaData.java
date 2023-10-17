
package Data;

import entidades.Dieta;
import entidades.Comida;
import entidades.DietaComida;
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

/**
 *
 * @author pc
 */
public class DietaComidaData {
    private Connection con=null;
    private DietaData dd=new DietaData();
   private ComidaData cd= new ComidaData();
   private PacienteData pd=new PacienteData(); 
   
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
   
  public void modificarDietaComida(int idPaciente, int idComida, int idDietaComida) {
    String sql = "UPDATE dietacomida SET idPaciente = ?, idComida = ? WHERE idDietaComida = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idPaciente);
        ps.setInt(2, idComida);
        ps.setInt(3, idDietaComida);
        
        int fila = ps.executeUpdate();
        
        if (fila > 0) {
            System.out.println("La fila se actualizó correctamente.");
        } else {
            System.out.println("La fila no se encontró o no se actualizó.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"Error al acceder a la tabla dieta comida"+ ex.getMessage());
    }
}
 public List<DietaComida> obtenerDietaComida(){
     ArrayList<DietaComida> lista = new ArrayList<>();
     String sql = "SELECT * FROM dietaComida"; 
     
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                DietaComida dCom=new DietaComida();
                dCom.setId(rs.getInt("idDietaComida"));
                Paciente pac = pd.buscarPaciente(rs.getInt("idPaciente"));
                Comida com = cd.buscarComida(rs.getInt("idComida"));
                dCom.setComida(com);
               
                lista.add(dCom);  
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla dietaComida");
        }
     return lista;
 }  
 public List<DietaComida> obtenerDietaComidaPorPaciente(int idPaciente){
     ArrayList<DietaComida> lista = new ArrayList<>();
     String sql= "SELECT * FROM dietaComida WHERE idPaciente = ?";
     
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                
                DietaComida dCom=new DietaComida();
                dCom.setId(rs.getInt("idDietaComida"));
                Paciente pac = pd.buscarPaciente(rs.getInt("idPaciente"));
                Comida com = cd.buscarComida(rs.getInt("idComida"));
                dCom.setComida(com);
               
                lista.add(dCom);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla dietaComida");
        }
        return lista;
 } 

}
