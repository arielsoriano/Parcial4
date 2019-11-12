/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;
import objetos.Grado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static uis.Principal.turnos;
/**
 *
 * @author Agustina
 */
public class GradoDTO extends Transaccion implements Icrud<Grado, Double>{
    private PreparedStatement ps;
    private ResultSet rs;
    Connection con = Conexion.conectarDB();
    
    public GradoDTO(Conexion conexion) {
        super(conexion);
    }

    public GradoDTO() {
    }
    
    @Override
    public boolean crear(Grado entidad) {
        
        String query;
        query = "INSERT INTO public.grados(" +
                "numero, seccion, idturno)" +
                "VALUES (?, ?, ?)";
        
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, entidad.getNumero());
            ps.setString(2, entidad.getSeccion());
            ps.setInt(3, entidad.getTurno().getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GradoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
           
            

            
        
        return true;
    }

    @Override
    public boolean eliminar(int id) {
        String query = "DELETE FROM grados WHERE id=?;";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GradoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public Grado extraer(int numero) {
        String query;
        query = "Select * from grados where numero=?";
        Grado grado = new Grado();
      
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                grado.setId(rs.getInt(1));
                grado.setNumero(rs.getInt(2));
                grado.setSeccion(rs.getString(3));
                int idTurno = rs.getInt(4);
                int i = 0;
                
                while (turnos.size() > i)
                {
                    if (idTurno == turnos.get(i).getId()){
                        grado.setTurno(turnos.get(i));
                    }
                    i++;
                }
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(GradoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return grado;
    }

    @Override
    public boolean modificar(Grado entidad) {
        String query = "UPDATE grados SET numero=?, seccion=?, idturno=? WHERE id=?;";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, entidad.getNumero());
            ps.setString(2, entidad.getSeccion());
            ps.setInt(3, entidad.getTurno().getId());
            ps.setInt(4, entidad.getId());
            int row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GradoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
   
    @Override
    public ArrayList<Grado> extraerTodo() {
        String query;
        query = "Select * from grados";
        ArrayList<Grado> grados = new ArrayList<>();
      
        try {
            Statement s = con.createStatement();
            s.execute(query);
            ResultSet rs = s.getResultSet();
            
            while (rs.next()) {
                Grado grado = new Grado();
                grado.setId(rs.getInt(1));
                grado.setNumero(rs.getInt(2));
                grado.setSeccion(rs.getString(3));
                int idTurno = rs.getInt(4);
                int i = 0;
                while (turnos.size() > i)
                {
                    if (idTurno == turnos.get(i).getId()){
                        grado.setTurno(turnos.get(i));
                    }
                    i++;
                }
                grados.add(grado);
            }
            //rs.close();
            //con.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(GradoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return grados;
    }

}
