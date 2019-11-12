/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uis;

import controladores.DocenteGradoDTO;
import java.awt.Dimension;
import java.util.ArrayList;
import objetos.DocenteGrado;
import objetos.Grado;
import objetos.Turno;
import static uis.PreABMGrado.gradosDTO;
import static uis.PreABMTurno.turnosDTO;

/**
 *
 * @author ariel
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */

    public static ArrayList<Grado> grados = new ArrayList<>();
    public static ArrayList<DocenteGrado> docenteGrados = new ArrayList<>();
    static DocenteGradoDTO docenteGradoDTO = new DocenteGradoDTO();
    public static ArrayList<Turno> turnos = new ArrayList<>();
    public Principal() {
        initComponents();
        grados = gradosDTO.extraerTodo();
        turnos = turnosDTO.extraerTodo();
        docenteGrados = docenteGradoDTO.extraerTodo();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        jmiCargos = new javax.swing.JMenuItem();
        jmiDocentes = new javax.swing.JMenuItem();
        jmiAlumnos = new javax.swing.JMenuItem();
        jmiGrados = new javax.swing.JMenuItem();
        jmiTurnos = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Menú");

        jmiCargos.setMnemonic('o');
        jmiCargos.setText("Cargos");
        jmiCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCargosActionPerformed(evt);
            }
        });
        fileMenu.add(jmiCargos);

        jmiDocentes.setText("Docentes");
        jmiDocentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDocentesActionPerformed(evt);
            }
        });
        fileMenu.add(jmiDocentes);

        jmiAlumnos.setText("Alumnos");
        jmiAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAlumnosActionPerformed(evt);
            }
        });
        fileMenu.add(jmiAlumnos);

        jmiGrados.setText("Grados");
        jmiGrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGradosActionPerformed(evt);
            }
        });
        fileMenu.add(jmiGrados);

        jmiTurnos.setText("Turnos");
        jmiTurnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTurnosActionPerformed(evt);
            }
        });
        fileMenu.add(jmiTurnos);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Ayuda");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Creditos");
        contentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Acerca de");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void contentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contentMenuItemActionPerformed

    private void jmiCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCargosActionPerformed
        PreABMCargo preABMCargo = new PreABMCargo();        // TODO add your handling code here:
        desktopPane.add(preABMCargo);
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = preABMCargo.getSize();
        preABMCargo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        preABMCargo.setVisible(true);
    }//GEN-LAST:event_jmiCargosActionPerformed

    private void jmiTurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTurnosActionPerformed
        PreABMTurno preABMTurno = new PreABMTurno();        // TODO add your handling code here:
        desktopPane.add(preABMTurno);
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = preABMTurno.getSize();
        preABMTurno.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        preABMTurno.setVisible(true);
    }//GEN-LAST:event_jmiTurnosActionPerformed

    private void jmiAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAlumnosActionPerformed
        PreABMAlumno preABMAlumno = new PreABMAlumno();        // TODO add your handling code here:
        desktopPane.add(preABMAlumno);
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = preABMAlumno.getSize();
        preABMAlumno.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        preABMAlumno.setVisible(true);
    }//GEN-LAST:event_jmiAlumnosActionPerformed

    private void jmiGradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGradosActionPerformed
        PreABMGrado preABMGrado = new PreABMGrado();        // TODO add your handling code here:
        desktopPane.add(preABMGrado);
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = preABMGrado.getSize();
        preABMGrado.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        preABMGrado.setVisible(true);
    }//GEN-LAST:event_jmiGradosActionPerformed

    private void jmiDocentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDocentesActionPerformed
        PreABMDocente preABMDocente = new PreABMDocente();        // TODO add your handling code here:
        desktopPane.add(preABMDocente);
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = preABMDocente.getSize();
        preABMDocente.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        preABMDocente.setVisible(true);
    }//GEN-LAST:event_jmiDocentesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem jmiAlumnos;
    private javax.swing.JMenuItem jmiCargos;
    private javax.swing.JMenuItem jmiDocentes;
    private javax.swing.JMenuItem jmiGrados;
    private javax.swing.JMenuItem jmiTurnos;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
