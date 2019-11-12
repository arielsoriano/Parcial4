package controladores;
import objetos.Turno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Agustina
 */
public class TurnoDTO extends Transaccion implements Icrud<Turno, Double>{
    private PreparedStatement ps;
    private ResultSet rs;
    Connection con = Conexion.conectarDB();
    
    public TurnoDTO(Conexion conexion) {
        super(conexion);
    }

    public TurnoDTO() {
    }
    
    @Override
    public boolean crear(Turno entidad) {
        
        String query;
        query = "INSERT INTO public.turnos(" +
                "codigo, descripcion)" +
                "VALUES (?, ?)";
;
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, entidad.getCodigo());
            ps.setString(2, entidad.getDescripcion());
            ps.executeUpdate();
           
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ese código ya existe");
        }
        return true;
    }

    @Override
    public boolean eliminar(int id) {
        String query = "DELETE FROM turnos WHERE id=?;";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int row = ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hay grados en este turno");
            Logger.getLogger(TurnoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public Turno extraer(String codigo) {
        String query;
        query = "Select * from turnos where codigo=?";
        Turno turno = new Turno();
      
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                turno.setId(rs.getInt(1));
                turno.setCodigo(rs.getInt(2));
                turno.setDescripcion(rs.getString(3));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TurnoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return turno;
    }

    @Override
    public boolean modificar(Turno entidad) {
        String query = "UPDATE turnos SET codigo=?, descripcion=? WHERE id=?;";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, entidad.getCodigo());
            ps.setString(2, entidad.getDescripcion());
            ps.setInt(3, entidad.getId());
            int row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TurnoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
   
    @Override
    public ArrayList<Turno> extraerTodo() {
        String query;
        query = "Select * from turnos";
        ArrayList<Turno> turnos = new ArrayList<>();
      
        try {
            Statement s = con.createStatement();
            s.execute(query);
            ResultSet rs = s.getResultSet();
            
            while (rs.next()) {
                Turno turno = new Turno();
                turno.setId(rs.getInt(1));
                turno.setCodigo(rs.getInt(3));
                turno.setDescripcion(rs.getString(2));
                turnos.add(turno);
            }
            //rs.close();
            //con.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(TurnoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return turnos;
    }

    @Override
    public Turno extraer(int codigo) {
        String query;
        query = "Select * from turnos where codigo=?";
        Turno turno = new Turno();
      
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                turno.setId(rs.getInt(1));
                turno.setCodigo(rs.getInt(3));
                turno.setDescripcion(rs.getString(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CargoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return turno;
    }

}
