/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grillas;

import objetos.Turno;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pamel
 */
public class GrillaTurnos extends AbstractTableModel{

    private ArrayList<Turno> turnos = new ArrayList<>();
    
    public GrillaTurnos(ArrayList turnos) {
        this.turnos = turnos;
    }

    public GrillaTurnos() {
    }
    

    @Override
    public int getRowCount() {
        return turnos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Turno turno = (Turno) turnos.get(rowIndex);
        switch(columnIndex){
                case 1: return turno.getCodigo();
                case 0: return turno.getDescripcion();
                default: return "";
                }
           
        }
            
        
    @Override
    public String getColumnName(int column) {
         switch(column){
            case 0: return "Codigo";
            case 1: return "Descripción";
            default: return "";
            }
    }
    
    public void removerRegistro(int registro) {
        turnos.remove(registro);
        this.fireTableRowsDeleted(registro, registro);
}
}