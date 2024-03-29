/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uis;

import controladores.GradoDTO;
import grillas.GrillaGrados;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import objetos.Grado;
import static uis.PreABMTurno.turnosDTO;
import static uis.Principal.grados;
import static uis.Principal.turnos;

/**
 *
 * @author ariel
 */
public class PreABMGrado extends javax.swing.JInternalFrame {

    /**
     * Creates new form PreABMGrado
     */
    
    static GradoDTO gradosDTO = new GradoDTO();
    

    public PreABMGrado() {
        turnos = turnosDTO.extraerTodo();
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

        grillaGrados1 = new grillas.GrillaGrados();
        grillaGrados2 = new grillas.GrillaGrados();
        jPanel1 = new javax.swing.JPanel();
        jbCerrar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jbBuscarNumero = new javax.swing.JButton();
        jtfBuscarNumero = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtGrados = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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

        jbBuscarNumero.setText("Buscar por número");
        jbBuscarNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarNumeroActionPerformed(evt);
            }
        });

        jtGrados.setModel(grillaGrados2);
        jScrollPane1.setViewportView(jtGrados);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbBuscarNumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfBuscarNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jbCerrar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo)
                    .addComponent(jbModificar)
                    .addComponent(jbEliminar)
                    .addComponent(jbCerrar)
                    .addComponent(jtfBuscarNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarNumero)))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Comandos");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jbCerrarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        if (jtGrados.getSelectedRow() == -1){JOptionPane.showMessageDialog(null, "Seleccione grado");}
        else{
        grados = gradosDTO.extraerTodo();
        gradosDTO.eliminar(grados.get(jtGrados.getSelectedRow()).getId());
        actualizarGrilla();}
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        AltaGrado jpAltaGrado = new AltaGrado();      
        JFrame jfAltaGrado = new JFrame();
        
        jfAltaGrado.add(jpAltaGrado, BorderLayout.CENTER);
        jfAltaGrado.pack();
        jfAltaGrado.setLocationRelativeTo(null);
        jfAltaGrado.setVisible(true);
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        if (jtGrados.getSelectedRow() == -1){JOptionPane.showMessageDialog(null, "Seleccione grado");}
        else{
        grados = gradosDTO.extraerTodo();
        ModificarGrado jpModificarGrado = new ModificarGrado(grados.get(jtGrados.getSelectedRow()));  
        JFrame jfModificarGrado = new JFrame();
        jfModificarGrado.add(jpModificarGrado, BorderLayout.CENTER);
        jfModificarGrado.pack();
        jfModificarGrado.setLocationRelativeTo(null);
        jfModificarGrado.setVisible(true);}
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbBuscarNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarNumeroActionPerformed
        if ("".equals(jtfBuscarNumero.getText())){
            actualizarGrilla();
        }
        else{
            Grado grado = new Grado();
            grado = gradosDTO.extraer(Integer.parseInt(jtfBuscarNumero.getText()));
            grados.clear();
            grados.add(grado);
            GrillaGrados grilla = new GrillaGrados(grados);
            jtGrados.setModel(grilla);
        }
    }//GEN-LAST:event_jbBuscarNumeroActionPerformed
    public static void actualizarGrilla(){
        grados = gradosDTO.extraerTodo();
        GrillaGrados grilla = new GrillaGrados(grados);
        jtGrados.setModel(grilla);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private grillas.GrillaGrados grillaGrados1;
    private grillas.GrillaGrados grillaGrados2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscarNumero;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private static javax.swing.JTable jtGrados;
    private javax.swing.JTextField jtfBuscarNumero;
    // End of variables declaration//GEN-END:variables
}
