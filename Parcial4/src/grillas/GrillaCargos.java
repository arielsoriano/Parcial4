/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grillas;

import objetos.Cargo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ariel
 */
public class GrillaCargos extends AbstractTableModel{

    private ArrayList<Cargo> cargos = new ArrayList<>();
    
    public GrillaCargos(ArrayList cargos) {
        this.cargos = cargos;
    }

    public GrillaCargos() {
    }
    

    @Override
    public int getRowCount() {
        return cargos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cargo cargo = (Cargo) cargos.get(rowIndex);
        switch(columnIndex){
                case 0: return cargo.getCodigo();
                case 1: return cargo.getDescripcion();
                default: return "";
                }
           
        }
            
        
    @Override
    public String getColumnName(int column) {
         switch(column){
            case 0: return "Código";
            case 1: return "Descripción";
            default: return "";
            }
    }
    
    public void removerRegistro(int registro) {
        cargos.remove(registro);
        this.fireTableRowsDeleted(registro, registro);
}
}