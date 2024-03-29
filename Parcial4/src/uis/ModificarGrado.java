/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uis;

import controladores.GradoDTO;
import java.awt.Window;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import objetos.Grado;
import objetos.Turno;
import static uis.Principal.turnos;

/**
 *
 * @author ariel
 */
public class ModificarGrado extends javax.swing.JPanel {

    /**
     * Creates new form ModificarGrado
     * @param CARGO
     */
    Grado grado = new Grado();
    DefaultComboBoxModel modeloTurnos;
    public ModificarGrado(Grado CARGO) {
        grado = CARGO;   
        modeloTurnos = new DefaultComboBoxModel(turnos.toArray());
        initComponents();
        jtfNumero.setText(String.valueOf(grado.getNumero()));
        jtfSeccion.setText(grado.getSeccion());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jtfNumero = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jbAgregar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jtfSeccion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcbTurno = new javax.swing.JComboBox<>();

        jLabel2.setText("Ingrese sección:");

        jtfNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNumeroKeyTyped(evt);
            }
        });

        jLabel1.setText("Ingrese número:");

        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jLabel3.setText("Turno:");

        jcbTurno.setModel(modeloTurnos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(jtfSeccion)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbTurno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jbAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbCancelar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbAgregar)
                    .addComponent(jbCancelar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNumeroKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') evt.consume();
    }//GEN-LAST:event_jtfNumeroKeyTyped

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        if (jtfSeccion.getText().length() < 3) {JOptionPane.showMessageDialog(null, "Ingrese sección correcta");}
        else if ((Integer.parseInt(jtfNumero.getText()) == 0)){JOptionPane.showMessageDialog(null, "Ingrese número correcto");}
        else{
            grado.setNumero(Integer.parseInt(jtfNumero.getText()));
            grado.setSeccion(jtfSeccion.getText());
            grado.setTurno((Turno) jcbTurno.getSelectedItem());
            GradoDTO gradoDTO = new GradoDTO();
            gradoDTO.modificar(grado);
            Window w = SwingUtilities.getWindowAncestor(this);
            w.setVisible(false);
            PreABMGrado.actualizarGrilla();}
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        Window w = SwingUtilities.getWindowAncestor(this);
        w.setVisible(false);
    }//GEN-LAST:event_jbCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JComboBox<String> jcbTurno;
    private javax.swing.JTextField jtfNumero;
    private javax.swing.JTextField jtfSeccion;
    // End of variables declaration//GEN-END:variables
}
