/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladordetomadedeciones;

/**
 * 
 * 
 // IDUSUARIO NOMBRE TIPOUSUARIO RFCUSUARIO CLAVEUSUARIO

 */
public class AgregarNwUsuario extends javax.swing.JFrame {

    /**
     * Creates new form AgregarNwUsuario
     */
    public AgregarNwUsuario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jtf_name = new javax.swing.JTextField();
        jtf_rfc = new javax.swing.JTextField();
        jtf_clave = new javax.swing.JTextField();
        jrb_usu = new javax.swing.JRadioButton();
        jrb_admin = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jb_crear = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jl_name_disponible = new javax.swing.JLabel();
        jl_rfc_disp = new javax.swing.JLabel();
        jl_security = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtf_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_nameKeyReleased(evt);
            }
        });
        jPanel1.add(jtf_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 120, -1));

        jtf_rfc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_rfcActionPerformed(evt);
            }
        });
        jtf_rfc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_rfcKeyReleased(evt);
            }
        });
        jPanel1.add(jtf_rfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 120, -1));

        jtf_clave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_claveKeyReleased(evt);
            }
        });
        jPanel1.add(jtf_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 120, -1));

        buttonGroup1.add(jrb_usu);
        jrb_usu.setSelected(true);
        jrb_usu.setText("Usuario");
        jPanel1.add(jrb_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

        buttonGroup1.add(jrb_admin);
        jrb_admin.setText("Administrador");
        jPanel1.add(jrb_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));

        jLabel1.setText("Nombre del usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 110, -1));

        jLabel2.setText("Tipo de Usuario");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 110, -1));

        jLabel3.setText("RFC");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 100, -1));

        jLabel4.setText("Clave temporal");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jb_crear.setText("Crear usuario");
        jPanel1.add(jb_crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 190, 100, -1));

        jButton2.setText("Cancelar");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, -1, -1));

        jl_name_disponible.setText("Disponible");
        jPanel1.add(jl_name_disponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        jl_rfc_disp.setText("Disponible");
        jPanel1.add(jl_rfc_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        jl_security.setText("Segura");
        jPanel1.add(jl_security, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_rfcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_rfcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_rfcActionPerformed

    private void jtf_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nameKeyReleased

    private void jtf_rfcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_rfcKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_rfcKeyReleased

    private void jtf_claveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_claveKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_claveKeyReleased

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
            java.util.logging.Logger.getLogger(AgregarNwUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarNwUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarNwUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarNwUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarNwUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jb_crear;
    private javax.swing.JLabel jl_name_disponible;
    private javax.swing.JLabel jl_rfc_disp;
    private javax.swing.JLabel jl_security;
    private javax.swing.JRadioButton jrb_admin;
    private javax.swing.JRadioButton jrb_usu;
    private javax.swing.JTextField jtf_clave;
    private javax.swing.JTextField jtf_name;
    private javax.swing.JTextField jtf_rfc;
    // End of variables declaration//GEN-END:variables
}