/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;
import objetos.Alumno;
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
import static uis.Principal.grados;
/**
 *
 * @author ariel
 */
public class AlumnoDTO extends Transaccion implements Icrud<Alumno, Double>{
    private PreparedStatement ps;
    private ResultSet rs;
    Connection con = Conexion.conectarDB();
    
    public AlumnoDTO(Conexion conexion) {
        super(conexion);
    }

    public AlumnoDTO() {
    }
    
    @Override
    public boolean crear(Alumno entidad) {
        
        String query;
        query = "INSERT INTO public.alumnos(" +
                "nombre, apellido, documento, fechanacimiento, sexo, matricula, idGrado)" +
                "VALUES (?, ?, ?, ?, ?, ? ,?)";
;
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getApellido());
            ps.setString(3, entidad.getDocumento());
            ps.setDate(4, (Date) entidad.getFechaNacimiento());
            ps.setString(5, entidad.getSexo());
            ps.setInt(6, entidad.getMatricula());
            ps.setInt(7, entidad.getGrado().getId());
            ps.executeUpdate();
           
            
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDTO.class.getName()).log(Level.SEVERE, null, ex);            
            JOptionPane.showMessageDialog(null, "Esa matrícula ya existe");
        }
        return true;
    }

    @Override
    public boolean eliminar(int id) {
        String query = "DELETE FROM alumnos WHERE id=?;";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public Alumno extraer(int matricula) {
        String query;
        query = "Select * from alumnos where matricula=?";
        Alumno alumno = new Alumno();
      
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, matricula);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                alumno.setNombre(rs.getString(1));
                alumno.setId(rs.getInt(2));
                alumno.setApellido(rs.getString(3));
                alumno.setDocumento(rs.getString(4));
                alumno.setFechaNacimiento(rs.getDate(5));
                alumno.setSexo(rs.getString(6));
                alumno.setMatricula(rs.getInt(7));
                int idCargo = rs.getInt(8);
                int i = 0;
                while (grados.size() > i)
                {
                    if (idCargo == grados.get(i).getId()){
                        alumno.setGrado(grados.get(i));
                    }
                    i++;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumno;
    }

    @Override
    public boolean modificar(Alumno entidad) {
        String query = "UPDATE alumnos SET nombre=?, apellido=?, documento=?, fechaNacimiento=?, sexo=?, matricula=?, idGrado=? WHERE id=?;";
        try {
            
            ps = con.prepareStatement(query);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getApellido());
            ps.setString(3, entidad.getDocumento());
            ps.setDate(4, (Date) entidad.getFechaNacimiento());
            ps.setString(5, entidad.getSexo());
            ps.setInt(6, entidad.getMatricula());
            ps.setInt(7, entidad.getGrado().getId());
            ps.setInt(8, entidad.getId());
            int row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDTO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Esa matrícula ya existe");
        }
        return true;
    }
   
    @Override
    public ArrayList<Alumno> extraerTodo() {
        String query;
        query = "Select * from alumnos";
        ArrayList<Alumno> alumnos = new ArrayList<>();
      
        try {
            Statement s = con.createStatement();
            s.execute(query);
            ResultSet rs = s.getResultSet();
            
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setNombre(rs.getString(1));
                alumno.setId(rs.getInt(2));
                alumno.setApellido(rs.getString(3));
                alumno.setDocumento(rs.getString(4));
                alumno.setFechaNacimiento(rs.getDate(5));
                alumno.setSexo(rs.getString(6));
                alumno.setMatricula(rs.getInt(7));
                int idCargo = rs.getInt(8);
                int i = 0;
                while (grados.size() > i)
                {
                    if (idCargo == grados.get(i).getId()){
                        alumno.setGrado(grados.get(i));
                    }
                    i++;
                }
                alumnos.add(alumno);
            }
            //rs.close();
            //con.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnos;
    }

}
