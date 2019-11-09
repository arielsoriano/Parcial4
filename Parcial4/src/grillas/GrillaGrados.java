/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grillas;

import objetos.Grado;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ariel
 */
public class GrillaGrados extends AbstractTableModel{

    private ArrayList<Grado> grados = new ArrayList<>();
    
    public GrillaGrados(ArrayList grados) {
        this.grados = grados;
    }

    public GrillaGrados() {
    }
    

    @Override
    public int getRowCount() {
        return grados.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Grado grado = (Grado) grados.get(rowIndex);
        switch(columnIndex){
                case 0: return grado.getNumero();
                case 1: return grado.getSeccion();
                default: return "";
                }
           
        }
            
        
    @Override
    public String getColumnName(int column) {
         switch(column){
            case 0: return "Numero";
            case 1: return "Seccion";
            default: return "";
            }
    }
    
    public void removerRegistro(int registro) {
        grados.remove(registro);
        this.fireTableRowsDeleted(registro, registro);
}
}