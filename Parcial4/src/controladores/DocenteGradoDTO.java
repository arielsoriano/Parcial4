package controladores;
import objetos.DocenteGrado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static uis.Principal.docenteGrados;
/**
 *
 * @author Agustina
 */
public class DocenteGradoDTO extends Transaccion implements Icrud<DocenteGrado, Double>{
    private PreparedStatement ps;
    private ResultSet rs;
    Connection con = Conexion.conectarDB();
    
    public DocenteGradoDTO(Conexion conexion) {
        super(conexion);
    }

    public DocenteGradoDTO() {
    }
    
    @Override
    public boolean crear(DocenteGrado entidad) {
        
        String query;
        query = "INSERT INTO public.docentegrado(" +
                "idgrado, iddocente)" +
                "VALUES (?, ?)";
;
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, entidad.getIdGrado());
            ps.setInt(2, entidad.getIdDocente());
            ps.executeUpdate();
           
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Ese código ya existe");
            Logger.getLogger(DocenteGradoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean eliminar(int id) {
        String query = "DELETE FROM docentegrado WHERE iddocente=?;";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DocenteGradoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public boolean eliminarG(int idgrado, int iddocente) {
        String query = "DELETE FROM docentegrado WHERE idgrado=? and iddocente=?;";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, idgrado);
            ps.setInt(2, iddocente);
            int row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DocenteGradoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    

    @Override
    public DocenteGrado extraer(int codigo) {
        String query;
        query = "Select * from docentegrado where grado=?";
        DocenteGrado grado = new DocenteGrado();
      
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                grado.setId(rs.getInt(1));
                grado.setIdGrado(rs.getInt(2));
                grado.setIdDocente(rs.getInt(3));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DocenteGradoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return grado;
    }
    public ArrayList<String> extraerP(int codigo) {
        String query;
        query = "select g.seccion, g.numero, t.descripcion\n" +
                "from docentes d\n" +
                "inner join docentegrado dg\n" +
                "on d.id = dg.iddocente\n" +
                "inner join grados g\n" +
                "on g.id = dg.idgrado\n" +
                "inner join turnos t\n" +
                "on g.idturno = t.id\n" +
                "where d.id =?";
        ArrayList<String> extraerP = new ArrayList<>();
      
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                extraerP.add(String.valueOf(rs.getInt(2)));
                extraerP.add(rs.getString(1));
                extraerP.add(rs.getString(3));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DocenteGradoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return extraerP;
    }

    @Override
    public boolean modificar(DocenteGrado entidad) {
        String query = "UPDATE docentegrado SET idgrado=?, iddocente=? WHERE id=?;";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, entidad.getIdGrado());
            ps.setInt(2, entidad.getIdDocente());
            ps.setInt(3, entidad.getId());
            int row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DocenteGradoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
   
    @Override
    public ArrayList<DocenteGrado> extraerTodo() {
        String query;
        query = "Select * from docentegrado";
      
        try {
            Statement s = con.createStatement();
            s.execute(query);
            ResultSet rs = s.getResultSet();
            
            while (rs.next()) {
                DocenteGrado grado = new DocenteGrado();
                grado.setId(rs.getInt(1));
                grado.setIdGrado(rs.getInt(2));
                grado.setIdDocente(rs.getInt(3));
                docenteGrados.add(grado);
            }
            //rs.close();
            //con.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(DocenteGradoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return docenteGrados;
    }

}
