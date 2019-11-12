/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uis;

import controladores.CargoDTO;
import grillas.GrillaCargos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import objetos.Cargo;

/**
 *
 * @author ariel
 */
public class PreABMCargo extends javax.swing.JInternalFrame {

    /**
     * Creates new form PreABMCargo
     */
    
    static CargoDTO cargosDTO = new CargoDTO();
    public static ArrayList<Cargo> cargos = new ArrayList<>();
    
    public PreABMCargo() {
        
        initComponents();
        actualizarGrilla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grillaCargos1 = new grillas.GrillaCargos();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCargos = new javax.swing.JTable();
        jbCerrar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jbBuscarCodigo = new javax.swing.JButton();
        jtfBuscarCodigo = new javax.swing.JTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jtCargos.setModel(grillaCargos1);
        jScrollPane1.setViewportView(jtCargos);

        jbCerrar.setText("Cerrar");
        jbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbBuscarCodigo.setText("Buscar por código");
        jbBuscarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jbNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbBuscarCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfBuscarCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCerrar))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo)
                    .addComponent(jbModificar)
                    .addComponent(jbEliminar)
                    .addComponent(jbCerrar)
                    .addComponent(jbBuscarCodigo)
                    .addComponent(jtfBuscarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("Comandos");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jbCerrarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        if (jtCargos.getSelectedRow() == -1){JOptionPane.showMessageDialog(null, "Seleccione cargo");}
        else{
        cargos = cargosDTO.extraerTodo();
        cargosDTO.eliminar(cargos.get(jtCargos.getSelectedRow()).getId());
        actualizarGrilla();}
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        AltaCargo jpAltaCargo = new AltaCargo();      
        JFrame jfAltaCargo = new JFrame();
        jfAltaCargo.add(jpAltaCargo, BorderLayout.CENTER);
        jfAltaCargo.pack();
        jfAltaCargo.setLocationRelativeTo(null);
        jfAltaCargo.setVisible(true);
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        if (jtCargos.getSelectedRow() == -1){JOptionPane.showMessageDialog(null, "Seleccione cargo");}
        else{
        cargos = cargosDTO.extraerTodo();
        ModificarCargo jpModificarCargo = new ModificarCargo(cargos.get(jtCargos.getSelectedRow()));  
        JFrame jfModificarCargo = new JFrame();
        jfModificarCargo.add(jpModificarCargo, BorderLayout.CENTER);
        jfModificarCargo.pack();
        jfModificarCargo.setLocationRelativeTo(null);
        jfModificarCargo.setVisible(true);}
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbBuscarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarCodigoActionPerformed
        if ("".equals(jtfBuscarCodigo.getText())){
            actualizarGrilla();
        }
        else{
            Cargo cargo = new Cargo();
            cargo = cargosDTO.extraer(Integer.parseInt(jtfBuscarCodigo.getText()));
            cargos.clear();
            cargos.add(cargo);
            GrillaCargos grilla = new GrillaCargos(cargos);
            jtCargos.setModel(grilla);
        }
    }//GEN-LAST:event_jbBuscarCodigoActionPerformed
    public static void actualizarGrilla(){
        cargos = cargosDTO.extraerTodo();
        GrillaCargos grilla = new GrillaCargos(cargos);
        jtCargos.setModel(grilla);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private grillas.GrillaCargos grillaCargos1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscarCodigo;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private static javax.swing.JTable jtCargos;
    private javax.swing.JTextField jtfBuscarCodigo;
    // End of variables declaration//GEN-END:variables
}