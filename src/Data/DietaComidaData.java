package Data;

import entidades.Dieta;
import entidades.Comida;
import entidades.DietaComida;
import entidades.Paciente;
import java.sql.Connection;
import java.sql.Date;
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

    private Connection con = null;
    private DietaData dd = new DietaData();
    private ComidaData cd = new ComidaData();
    private PacienteData pd = new PacienteData();

    public DietaComidaData() {
        con = Conexion.getConnection();
    }

    public void agregarDietaComida(DietaComida dietacomida) {
        String sql = "INSERT INTO dietaComida(idComida, idDieta)VALUES(?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dietacomida.getComida().getIdComida());
            ps.setInt(2, dietacomida.getDieta().getIdDieta());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {

                dietacomida.setId(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "dietaComida registrada");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dietaComida");
        }
    }

    public void borrarDietaComida(int idPaciente, int idComida) {
        String sql = "delete FROM dietacomida WHERE idPaciente = ? AND idComida = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            ps.setInt(2, idComida);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "ComidaData borrada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dietacomida" + ex.getMessage());

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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dieta comida" + ex.getMessage());
        }
    }

    public List<DietaComida> obtenerDietaComida() {
        ArrayList<DietaComida> lista = new ArrayList<>();
        String sql = "SELECT * FROM dietaComida";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                DietaComida dCom = new DietaComida();
                dCom.setId(rs.getInt("idDietaComida"));
                Paciente pac = pd.buscarPacientePorId(rs.getInt("idPaciente"));
                Comida com = cd.buscarComida(rs.getInt("idComida"));
                dCom.setComida(com);

                lista.add(dCom);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dietaComida");
        }
        return lista;
    }

    public List<DietaComida> obtenerDietaComidaPorPaciente(int idPaciente) {
        ArrayList<DietaComida> lista = new ArrayList<>();
        String sql = "SELECT * FROM dietaComida WHERE idPaciente = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                DietaComida dCom = new DietaComida();
                dCom.setId(rs.getInt("idDietaComida"));
                Paciente pac = pd.buscarPacientePorId(rs.getInt("idPaciente"));
                Comida com = cd.buscarComida(rs.getInt("idComida"));
                dCom.setComida(com);

                lista.add(dCom);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dietaComida");
        }
        return lista;
    }

    public List<DietaComida> listarComidasEnDietas(String comida) {
    List<DietaComida> comidasEnDieta = new ArrayList<>();
    String sql = "SELECT d.nombre AS dieta_nombre, c.nombre AS comida_nombre, d.idDieta AS dieta_id, c.idComida AS comida_id "
             + "FROM dietacomida dc JOIN dieta d ON d.idDieta = dc.idDieta JOIN comida c ON c.idComida = dc.idComida "
             + "WHERE c.nombre LIKE ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, comida);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String dietaNombre = rs.getString("dieta_nombre");
            String comidaNombre = rs.getString("comida_nombre");
            int dietaId = rs.getInt("dieta_id");
            int comidaId = rs.getInt("comida_id");

            // Crea instancias de Comida y Dieta
            Comida comida3 = new Comida(comidaNombre,comidaId);
            Dieta dieta3 = new Dieta(dietaNombre,dietaId);

            // Crea una instancia de DietaComida
            DietaComida dietaComida9 = new DietaComida(comida3, dieta3);

            comidasEnDieta.add(dietaComida9);
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al listar las comidas de dieta: " + ex.getMessage());
    }
    return comidasEnDieta;
}
public List<Comida> obtenerComidasEnDietaPorNombre(String nombreDieta) {
    List<Comida> comidasEnDieta = new ArrayList<>();
    String sql = "SELECT c.idComida, c.nombre FROM dieta d " +
                 "JOIN dietacomida dc ON d.idDieta = dc.idDieta " +
                 "JOIN comida c ON dc.idComida = c.idComida " +
                 "WHERE d.nombre = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombreDieta);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int comidaId = rs.getInt("idComida");
            String comidaNombre = rs.getString("nombre");

            // Crea instancias de Comida
            Comida comida = new Comida(comidaNombre,comidaId);

            comidasEnDieta.add(comida);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener las comidas de la dieta: " + ex.getMessage());
    }

    return comidasEnDieta;
}

}
