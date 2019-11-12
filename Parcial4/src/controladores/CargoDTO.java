/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;
import objetos.Cargo;
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
 * @author ariel
 */
public class CargoDTO extends Transaccion implements Icrud<Cargo, Double>{
    private PreparedStatement ps;
    private ResultSet rs;
    Connection con = Conexion.conectarDB();
    
    public CargoDTO(Conexion conexion) {
        super(conexion);
    }

    public CargoDTO() {
    }
    
    @Override
    public boolean crear(Cargo entidad) {
        
        String query;
        query = "INSERT INTO public.cargos(" +
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
        String query = "DELETE FROM cargos WHERE id=?;";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int row = ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hay docentes con este cargo");
            Logger.getLogger(CargoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public Cargo extraer(int codigo) {
        String query;
        query = "Select * from cargos where codigo=?";
        Cargo cargo = new Cargo();
      
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                cargo.setId(rs.getInt(1));
                cargo.setCodigo(rs.getInt(2));
                cargo.setDescripcion(rs.getString(3));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CargoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cargo;
    }

    @Override
    public boolean modificar(Cargo entidad) {
        String query = "UPDATE cargos SET codigo=?, descripcion=? WHERE id=?;";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, entidad.getCodigo());
            ps.setString(2, entidad.getDescripcion());
            ps.setInt(3, entidad.getId());
            int row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CargoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
   
    @Override
    public ArrayList<Cargo> extraerTodo() {
        String query;
        query = "Select * from cargos";
        ArrayList<Cargo> cargos = new ArrayList<>();
      
        try {
            Statement s = con.createStatement();
            s.execute(query);
            ResultSet rs = s.getResultSet();
            
            while (rs.next()) {
                Cargo cargo = new Cargo();
                cargo.setId(rs.getInt(1));
                cargo.setCodigo(rs.getInt(2));
                cargo.setDescripcion(rs.getString(3));
                cargos.add(cargo);
            }
            //rs.close();
            //con.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(CargoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cargos;
    }

}
