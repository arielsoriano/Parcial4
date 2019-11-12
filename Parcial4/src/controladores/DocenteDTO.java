package controladores;
import objetos.Docente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static uis.PreABMCargo.cargos;
/**
 *
 * @author Agustina
 */
public class DocenteDTO extends Transaccion implements Icrud<Docente, Double>{
    private PreparedStatement ps;
    private ResultSet rs;
    Connection con = Conexion.conectarDB();
    
    public DocenteDTO(Conexion conexion) {
        super(conexion);
    }

    public DocenteDTO() {
    }
    
    @Override
    public boolean crear(Docente entidad) {
        
        String query;
        query = "INSERT INTO public.docentes(" +
                "nombre, apellido, documento, fechanacimiento, sexo, legajo, idcargo)" +
                "VALUES (?, ?, ?, ?, ?, ? ,?)";
;
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getApellido());
            ps.setString(3, entidad.getDocumento());
            ps.setDate(4, (Date) entidad.getFechaNacimiento());
            ps.setString(5, entidad.getSexo());
            ps.setInt(6, entidad.getLegajo());
            ps.setInt(7, entidad.getCargo().getId());
            ps.executeUpdate();
           
            
        } catch (SQLException ex) {
            Logger.getLogger(DocenteDTO.class.getName()).log(Level.SEVERE, null, ex);            
            JOptionPane.showMessageDialog(null, "Ese legajo ya existe");
        }
        return true;
    }

    @Override
    public boolean eliminar(int id) {
        String query = "DELETE FROM docentes WHERE id=?;";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DocenteDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public Docente extraer(int legajo) {
        String query;
        query = "Select * from docentes where legajo=?";
        Docente docente = new Docente();
      
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, legajo);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                docente.setNombre(rs.getString(2));
                docente.setId(rs.getInt(1));
                docente.setApellido(rs.getString(3));
                docente.setDocumento(rs.getString(4));
                docente.setFechaNacimiento(rs.getDate(5));
                docente.setSexo(rs.getString(6));
                docente.setLegajo(rs.getInt(7));
                int idCargo = rs.getInt(8);
                int i = 0;
                while (cargos.size() > i)
                {
                    if (idCargo == cargos.get(i).getId()){
                        docente.setCargo(cargos.get(i));
                    }
                    i++;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DocenteDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return docente;
    }

    @Override
    public boolean modificar(Docente entidad) {
        String query = "UPDATE docentes SET nombre=?, apellido=?, documento=?, fechaNacimiento=?, sexo=?, legajo=?, idcargo=? WHERE id=?;";
        try {
            
            ps = con.prepareStatement(query);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getApellido());
            ps.setString(3, entidad.getDocumento());
            ps.setDate(4, (Date) entidad.getFechaNacimiento());
            ps.setString(5, entidad.getSexo());
            ps.setInt(6, entidad.getLegajo());
            ps.setInt(7, entidad.getCargo().getId());
            ps.setInt(8, entidad.getId());
            int row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DocenteDTO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Esa matrícula ya existe");
        }
        return true;
    }
   
    @Override
    public ArrayList<Docente> extraerTodo() {
        String query;
        query = "Select * from docentes";
        ArrayList<Docente> docentes = new ArrayList<>();
      
        try {
            Statement s = con.createStatement();
            s.execute(query);
            ResultSet rs = s.getResultSet();
            
            while (rs.next()) {
                Docente docente = new Docente();
                docente.setNombre(rs.getString(2));
                docente.setId(rs.getInt(1));
                docente.setApellido(rs.getString(3));
                docente.setDocumento(rs.getString(4));
                docente.setFechaNacimiento(rs.getDate(5));
                docente.setSexo(rs.getString(6));
                docente.setLegajo(rs.getInt(7));
                int idCargo = rs.getInt(8);
                int i = 0;
                while (cargos.size() > i)
                {
                    if (idCargo == cargos.get(i).getId()){
                        docente.setCargo(cargos.get(i));
                    }
                    i++;
                }
                docentes.add(docente);
            }
            //rs.close();
            //con.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(DocenteDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return docentes;
    }
    

}
