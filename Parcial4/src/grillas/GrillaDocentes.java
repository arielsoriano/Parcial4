/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grillas;

import controladores.DocenteGradoDTO;
import objetos.Docente;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import objetos.Grado;
import static uis.PreABMDocente.docenteGradosDTO;
import static uis.Principal.docenteGrados;
import static uis.Principal.grados;

/**
 *
 * @author pamel
 */
public class GrillaDocentes extends AbstractTableModel{

    private ArrayList<Docente> docentes = new ArrayList<>();
    
    public GrillaDocentes(ArrayList docentes) {
        this.docentes = docentes;
    }

    public GrillaDocentes() {
    }
    

    @Override
    public int getRowCount() {
        return docentes.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Docente docente = (Docente) docentes.get(rowIndex);        
        switch(columnIndex){
                case 0: return docente.getNombre();
                case 1: return docente.getApellido();
                case 2: return docente.getDocumento();
                case 3: return docente.getFechaNacimiento();
                case 4: return docente.getSexo();
                case 5: return docente.getLegajo();
                case 6: return docente.getCargo().getDescripcion();
                case 7: return docenteGradosDTO.extraerP(docente.getId());
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
            case 5: return "Legajo";
            case 6: return "Cargo";
            case 7: return "Grados";
            default: return "";
            }
    }
    
    public void removerRegistro(int registro) {
        docentes.remove(registro);
        this.fireTableRowsDeleted(registro, registro);
}
}