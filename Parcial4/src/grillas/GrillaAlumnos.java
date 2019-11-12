/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grillas;

import objetos.Alumno;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pamel
 */
public class GrillaAlumnos extends AbstractTableModel{

    private ArrayList<Alumno> alumnos = new ArrayList<>();
    
    public GrillaAlumnos(ArrayList alumnos) {
        this.alumnos = alumnos;
    }

    public GrillaAlumnos() {
    }
    

    @Override
    public int getRowCount() {
        return alumnos.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Alumno alumno = (Alumno) alumnos.get(rowIndex);
        switch(columnIndex){
                case 0: return alumno.getNombre();
                case 1: return alumno.getApellido();
                case 2: return alumno.getDocumento();
                case 3: return alumno.getFechaNacimiento();
                case 4: return alumno.getSexo();
                case 5: return alumno.getMatricula();
                case 6: return alumno.getGrado();
                default: return "";
                }
           
        }
            
        
    @Override
    public String getColumnName(int column) {
         switch(column){
            case 0: return "Nombre";
            case 1: return "Apellido";
            case 2: return "Documento";
            case 3: return "Fecha de nacimiento";
            case 4: return "Sexo";
            case 5: return "Matricula";
            case 6: return "Grado";
            default: return "";
            }
    }
    
    public void removerRegistro(int registro) {
        alumnos.remove(registro);
        this.fireTableRowsDeleted(registro, registro);
}
}