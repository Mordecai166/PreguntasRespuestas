package es.maestredam.qa.view;

import es.maestredam.qa.model.GestorInfo;
import es.maestredam.qa.model.User;
import es.maestredam.util.LinkedList;
import javax.swing.filechooser.FileSystemView;

/**
 * @version 1.00
 * @author franh
 */
public class QAGUIApp extends javax.swing.JFrame {

    public QAGUIApp() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuItemGuardarUsuarios = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuItemSalir = new javax.swing.JMenuItem();
        menuNuevo = new javax.swing.JMenu();
        menuItemNuevoTest = new javax.swing.JMenuItem();
        menuItemNuevoParticipante = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuItemNuevaPregunta = new javax.swing.JMenuItem();
        menuVer = new javax.swing.JMenu();
        menuItemVerParticipantes = new javax.swing.JMenuItem();
        menuItemVerPreguntas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuArchivo.setText("Archivo");

        menuItemGuardarUsuarios.setText("Guardar Usuario(s)");
        menuItemGuardarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGuardarUsuariosActionPerformed(evt);
            }
        });
        menuArchivo.add(menuItemGuardarUsuarios);
        menuArchivo.add(jSeparator2);

        menuItemSalir.setText("Salir");
        menuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(menuItemSalir);

        jMenuBar1.add(menuArchivo);

        menuNuevo.setText("Nuevo");

        menuItemNuevoTest.setText("Test...");
        menuItemNuevoTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNuevoTestActionPerformed(evt);
            }
        });
        menuNuevo.add(menuItemNuevoTest);

        menuItemNuevoParticipante.setText("Participante...");
        menuItemNuevoParticipante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNuevoParticipanteActionPerformed(evt);
            }
        });
        menuNuevo.add(menuItemNuevoParticipante);
        menuNuevo.add(jSeparator1);

        menuItemNuevaPregunta.setText("Pregunta...");
        menuItemNuevaPregunta.setEnabled(false);
        menuItemNuevaPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNuevaPreguntaActionPerformed(evt);
            }
        });
        menuNuevo.add(menuItemNuevaPregunta);

        jMenuBar1.add(menuNuevo);

        menuVer.setText("Ver");

        menuItemVerParticipantes.setText("Participantes...");
        menuItemVerParticipantes.setEnabled(false);
        menuItemVerParticipantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVerParticipantesActionPerformed(evt);
            }
        });
        menuVer.add(menuItemVerParticipantes);

        menuItemVerPreguntas.setText("Preguntas...");
        menuItemVerPreguntas.setEnabled(false);
        menuItemVerPreguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVerPreguntasActionPerformed(evt);
            }
        });
        menuVer.add(menuItemVerPreguntas);

        jMenuBar1.add(menuVer);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 779, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemGuardarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGuardarUsuariosActionPerformed
        gestor.guardarListaUsuarios(usuarios, false);
    }//GEN-LAST:event_menuItemGuardarUsuariosActionPerformed

    private void menuItemNuevoParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNuevoParticipanteActionPerformed
        DlgAddUser dlgUser = new DlgAddUser(this, true);
        dlgUser.setVisible(true);
        usuario = dlgUser.getNewUser();
        usuarios.add(usuario);
        usuario = null;
    }//GEN-LAST:event_menuItemNuevoParticipanteActionPerformed

    private void menuItemNuevoTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNuevoTestActionPerformed
        DlgNewTestLogin dlgTest = new DlgNewTestLogin(this, true);
        dlgTest.setVisible(true);
        User userLogged = dlgTest.getUser();
        //usuario = userLogged;
        if(!userLogged.isAdmin()){
            menuItemNuevaPregunta.setEnabled(true);
            menuItemVerPreguntas.setEnabled(true);
            menuItemVerParticipantes.setEnabled(true);
        }
        else{
            menuItemNuevaPregunta.setEnabled(false);
            menuItemVerPreguntas.setEnabled(false);
            menuItemVerParticipantes.setEnabled(false);
        }
        
        DlgNewTestJuego dlgJuego = new DlgNewTestJuego(this, true);
        dlgJuego.setVisible(true);
        
    }//GEN-LAST:event_menuItemNuevoTestActionPerformed

    private void menuItemNuevaPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNuevaPreguntaActionPerformed
        DlgAddPregunta dlgPregunta = new DlgAddPregunta(this, true);
        dlgPregunta.setVisible(true);
    }//GEN-LAST:event_menuItemNuevaPreguntaActionPerformed

    private void menuItemVerParticipantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVerParticipantesActionPerformed
        DlgVerParticipantes dlgPart = new DlgVerParticipantes(this, true);
        dlgPart.setVisible(true);
    }//GEN-LAST:event_menuItemVerParticipantesActionPerformed

    private void menuItemVerPreguntasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVerPreguntasActionPerformed
        DlgVerPreguntas dlgPreg = new DlgVerPreguntas(this, true);
        dlgPreg.setVisible(true);
    }//GEN-LAST:event_menuItemVerPreguntasActionPerformed

    private void menuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuItemSalirActionPerformed

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
            java.util.logging.Logger.getLogger(QAGUIApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QAGUIApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QAGUIApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QAGUIApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QAGUIApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuItem menuItemGuardarUsuarios;
    private javax.swing.JMenuItem menuItemNuevaPregunta;
    private javax.swing.JMenuItem menuItemNuevoParticipante;
    private javax.swing.JMenuItem menuItemNuevoTest;
    private javax.swing.JMenuItem menuItemSalir;
    private javax.swing.JMenuItem menuItemVerParticipantes;
    private javax.swing.JMenuItem menuItemVerPreguntas;
    private javax.swing.JMenu menuNuevo;
    private javax.swing.JMenu menuVer;
    // End of variables declaration//GEN-END:variables

    private GestorInfo gestor = new GestorInfo(FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+"/ProyectoPreguntasRespuestas");
    private User usuario;
    private LinkedList<User> usuarios;
}
