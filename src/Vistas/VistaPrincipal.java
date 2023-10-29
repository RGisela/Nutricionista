
package Vistas;

import javax.swing.JDesktopPane;


public class VistaPrincipal extends javax.swing.JFrame {

   private JDesktopPane escritorio;
    
    public VistaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        escritorio= new JDesktopPane();//para luego ser llamado
        this.setContentPane(escritorio);
        //escritorio.add(this.button1)//por si quiero que se vea el boton
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmiComida = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jmiGestionDieta = new javax.swing.JMenu();
        jmItemDieta = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        jMenu3.setText("Paciente");
        jMenu3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jMenuItem1.setText("Gestión Paciente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        jmiComida.setText("Comida");
        jmiComida.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jmiComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiComidaActionPerformed(evt);
            }
        });

        jMenuItem2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jMenuItem2.setText("Gestion Comida");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jmiComida.add(jMenuItem2);

        jMenuBar1.add(jmiComida);

        jmiGestionDieta.setText("Dieta");
        jmiGestionDieta.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        jmItemDieta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jmItemDieta.setText("Gestión Dieta");
        jmItemDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmItemDietaActionPerformed(evt);
            }
        });
        jmiGestionDieta.add(jmItemDieta);

        jMenuBar1.add(jmiGestionDieta);

        jMenu2.setText("Administracion");
        jMenu2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        jMenuItem4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jMenuItem4.setText("Manejo de DietaComida");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Salir");
        jMenu5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        jMenuItem5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jMenuItem5.setText("Salir");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.out.println("Haciendo clic en jmiAgregarPaciente");
    PacienteVista ventanaPaciente = new PacienteVista();
    ventanaPaciente.setVisible(true);
    
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
           ComidaView comida = new ComidaView();
        escritorio.add(comida);//agrego la ventana al escritorio(JDesktopPane)
        comida.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jmItemDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItemDietaActionPerformed
        // TODO add your handling code here:
        DietaView dieta =new DietaView();
        escritorio.add(dieta);
        dieta.setVisible(true);
    }//GEN-LAST:event_jmItemDietaActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jmiComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiComidaActionPerformed
        
//        ComidaView comida = new ComidaView();
//        escritorio.add(comida);//agrego la ventana al escritorio(JDesktopPane)
//        comida.setVisible(true);
    }//GEN-LAST:event_jmiComidaActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        DietaComidaView dietaComida = new DietaComidaView();
        escritorio.add(dietaComida);//agrego la ventana al escritorio(JDesktopPane)
        dietaComida.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    
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
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jmItemDieta;
    private javax.swing.JMenu jmiComida;
    private javax.swing.JMenu jmiGestionDieta;
    // End of variables declaration//GEN-END:variables
}
